/******************************************************************************
 * File: ParserData.java 
 * 
 * Purpose: Parser the states outside data and store it on the State structure.
 ******************************************************************************/

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

	// Acquire the informations about a state by its ID, and save in an array.
	public HashMap<String, ArrayList<String[]>> getState(int position) throws IOException {
		AssetManager assetManager = null;
		assetManager = this.context.getAssets();
		
		InputStream inputStream = null;
		inputStream = assetManager.open(this.states[position][1] + this.extension);
		
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

		String name = null; 
		name = bufferedReader.readLine();
		name = this.states[position][0];
		
		String acronym = null;
		acronym = bufferedReader.readLine();
		
		cleanInformations();
		clearData();
		
		insertAcronymName(name, acronym);
		readIndicative(bufferedReader);
		
		return informations;
	}

	// Clear the array with the state's indicatives information.
	public void cleanInformations() {
		this.informations.clear();
	}
	
	// Clear the array with the state's information.
	public void clearData() {
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
	public void readIndicative(BufferedReader bufferedReader) throws IOException {
		String currentReadLine = null;
		currentReadLine = bufferedReader.readLine();
		this.indicatorName = bufferedReader.readLine();
		currentReadLine = bufferedReader.readLine();
		
		int lineCounting = 0;
		while (currentReadLine != null) {
			if (currentReadLine.isEmpty()) {
				lineCounting++;
			} 
			else {
				this.data.add(currentReadLine.split(": "));
			}

			if (lineCounting == this.lines) {
				lineCounting = 0;
				this.informations.put(indicatorName, data);
				this.indicatorName = bufferedReader.readLine();
				clearData();
			}
			else {
				// Do nothing.
			}
			
			currentReadLine = bufferedReader.readLine();
		}
		
		bufferedReader.close();
	}
}
