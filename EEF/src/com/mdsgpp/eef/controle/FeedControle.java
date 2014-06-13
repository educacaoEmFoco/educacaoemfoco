package com.mdsgpp.eef.controle;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.modelo.Feed;
import com.mdsgpp.eef.parse.FeedParser;
import com.mdsgpp.eef.parse.FeedPersistencia;
import com.mdsgpp.eef.visao.ReceptorDados;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

public class FeedControle extends AsyncTask<String, Void, Feed> {

	private Context context;
	private boolean updated = false;
	private ReceptorDados dataReceiver;
	private ProgressDialog barraProgresso;

	public FeedControle(Context context, ReceptorDados dataReceiver) {
		this.dataReceiver = dataReceiver;
		this.context = context;
	}
	
	@Override
	protected void onPreExecute() {
		barraProgresso = new ProgressDialog(context, R.style.CustomProgressBar);
		barraProgresso.setIndeterminate(true);
		barraProgresso.setMessage("Carregando Notícias!");
		barraProgresso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		barraProgresso.show();
		super.onPreExecute();
	}

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

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			feed = FeedPersistencia.getInstance(this.context).readFeedFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return feed;

	}

	protected void onPostExecute(Feed feed) {
		
		if (barraProgresso != null) {
			barraProgresso.dismiss();
		}
		
		if (!this.updated) {
			Toast.makeText(this.context, "Não foi possível atualizar as notícias! :(",
					Toast.LENGTH_LONG).show();
		}

		if (dataReceiver != null) {
			this.dataReceiver.receiveFeed(feed);
		}
	}
}