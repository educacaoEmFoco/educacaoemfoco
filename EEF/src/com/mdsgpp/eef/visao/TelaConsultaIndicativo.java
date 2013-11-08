package com.mdsgpp.eef.visao;

import android.content.Intent;
import android.view.View;


public class TelaConsultaIndicativo extends Comparacao {
	
	@Override
	public void clickBotaoComparacaoEstados(View view){
		preencheTodosEstados();
		
		getEstadosSpinner01().getSelectedItem().toString();
		getEstadosSpinner().getSelectedItem().toString();

		int posicao01 = getTodosEstados().indexOf(getEstadosSpinner01().getSelectedItem()
				.toString());
		int posicao02 = getTodosEstados().indexOf(getEstadosSpinner().getSelectedItem()
				.toString());
		
		Intent intent = new Intent(this, TelaIndicativosConsultados.class);
		
		intent.putExtra("POSICAO_ESTADO01", posicao01);
		intent.putExtra("POSICAO_ESTADO02", posicao02);
		
		startActivity(intent);
	}	
}

