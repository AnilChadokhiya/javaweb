package com.techforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techforce.pojo.UserPojo;
import com.techforce.ultil.ApplicationUtils;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		final RequestDispatcher rd = request.getRequestDispatcher( "index.jsp" );
		rd.include( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		response.setContentType( "text/html" );
		final PrintWriter out = response.getWriter();

		if ( request.getParameter( "uName" ).length() > 0 && request.getParameter( "password" ).length() > 0 ) {

			final HttpSession session = request.getSession( true );

			final UserPojo userPojo = ApplicationUtils.getUserDao().userLogin( request.getParameter( "uName" ),
					request.getParameter( "password" ) );

			// System.out.println( "id -->> " + userPojo.getId() );

			if ( userPojo.getUserName() != null && userPojo.getPassword() != null ) {

				session.setAttribute( "userPojo", userPojo );
				final RequestDispatcher rd = request.getRequestDispatcher( "/home" );
				rd.forward( request, response );

			} else {
				out.print( "! Invalid Username and Password" );
				final RequestDispatcher rd = request.getRequestDispatcher( "/index.jsp" );
				rd.include( request, response );
			}
		} else {
			out.print( "Please Enter your Username and Password" );
			final RequestDispatcher rd = request.getRequestDispatcher( "/index.jsp" );
			rd.include( request, response );
		}

		// final RequestDispatcher rd = request.getRequestDispatcher( "/home" );
		// rd.forward( request, response );
	}

}
