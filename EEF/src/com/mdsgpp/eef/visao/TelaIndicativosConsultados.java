package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class TelaIndicativosConsultados extends Activity {
	
	CheckBox cbIdeb, cbPib, cbPopulacao, cbPrimeirosProjetos, cbProjetosCnpq,
			cbProjetosDifusao, cbProjetosIniciacao, cbProjetosJovens;
	boolean bIdeb, bPib, bPopulacao, bPrimeirosProjetos, bProjetosCnpq,
			bProjetosDifusao, bProjetosIniciacao, bProjetosJovens;
	int posicao01, posicao02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_indicativos_consultados);
		Intent intentAuxiliar = getIntent();
		
		posicao01 = intentAuxiliar.getIntExtra("POSICAO_ESTADO01", 0);
		
		posicao02 = intentAuxiliar.getIntExtra("POSICAO_ESTADO02", 0);
		
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
	
	
public void onRadioButtonClicked(View view) {
		
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radioButtonMarcar:
                if (checked)
                	
                break;
            case R.id.radioButtonDesmarcar:
                if (checked)
                	
                break;
        }
}
	
	private void capturaValores() {
		bIdeb = cbIdeb.isChecked();
		bPib = cbPib.isChecked();
		bPopulacao = cbPopulacao.isChecked();
		bPrimeirosProjetos = cbPrimeirosProjetos.isChecked();
		bProjetosCnpq = cbProjetosCnpq.isChecked();
		bProjetosDifusao = cbProjetosDifusao.isChecked();
		bProjetosIniciacao = cbProjetosIniciacao.isChecked();
		bProjetosJovens = cbProjetosJovens.isChecked();
		
	}
	
	public void clickBotao(View view) {
		inicializaCheckBox();
		capturaValores();
		
		Intent intent = new Intent(this,TelaResultadoConsulta.class);
		intent.putExtra("CB_IDEB", bIdeb);
		intent.putExtra("CB_PIB", bPib);
		intent.putExtra("CB_POPULACAO", bPopulacao);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", bPrimeirosProjetos);
		intent.putExtra("CB_PROJETOS_CNPQ", bProjetosCnpq);
		intent.putExtra("CB_PROJETOS_DIFUSAO", bProjetosDifusao);
		intent.putExtra("CB_PROJETOS_INICIACAO", bProjetosIniciacao);
		intent.putExtra("CB_PROJETOS_JOVENS", bProjetosJovens);
		
		intent.putExtra("POSICAO_ESTADO_01",posicao01 );
		intent.putExtra("POSICAO_ESTADO_02",posicao02 );
		
		startActivity(intent);
		
	}

}
