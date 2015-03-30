package com.mdsgpp.eef.parse;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mdsgpp.eef.modelo.Feed;

import android.content.Context;

public class FeedPersistencia {

	private static final String FILENAME = "feed.txt";
	private static FeedPersistencia instancia;
	private Context context;
	
	public FeedPersistencia(Context context) {
		this.context = context;
	}

	public static FeedPersistencia getInstance(Context context) {
		if (instancia == null) {
			instancia = new FeedPersistencia(context);
		}
		else {
			// Do nothing.
		}
		return instancia;
	}
	
	public void writeFeedFile(Feed feed) throws IOException {
		FileOutputStream fileout = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
		ObjectOutputStream out = new ObjectOutputStream(fileout);

		out.writeObject(feed);
		out.close();
	}

	public Feed readFeedFile() throws IOException, ClassNotFoundException {
		Feed feed;

		FileInputStream filein = context.openFileInput(FILENAME);
		ObjectInputStream in = new ObjectInputStream(filein);

		feed = (Feed) in.readObject();
		in.close();

		return feed;
	}
}
