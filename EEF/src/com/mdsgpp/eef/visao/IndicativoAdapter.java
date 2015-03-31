package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.HashMap;

import com.mdsgpp.eef.R;
import com.mdsgpp.eef.controle.EstadoControle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.Gravity;

public class IndicativoAdapter extends BaseAdapter {
	
	private HashMap<String, String> estado;
	private String indicativoEscolhido;
	private String titulo;
	private Context context;
	private ViewHolder holder;
	private LayoutInflater inflater;
	
	// Name of all flags from states.
	String bandeiras[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", "ceara", 
		"distritofederal", "espiritosanto", "goias", "maranhao", "matogrosso", "matogrossodosul", 
		"minasgerais", "para", "paraiba", "parana", "pernambuco", "piaui", "riodejaneiro", 
		"riograndedonorte", "riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo", 
		"sergipe", "tocantins"};
	
	static class ViewHolder{
		private TextView tvNome;
		private TextView tvValorIndicativo;
		private ImageView tvBandeiras;
	}
	
	public IndicativoAdapter(String titulo, String indicativoEscolhido, Context context) {
		this.indicativoEscolhido = indicativoEscolhido;
		this.titulo = titulo;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return 28;
	}

	@Override
	public HashMap<String, String> getItem(int posicao) {
		HashMap<String, String> estado = null;
		try {
			estado = EstadoControle.getInstancia(context).lerEstado(posicao);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public long getItemId(int posicao) {
		return posicao;
	}
	
	@Override
	public View getView(int posicao, View view, ViewGroup viewGroup) {
		if(view == null) {
			view = this.inflater.inflate(R.layout.listview_item_indicativos, null);
			holder = new ViewHolder();
				
			holder.tvNome = (TextView) view.findViewById(R.id.textview_lista_indicativos_nome);
			holder.tvValorIndicativo = (TextView) view.findViewById
				(R.id.textview_lista_indicativos_conteudo);
			holder.tvBandeiras = (ImageView) view.findViewById
				(R.id.imageview_lista_indicativos_bandeiras);
			view.setTag(holder);
		} 
		else {
			holder = (ViewHolder) view.getTag();
		}
		
		if(posicao == 0){	// Title.
			holder.tvNome.setText(titulo);
			holder.tvNome.setGravity(Gravity.CENTER_HORIZONTAL);
			holder.tvValorIndicativo.setVisibility(View.GONE);
			holder.tvBandeiras.setImageResource(NO_SELECTION);
		} 
		else {	// Indicative and it's values.
			estado = getItem(posicao-1);
			holder.tvNome.setText(estado.get("nome"));
			holder.tvValorIndicativo.setText( pegaValor(estado.get(indicativoEscolhido)) );
			holder.tvValorIndicativo.setVisibility(View.VISIBLE);
			
			int idBandeira = context.getResources().getIdentifier(bandeiras[posicao-1], "drawable", 
				context.getPackageName());
			holder.tvBandeiras.setImageResource(idBandeira);
		}

		return view;
	}
	
	private String pegaValor(String linha) {
		if(linha.contains(":")) {
			String partes[] = linha.split(": ");
			return partes[1];
		}
		
		return linha;
	}
}