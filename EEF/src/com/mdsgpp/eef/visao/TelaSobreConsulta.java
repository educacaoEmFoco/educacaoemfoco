package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TelaSobreConsulta extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_sobre_consulta);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_sobre_consulta, menu);
		return true;
	}

}
