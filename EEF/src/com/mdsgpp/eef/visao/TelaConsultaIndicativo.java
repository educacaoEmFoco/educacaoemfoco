package com.mdsgpp.eef.visao;

import android.content.Intent;
import android.view.View;


public class TelaConsultaIndicativo extends Comparacao {
	
	@Override
	public void clickBotaoComparacaoEstados(View view){
	
		int posicao01 = getEstadosSpinner().getSelectedItemPosition();
		int posicao02 = getEstadosSpinner01().getSelectedItemPosition();
		
		Intent intent = new Intent(this, TelaIndicativosConsultados.class);
		
		intent.putExtra("POSICAO_ESTADO01", posicao01);
		intent.putExtra("POSICAO_ESTADO02", posicao02);
		
		startActivity(intent);
	}	
}

