package com.mdsgpp.eef;

import java.io.IOException;

import com.mdsgpp.eef.modelo.Estado;
import com.mdsgpp.eef.parse.DadosParse;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class TelaEstado extends Activity {

	String estados[] = {"Acre", "Alagoas", "Amapa", "Amazonas", "Bahia", 
			"Ceara", "Distrito Federal","Espirito Santo","Goias", "Maranhao",
			"Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Para", "Paraiba",
			"Parana", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte",
			"Rio Grande do Sul", "Rondonia", "Roraima", "Sao Paulo", "Santa Catarina",
			"Sergipe", "Tocantins"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_estado);
		
		// Captura o intent que abriu a activity
		Intent intent = getIntent();
		// Captura o valor transferido através da intent
		int posicao = intent.getIntExtra("INDEX_ESTADO_ESCOLHIDO", 0);
		
		TextView textView = (TextView) findViewById(R.id.text_view_estado);
		textView.setText("Posição selecionada: "+posicao);
		
		DadosParse parser = new DadosParse(this);
		
		try {
			Estado estado = parser.getEstado(estados[posicao]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_estado, menu);
		return true;
	}

}
