package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class TelaConsultasGerais extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_consultas_gerais);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}

	public void clickBotaoListaEstado(View view) {
		Intent intent = new Intent(this, TelaListaEstado.class);
		startActivity(intent);
	}

}
