/*******************************************************************
 * File: FeedController.java 
 * 
 * Purpose: Update a Feed object by accessing given URLs at runtime.
 *******************************************************************/

package com.mdsgpp.eef.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.debug.Debug;
import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.parser.FeedParser;
import com.mdsgpp.eef.parser.FeedPersistence;
import com.mdsgpp.eef.view.DataReceiver;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class FeedController extends AsyncTask<String, Void, Feed> {

	private Context context;
	private boolean updated = false;
	private DataReceiver dataReceiver;
	private ProgressDialog progressBar;

	public FeedController(Context contextPassed, DataReceiver dataReceiver) {
		this.dataReceiver = dataReceiver;
		this.context = contextPassed;
	}
	
	@Override
	protected void onPreExecute() {
		Debug.log("FeedController - onPreExecute()", "Executing onPreExecute method", Debug.INFO);
		
		this.progressBar = new ProgressDialog(this.context, R.style.CustomProgressBar);
		this.progressBar.setIndeterminate(true);
		this.progressBar.setMessage("Carregando Notícias!");
		
		Debug.log("FeedController - onPreExecute()", "Loading Feeds", Debug.INFO);
		
		this.progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		this.progressBar.show();
		
		super.onPreExecute();
	}
	
	// This method seeks to update the feed accessing the url at runtime.
	protected Feed doInBackground(String... urls) {
		Feed currentFeed = null;

		try {
			URL url = new URL(urls[0]);
			
			InputStream inputStreamObject = null;
			inputStreamObject = url.openStream();
			
			FeedParser feedParserHandler = new FeedParser();
			currentFeed = feedParserHandler.parse(inputStreamObject);
			
			FeedPersistence feedPersistenceInstance = null;
			feedPersistenceInstance = FeedPersistence.getInstance(this.context);
			feedPersistenceInstance.writeFeedFile(currentFeed);
			
			this.update();

			return currentFeed;
		} catch(MalformedURLException exception) {
			exception.printStackTrace();
		} catch(IOException exception) {
			exception.printStackTrace();
		}

		try {
			currentFeed = FeedPersistence.getInstance(this.context).readFeedFile();
		} catch(IOException exception) {
			exception.printStackTrace();
		} catch(ClassNotFoundException exception) {
			exception.printStackTrace();
		}
		
		return currentFeed;
	}
	
	private void update() {
		this.updated = true;
		Debug.log("FeedController - update()", "Feeds Updated!", Debug.INFO);
	}
	
	// After the execution of the task
	protected void onPostExecute(Feed feed) {	
		Debug.log("FeedController - onPostExecute()", "Executing onPostExecute method", Debug.DEBUG);
		if(this.progressBar != null) {
			this.progressBar.dismiss();
		}
		else {
			Debug.log("FeedController - onPostExecute()",
					  "Null value on progressBar in onPostExecute method",
					  Debug.WARNING);
		}
		
		if(this.updated == false) {
			Toast.makeText(this.context, "Não foi possível atualizar as notícias! :(", 
				Toast.LENGTH_LONG).show();
			
			Debug.log("FeedController - onPostExecute()", "The Feed could not be updated!",
					  Debug.WARNING);
		}
		else {
			// Nothing to do.
		}

		if(dataReceiver != null) {
			this.dataReceiver.receiveFeed(feed);
		}
		else {
			Debug.log("FeedController - onPostExecute()",
					  "dataReceiver value null in method onPostExecute!",
					  Debug.WARNING);
		}
	}
}