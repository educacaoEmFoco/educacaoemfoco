package com.mdsgpp.eef.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.res.AssetManager;

public class DadosParse {

	private HashMap<String, ArrayList<String[]>> informacoes;
	private ArrayList<String[]> dados;
	private Context context;
	private String extensao = ".txt";
	private String nomeIndicador;

	String estados[][] = { { "Acre", "Acre" }, { "Alagoas", "Alagoas" },
			{ "Amap�", "Amapa" }, { "Amazonas", "Amazonas" },
			{ "Bahia", "Bahia" }, { "Cear�", "Ceara" },
			{ "Distrito Federal", "Distrito Federal" },
			{ "Esp�rito Santo", "Espirito Santo" }, { "Goi�s", "Goias" },
			{ "Maranh�o", "Maranhao" }, { "Mato Grosso", "Mato Grosso" },
			{ "Mato Grosso do Sul", "Mato Grosso do Sul" },
			{ "Minas Gerais", "Minas Gerais" }, { "Par�", "Para" },
			{ "Para�ba", "Paraiba" }, { "Paran�", "Parana" },
			{ "Pernambuco", "Pernambuco" }, { "Piau�", "Piaui" },
			{ "Rio de Janeiro", "Rio de Janeiro" },
			{ "Rio Grande do Norte", "Rio Grande do Norte" },
			{ "Rio Grande do Sul", "Rio Grande do Sul" },
			{ "Rond�nia", "Rondonia" }, { "Roraima", "Roraima" },
			{ "Santa Catarina", "Santa Catarina" },
			{ "S�o Paulo", "Sao Paulo" }, { "Sergipe", "Sergipe" },
			{ "Tocantins", "Tocantins" } };

	public DadosParse(Context context) {
		this.context = context;
		this.informacoes = new HashMap<String, ArrayList<String[]>>();
	}

	public HashMap<String, ArrayList<String[]>> getEstado(int posicao) throws IOException {
		String nome, sigla;

		AssetManager am = this.context.getAssets();
		InputStream is = am.open(this.estados[posicao][1] + this.extensao);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		nome = br.readLine();
		nome = this.estados[posicao][0];
		sigla = br.readLine();
		
		limpaInformacoes();
		limpaDados();
		
		insereNomeSigla(nome, sigla);
		lerIndicativos(br);
		
		return informacoes;
	}

	public void limpaInformacoes() {
		this.informacoes.clear();
	}
	
	public void limpaDados() {
		this.dados = new ArrayList<String[]>(); 
	}

	// M�todo para mandar o nome e a sigla atrav�s do mesmo hashmap ds indicativos
	public void insereNomeSigla(String nome, String sigla) {
		ArrayList<String[]> container = new ArrayList<String[]>();
		String nomeEsigla[] = new String[2];
		nomeEsigla[0] = nome;
		nomeEsigla[1] = sigla;
		
		container.add(nomeEsigla);
		this.informacoes.put("nome_e_sigla", container);
	}
	
	public void lerIndicativos(BufferedReader br) throws IOException {
		int aux = 0;
		String linha;

		linha = br.readLine();
		nomeIndicador = br.readLine();
		linha = br.readLine();
		
		while (linha != null) {
			
			if (linha.isEmpty()) {
				aux++;
			} else {
				dados.add(linha.split(": "));
			}

			if (aux == 2) {
				aux = 0;
				this.informacoes.put(nomeIndicador, dados);
				nomeIndicador = br.readLine();
				limpaDados();
			}
			
			linha = br.readLine();
		}

		br.close();
	}

}
