package com.mdsgpp.eef.view;

import java.io.IOException;
import java.util.HashMap;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controller.StateController;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Gravity;

public class IndicativeAdapter extends BaseAdapter {
	
	private HashMap<String, String> state;
	private String choosenIndicative;
	private String title;
	private Context context;
	private ViewHolder holder;
	private LayoutInflater inflater;
	
	// Name of all flags from states.
	String flags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", "ceara", 
		"distritofederal", "espiritosanto", "goias", "maranhao", "matogrosso", "matogrossodosul", 
		"minasgerais", "para", "paraiba", "parana", "pernambuco", "piaui", "riodejaneiro", 
		"riograndedonorte", "riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo", 
		"sergipe", "tocantins"};
	
	static class ViewHolder{
		private TextView tvName;
		private TextView tvIndicativeValue;
		private ImageView tvFlags;
	}
	
	public IndicativeAdapter(String title, String choosenIndicative, Context context) {
		this.choosenIndicative = choosenIndicative;
		this.title = title;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return 28;
	}

	@Override
	public HashMap<String, String> getItem(int position) {
		HashMap<String, String> state = null;
		try {
			state = StateController.getInstance(context).readState(position);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return state;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup viewGroup) {
		if(view == null) {
			view = this.inflater.inflate(R.layout.listview_item_indicativos, null);
			holder = new ViewHolder();
				
			holder.tvName = (TextView) view.findViewById(R.id.textview_lista_indicativos_nome);
			holder.tvIndicativeValue = (TextView) view.findViewById
				(R.id.textview_lista_indicativos_conteudo);
			holder.tvFlags = (ImageView) view.findViewById
				(R.id.imageview_lista_indicativos_bandeiras);
			view.setTag(holder);
		} 
		else {
			holder = (ViewHolder) view.getTag();
		}
		
		if(position == 0){	// Title.
			holder.tvName.setText(title);
			holder.tvName.setGravity(Gravity.CENTER_HORIZONTAL);
			holder.tvIndicativeValue.setVisibility(View.GONE);
			holder.tvFlags.setImageResource(NO_SELECTION);
		} 
		else {	// Indicative and it's values.
			state = getItem(position-1);
			holder.tvName.setText(state.get("nome"));
			holder.tvIndicativeValue.setText(getValue(state.get(choosenIndicative)) );
			holder.tvIndicativeValue.setVisibility(View.VISIBLE);
			
			int idFlag = context.getResources().getIdentifier(flags[position-1], "drawable", 
				context.getPackageName());
			holder.tvFlags.setImageResource(idFlag);
		}

		return view;
	}
	
	// Split the line whe it contains an ":".
	private String getValue(String line) {
		if(line.contains(":")) {
			String parts[] = line.split(": ");
			return parts[1];
		}
		
		return line;
	}
}