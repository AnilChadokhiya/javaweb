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
 * Servlet implementation class Signup
 */
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
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

		response.setContentType( "text/html" );

		final RequestDispatcher rd = request.getRequestDispatcher( "/signup.jsp" );
		rd.include( request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType( "text/html" );

		final UserPojo pojo = new UserPojo();

		pojo.setUserName( request.getParameter( "userName" ) );
		pojo.setPassword( request.getParameter( "password" ) );
		pojo.setFirstName( request.getParameter( "firstName" ) );
		pojo.setLastName( request.getParameter( "lastName" ) );
		pojo.setEmailId( request.getParameter( "emailId" ) );
		pojo.setCity( request.getParameter( "city" ) );
		pojo.setMobileNo( request.getParameter( "mobileNo" ) );
		pojo.setSalary( Float.parseFloat( request.getParameter( "salary" ) ) );

		ApplicationUtils.getUserDao().insertUser( pojo );

		final RequestDispatcher rd = request.getRequestDispatcher( "/home" );
		rd.forward( request, response );

	}

}
