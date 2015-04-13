package com.mdsgpp.eef.visao;


import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class TelaResultadoConsultaPorIndicativo extends Activity {
	private final Context context = this;
	private ListView listaDeEstados = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_resultado_consulta_por_indicativo);
		inicializaViews();
		
		carregaIndicativosDosEstados();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(
				R.menu.menu_telas, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.sobre:
			abreTelaSobre();
			break;
			
		case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        break;
	        
		default:
			// Do nothing.
			break;
		}
		
    	return true;
	}
	
	// Change the activity to TelaSobreResultadosDaConsulta activity.
	public void abreTelaSobre() {
		Intent intent = new Intent(this, TelaSobreResultadoDaConsulta.class);
    	startActivity(intent);
		
	}
	
	// Takes the indicatives information from the previous activity to that.
	private void carregaIndicativosDosEstados() {
		Intent intent = getIntent();
			
		String indicativo = intent.getStringExtra("INDICATIVO");
		String titulo = intent.getStringExtra("TITULO");
			
		IndicativoAdapter adapter = new IndicativoAdapter(titulo, indicativo,
			context);
			
		listaDeEstados.setAdapter(adapter);
	}
	
	/*
	 * Assigns the class variable listaDeEstados with the ListView on the
	 * screen.
	 */
	public void inicializaViews(){
		listaDeEstados = (ListView) 
			findViewById(R.id.listview_tela_resultado_consulta_por_indicativo);
	}
	
	
}
