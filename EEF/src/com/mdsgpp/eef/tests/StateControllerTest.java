package com.mdsgpp.eef.tests;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;

import com.mdsgpp.eef.controller.StateController;

import android.test.AndroidTestCase;

public class StateControllerTest extends AndroidTestCase {

	private HashMap<String, String> information;
	private HashMap<String, String> fullInformation;
	private StateController instance;
	private StateController instance2;
	private StateController instance3;
	private DecimalFormat dfValue = new DecimalFormat("#,##0.00");
	private DecimalFormat dfPopulation = new DecimalFormat("#,###");
	private DecimalFormat dfPercentage = new DecimalFormat("#.##");
	
	public void setUp() throws Exception {
		instance = new StateController(getContext());
		
		instance = StateController.getInstance(getContext());
		information = new HashMap<String, String>();
		fullInformation =  new HashMap<String, String>();
		
		instance2 = StateController.getInstance(getContext());
		instance3 = StateController.getInstance(getContext());
		
		this.information.put("sigla", "AC");
		this.information.put("nome", "Acre");
		this.information.put("populacao", dfPopulation.format(691132) + " habitantes");
		this.information.put("percentual_participacao_pib", 
			dfPercentage.format(0.200000000000045) + "%");
		this.information.put("projetos_ciencia_tecnologia", "Quantidade: " + 3 + " projetos");
		this.information.put("valor_ciencia_tecnologia", "Valor investido: R$ " 
			+ dfValue.format(563681.899999976) + " (em mil)");
		this.information.put("ideb_fundamental_final", "Ensino Fundamental (séries finais): " 
			+ dfPercentage.format(4.09999999999854));
		this.information.put("ideb_ensino_medio", "Ensino Médio: " + dfPercentage.format(3.5) 
			+ "" );	
		this.information.put("ideb_fundamental_inicial", "Ensino Fundamental (Séries iniciais): " 
			+ dfPercentage.format(4.5) + "");
		this.information.put("quantidade_primeiros_projetos", "Quantidade: " + 2 + " projetos");
		this.information.put("valor_primeiros_projetos", "Valor investido: R$ " 
			+ dfValue.format(55.4400000000023) + " (em mil)");
		this.information.put("quantidade_projeto_cnpq", "Quantidade: " + 133 + " projetos");
		this.information.put("valor_projetos_cnpq", "Valor investido: R$ " 
			+ dfValue.format( 1905.13000000053 ) + " (em mil)");
		this.information.put("quantidade_projeto_jovens_pesquisadores", "Quantidade: " + 3 
			+ " projetos");
		this.information.put("valor_projetos_jovens_pesquisadores", "Valor investido: R$ " 
			+ dfValue.format( 138.250000000029 ) + " (em mil)");
		
		this.fullInformation.put("sigla", "AC");
		this.fullInformation.put("nome", "Acre");
		this.fullInformation.put("populacao", dfPopulation.format(691132) + " habitantes");
	}

	public void tearDown() throws Exception {
		//Do nothing.
	}

	public void testLerEstado() throws IOException {
		assertEquals(this.information.get("nome"), 
			StateController.getInstance(getContext()).readState(0).get("nome"));

		assertEquals(this.information.get("sigla"), 
			StateController.getInstance(getContext()).readState(0).get("sigla"));

		assertEquals(this.information.get("populacao"), 
			StateController.getInstance(getContext()).readState(0).get("populacao"));

		assertEquals(this.information.get("percentual_participacao_pib"), 
			StateController.getInstance(getContext()).readState(0).get
				("percentual_participacao_pib"));
		
		assertEquals(this.information.get("projetos_ciencia_tecnologia"), 
			StateController.getInstance(getContext()).readState(0).get
				("projetos_ciencia_tecnologia"));
		
		assertEquals(this.information.get("ideb_fundamental_final"), 
			StateController.getInstance(getContext()).readState(0).get("ideb_fundamental_final"));
		
		assertEquals(this.information.get("ideb_ensino_medio"), 
			StateController.getInstance(getContext()).readState(0).get("ideb_ensino_medio"));
		
		assertEquals(this.information.get("ideb_fundamental_inicial"), 
			StateController.getInstance(getContext()).readState(0).get("ideb_fundamental_inicial"));

		assertEquals(this.information.get("quantidade_primeiros_projetos"), 
			StateController.getInstance(getContext()).readState(0).get
				("quantidade_primeiros_projetos"));

		assertEquals(this.information.get("valor_primeiros_projetos"), 
			StateController.getInstance(getContext()).readState(0).get("valor_primeiros_projetos"));

		assertEquals(this.information.get("quantidade_projeto_cnpq"), 
			StateController.getInstance(getContext()).readState(0).get("quantidade_projeto_cnpq"));

		assertEquals(this.information.get("valor_projetos_cnpq"), 
			StateController.getInstance(getContext()).readState(0).get("valor_projetos_cnpq"));

		assertEquals(this.information.get("quantidade_projeto_jovens_pesquisadores"), 
			StateController.getInstance(getContext()).readState(0).get
				("quantidade_projeto_jovens_pesquisadores"));

		assertEquals(this.information.get("valor_projetos_jovens_pesquisadores"), 
			StateController.getInstance(getContext()).readState(0).get
				("valor_projetos_jovens_pesquisadores"));
	}
	
	public void testLerEstadoCompleto() throws IOException {
		assertEquals(this.fullInformation.get("nome"), 
			StateController.getInstance(getContext()).readFullState(0).get("nome"));

		assertEquals(this.fullInformation.get("sigla"), 
			StateController.getInstance(getContext()).readFullState(0).get("sigla"));
		
		assertEquals(this.fullInformation.get("populacao"), 
			StateController.getInstance(getContext()).readFullState(0).get("populacao"));
	}

	public void testInstancia() throws IOException {
		assertEquals(instance, instance2);
		assertEquals(instance, instance3);
	}
}
