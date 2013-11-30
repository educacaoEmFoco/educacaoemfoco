package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.echo.holographlibrary.Bar;
import com.echo.holographlibrary.BarGraph;
import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controle.EstadoControle;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class TelaGrafico extends Activity {

	private int estado1;
	private int estado2;
	private String titulo;
	private String indicativo;
	private TextView tituloGrafico;
	private float valorIndicativoEstado1;
	private float valorIndicativoEstado2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_grafico);
		
		capturaInformacoes();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}
	
	@SuppressWarnings({"unchecked"})
	private void capturaInformacoes() {
		inicializaCamposTexto();
		
		// Captura o intent que abriu a activity
		Intent intent = getIntent();
		// Captura o valor transferido atrav√©s da intent
		estado1 = intent.getIntExtra("INDEX_ESTADO1_ESCOLHIDO", 0);
		estado2 = intent.getIntExtra("INDEX_ESTADO2_ESCOLHIDO", 0);
		titulo = intent.getStringExtra("TITULO");
		indicativo = intent.getStringExtra("INDICATIVO");

		HashMap<String, String> informacoesEstado1 = new HashMap<String, String>();
		HashMap<String, String> informacoesEstado2 = new HashMap<String, String>();

		try {
			informacoesEstado1 = (HashMap<String, String>) EstadoControle
					.getInstancia(this).lerEstado(estado1).clone();
			informacoesEstado2 = (HashMap<String, String>) EstadoControle
					.getInstancia(this).lerEstado(estado2).clone();
			
			converteDados(informacoesEstado1, informacoesEstado2);
			criaGrafico(informacoesEstado1, informacoesEstado2);
			
		} catch (IOException e) {
			Toast.makeText(getApplicationContext(), "Houve um erro no acesso ‡s informaÁıes.", Toast.LENGTH_SHORT).show();
			Log.i("IOException - TelaComparaEstados",e.toString());
		}
	}
	
	private void criaGrafico(HashMap<String, String> informacoesEstado1,
			HashMap<String, String> informacoesEstado2) {
		
        Bar estado1Barra = new Bar();
        estado1Barra.setColor(Color.parseColor("#4682B4"));
        estado1Barra.setName(informacoesEstado1.get("nome"));
		estado1Barra.setValue(valorIndicativoEstado1);
        
        Bar estado2Barra = new Bar();       
        estado2Barra.setColor(Color.parseColor("#191970"));
        estado2Barra.setName(informacoesEstado2.get("nome"));
        estado2Barra.setValue(valorIndicativoEstado2); 

		ArrayList<Bar> barras = new ArrayList<Bar>();     
        barras.add(estado1Barra);
        barras.add(estado2Barra);

        tituloGrafico.setText(titulo);
        
        BarGraph grafico = (BarGraph)findViewById(R.id.graph); 
        
        grafico.setBars(barras);
	}

	private void converteDados(HashMap<String, String> informacoesEstado1,
			HashMap<String, String> informacoesEstado2) {
		
		String estado1IndicativoString = informacoesEstado1.get(indicativo);
		String estado2IndicativoString = informacoesEstado2.get(indicativo);
				
		estado1IndicativoString = estado1IndicativoString.replaceAll("[^\\d,]", "");/*como os dados viram como est√£o escritos na tela
																					   aqui n√≥s pegamos somente os n√£o digitos (numeros)
																					   que est√£o na String*/
		estado2IndicativoString = estado2IndicativoString.replaceAll("[^\\d,]", "");
		
		estado1IndicativoString = estado1IndicativoString.replaceAll(",", ".");
		estado2IndicativoString = estado2IndicativoString.replaceAll(",", ".");
		
		valorIndicativoEstado1 = Float.parseFloat(estado1IndicativoString);
		valorIndicativoEstado2 = Float.parseFloat(estado2IndicativoString);
	}

	private void inicializaCamposTexto() {
		tituloGrafico = (TextView) findViewById(R.id.text_view_titulo_grafico);		
	}
}
