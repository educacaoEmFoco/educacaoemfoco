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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }	
    
    
    // Eventos
    public void clickBotaoListaEstados(View view) {
    	Intent intent = new Intent(this, TelaListaEstado.class);
		startActivity(intent);
    }
    
    public void clickBotaoComparacao(View view) {
    	Intent intent = new Intent(this, TelaComparacao.class);
		startActivity(intent);
    }
    
    public void clickBotaoSobre(View view){
    	Intent intent = new Intent(this, TelaSobre.class);
    	startActivity(intent);
    }
}
