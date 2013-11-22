package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class TelaResultadoConsultaPorIndicativo extends Activity {
	private ArrayList<String> indicativos = new ArrayList<String>();
	private final Context context = this;
	private HashMap<String, String> informacaoEstado = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_resultado_consulta_por_indicativo);
		
		Intent intent = getIntent();
		
		String indicativo = intent.getStringExtra("INDICATIVO");
		
		IndicativoAdapter adapter = new IndicativoAdapter(indicativo, context);

		for(int i=0;i<adapter.getCount();i++){
			try{
				indicativos.add(adapter.getItem(i).get(indicativo));
				Log.i("teste reusultado consulta", indicativos.get(i));
			}catch(NullPointerException e){
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(
				R.menu.tela_resultado_consulta_por_indicativo, menu);
		return true;
	}

}
