package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.modelo.Feed;
import com.mdsgpp.eef.parse.FeedParser;
import com.mdsgpp.eef.parse.FeedPersistencia;
import com.mdsgpp.eef.visao.DataReceiver;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class FeedController extends AsyncTask<String, Void, Feed> {

	private Context context;
	private boolean updated = false;
	private DataReceiver dataReceiver;
	private ProgressDialog progressBar;

	public FeedController(Context context, DataReceiver dataReceiver) {
		this.dataReceiver = dataReceiver;
		this.context = context;
	}
	
	@Override
	protected void onPreExecute() {
		progressBar = new ProgressDialog(context, R.style.CustomProgressBar);
		progressBar.setIndeterminate(true);
		progressBar.setMessage("Carregando Notícias!");
		progressBar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressBar.show();
		super.onPreExecute();
	}
	
	// This method seeks to update the feed accessing the url at runtime.
	protected Feed doInBackground(String... urls) {
		Feed feed = null;

		try {
			URL url = new URL(urls[0]);
			FeedParser handler = new FeedParser();
			InputStream is = url.openStream();
			feed = handler.parse(is);

			FeedPersistencia.getInstance(this.context).writeFeedFile(feed);
			this.updated = true;

			return feed;
		} 
		catch(MalformedURLException e) {
			e.printStackTrace();
		} 
		catch(IOException e) {
			e.printStackTrace();
		}

		try {
			feed = FeedPersistencia.getInstance(this.context).readFeedFile();
		} 
		catch(IOException e) {
			e.printStackTrace();
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

		return feed;
	}

	// After the execution of the task
	protected void onPostExecute(Feed feed) {		
		if(progressBar != null) {
			progressBar.dismiss();
		}
		else {
			// Nothing to do.
		}
		
		if(!this.updated) {
			Toast.makeText(this.context, "Não foi possível atualizar as notícias! :(", 
				Toast.LENGTH_LONG).show();
		}
		else {
			// Nothing to do.
		}

		if(dataReceiver != null) {
			this.dataReceiver.receiveFeed(feed);
		}
		else {
			// Nothing to do.
		}
	}
}