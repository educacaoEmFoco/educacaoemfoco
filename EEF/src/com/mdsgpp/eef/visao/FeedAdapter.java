package com.mdsgpp.eef.visao;



import com.mdsgpp.eef.R;
import com.mdsgpp.eef.modelo.Feed;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FeedAdapter extends BaseAdapter {

	private LayoutInflater mInflater;
	private Feed feed;
	private ViewHolder holder;
	
	static class ViewHolder {
		TextView tvTitle;
		TextView tvCategory;
		TextView tvDescription;
	}
	
	public FeedAdapter(Context context, Feed feed) {
		this.mInflater = LayoutInflater.from(context);
		this.feed = feed;
	}

	@Override
	public int getCount() {
		return feed.getItemsSize();
	}

	@Override
	public Object getItem(int position) {
		return feed.getItems().get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			/* if the convertView is null (first ListView item), inflate the layout
			   and create a ViewHolder to carry our TextViews, storing inside the ConvertView */
			convertView = this.mInflater.inflate(R.layout.rss_listview_item , null);
			this.holder = new ViewHolder();
			
			this.holder.tvTitle = (TextView) convertView.findViewById(R.id.textView_rss_title);
			this.holder.tvCategory = (TextView) convertView.findViewById(R.id.textView_rss_category);
			this.holder.tvDescription = (TextView) convertView.findViewById(R.id.textView_rss_description);
			convertView.setTag(this.holder);
			
		} else {
			// if the convertView is already inflated, just takes our ViewHolder back
			this.holder = (ViewHolder) convertView.getTag();
		}
		
		// Set the text to our TextViews
		this.holder.tvTitle.setText(this.feed.getItem(position).getTitle());
		this.holder.tvCategory.setText(this.feed.getItem(position).getCategory());
		this.holder.tvDescription.setText(Html.fromHtml( this.feed.getItem(position).getDescription() ));
		
		// at this point, the convertView is full, so we can just return it
		return convertView;
	}

}
