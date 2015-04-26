package com.mdsgpp.eef.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

import com.mdsgpp.eef.parser.ParserData;

public class ParserController {

	private static ParserController instance;
	private ParserData parser;

	public ParserController(Context context) {
		this.parser = new ParserData(context);
	}

	public static ParserController getInstance(Context context) {
		if(instance == null) {
			instance = new ParserController(context);
		}
		else {
			// Nothing to do.
		}

		return instance;
	}
	
	// This method acquire the information of a state by the parser.
	public HashMap<String, ArrayList<String[]>> getStateInformation(int position) 
			throws IOException {
		return parser.getState(position);
	}	
}