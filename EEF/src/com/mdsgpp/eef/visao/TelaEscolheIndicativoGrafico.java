package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;

public class TelaEscolheIndicativoGrafico extends Activity {
	private String indicativo = "valorpadrao";
	private String titulo = "valorpadrao";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_escolhe_indicativo_grafico, menu);
		return true;
	}
	
	
	public void onRadioButtonClicked(View view) {
		
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio_apoio_cnpq_investimento:
                if (checked)
                break;
            case R.id.radio_apoio_cnpq_qtd:
                if (checked)
                break;
            case R.id.radio_difusao_tecnologica_investimento:
                if (checked)
                break;
            case R.id.radio_difusao_tecnologica_qtd:
                if (checked)
                break;
            case R.id.radio_ideb_fundamental_finais:
                if (checked)
                break;
            case R.id.radio_ideb_fundamental_iniciai:
                if (checked)
                break;
            case R.id.radio_ideb_medio:
                if (checked)
                break;
            case R.id.radio_jovens_pesquisadores_investimento:
                if (checked)
                break;
                
            case R.id.radio_jovens_pesquisadores_qtd:
                if (checked)
                break;
                
            case R.id.radio_pib:
                if (checked)
                break;
                
            case R.id.radio_populacao:
                if (checked)
                break;
                
            case R.id.radio_primeiros_projetos_investimento:
                    if (checked)
                    break;
                    
                case R.id.radio_primeiros_projetos_qtd:
                    if (checked)
                    break;
                    
                case R.id.radio_projetos_inct_investimento:
                    if (checked)
                    break;
                    
                case R.id.radio_projetos_inct_qtd:
                    if (checked)
                    break;
        }
        }
	
	public void clickBotaoGrafico(View view) {
		Intent intent = new Intent(this, TelaGrafico.class);
		Intent intent1 = getIntent();

		int posicao1 = intent1.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		int posicao2 = intent1.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);

		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", posicao1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", posicao2);
		intent.putExtra("INDICATIVO", indicativo);
		intent.putExtra("TITULO", titulo);

		startActivity(intent);
	}	
}
