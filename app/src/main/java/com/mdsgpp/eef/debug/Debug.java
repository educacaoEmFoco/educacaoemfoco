/************************************************************
 * File: Debug.java 
 * 
 * Purpose: Implements methods of debug and log of the system.
 ************************************************************/

package com.mdsgpp.eef.debug;

import android.util.Log;

public class Debug {
	private static final boolean DEBUG_ON = true;
	public static final int DEBUG = 0;
	public static final int ERROR = 1;
	public static final int INFO = 2;
	public static final int VERBOSE = 3;
	public static final int WARNING = 4;
	
	// Receives the message of debug and the type of this debug.
	public static void log(String tag, String message, int log_type) {
		if(DEBUG_ON) {
			switch(log_type) {
				case DEBUG:
					Log.d(tag, message);
					break;
				
				case ERROR:
					Log.e(tag, message);
					break;
					
				case INFO:
					Log.i(tag, message);
					break;
					
				case VERBOSE:
					Log.v(tag, message);
					break;
					
				case WARNING:
					Log.w(tag, message);
					break;
					
				default:
					// Do nothing.
					break;
			}
		}
	}
}
