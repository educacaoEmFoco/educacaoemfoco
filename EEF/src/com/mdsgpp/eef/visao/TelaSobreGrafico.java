package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TelaSobreGrafico extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_sobre_grafico);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas_sem_sobre, menu);
		return true;
	}

}
