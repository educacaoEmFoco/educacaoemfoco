package com.mdsgpp.eef.modelo;

import com.mdsgpp.eef.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class EstadoAdapter extends BaseAdapter{

	String estados[] = {"Acre", "Alagoas", "Amap�", "Amazonas", "Bahia", 
			"Cear�", "Distrito Federal","Esp�rito Santo","Goi�s", "Maranh�o",
			"Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Par�", "Paraiba",
			"Paran�", "Pernambuco", "Piau�", "Rio de Janeiro", "Rio Grande do Norte",
			"Rio Grande do Sul", "Rond�nia", "Ror�ima", "S�o Paulo", "Santa Catarina",
			"Sergipe", "Tocantins"};
	
	String siglas[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", 
			"PA", "PB", "PR", "PE",	"PI", "RJ", "RN","RS", "RO", "RR", "SP", "SC", "SE", "TO" };
	
	private LayoutInflater mInflater;
	private ViewHolder holder;
	
	static class ViewHolder {
		private TextView tvNome;
		private TextView tvSigla;
	}
	
	public EstadoAdapter(Context context) {
		mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return estados.length;
	}

	@Override
	public Object getItem(int position) {
		return estados[position];
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Infla o layout, e pega os views jogando no holder para economizar processamento
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.listview_item , null);
			holder = new ViewHolder();
		 
			holder.tvNome = (TextView) convertView.findViewById(R.id.textview_lista_estados);
			holder.tvSigla = (TextView) convertView.findViewById(R.id.textview_lista_siglas);
			convertView.setTag(holder);
		} else {
			// pega do holder se tudo j� tiver sido iniciado
			holder = (ViewHolder) convertView.getTag();
		}
				
		holder.tvNome.setText(estados[position]);
		holder.tvSigla.setText(siglas[position]);
		
		return convertView;
	}

}
