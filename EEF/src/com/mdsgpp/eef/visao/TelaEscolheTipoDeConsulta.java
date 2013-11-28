package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class TelaEscolheTipoDeConsulta extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_tipo_de_consulta);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_escolhe_tipo_de_consulta, menu);
		return true;
	}

    public void clickBotaoHistorico(View view) {
    	Intent intent = new Intent(this, TelaEscolheTipoDeConsulta.class);
		startActivity(intent);
    }
    
    public void clickBotaoEstados(View view) {
    	Intent intent = new Intent(this, TelaListaEstado.class);
		startActivity(intent);
    }

}
