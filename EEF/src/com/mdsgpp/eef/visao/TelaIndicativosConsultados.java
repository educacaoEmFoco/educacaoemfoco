package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.R.layout;
import com.mdsgpp.eef.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;

public class TelaIndicativosConsultados extends Activity {
	
	CheckBox cbIdeb, cbPib, cbPopulacao, cbPrimeirosProjetos, cbProjetosCnpq,
			cbProjetosDifusao, cbProjetosIniciacao, cbProjetosJovens;
	int posicao01, posicao02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_indicativos_consultados);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_indicativos_consultados, menu);
		return true;
	}
	
	
	private void inicializaCheckBox() {
		cbIdeb = (CheckBox) findViewById(R.id.checkBox_ideb);
		cbPib = (CheckBox) findViewById(R.id.checkBox_participacao_pib);
		cbPopulacao = (CheckBox) findViewById(R.id.checkBox_populacao);
		cbPrimeirosProjetos = (CheckBox) findViewById(R.id.checkBox_primeiros_projeto);
		cbProjetosCnpq = (CheckBox) findViewById(R.id.checkBox_projetos_cnpq);
		cbProjetosDifusao = (CheckBox) findViewById(R.id.checkBox_projetos_difusao);
		cbProjetosIniciacao = (CheckBox) findViewById(R.id.checkBox_projetos_iniciacao);
		cbProjetosJovens = (CheckBox) findViewById(R.id.checkBox_projetos_jovens);
	}

}
