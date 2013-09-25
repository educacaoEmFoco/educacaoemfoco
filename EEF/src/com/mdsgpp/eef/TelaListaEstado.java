package com.mdsgpp.eef;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class TelaListaEstado extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_lista_estado);
		
		ListView listView = (ListView) findViewById(R.id.listview_tela_estados);
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("Acre");
		lista.add("Bahia");
		lista.add("Ceara");
		lista.add("Alagoas");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,  R.layout.listview_item,lista);
		listView.setAdapter(adapter);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_lista_estado, menu);
		return true;
	}

	
}
