/************************************************************
 * File: IndicativeAdapter.java
 *
 * Purpose: Generate information about a selected indicative.
 ************************************************************/

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

	private HashMap<String, String> state = null;
	private String choosenIndicative = null;
	private String title = null;
	private Context context = null;
	private ViewHolder viewHolder = null;
	private LayoutInflater layoutInflater = null;
	final int amountMenuItens = 28;
	final int titlePosition = 1;

	// Contains the name of all states from brazil, to select its own flag.
	final String flagsNames[] = {"acre", "alagoas", "amapa", "amazonas", "bahia", "ceara", 
		"distritofederal", "espiritosanto", "goias", "maranhao", "matogrosso", "matogrossodosul", 
		"minasgerais", "para", "paraiba", "parana", "pernambuco", "piaui", "riodejaneiro", 
		"riograndedonorte", "riograndedosul", "rondonia", "roraima", "santacatarina", "saopaulo", 
		"sergipe", "tocantins"};

	static class ViewHolder{
		private TextView textViewName;
		private TextView textViewIndicativeValue;
		private ImageView textViewFlags;
	}

	public IndicativeAdapter(String title, String choosenIndicative, Context context) {
		this.choosenIndicative = choosenIndicative;
		this.title = title;
		this.context = context;
		this.layoutInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return amountMenuItens;
	}

	@Override
	public HashMap<String, String> getItem(int positionOneMenuState) {
		HashMap<String, String> state = null;
		try {
			state = StateController.getInstance(context).readState(positionOneMenuState);
		} catch(IOException e) {
			e.printStackTrace();
		}

		return state;
	}

	@Override
	public long getItemId(int positionOneMenuState) {
		return positionOneMenuState;
	}

	@Override
	public View getView(int positionOneMenuState, View view, ViewGroup viewGroup) {
		if(view == null) {
			view = this.layoutInflater.inflate(R.layout.listview_item_indicativos, null);
			viewHolder = new ViewHolder();

			viewHolder.textViewName = (TextView) view.findViewById
				(R.id.textview_lista_indicativos_nome);
			viewHolder.textViewIndicativeValue = (TextView) view.findViewById
				(R.id.textview_lista_indicativos_conteudo);
			viewHolder.textViewFlags = (ImageView) view.findViewById
				(R.id.imageview_lista_indicativos_bandeiras);

			view.setTag(viewHolder);
		}
		else {
			viewHolder = (ViewHolder) view.getTag();
		}

		if(positionOneMenuState == 0) {	// Title.
			viewHolder.textViewName.setText(title);
			viewHolder.textViewName.setGravity(Gravity.CENTER_HORIZONTAL);
			viewHolder.textViewIndicativeValue.setVisibility(View.GONE);
			viewHolder.textViewFlags.setImageResource(NO_SELECTION);
		}
		else {	// Indicative and it's values.
			state = getItem(positionOneMenuState - titlePosition);

			viewHolder.textViewName.setText(state.get("nome"));
			viewHolder.textViewIndicativeValue.setText(getValue(state.get(choosenIndicative)));
			viewHolder.textViewIndicativeValue.setVisibility(View.VISIBLE);

			int idFlag = 0;
			idFlag = context.getResources().getIdentifier(flagsNames[positionOneMenuState - 
				titlePosition], "drawable", context.getPackageName());

			viewHolder.textViewFlags.setImageResource(idFlag);
		}

		return view;
	}

	// Split the line whe it contains an ":".
	private String getValue(String line) {
		if(line.contains(":")) {
			String parts[] = line.split(": ");
			return parts[1];
		}
		else {
			// Do nothing.
		}

		return line;
	}
}
