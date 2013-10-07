package com.mdsgpp.eef;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TelaComparacao extends Activity {
	
	Spinner estadosspinner01; 
	Spinner estadosspinner02; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_comparacao);
		
		// Captura o spinners
		estadosspinner01 = (Spinner) findViewById(R.id.spinner1);
		estadosspinner02 = (Spinner) findViewById(R.id.spinner2);
		
		ArrayAdapter<CharSequence> estados01 = ArrayAdapter.createFromResource(this, R.array.estados, android.R.layout.simple_list_item_1);
		estados01.setDropDownViewResource(android.R.layout.simple_list_item_1);
		
		ArrayAdapter<CharSequence> estados02 = ArrayAdapter.createFromResource(this, R.array.estados, android.R.layout.simple_list_item_1);
		estados02.setDropDownViewResource(android.R.layout.simple_list_item_1);
		
		// Define o adapter para os spinners
		estadosspinner01.setAdapter(estados01);
		estadosspinner02.setAdapter(estados02);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_comparacao, menu);
		return true;
	}

}
