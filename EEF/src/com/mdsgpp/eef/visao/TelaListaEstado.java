package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.visao.EstadoAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class TelaListaEstado extends Activity {

	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_lista_estado);

		inicializaListView();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}
	
	 @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	    	
			switch (item.getItemId()) {
			case R.id.sobre:
				abreTelaSobre();
				break;
				
			case android.R.id.home:
		        NavUtils.navigateUpFromSameTask(this);
		        break;
		        
			default:
				// Do nothing.
				break;
			}
			
	    	return true;
	    }
	    
	    public void abreTelaSobre() {
	    	Intent intent = new Intent(this, TelaSobreListaEstado.class);
	    	startActivity(intent);
	    }
	
	private void inicializaListView() {
		ListView listView = (ListView) findViewById(R.id.listview_tela_estados);

		EstadoAdapter adapter = new EstadoAdapter(this);

		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1,
			int position, long id) {
			Intent intent = new Intent(context, TelaEstado.class);
			intent.putExtra("INDEX_ESTADO_ESCOLHIDO", position);
			startActivity(intent);
		}
		});
	}

}
