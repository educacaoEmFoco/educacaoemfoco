package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.R.layout;
import com.mdsgpp.eef.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class TelaSobre extends Activity {
	
	private TextView textViewParticipacaoPib;
	private TextView textViewProjetosDifusao ;
	private TextView textViewIdeb;
	private TextView textViewProjetosApoioCnpq;
	private TextView textViewProjetosJovensPesquisadores;
	private TextView textViewProjetosInct;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_sobre);
		
		InicializaCamposTexto();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_sobre, menu);
		return true;
	}
	
private void InicializaCamposTexto() {
		
		textViewParticipacaoPib = (TextView) findViewById(R.id.textView_participacaoPIB);
		textViewProjetosDifusao = (TextView) findViewById(R.id.textView_projetos_difusao);
		textViewIdeb = (TextView) findViewById(R.id.textView_ideb);
		textViewProjetosApoioCnpq = (TextView) findViewById(R.id.textView_projetos_apoio_cnpq);
		textViewProjetosJovensPesquisadores = (TextView) findViewById(R.id.textView_projetos_jovens_pesquisadores);
		textViewProjetosInct = (TextView) findViewById(R.id.textView_projetos_inct);

  }

}
