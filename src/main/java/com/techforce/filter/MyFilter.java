package com.techforce.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.techforce.pojo.UserPojo;

/**
 * Servlet Filter implementation class MyFilter
 */
public class MyFilter implements Filter {

	private final List< String > url;

	/**
	 * Default constructor.
	 */
	public MyFilter() {
		// TODO Auto-generated constructor stub
		url = new ArrayList< String >();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init( FilterConfig fConfig ) throws ServletException {
		// TODO Auto-generated method stub
		url.add( "/JavaWeb/signup" );
		url.add( "/JavaWeb/home" );
	}

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain )
			throws IOException, ServletException {

		final String path = ( (HttpServletRequest) request ).getRequestURI();

		System.out.println( "path -->> " + path + " url  -->> " + url.contains( path ) );

		if ( !url.contains( path ) ) {

			response.setContentType( "text/html" );
			final PrintWriter out = response.getWriter();

			final HttpServletRequest req = (HttpServletRequest) request;
			// final HttpServletResponse res = (HttpServletResponse) response;

			final HttpSession session = req.getSession( false );

			if ( session != null ) {

				final UserPojo poj = (UserPojo) session.getAttribute( "userPojo" );

				if ( poj != null && poj.getId() > 0 ) {
					chain.doFilter( request, response );
				} else {
					out.print( "! Please Login" );
					final RequestDispatcher rd = request.getRequestDispatcher( "/login" );
					rd.include( request, response );
				}
			} else {
				chain.doFilter( request, response );
			}
		} else {
			chain.doFilter( request, response );
		}
	}

}
