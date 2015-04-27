/************************************************************************************************
 * File: AboutResultOfConsultationScreen.java 
 * 
 * Purpose: Create the screen responsible to show informations about the screen with results from
 * search.
 ************************************************************************************************/

package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AboutResultOfConsultationScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_sobre_resultado_da_consulta);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_telas_sem_sobre, menu);
		return true;
	}
}
