package com.techforce.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class AllOneFilter
 */
public class AllOneFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public AllOneFilter() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		// place your code here

		/*
		 * response.setContentType( "text/html" ); final PrintWriter out =
		 * response.getWriter();
		 * 
		 * final HttpServletRequest req = (HttpServletRequest) request; final
		 * HttpServletResponse res = (HttpServletResponse) response;
		 * 
		 * final HttpSession session = req.getSession( false );
		 * 
		 * RequestDispatcher requestDispatcher;
		 * 
		 * if ( session != null && session.getAttribute( "userPojo" ) != null ) {
		 * 
		 * final UserPojo poj = (UserPojo) session.getAttribute( "userPojo" );
		 * 
		 * if ( poj != null && poj.getId() > 0 ) {
		 * 
		 * final UserPojo pojo = (UserPojo) session.getAttribute( "userPojo" );
		 * System.out.println( "session UserName -->> " + pojo.getUserName() );
		 * System.out.println( "session pssword -->> " + pojo.getPassword() );
		 * 
		 * chain.doFilter( request, response ); } else { out.print(
		 * "! Invaild UserName and password" ); requestDispatcher =
		 * req.getRequestDispatcher( "/index.jsp" ); requestDispatcher.include( req, res
		 * ); }
		 * 
		 * } else { out.print( "Please Login" ); requestDispatcher =
		 * req.getRequestDispatcher( "/index.jsp" ); requestDispatcher.include( req, res
		 * ); }
		 */

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init( FilterConfig fConfig ) throws ServletException {
		// TODO Auto-generated method stub
	}

}
