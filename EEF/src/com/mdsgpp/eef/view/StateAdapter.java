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

	final String states[] = {"Acre", "Alagoas", "Amap�", "Amazonas", "Bahia", "Cear�",
		"Distrito Federal","Esp�rito Santo","Goi�s", "Maranh�o", "Mato Grosso", 
		"Mato Grosso do Sul", "Minas Gerais", "Par�", "Paraiba", "Paran�", "Pernambuco", "Piau�", 
		"Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rond�nia", "Ror�ima", 
		"Santa Catarina", "S�o Paulo", "Sergipe", "Tocantins"};
	
	final String acronyms[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", 
		"PA", "PB", "PR", "PE",	"PI", "RJ", "RN","RS", "RO", "RR", "SC", "SP", "SE", "TO" };
	
	final String flags[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", "ceara", 
		"distritofederal", "espiritosanto", "goias", "maranhao", "matogrosso", "matogrossodosul", 
		"minasgerais", "para", "paraiba", "parana", "pernambuco", "piaui", "riodejaneiro", 
		"riograndedonorte", "riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo", 
		"sergipe", "tocantins"};
	
	private LayoutInflater layoutInflater;
	private ViewHolder viewHolder;
	private Context context;
	
	static class ViewHolder {
		private TextView tvName;
		private TextView tvAcronym;
		private ImageView tvFlags;
	}
	
	public StateAdapter(Context context) {
		this.context = context;
		layoutInflater = LayoutInflater.from(context);
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
		// Inflate layout, and get the view to put into the viewHolder.
		if (convertView == null) {
			convertView = layoutInflater.inflate(R.layout.listview_item , null);
			this.viewHolder = new ViewHolder();
		 
			this.viewHolder.tvName = (TextView) convertView.findViewById(R.id.textview_lista_estados);
			this.viewHolder.tvAcronym = (TextView) convertView.findViewById(R.id.textview_lista_siglas);
			this.viewHolder.tvFlags = (ImageView) convertView.findViewById(R.id.imageView_bandeiras);
		} 
		else {
			// Get the viewHolder if everything already got initialized.
			this.viewHolder = (ViewHolder) convertView.getTag();
		}
		
		String contextPackageName = null;
		contextPackageName = this.context.getPackageName();
		
		int idFlag = this.context.getResources().getIdentifier(flags[position], "drawable", 
				contextPackageName);
		
		this.viewHolder.tvName.setText(this.states[position]);
		this.viewHolder.tvAcronym.setText(this.acronyms[position]);
		this.viewHolder.tvFlags.setImageResource(idFlag);
		
		convertView.setTag(this.viewHolder);
		
		return convertView;
	}
}