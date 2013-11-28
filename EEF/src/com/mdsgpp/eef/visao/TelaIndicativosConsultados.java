package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;

public class TelaIndicativosConsultados extends Activity {

	CheckBox cbIdeb, cbPib, cbPopulacao, cbPrimeirosProjetos, cbProjetosCnpq,
			cbProjetosDifusao, cbProjetosIniciacao, cbProjetosJovens, cbCenso,
			cbAlunosTurma, cbHorasAula, cbTaxaDistorcao, cbTaxaAbandono,
			cbAprovacao;
	boolean bIdeb, bPib, bPopulacao, bPrimeirosProjetos, bProjetosCnpq,
			bProjetosDifusao, bProjetosIniciacao, bProjetosJovens, bCenso,
			bAlunosTurma, bHorasAula, bTaxaDistorcao, bTaxaAbandono,
			bAprovacao;
	int posicao01, posicao02;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_indicativos_consultados);
		Intent intentAuxiliar = getIntent();

		inicializaCheckBox();

		posicao01 = intentAuxiliar.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		posicao02 = intentAuxiliar.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas_sem_sobre, menu);
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
		cbCenso = (CheckBox) findViewById(R.id.checkBox_censo);
		cbAlunosTurma = (CheckBox) findViewById(R.id.checkBox_quantidade_aluno);
		cbHorasAula = (CheckBox) findViewById(R.id.checkBox_horas_aula);
		cbTaxaDistorcao = (CheckBox) findViewById(R.id.checkBox_taxa_distorcao);
		cbTaxaAbandono = (CheckBox) findViewById(R.id.checkBox_taxa_abandono);
		cbAprovacao = (CheckBox) findViewById(R.id.checkBox_taxa_aprovacao);
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
		bCenso = cbCenso.isChecked();
		bAlunosTurma = cbAlunosTurma.isChecked();
		bHorasAula = cbHorasAula.isChecked();
		bTaxaDistorcao = cbTaxaDistorcao.isChecked();
		bTaxaAbandono = cbTaxaAbandono.isChecked();
		bAprovacao = cbAprovacao.isChecked();
	}
	
	public void marcaOuDesmarcaCheckBox(boolean opcaoEscolhida) {
		cbIdeb.setChecked(opcaoEscolhida);
		cbPib.setChecked(opcaoEscolhida);
		cbPopulacao.setChecked(opcaoEscolhida);
		cbPrimeirosProjetos.setChecked(opcaoEscolhida);
		cbProjetosCnpq.setChecked(opcaoEscolhida);
		cbProjetosDifusao.setChecked(opcaoEscolhida);
		cbProjetosIniciacao.setChecked(opcaoEscolhida);
		cbProjetosJovens.setChecked(opcaoEscolhida);
		cbCenso.setChecked(opcaoEscolhida);
		cbAlunosTurma.setChecked(opcaoEscolhida);
		cbHorasAula.setChecked(opcaoEscolhida);
		cbTaxaDistorcao.setChecked(opcaoEscolhida);
		cbTaxaAbandono.setChecked(opcaoEscolhida);
		cbAprovacao.setChecked(opcaoEscolhida);
	}
	
	public void onRadioButtonMarcarTodosClicked(View view) {
		marcaOuDesmarcaCheckBox(true);
	}

	public void onRadioButtonDesmarcarTodosClicked(View view) {
		marcaOuDesmarcaCheckBox(false);
	}
	
	public void clickBotao(View view) {
		capturaValores();

		Intent intent = new Intent(this, TelaResultadoConsulta.class);
		intent.putExtra("CB_IDEB", bIdeb);
		intent.putExtra("CB_PIB", bPib);
		intent.putExtra("CB_POPULACAO", bPopulacao);
		intent.putExtra("CB_PRIMEIROS_PROJETOS", bPrimeirosProjetos);
		intent.putExtra("CB_PROJETOS_CNPQ", bProjetosCnpq);
		intent.putExtra("CB_PROJETOS_DIFUSAO", bProjetosDifusao);
		intent.putExtra("CB_PROJETOS_INICIACAO", bProjetosIniciacao);
		intent.putExtra("CB_PROJETOS_JOVENS", bProjetosJovens);
		intent.putExtra("CB_ALUNOS_TURMA", bAlunosTurma);
		intent.putExtra("CB_APROVACAO", bAprovacao);
		intent.putExtra("CB_CENSO", bCenso);
		intent.putExtra("CB_HORAS_AULA", bHorasAula);
		intent.putExtra("CB_TAXA_ABANDONO", bTaxaAbandono);
		intent.putExtra("CB_TAXA_DISTORCAO", bTaxaDistorcao);
		
		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", posicao01);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", posicao02);

		startActivity(intent);
	}

}
