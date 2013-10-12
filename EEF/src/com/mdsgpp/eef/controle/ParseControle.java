package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

import com.mdsgpp.eef.parse.DadosParse;

public class ParseControle {

	private static ParseControle instancia;
	DadosParse parser;

	private String[] nomeSigla;
	private HashMap<String, ArrayList<String[]>> informacoes;

	public ParseControle(Context context) {
		parser = new DadosParse(context);
		informacoes = new HashMap<String, ArrayList<String[]>>();
	}

	public static ParseControle getInstancia(Context context) {
		if (instancia == null) instancia = new ParseControle(context);
		return instancia;
	}

	public void setInformacoes(String nome, String sigla, HashMap<String, ArrayList<String[]>> informacoes) {
		this.nomeSigla = new String[2];
		this.nomeSigla[0] = nome;
		this.nomeSigla[1] = sigla;
		
		ArrayList<String[]> container = new ArrayList<String[]>();
		container.add(nomeSigla);
		
		informacoes.put("nome_e_sigla", container);
		this.informacoes = informacoes;
	}
	
	public HashMap<String, ArrayList<String[]>> getInformacoes(int posicao) throws IOException {
		parser.getEstado(posicao);
		return this.informacoes;
	}
	
}
