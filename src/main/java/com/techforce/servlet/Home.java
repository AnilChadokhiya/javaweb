package com.techforce.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techforce.pojo.UserPojo;
import com.techforce.ultil.ApplicationUtils;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Home() {
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

		List < UserPojo > pojoList = new ArrayList < UserPojo >();

		pojoList = ApplicationUtils.getUserDao().getAllUser();

		request.setAttribute( "userList", pojoList );

		System.out.println( "user List ==>> " + pojoList.size() );

		final RequestDispatcher rd = request.getRequestDispatcher( "/home.jsp" );
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
		doGet( request, response );
	}

}
