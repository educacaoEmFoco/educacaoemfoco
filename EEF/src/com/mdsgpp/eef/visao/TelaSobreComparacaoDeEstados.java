package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.R.layout;
import com.mdsgpp.eef.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TelaSobreComparacaoDeEstados extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sobre_tela_comparacao_de_estados);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_comparacao_de_estados, menu);
		return true;
	}

}
