package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.mdsgpp.eef.modelo.Feed;
import com.mdsgpp.eef.parse.FeedParser;
import com.mdsgpp.eef.parse.FeedPersistencia;
import com.mdsgpp.eef.visao.ReceptorDados;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class FeedControle extends AsyncTask<String, Void, Feed> {

	private Context context;
	private boolean updated = false;
	private ReceptorDados dataReceiver;

	public FeedControle(ReceptorDados dataReceiver) {
		this.dataReceiver = dataReceiver;
	}

	// While the execution of the task
	protected Feed doInBackground(String... urls) {

		Feed feed = null;

		// Try to download the feed data
		try {
			URL url = new URL(urls[0]);
			FeedParser handler = new FeedParser();
			InputStream is = url.openStream();
			feed = handler.parse(is);

			FeedPersistencia.getInstance(this.context).writeFeedFile(feed);
			this.updated = true;

			return feed;

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Try to read the feed data from the .txt file
		try {
			feed = FeedPersistencia.getInstance(this.context).readFeedFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return feed;

	}

	// After the execution of the task
	protected void onPostExecute(Feed feed) {
		
		if (!this.updated) {
			Toast.makeText(this.context, "Couldn't update the news! :(",
					Toast.LENGTH_LONG).show();
		}

		if (dataReceiver != null) {
			this.dataReceiver.receiveFeed(feed);
		}
	}
}