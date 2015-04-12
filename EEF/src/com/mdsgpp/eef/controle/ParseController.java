package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

import com.mdsgpp.eef.parse.DadosParse;

public class ParseController {

	private static ParseController instance;
	DadosParse parser;

	public ParseController(Context context) {
		parser = new DadosParse(context);
	}

	public static ParseController getInstance(Context context) {
		if(instance == null) {
			instance = new ParseController(context);
		}
		else {
			// Nothing to do.
		}

		return instance;
	}
	
	// This method acquire the information of a state by the parser.
	public HashMap<String, ArrayList<String[]>> getInformation(int position)
		throws IOException {
		return parser.getState(position);
	}	
}