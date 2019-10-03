package com.techforce.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	int countUser = 0;

	@Override
	public void sessionCreated( HttpSessionEvent e ) {

	countUser++;
	System.out.println( countUser + " ==>> User Created " );
	System.out.println( "Total User ==>> " + countUser );

	}

	@Override
	public void sessionDestroyed( HttpSessionEvent e ) {

	countUser--;
	System.out.println( " User Destryoed " );

	System.out.println( "Total User After One Userdestryoed ==>> " + countUser );

	}

}
