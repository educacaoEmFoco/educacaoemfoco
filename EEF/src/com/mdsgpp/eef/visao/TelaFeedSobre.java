package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class TelaFeedSobre extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_feed_sobre);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_telas, menu);
		return true;
	}

}
