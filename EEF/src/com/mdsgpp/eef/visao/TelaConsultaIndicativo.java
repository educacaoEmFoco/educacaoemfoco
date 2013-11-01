package com.mdsgpp.eef.visao;

import java.util.ArrayList;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.R.layout;
import com.mdsgpp.eef.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TelaConsultaIndicativo extends Activity {

	private Spinner estadosSpinner01;
	private Spinner estadosSpinner02;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_consulta_indicativo);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_consulta_indicativo, menu);
		return true;
	}
	
	private void inicializaSpinner(){
	
	estadosSpinner01 = (Spinner) findViewById(R.id.spinner_consulta01);
	estadosSpinner02 = (Spinner) findViewById(R.id.spinner_consulta02);
	
	ArrayAdapter<String> estadoAdapter01 = new ArrayAdapter<String>(this, R.layout.spinner_item, preencherEstado()); 
	ArrayAdapter<String> estadoAdapter02 = new ArrayAdapter<String>(this, R.layout.spinner_item, preencherEstado());

	estadosSpinner01.setAdapter(estadoAdapter01);
	estadosSpinner02.setAdapter(estadoAdapter02);
}

private ArrayList<String> preencherEstado(){
	ArrayList<String> estados01 = new ArrayList<String>();
	
	estados01.add("Acre");
	estados01.add("Alagoas");
	estados01.add("Amapá");
	estados01.add("Amazonas");
	estados01.add("Bahia");
	estados01.add("Ceará");
	estados01.add("Distrito Federal");
	estados01.add("Espírito Santo");
	estados01.add("Goiás");
	estados01.add("Maranhão");
	estados01.add("Mato Grosso");
	estados01.add("Mato Grosso do Sul");
	estados01.add("Minas Gerais");
	estados01.add("Pará");
	estados01.add("Paraíba");
	estados01.add("Paraná");
	estados01.add("Pernambuco");
	estados01.add("Piauí");
	estados01.add("Rio de Janeiro");
	estados01.add("Rio Grande do Norte");
	estados01.add("Rio Grande do Sul");
	estados01.add("Rondônia");
	estados01.add("Roraima");
	estados01.add("Santa Catarina");
	estados01.add("São Paulo");
	estados01.add("Sergipe");
	estados01.add("Tocantins");
	
	return estados01;
} 


}
