package com.mdsgpp.eef;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TelaComparacao extends Activity {

	private Spinner estadosSpinner01;
	private Spinner estadosSpinner;
	private ArrayAdapter<String> estadosAdapter01;
	private ArrayAdapter<String> estadosAdapter02;
	private ArrayList<String> estados01;
	private ArrayList<String> estados02;
	private ArrayList<String> todosEstados;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_comparacao);

		inicializaSpinners();
		preencheEstados01();
		preencheEstados02();

		setAdapterSpinner01();
		setAdapterSpinner02();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_comparacao, menu);
		return true;
	}

	private void inicializaSpinners() {
		estados01 = new ArrayList<String>();
		estados02 = new ArrayList<String>();
		todosEstados = new ArrayList<String>();

		estadosSpinner01 = (Spinner) findViewById(R.id.spinner1);
		estadosSpinner01
				.setOnItemSelectedListener(new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> adapter,
							View view, int posicao, long id) {
						atualizaValoresSpinner02(estadosSpinner01
								.getSelectedItem().toString());
					}

					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
						// nada a fazer
					}
				});

		estadosSpinner = (Spinner) findViewById(R.id.spinner2);
		estadosSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> adapter, View view,
					int posicao, long id) {
				atualizaValoresSpinner01(estadosSpinner.getSelectedItem()
						.toString());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// nada a fazer
			}
		});

	}

	private void setAdapterSpinner01() {
		estadosAdapter01 = new ArrayAdapter<String>(this,
				R.layout.spinner_item, estados01);
		estadosAdapter01
				.setDropDownViewResource(android.R.layout.simple_list_item_1);

		estadosSpinner01.setAdapter(estadosAdapter01);
	}

	private void setAdapterSpinner02() {
		estadosAdapter02 = new ArrayAdapter<String>(this,
				R.layout.spinner_item, estados02);
		estadosAdapter02.setDropDownViewResource(R.layout.spinner_item);

		// Define o adapter para os spinners
		estadosSpinner.setAdapter(estadosAdapter02);
	}

	private void preencheEstados01() {
		estados01.clear();

		estados01.add("Acre");
		estados01.add("Alagoas");
		estados01.add("Amap�");
		estados01.add("Amazonas");
		estados01.add("Bahia");
		estados01.add("Cear�");
		estados01.add("Distrito Federal");
		estados01.add("Esp�rito Santo");
		estados01.add("Goi�s");
		estados01.add("Maranh�o");
		estados01.add("Mato Grosso");
		estados01.add("Mato Grosso do Sul");
		estados01.add("Minas Gerais");
		estados01.add("Par�");
		estados01.add("Para�ba");
		estados01.add("Paran�");
		estados01.add("Pernambuco");
		estados01.add("Piau�");
		estados01.add("Rio de Janeiro");
		estados01.add("Rio Grande do Norte");
		estados01.add("Rio Grande do Sul");
		estados01.add("Rond�nia");
		estados01.add("Roraima");
		estados01.add("Santa Catarina");
		estados01.add("S�o Paulo");
		estados01.add("Sergipe");
		estados01.add("Tocantins");
	}

	private void preencheEstados02() {
		estados02.clear();

		estados02.add("Acre");
		estados02.add("Alagoas");
		estados02.add("Amap�");
		estados02.add("Amazonas");
		estados02.add("Bahia");
		estados02.add("Cear�");
		estados02.add("Distrito Federal");
		estados02.add("Esp�rito Santo");
		estados02.add("Goi�s");
		estados02.add("Maranh�o");
		estados02.add("Mato Grosso");
		estados02.add("Mato Grosso do Sul");
		estados02.add("Minas Gerais");
		estados02.add("Par�");
		estados02.add("Para�ba");
		estados02.add("Paran�");
		estados02.add("Pernambuco");
		estados02.add("Piau�");
		estados02.add("Rio de Janeiro");
		estados02.add("Rio Grande do Norte");
		estados02.add("Rio Grande do Sul");
		estados02.add("Rond�nia");
		estados02.add("Roraima");
		estados02.add("Santa Catarina");
		estados02.add("S�o Paulo");
		estados02.add("Sergipe");
		estados02.add("Tocantins");

	}

	private void preencheTodosEstados() {
		todosEstados.clear();

		todosEstados.add("Acre");
		todosEstados.add("Alagoas");
		todosEstados.add("Amap�");
		todosEstados.add("Amazonas");
		todosEstados.add("Bahia");
		todosEstados.add("Cear�");
		todosEstados.add("Distrito Federal");
		todosEstados.add("Esp�rito Santo");
		todosEstados.add("Goi�s");
		todosEstados.add("Maranh�o");
		todosEstados.add("Mato Grosso");
		todosEstados.add("Mato Grosso do Sul");
		todosEstados.add("Minas Gerais");
		todosEstados.add("Par�");
		todosEstados.add("Para�ba");
		todosEstados.add("Paran�");
		todosEstados.add("Pernambuco");
		todosEstados.add("Piau�");
		todosEstados.add("Rio de Janeiro");
		todosEstados.add("Rio Grande do Norte");
		todosEstados.add("Rio Grande do Sul");
		todosEstados.add("Rond�nia");
		todosEstados.add("Roraima");
		todosEstados.add("Santa Catarina");
		todosEstados.add("S�o Paulo");
		todosEstados.add("Sergipe");
		todosEstados.add("Tocantins");

	}

	private void atualizaValoresSpinner01(String nome) {
		preencheEstados01();
		estados01.remove(nome);
		estadosAdapter01.notifyDataSetChanged();
	}

	private void atualizaValoresSpinner02(String nome) {
		preencheEstados02();
		estados02.remove(nome);
		estadosAdapter02.notifyDataSetChanged();
	}

	public void clickBotaoComparacaoEstados(View view) {
		preencheTodosEstados();
		Intent intent = new Intent(this, TelaComparaEstados.class);
		estadosSpinner01.getSelectedItem().toString();
		estadosSpinner.getSelectedItem().toString();

		int posicao1 = todosEstados.indexOf(estadosSpinner01.getSelectedItem()
				.toString());
		int posicao2 = todosEstados.indexOf(estadosSpinner.getSelectedItem()
				.toString());

		intent.putExtra("INDEX_ESTADO1_ESCOLHIDO", posicao1);
		intent.putExtra("INDEX_ESTADO2_ESCOLHIDO", posicao2);

		startActivity(intent);
	}

}
