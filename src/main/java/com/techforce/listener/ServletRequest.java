package com.techforce.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class ServletRequest implements ServletRequestListener {

	@Override
	public void requestDestroyed( ServletRequestEvent sre ) {

	System.out.println( "ServletRequest requestDestroyed" );

	}

	@Override
	public void requestInitialized( ServletRequestEvent sre ) {

	System.out.println( "ServletRequest requestInitialized" );

	}

}
