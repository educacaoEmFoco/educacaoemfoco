package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.debug.Debug;
import com.mdsgpp.eef.view.StateAdapter;

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

public class StateListScreen extends Activity {

	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_lista_estado);

		startListView();
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
				openAboutScreen();
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
	
	// Change the activity to StateListAboutScreen activity.
	public void openAboutScreen() {
		Debug.log("StateScreen - openAboutScreen()", "opening StateListAboutScreen", Debug.DEBUG);
		
	    Intent intent = new Intent(this, StateListAboutScreen.class);
	    startActivity(intent);
	 }
	
	/*
	 * Assigns the class variable listView with the ListView on the screen and
	 * assign action to the elements on the list.
	 */
	private void startListView() {
		ListView listView = (ListView) findViewById(R.id.listview_tela_estados);
		
		Debug.log("StateListScreen - startListView()", "setting state adapter", Debug.DEBUG);
		
		StateAdapter adapter = new StateAdapter(this);

		listView.setAdapter(adapter);
		
		Debug.log("StateListScreen - startListView()", "setting onItemCLickListener on list view",
				Debug.DEBUG);
		
		listView.setOnItemClickListener(new OnItemClickListener() {
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
			Intent intent = new Intent(context, StateScreen.class);
			intent.putExtra("INDEX_ESTADO_ESCOLHIDO", position);
			
			Debug.log("StateListScreen - startListView()",
				"itemClick detected on item: " + position, Debug.INFO);
			
			startActivity(intent);
		}
		});
	}

}