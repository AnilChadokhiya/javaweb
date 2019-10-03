package com.techforce.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techforce.ultil.ApplicationUtils;

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUserServlet() {
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException {
		// TODO Auto-generated method stub.

		final int id = Integer.parseInt( request.getParameter( "id" ) );

		final int status = ApplicationUtils.getUserDao().deleteUseById( id );

		if ( status > 0 ) {
			final RequestDispatcher rd = request.getRequestDispatcher( "/home" );
			rd.forward( request, response );
		}
		// System.out.println( "user Delete status =>> " + status );
		// doGet( request, response );
	}

}
