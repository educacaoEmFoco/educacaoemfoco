package com.mdsgpp.eef;

import com.mdsgpp.eef.modelo.EstadoAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class TelaListaEstado extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_lista_estado);
		
		ListView listView = (ListView) findViewById(R.id.listview_tela_estados);
		
		EstadoAdapter adapter = new EstadoAdapter(this); 
		
		listView.setAdapter(adapter);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_lista_estado, menu);
		return true;
	}

	
}
