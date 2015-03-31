package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_telas, menu);
        
        return true;
    }	
        
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
		switch(item.getItemId()) {
    		case R.id.sobre:
    			abreTelaSobre();
    			break;
    		default:
    			break;
		}
		
    	return true;
    }
    
    public void abreTelaSobre() {
    	Intent intent = new Intent(this, TelaSobre.class);
    	startActivity(intent);
    }

    public void clickBotaoComparacaoGeral(View view) {
    	Intent intent = new Intent(this, TelaComparacoesGerais.class);
		startActivity(intent);
    }
    
    public void clickBotaoConsultaGeral(View view) {
    	Intent intent = new Intent(this, TelaListaEstado.class);
    	startActivity(intent);
    }
    
    public void clickBotaoFeed(View view) {
    	Intent intent = new Intent(this, TelaFeed.class);
    	startActivity(intent);
    }
    public void clickBotaoConsultaPorIndicativo(View view) {
    	Intent intent = new Intent(this, TelaConsultaPorIndicativo.class);
    	startActivity(intent);
    }
}