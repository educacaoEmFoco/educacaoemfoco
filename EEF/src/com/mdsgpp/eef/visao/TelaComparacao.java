package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;

public class TelaComparacao extends Comparacao {
	@Override
	public void clickBotaoComparacaoEstados(View view) {
		Intent intent = new Intent(this, TelaIndicativosConsultados.class);
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
	
    public boolean onOptionsItemSelected(MenuItem item) {
    	
		switch (item.getItemId()) {
		case R.id.sobre:
			abreTelaSobre();
			break;
		case android.R.id.home:
	        NavUtils.navigateUpFromSameTask(this);
	        break;
		default:
			break;
		}
		
    	return true;
    }
    
    public void abreTelaSobre() {
    	Intent intent = new Intent(this, TelaSobreComparacao.class);
    	startActivity(intent);
    }
	
	public void clickBotaoSobreComparacao(View view){
    	Intent intent = new Intent(this, TelaSobreComparacao.class);
    	startActivity(intent);
    }
}
