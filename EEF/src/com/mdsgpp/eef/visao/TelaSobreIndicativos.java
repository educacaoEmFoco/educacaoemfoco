package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class TelaSobreIndicativos extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sobre_indicativos);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sobre_indicativos, menu);
		return true;
	}

}