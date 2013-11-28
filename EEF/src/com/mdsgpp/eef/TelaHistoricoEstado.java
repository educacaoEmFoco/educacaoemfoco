package com.mdsgpp.eef;

import java.io.IOException;
import java.util.HashMap;

import com.mdsgpp.eef.controle.EstadoControle;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.widget.Toast;

public class TelaHistoricoEstado extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_historico_estado);
		Intent intent = getIntent();
		
		int posicao = intent.getIntExtra("ESTADO", 0);
		HashMap<String, String> informacoes = new HashMap <String, String>();
		
		try {
			informacoes = EstadoControle.getInstancia(this).lerEstado(posicao);
			Log.i(null, informacoes.get("sigla"));
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso às informações.", Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaHistoricoEstado", e.toString());
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_historico_estado, menu);
		return true;
	}
	
}
