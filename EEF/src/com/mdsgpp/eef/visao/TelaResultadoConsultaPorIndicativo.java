package com.mdsgpp.eef.visao;


import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

public class TelaResultadoConsultaPorIndicativo extends Activity {
	private final Context context = this;
	private ListView listaDeEstados = null;
	private TextView textViewTitulo = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_resultado_consulta_por_indicativo);
		inicializaViews();
		
		carregaIndicativosDosEstados();
		
		//carregaTitulo();

		Intent intent = getIntent();
		
		String titulo = intent.getStringExtra("TITULO");
		
		textViewTitulo.setText(titulo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(
				R.menu.tela_resultado_consulta_por_indicativo, menu);
		return true;
	}
	
	private void carregaIndicativosDosEstados() {
			Intent intent = getIntent();
			
			String indicativo = intent.getStringExtra("INDICATIVO");

			IndicativoAdapter adapter = new IndicativoAdapter(indicativo,
					context);
			
			listaDeEstados.setAdapter(adapter);
	}
	
	public void inicializaViews(){
		listaDeEstados = (ListView) findViewById(R.id.listview_tela_resultado_consulta_por_indicativo);
		textViewTitulo = (TextView) findViewById(R.id.text_view_titulo_indicativo);
	}
	
	public void carregaTitulo(){
		Intent intent = getIntent();
		String titulo = intent.getStringExtra("TITULO");
		
		textViewTitulo.setText(titulo);
	}
	
}
