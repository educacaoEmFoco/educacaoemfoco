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
import android.widget.TextView;

public class IndicativoAdapter extends BaseAdapter{
	
	private HashMap<String, String> estado;
	private String indicativoEscolhido;
	private Context context;
	private ViewHolder holder;
	private LayoutInflater inflater;
	
	static class ViewHolder{
		private TextView tvNome;
		private TextView tvValorIndicativo;
	}
	
	public IndicativoAdapter(String indicativoEscolhido, Context context){
		this.indicativoEscolhido = indicativoEscolhido;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return 27;
	}

	@Override
	public HashMap<String, String> getItem(int posicao) {
		HashMap<String, String> estado = null;
		try {
			estado = EstadoControle.getInstancia(context).lerEstado(posicao);
		} catch (IOException e) {
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
			holder.tvValorIndicativo = (TextView) view.findViewById(R.id.textview_lista_indicativos_conteudo);
			
			view.setTag(holder);
			
		} else {
			holder = (ViewHolder) view.getTag();
		}
		
		estado = getItem(posicao);
		
		holder.tvNome.setText(estado.get("nome"));
		holder.tvValorIndicativo.setText(estado.get(indicativoEscolhido));
		
		return view;
	}
	
}