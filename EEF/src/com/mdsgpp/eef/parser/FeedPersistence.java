/**********************************************************
 * File: FeedPersistence.java 
 * 
 * Purpose: Read and write Feed objects from/on text files.
 **********************************************************/

package com.mdsgpp.eef.parser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mdsgpp.eef.model.Feed;

import android.content.Context;

public class FeedPersistence {

	private static final String FILENAME = "feed.txt";
	private static FeedPersistence instance;
	private Context context;
	
	public FeedPersistence(Context context) {
		this.context = context;
	}

	// Get the ONLY instance of this class. Singleton design pattern applied on here.
	public static FeedPersistence getInstance(Context context) {
		if (instance == null) {
			instance = new FeedPersistence(context);
		}
		else {
			// Do nothing.
		}
		return instance;
	}
	
	// Save the feed on an extern file.
	public void writeFeedFile(Feed feed) throws IOException {
		FileOutputStream fileout = context.openFileOutput(FILENAME, Context.MODE_PRIVATE);
		ObjectOutputStream out = new ObjectOutputStream(fileout);

		out.writeObject(feed);
		out.close();
	}

	// Read the feed saved on a file.
	public Feed readFeedFile() throws IOException, ClassNotFoundException {
		Feed feed;

		FileInputStream filein = context.openFileInput(FILENAME);
		ObjectInputStream in = new ObjectInputStream(filein);

		feed = (Feed) in.readObject();
		in.close();

		return feed;
	}
}
