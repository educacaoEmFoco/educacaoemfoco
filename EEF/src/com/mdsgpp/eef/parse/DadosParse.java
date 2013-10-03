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
	
	String estados[][] = { { "Acre", "Acre" },
			{ "Alagoas", "Alagoas" }, { "Amapá", "Amapa" },
			{ "Amazonas", "Amazonas" }, { "Bahia", "Bahia" },
			{ "Ceará", "Ceara" },
			{ "Distrito Federal", "Distrito Federal" },
			{ "Espírito Santo", "Espirito Santo" },
			{ "Goiás", "Goias" }, { "Maranhão", "Maranhao" },
			{ "Mato Grosso", "Mato Grosso" },
			{ "Mato Grosso do Sul", "Mato Grosso do Sul" },
			{ "Minas Gerais", "Minas Gerais" }, { "Pará", "Para" },
			{ "Paraíba", "Paraiba" }, { "Paraná", "Parana" },
			{ "Pernambuco", "Pernambuco" }, { "Piauí", "Piaui" },
			{ "Rio de Janeiro", "Rio de Janeiro" },
			{ "Rio Grande do Norte", "Rio Grande do Norte" },
			{ "Rio Grande do Sul", "Rio Grande do Sul" },
			{ "Rondônia", "Rondonia" }, { "Roraima", "Roraima" },
			{ "Santa Catarina", "Santa Catarina" },
			{ "São Paulo", "Sao Paulo" }, { "Sergipe", "Sergipe" },
			{ "Tocantins", "Tocantins" } };
	
	public DadosParse(Context context) {
		this.context = context;
	}
	
	public Estado getEstado(int posicao) throws IOException {
		Estado estado;
		String nome, sigla;
		
		AssetManager am = context.getAssets();
		InputStream is = am.open(estados[posicao][1]+extensao);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		limpaInformacoes();
		
		nome = br.readLine();
		sigla = br.readLine();
		
		lerIndicativos(br);
		
		nome = estados[posicao][0];
		estado = new Estado(nome, sigla, informacoes);
		
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
