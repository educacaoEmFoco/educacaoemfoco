package com.mdsgpp.eef.visao;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;

import com.mdsgpp.eef.R;

public class TelaEscolheIndicativoGraficoComparacao extends EscolheIndicativo{
	public void onRadioButtonClicked(View view) {

		boolean checked = ((RadioButton) view).isChecked();
		
		switch (view.getId()) {
		case R.id.radio_apoio_cnpq_investimento:
			if (checked)
				setIndicativo("valor_projetos_cnpq");
				setTitulo("Projetos de Pesquisa Apoio CNPq (R$)");
			break;
		case R.id.radio_apoio_cnpq_qtd:
			if (checked)
				setIndicativo("quantidade_projeto_cnpq");
				setTitulo("rojetos de Pesquisa Apoio CNPq (Qtd.)");
			break;
		case R.id.radio_difusao_tecnologica_investimento:
			if (checked)
				setIndicativo("valor_ciencia_tecnologia");
				setTitulo("Projeto de Difus�o Tecnol�gica (R$)");
			break;
		case R.id.radio_difusao_tecnologica_qtd:
			if (checked)
				setIndicativo("projetos_ciencia_tecnologia");
				setTitulo("Projeto de Difus�o Tecnol�gica (Qtd.)");
			break;
		case R.id.radio_ideb_fundamental_finais:
			if (checked)
				setIndicativo("ideb_fundamental_final");
				setTitulo("IDEB do Ensino Fundamental (S�ries Finais)");
			break;
		case R.id.radio_ideb_fundamental_iniciai:
			if (checked)
				setIndicativo("ideb_fundamental_inicial");
				setTitulo("IDEB do Ensino Fundamental (S�ries Iniciais)");
			break;
		case R.id.radio_ideb_medio:
			if (checked)
				setIndicativo("ideb_ensino_medio");
				setTitulo("IDEB do Ensino M�dio");
			break;
		case R.id.radio_jovens_pesquisadores_investimento:
			if (checked)
				setIndicativo("valor_projetos_jovens_pesquisadores");
				setTitulo("Jovens pesquisadores (R$)");
			break;

		case R.id.radio_jovens_pesquisadores_qtd:
			if (checked)
				setIndicativo("quantidade_projeto_jovens_pesquisadores");
				setTitulo("Jovens pesquisadores (Qtd.)");
			break;

		case R.id.radio_pib:
			if (checked)
				setIndicativo("percentual_participacao_pib");
				setTitulo("Participa��o Estadual no PIB (%)");
			break;

		case R.id.radio_populacao:
			if (checked)
				setIndicativo("populacao");
				setTitulo("Popula��o");
			break;

		case R.id.radio_primeiros_projetos_investimento:
			if (checked)
				setIndicativo("valor_primeiros_projetos");
				setTitulo("Programa Primeiros Projetos (R$)");
			break;

		case R.id.radio_primeiros_projetos_qtd:
			if (checked)
				setIndicativo("quantidade_primeiros_projetos");
				setTitulo("Programa Primeiros Projetos (Qtd.)");
			break;

		case R.id.radio_projetos_inct_investimento:
			if (checked)
				setIndicativo("valor_projetos_inct");
				setTitulo("Projetos INCT (R$)");
			break;

		case R.id.radio_projetos_inct_qtd:
			if (checked)
				setIndicativo("quantidade_projetos_inct");
				setTitulo("Projetos INCT (Qtd.)");
			break;
		}
	}

	public void clickBotaoGrafico(View view) {
		Intent intent = new Intent(this, TelaGrafico.class);
		
		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", getPosicao1());
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", getPosicao2());
		intent.putExtra("INDICATIVO", getIndicativo());
		intent.putExtra("TITULO", getTitulo());

		startActivity(intent);		
	}
}
