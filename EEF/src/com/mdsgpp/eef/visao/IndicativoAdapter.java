package com.mdsgpp.eef.visao;

import java.io.IOException;
import java.util.HashMap;

import com.mdsgpp.eef.controle.EstadoControle;
import com.mdsgpp.eef.modelo.Estado;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class IndicativoAdapter extends BaseAdapter{
	
	private HashMap<String, String> estado;
	private String indicativoEscolhido;
	private Context context;
	
	public IndicativoAdapter(String indicativoEscolhido, Context context){
		this.indicativoEscolhido = indicativoEscolhido;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		return 27;
	}

	@Override
	public Object getItem(int posicao) {
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
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		return null;
	}
	
}
