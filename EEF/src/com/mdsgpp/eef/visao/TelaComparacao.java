package com.mdsgpp.eef.visao;

import android.content.Intent;
import android.view.View;

public class TelaComparacao extends Comparacao {
	@Override
	public void clickBotaoComparacaoEstados(View view) {
		preencheTodosEstados();
		Intent intent = new Intent(this, TelaComparaEstados.class);
		getEstadosSpinner01().getSelectedItem().toString();
		getEstadosSpinner().getSelectedItem().toString();

		int posicao1 = getTodosEstados().indexOf(getEstadosSpinner01().getSelectedItem()
				.toString());
		int posicao2 = getTodosEstados().indexOf(getEstadosSpinner().getSelectedItem()
				.toString());

		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", posicao1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", posicao2);

		startActivity(intent);
	}	
}
