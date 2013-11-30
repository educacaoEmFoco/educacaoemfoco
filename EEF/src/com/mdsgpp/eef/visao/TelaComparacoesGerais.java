package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class TelaComparacoesGerais extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_comparacoes_gerais);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}
	
    public boolean onOptionsItemSelected(MenuItem item) {
    	
		switch (item.getItemId()) {
		case R.id.sobre:
			abreTelaSobre();
			break;
		default:
			break;
		}
		
    	return true;
    }
    
    public void abreTelaSobre() {
    	Intent intent = new Intent(this, TelaSobreComparacoesGerais.class);
    	startActivity(intent);
    }
	
	public void clickBotaoComparacao(View view) {
		Intent intent = new Intent(this, TelaComparacao.class);
		startActivity(intent);
	}
	
	public void clickBotaoIndicativos(View view) {
		Intent intent = new Intent(this, TelaConsultaPorIndicativo.class);
		startActivity(intent);
	}
	
}

