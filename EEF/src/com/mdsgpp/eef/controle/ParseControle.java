package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

import com.mdsgpp.eef.parse.DadosParse;

public class ParseControle {

	private static ParseControle instancia;
	DadosParse parser;

	public ParseControle(Context context) {
		parser = new DadosParse(context);
	}

	public static ParseControle getInstancia(Context context) {
		if(instancia == null) {
			instancia = new ParseControle(context);
		}
		else {
			// Nothing to do.
		}

		return instancia;
	}
	
	// This method acquire the information of a state by the parser.
	public HashMap<String, ArrayList<String[]>> getInformacoes(int posicao)
		throws IOException {
		return parser.getEstado(posicao);
	}	
}