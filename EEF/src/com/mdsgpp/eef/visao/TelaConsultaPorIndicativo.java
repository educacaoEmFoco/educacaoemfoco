package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class TelaConsultaPorIndicativo extends EscolheIndicativo {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
		
		TextView txtViewTitulo = (TextView) findViewById(R.id.textview_titulo);
		txtViewTitulo.setText("Escolha um indicativo para gerar a lista: ");
	}

	public void abreTelaSobre() {
		Intent intent = new Intent(this, TelaSobreIndicativos.class);
		startActivity(intent);
	}
	
	public void clickBotaoAvancar(View view) {
		Intent intent = new Intent(this, TelaResultadoConsultaPorIndicativo.class);

		intent.putExtra("INDICATIVO", getIndicativo());
		intent.putExtra("TITULO", getTitulo());

		startActivity(intent);
	}
	
}