package com.mdsgpp.eef;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TelaComparacao extends Activity {
	
	Spinner spinnerestados; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_comparacao);
		
		// Captura o spinner
		spinnerestados = (Spinner) findViewById(R.id.spinner1);
		
		ArrayAdapter<CharSequence> estados = ArrayAdapter.createFromResource(this, R.array.estados, android.R.layout.simple_dropdown_item_1line);
		estados.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		
		// Define o adapter para o spinner
		spinnerestados.setAdapter(estados);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_comparacao, menu);
		return true;
	}

}
