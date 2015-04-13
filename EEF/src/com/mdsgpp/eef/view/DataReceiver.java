package com.mdsgpp.eef.view;

import com.mdsgpp.eef.model.Feed;

public interface DataReceiver {

	// Receive the information about states.
	void receiveFeed(Feed feed);	
}