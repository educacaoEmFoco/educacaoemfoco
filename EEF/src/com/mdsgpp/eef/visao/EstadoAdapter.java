package com.mdsgpp.eef.visao;

import com.mdsgpp.eef.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EstadoAdapter extends BaseAdapter{

	String estados[] = {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
		"Distrito Federal","Espírito Santo","Goiás", "Maranhão", "Mato Grosso", 
		"Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraiba", "Paraná", "Pernambuco", "Piauí", 
		"Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Rorâima", 
		"Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};
	
	String siglas[] = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", 
		"PA", "PB", "PR", "PE",	"PI", "RJ", "RN","RS", "RO", "RR", "SC", "SP", "SE", "TO" };
	
	String bandeiras[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", "ceara", 
		"distritofederal", "espiritosanto", "goias", "maranhao", "matogrosso", "matogrossodosul", 
		"minasgerais", "para", "paraiba", "parana", "pernambuco", "piaui", "riodejaneiro", 
		"riograndedonorte", "riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo", 
		"sergipe", "tocantins"};
	
	private LayoutInflater mInflater;
	private ViewHolder holder;
	private Context context;
	
	static class ViewHolder {
		private TextView tvNome;
		private TextView tvSigla;
		private ImageView tvBandeiras;
	}
	
	public EstadoAdapter(Context context) {
		this.context = context;
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
			
			holder.tvBandeiras = (ImageView) convertView.findViewById(R.id.imageView_bandeiras);
			if(holder.tvBandeiras==null)
				Log.i(null, "nulo");
			else{
				Log.i(null, "não nulo");
			}

		} else {
			// pega do holder se tudo já tiver sido iniciado
			holder = (ViewHolder) convertView.getTag();
		}
				
		holder.tvNome.setText(estados[position]);
		holder.tvSigla.setText(siglas[position]);
		int idBandeira = context.getResources().getIdentifier(bandeiras[position], "drawable", 
			context.getPackageName());
		holder.tvBandeiras.setImageResource(idBandeira);
		convertView.setTag(holder);
		
		return convertView;
	}
}