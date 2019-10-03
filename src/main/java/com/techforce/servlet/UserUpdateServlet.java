package com.techforce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techforce.pojo.UserPojo;
import com.techforce.ultil.ApplicationUtils;

/**
 * Servlet implementation class UserUpdateServlet
 */
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateServlet() {
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

		if ( request.getParameter( "id" ).length() > 0 && Integer.parseInt( request.getParameter( "id" ) ) > 0 ) {

			final UserPojo userPojo = ApplicationUtils.getUserDao()
					.getUserPojoById( Integer.parseInt( request.getParameter( "id" ) ) );

			request.setAttribute( "updateUserPojo", userPojo );

			final RequestDispatcher rd = request.getRequestDispatcher( "/update_user.jsp" );
			rd.include( request, response );
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {

		final UserPojo pojo = new UserPojo();

		pojo.setId( Integer.parseInt( request.getParameter( "id" ) ) );
		pojo.setUserName( request.getParameter( "userName" ) );
		pojo.setPassword( request.getParameter( "password" ) );
		pojo.setFirstName( request.getParameter( "firstName" ) );
		pojo.setLastName( request.getParameter( "lastName" ) );
		pojo.setEmailId( request.getParameter( "emailId" ) );
		pojo.setCity( request.getParameter( "city" ) );
		pojo.setMobileNo( request.getParameter( "mobileNo" ) );
		pojo.setSalary( Float.parseFloat( request.getParameter( "salary" ) ) );

		final int status = ApplicationUtils.getUserDao().updateUser( pojo );

		if ( status > 0 ) {
			final RequestDispatcher rd = request.getRequestDispatcher( "/home" );
			rd.forward( request, response );
		}
	}

}
