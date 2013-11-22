package com.mdsgpp.eef.visao;

import java.util.HashMap;

import com.mdsgpp.eef.controle.EstadoControle;
import com.mdsgpp.eef.modelo.Estado;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class IndicativoAdapter extends BaseAdapter{
	
	private HashMap<String, String> estados;
	private String indicativoEscolhido;
	private Context context;
	
	public IndicativoAdapter(String indicativoEscolhido, Context context){
		this.indicativoEscolhido = indicativoEscolhido;
		this.context = context;
	}
	
	@Override
	public int getCount() {
		
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		return null;
	}
	
}
