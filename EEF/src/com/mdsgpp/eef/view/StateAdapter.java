package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StateAdapter extends BaseAdapter {

	String states[] = {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
		"Distrito Federal","Espírito Santo","Goiás", "Maranhão", "Mato Grosso", 
		"Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraiba", "Paraná", "Pernambuco", "Piauí", 
		"Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Rorâima", 
		"Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
	
	String acronyms[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", 
		"PA", "PB", "PR", "PE",	"PI", "RJ", "RN","RS", "RO", "RR", "SC", "SP", "SE", "TO" };
	
	String flags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", "ceara", 
		"distritofederal", "espiritosanto", "goias", "maranhao", "matogrosso", "matogrossodosul", 
		"minasgerais", "para", "paraiba", "parana", "pernambuco", "piaui", "riodejaneiro", 
		"riograndedonorte", "riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo", 
		"sergipe", "tocantins"};
	
	private LayoutInflater mInflater;
	private ViewHolder holder;
	private Context context;
	
	static class ViewHolder {
		private TextView tvName;
		private TextView tvAcronym;
		private ImageView tvFlags;
	}
	
	public EstadoAdapter(Context context) {
		this.context = context;
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return states.length;
	}

	@Override
	public Object getItem(int position) {
		return states[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Inflate layout, and get the view to put into the holder.
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.listview_item , null);
			holder = new ViewHolder();
		 
			holder.tvName = (TextView) convertView.findViewById(R.id.textview_lista_estados);
			holder.tvAcronym = (TextView) convertView.findViewById(R.id.textview_lista_siglas);
			
			holder.tvFlags = (ImageView) convertView.findViewById(R.id.imageView_bandeiras);
			if(holder.tvFlags==null) {
				Log.i(null, "nulo");
			}
			else{
				Log.i(null, "não nulo");
			}

		} 
		else {
			// Get the holder if everything already got initialized.
			holder = (ViewHolder) convertView.getTag();
		}
				
		holder.tvName.setText(states[position]);
		holder.tvAcronym.setText(acronyms[position]);
		int idFlag = context.getResources().getIdentifier(flags[position], "drawable", 
			context.getPackageName());
		holder.tvFlags.setImageResource(idFlag);
		convertView.setTag(holder);
		
		return convertView;
	}
}