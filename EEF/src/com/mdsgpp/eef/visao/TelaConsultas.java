package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.R.layout;
import com.mdsgpp.eef.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class TelaConsultas extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_consultas);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_consultas, menu);

		return true;
	}

	public void clickBotaoListaEstados(View view) {
		Intent intent = new Intent(this, TelaListaEstado.class);
		startActivity(intent);
	}

	public void clickBotaoConsulta(View view) {
		Intent intent = new Intent(this, TelaConsultaIndicativo.class);
		startActivity(intent);
	}

}
