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
import com.mdsgpp.eef.model.Feed;
import com.mdsgpp.eef.parser.FeedParser;
import com.mdsgpp.eef.parser.FeedPersistence;
import com.mdsgpp.eef.view.DataReceiver;
import com.mdsgpp.eef.util.Debug;

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
		Debug.debug(Debug.DEBUG, "Executing onPreExecute method");
		this.progressBar = new ProgressDialog(this.context, R.style.CustomProgressBar);
		this.progressBar.setIndeterminate(true);
		this.progressBar.setMessage("Carregando Notícias!");
		Debug.debug(Debug.INFO, "Loading Feeds");
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
		Debug.debug(Debug.INFO, "Feeds Updated!");
	}
	
	// After the execution of the task
	protected void onPostExecute(Feed feed) {	
		Debug.debug(Debug.DEBUG, "Executing onPostExecute method");
		if(this.progressBar != null) {
			this.progressBar.dismiss();
		}
		else {
			Debug.debug(Debug.WARNING, "null value on progressBar in onPostExecute method");
		}
		
		if(this.updated == false) {
			Toast.makeText(this.context, "Não foi possível atualizar as notícias! :(", 
				Toast.LENGTH_LONG).show();
			Debug.debug(Debug.WARNING, "The Feed could not be updated!");
		}
		else {
			// Nothing to do.
		}

		if(dataReceiver != null) {
			this.dataReceiver.receiveFeed(feed);
		}
		else {
			Debug.debug(Debug.WARNING, "dataReceiver value null in method onPostExecute!");
		}
	}
}