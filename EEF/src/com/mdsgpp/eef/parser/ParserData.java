package com.mdsgpp.eef.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.content.res.AssetManager;

public class ParserData {

	private HashMap<String, ArrayList<String[]>> informations;
	private ArrayList<String[]> data;
	private Context context;
	private String extension = ".txt";
	private String indicatorName;
	private int lines = 2;

	String states[][] = { {"Acre", "Acre"}, {"Alagoas", "Alagoas"},
			{"Amap�", "Amapa"}, {"Amazonas", "Amazonas"},
			{"Bahia", "Bahia"}, {"Cear�", "Ceara"},
			{"Distrito Federal", "Distrito Federal"},
			{"Esp�rito Santo", "Espirito Santo"}, {"Goi�s", "Goias"},
			{"Maranh�o", "Maranhao"}, {"Mato Grosso", "Mato Grosso"},
			{"Mato Grosso do Sul", "Mato Grosso do Sul"},
			{"Minas Gerais", "Minas Gerais"}, {"Par�", "Para"},
			{"Para�ba", "Paraiba"}, {"Paran�", "Parana"},
			{"Pernambuco", "Pernambuco"}, {"Piau�", "Piaui"},
			{"Rio de Janeiro", "Rio de Janeiro"},
			{"Rio Grande do Norte", "Rio Grande do Norte"},
			{"Rio Grande do Sul", "Rio Grande do Sul"},
			{"Rond�nia", "Rondonia"}, {"Roraima", "Roraima"},
			{"Santa Catarina", "Santa Catarina"},
			{"S�o Paulo", "Sao Paulo"}, {"Sergipe", "Sergipe"},
			{"Tocantins", "Tocantins"} };

	public ParserData(Context context) {
		this.context = context;
		this.informations = new HashMap<String, ArrayList<String[]>>();
	}

	// Acquire the informations about a state by it's ID, and save in a vector.
	public HashMap<String, ArrayList<String[]>> getEstado(int position) throws IOException {
		String name, acronym;

		AssetManager am = this.context.getAssets();
		InputStream is = am.open(this.states[position][1] + this.extension);
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		name = br.readLine();
		name = this.states[position][0];
		acronym = br.readLine();
		
		cleanInformations();
		cleanData();
		
		insertAcronymName(name, acronym);
		readIndicative(br);
		
		return informations;
	}

	// Clear the vector with the state's indicatives information.
	public void cleanInformations() {
		this.informations.clear();
	}
	
	// Clear the vector with the state's information.
	public void cleanData() {
		this.data = new ArrayList<String[]>(); 
	}

	// Responsible for sending the name and the symbol through the same hashmap indicative.
	public void insertAcronymName(String nome, String sigla) {
		ArrayList<String[]> container = new ArrayList<String[]>();
		String acronymAndName[] = new String[2];
		acronymAndName[0] = nome;
		acronymAndName[1] = sigla;
		
		container.add(acronymAndName);
		this.informations.put("nome_e_sigla", container);
	}
	
	// Responsible for reading the available data.
	public void readIndicative(BufferedReader br) throws IOException {
		int aux = 0;
		String line;

		line = br.readLine();
		indicatorName = br.readLine();
		line = br.readLine();
		
		while (line != null) {
			
			if (line.isEmpty()) {
				aux++;
			} 
			else {
				data.add(line.split(": "));
			}

			if (aux == lines) {
				aux = 0;
				this.informations.put(indicatorName, data);
				indicatorName = br.readLine();
				cleanData();
			}
			else {
				// Do nothing.
			}
			
			line = br.readLine();
		}

		br.close();
	}
}
