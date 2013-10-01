package com.mdsgpp.eef.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.res.AssetManager;

import com.mdsgpp.eef.modelo.Estado;

public class DadosParse {
	
	Context context;
	String extensao = ".txt";
	private HashMap<String, ArrayList<String[]>> informacoes = new HashMap<String, ArrayList<String[]>>();
	private String nomeIndicador;
	
	public DadosParse(Context context) {
		this.context = context;
	}
	
	public Estado getEstado(String nomeEstado) throws IOException {
		Estado estado;
		String nome, sigla;
		
		AssetManager am = context.getAssets();
		InputStream is = am.open(nomeEstado+extensao);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		limpaInformacoes();
		
		nome = br.readLine();
		sigla = br.readLine();
		
		lerIndicativos(br);
		
		estado = new Estado();
		estado.setNome(nome);
		estado.setSigla(sigla);
		
		return estado;
	}
	
	
	public void limpaInformacoes() {
		informacoes.clear();
	}
	
	
	public void lerIndicativos(BufferedReader br) throws IOException {
		String linha = br.readLine();
		linha = br.readLine();
		int aux = 0;
		
		while (linha != null) {
			nomeIndicador = linha;
			ArrayList<String[]> dados = new ArrayList<String[]>();
			
			linha = br.readLine();
			while(linha != null && aux < 2) {
				if (linha.isEmpty()) {
					aux++;
				} else {
					dados.add(linha.split(": "));
				}
				linha = br.readLine();
			}
			
			aux = 0;
			informacoes.put(nomeIndicador, dados);

			if (linha == null)
				return;
		}
		
		br.close();
	}
	
}
