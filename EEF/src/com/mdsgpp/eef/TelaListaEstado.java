package com.mdsgpp.eef;

import com.mdsgpp.eef.modelo.EstadoAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TelaListaEstado extends Activity {

	final Context context = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_lista_estado);
		
		// Captura a listview
		ListView listView = (ListView) findViewById(R.id.listview_tela_estados);
		
		// Cria um Adapter para a list view
		EstadoAdapter adapter = new EstadoAdapter(this); 
		
		// Define o adapter para a list view
		listView.setAdapter(adapter);
		// Cria o evento para responder à escolha de um item
		listView.setOnItemClickListener( new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
				// Cria uma nova intent para chamar a próxima activity
				Intent intent = new Intent(context, TelaEstado.class);
				// Transfere a posição do item escolhido através da intent para a próxima activity
				intent.putExtra("INDEX_ESTADO_ESCOLHIDO", position);
				// Executa a intent
				startActivity(intent);
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_lista_estado, menu);
		return true;
	}

	
}
