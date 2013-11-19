package com.mdsgpp.eef;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class TelaEscolheIndicativoGrafico extends Activity {

	public void clickBotaoSobreIndicativos(View view) {
		Intent intent = new Intent(this, SobreIndicativosActivity.class);
		
		
		startActivity(intent);
	}	


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_escolhe_indicativo_grafico, menu);
		return true;
	}

}
