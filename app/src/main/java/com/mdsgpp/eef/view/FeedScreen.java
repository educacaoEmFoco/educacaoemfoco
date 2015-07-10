package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.FeedController;
import com.mdsgpp.eef.debug.Debug;
import com.mdsgpp.eef.model.Feed;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class FeedScreen extends Activity implements DataReceiver {

	private final static String FEED_ADDRESS = "http://noticias.gov.br/noticias/rss?id=AFSZW";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_feed);
		
		// Execute the task to retrieve the feed data.
		new FeedController(this, this).execute(FEED_ADDRESS);
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
			openFeedAboutScreen();
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

	@Override
	public void receiveFeed(final Feed feed) {
		Debug.log("FeedScreen - receiveFeed()", "Initialising", Debug.DEBUG);
		
		ListView listview = (ListView) findViewById(R.id.listView1);
		
		if(feed != null) {
			Debug.log("FeedScreen - receiveFeed()", "Feed feed is null", Debug.INFO);
			FeedAdapter adapter = new FeedAdapter(this, feed);
			listview.setAdapter(adapter);
		}
		else {
			Debug.log("FeedScreen - receiveFeed()", "Feed feed is not null", Debug.INFO);
			// Do nothing.
		}
		
		listview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
				int position, long id) {
				String link = feed.getItem(position).getLink();
				
				Intent browserIntent = new Intent(Intent.ACTION_VIEW,
					Uri.parse(link));
				startActivity(browserIntent);
			}
		});
		
		Debug.log("FeedScreen - receiveFeed()", "Leaving", Debug.DEBUG);
	}
	
	// Change the activity to FeedAboutScreen activity.
	public void openFeedAboutScreen() {
		Intent intent = new Intent(this, FeedAboutScreen.class);
		Debug.log("FeedScreen - openFeedAboutScreen()", "Starting FeedAbout Activity", Debug.DEBUG);
		startActivity(intent);
		Debug.log("FeedScreen - openFeedAboutScreen()", "FeedAbout Activity started", Debug.DEBUG);
	}	
	
}
