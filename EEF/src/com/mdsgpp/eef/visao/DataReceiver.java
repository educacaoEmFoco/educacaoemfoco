package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.modelo.Feed;

public interface DataReceiver {

	// Receive the information about states.
	void receiveFeed(Feed feed);	
}