package com.techforce.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

	@Override
	public void contextInitialized( ServletContextEvent event ) {

	System.out.println( "ContextxInitilized Metod invoked" + event.getServletContext() );

	}

	@Override
	public void contextDestroyed( ServletContextEvent eve ) {

	System.out.println( "ContextxDestroyed Metod invoked" );

	}

}
