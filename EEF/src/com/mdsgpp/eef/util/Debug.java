/************************************************************
 * File: Debug.java 
 * 
 * Purpose: Implements methods of debug and log of the system.
 ************************************************************/

package com.mdsgpp.eef.util;

import android.util.Log;

public class Debug {
	public static final int DEBUG = 0;
	public static final int ERROR = 1;
	public static final int INFO = 2;
	public static final int VERBOSE = 3;
	public static final int WARNING = 4;
	
	private static String TAG = "EEF";
	
	// Receives the message of debug and the type of this debug.
	public static void debug(int log_type, String message) {
		switch(log_type) {
			case DEBUG:
				Log.d(TAG, message);
				break;
			
			case ERROR:
				Log.e(TAG, message);
				break;
				
			case INFO:
				Log.i(TAG, message);
				break;
				
			case VERBOSE:
				Log.v(TAG, message);
				break;
				
			case WARNING:
				Log.w(TAG, message);
				break;
				
			default:
				// Do nothing.
		}
		return;
	}

}
