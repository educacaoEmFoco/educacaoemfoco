/***************************************************************************
 * File: ConsultationByIndicativeScreen.java
 *
 * Purpose: Show all possible indicatives to be selected for a consultation.
 ***************************************************************************/

package com.mdsgpp.eef.view;

import com.mdsgpp.eef.R;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ConsultationByIndicativeScreen extends ChoosesIndicative {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_escolhe_indicativo_grafico);
		
		TextView txtViewTitle = (TextView) findViewById(R.id.textview_titulo);
		txtViewTitle.setText("Escolha um indicativo para gerar a lista: ");
	}

	// Open "About" screen.
	public void opensAboutScreen() {
		Debug.log("ConsultationByIndicativeScreen - opensAboutScreen()", 
			"click detected in About Screen Button.", Debug.DEBUG);

		Intent intent = new Intent(this, IndicativesAboutScreen.class);

		Debug.log("ConsultationByIndicativeScreen - opensAboutScreen()", "starting new activity", 
			Debug.DEBUG);

		startActivity(intent);
	}
	
	// When button "Next" get clicked start a new activity with new screen.
	public void clickForwardButton(View view) {
		Debug.log("ConsultationByIndicativeScreen - clickForwardButton()", 
			"click detected in Forward Button.", Debug.DEBUG);

		Intent intent = new Intent(this, ConsultationByIndicativeResultScreen.class);

		intent.putExtra("INDICATIVO", getIndicative());
		intent.putExtra("TITULO", getTitle());

		Debug.log("ConsultationByIndicativeScreen - clickForwardButton()", "starting new activity", 
			Debug.DEBUG);

		startActivity(intent);
	}	
}