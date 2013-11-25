package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }	
    
    
    // Eventos 
   
    public void clickBotaoComparacaoGeral(View view) {
    	Intent intent = new Intent(this, TelaComparacoesGerais.class);
		startActivity(intent);
    }

    public void clickBotaoSobre(View view){
    	Intent intent = new Intent(this, TelaSobre.class);
    	startActivity(intent);
    }
    
    public void clickBotaoConsultaGeral(View view){
    	Intent intent = new Intent(this, TelaConsultasGerais.class);
    	startActivity(intent);
    }
    
    public void clickBotaoFeed(View view){
    	Intent intent = new Intent(this, TelaFeed.class);
    	startActivity(intent);
    }
}