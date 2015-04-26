package com.mdsgpp.eef.controller;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;

import com.mdsgpp.eef.model.State;

public class StateController {

	private static StateController instance;
	private Context context;
	private HashMap<String, String> stateInformation;
	private HashMap<String, ArrayList<String[]>> parseInformation;
	private DecimalFormat decimalFormatValue = new DecimalFormat("#,##0.00");
	private DecimalFormat decimalFormatPopulation = new DecimalFormat("#,###");
	private DecimalFormat decimalFormatPercentage = new DecimalFormat("#.##");

	public StateController(Context contextActivity) {
		this.context = contextActivity;
		this.stateInformation = new HashMap<String, String>();
		this.parseInformation = new HashMap<String, ArrayList<String[]>>();
	}

	public static StateController getInstance(Context contextActivity) {
		if(instance == null) {
			instance = new StateController(contextActivity);
		}
		else {
			// Nothing to do.
		}

		return instance;
	}
	
	/*
	 * This method get the information of a state by its position number and fill this information
	 * in a variable.
	 */
	public State obtainState(int position) throws IOException {
		parseInformation = ParserController.getInstance(context).getStateInformation(position);
		String acronymName[] = parseInformation.get("nome_e_sigla").get(0);
		State state = new State(acronymName[0], acronymName[1],
			parseInformation);

		writeStateWithAllInformation(state);

		return state;
	}
	
	/*
	 * This method get some information of a state through the parser, by its position number and
	 * return this information.
	 */
	public HashMap<String, String> readState(int position) throws IOException {
		parseInformation = ParserController.getInstance(context).getStateInformation(position);
		String acronymName[] = parseInformation.get("nome_e_sigla").get(0);
		State state = new State(acronymName[0], acronymName[1],
			parseInformation);

		writeState(state);

		return this.stateInformation;
	}
	
	/*
	 * This method get all the information of a state through the parser, by its position number
	 * and return this information
	 */
	public HashMap<String, String> readFullState(int position) throws
		IOException {
		parseInformation = ParserController.getInstance(context).getStateInformation
			(position);
		String acronymName[] = parseInformation.get("nome_e_sigla").get(0);
		State state = new State(acronymName[0], acronymName[1],
			parseInformation);

		writeStateWithAllInformation(state);

		return this.stateInformation;
	}
	
	/*
	 * This method take some data from one state and fills the hashmap "stateInformation" with
	 * the data.
	 */
	private void writeState(State state) {
		fulfillNameAcronymAndPopulation(state);

		this.stateInformation.put("percentual_participacao_pib", 
			decimalFormatPercentage.format(state.getPIBPercentParticipation()
			[state.getPIBPercentParticipation().length - 1]) + "%");
		this.stateInformation.put("projetos_ciencia_tecnologia", "Quantidade: " 
			+ state.getScienceTechnologyProjects()
			[state.getScienceTechnologyProjects().length - 1].getQuantity()
			+ " projetos");
		this.stateInformation.put("valor_ciencia_tecnologia",
			"Valor investido: R$ " + decimalFormatValue.format
			(state.getScienceTechnologyProjects()
			[state.getScienceTechnologyProjects().length - 1].getValue()) + 
			" (em mil)");
		this.stateInformation.put("ideb_fundamental_final",
			"Ensino Fundamental (s�ries finais): " + decimalFormatPercentage.format
			(state.getIdebs()[state.getIdebs().length - 1].getElementarySchool()));
		this.stateInformation.put("ideb_ensino_medio", "Ensino M�dio: " 
			+ decimalFormatPercentage.format(state.getIdebs()[state.getIdebs().length
			- 1].getHighSchool()) + "");
		this.stateInformation.put("ideb_fundamental_inicial", 
			"Ensino Fundamental (S�ries iniciais): " + decimalFormatPercentage.format
			(state.getIdebs()[state.getIdebs().length - 1]
			.getEarlyGrades()) + "");
		this.stateInformation.put("quantidade_primeiros_projetos",
			"Quantidade: " + state.getFirstProjects()
			[state.getFirstProjects().length - 1].getQuantity() + 
			" projetos");
		this.stateInformation.put("valor_primeiros_projetos",
			"Valor investido: R$ " + decimalFormatValue.format
			(state.getFirstProjects()[state.getFirstProjects().length
			- 1].getValue()) + " (em mil)");
		this.stateInformation.put("quantidade_projeto_cnpq", "Quantidade: " 
			+ state.getCnpqSupportProjects()[state.getCnpqSupportProjects().length
			- 1].getQuantity() + " projetos");
		this.stateInformation.put("valor_projetos_cnpq", "Valor investido: R$ " 
			+ decimalFormatValue.format(state.getCnpqSupportProjects()
			[state.getCnpqSupportProjects().length - 1].getValue()) +
			" (em mil)");
		this.stateInformation.put("quantidade_projeto_jovens_pesquisadores",
			"Quantidade: " + state.getYoungResearchersProject()
			[state.getYoungResearchersProject().length - 1].getQuantity()
			+ " projetos");
		this.stateInformation.put("valor_projetos_jovens_pesquisadores",
			"Valor investido: R$ " + decimalFormatValue.format
			(state.getYoungResearchersProject()
			[state.getYoungResearchersProject().length - 1].getValue()) +
			" (em mil)");
		this.stateInformation.put("quantidade_projetos_inct", "Quantidade: " 
			+ state.getInctProjects()[state.getInctProjects().length - 1]
			.getQuantity() + " projetos");
		this.stateInformation.put("valor_projetos_inct", "Valor investido: R$ " 
			+ decimalFormatValue.format(state.getInctProjects()
			[state.getInctProjects().length - 1].getValue()) + " (em mil)");
		this.stateInformation.put("alunos_por_turma_ensino_fundamental", 
			"Quantidade media de alunos por turma (Fundamental): " 
			+ decimalFormatValue.format(state.getAverageClassSize()
			[state.getAverageClassSize().length - 1].
			getElementarySchool()));
		this.stateInformation.put("alunos_por_turma_ensino_medio", 
			"Quantidade media de alunos por turma (Medio): " 
			+ decimalFormatValue.format(state.getAverageClassSize()
			[state.getAverageClassSize().length - 1].getHighSchool()));
		this.stateInformation.put("horas_aula_ensino_fundamental", 
			"Quantidade media de horas de aula(Fundamental): " 
			+ decimalFormatValue.format(state.getAverageClassHours()
			[state.getAverageClassHours().length - 1].getElementarySchool()));
		this.stateInformation.put("horas_aula_ensino_medio", 
			"Quantidade media de horas de aula (Medio): " 
			+ decimalFormatValue.format(state.getAverageClassHours()
			[state.getAverageClassHours().length - 1].getHighSchool()));
		this.stateInformation.put("taxa_distorcao_fundamental", 
			"Quantidade de Distor��o da Idade(Fundamental): " 
			+ decimalFormatPercentage.format(state.getAgeSeriesDistortionRate()
			[state.getAgeSeriesDistortionRate().length - 1]
			.getElementarySchool()));
		this.stateInformation.put("taxa_distorcao_medio", 
			"Quantidade de Distor��o da Idade (Medio): " 
			+ decimalFormatPercentage.format(state.getAgeSeriesDistortionRate()[state
				.getAgeSeriesDistortionRate().length - 1].getHighSchool()));
		this.stateInformation.put("taxa_aprovacao_fundamental", 
			"Taxa de Aprova��o (Fundamental): " + decimalFormatPercentage.format
			(state.getUtilizationRate()[state.getUtilizationRate()
			.length - 1].getElementarySchool()));
		this.stateInformation.put("taxa_aprovacao_medio",
			"Taxa de Aprova��o (Medio): " + decimalFormatPercentage.format
			(state.getUtilizationRate()[state.getUtilizationRate()
			.length - 1].getHighSchool()));
		this.stateInformation.put("taxa_abandono_fundamental",
			"Taxa de Abandono (Fundamental): " + decimalFormatPercentage.format
			(state.getDropoutRate()[state.getDropoutRate().length - 1]
			.getElementarySchool()));
		this.stateInformation.put("taxa_abandono_medio",
			"Taxa de Abandono (Medio): " + decimalFormatPercentage.format
			(state.getDropoutRate()[state.getDropoutRate().length - 1]
			.getHighSchool()));
		this.stateInformation.put("censo_anos_iniciais_fundamental", 
			"Censo Anos Iniciais (Fundamental): " 
			+ decimalFormatPercentage.format(state.getCensos()[state.getCensos().length
			- 1].getElementarySchoolEarlyYears()));
		this.stateInformation.put("censo_anos_finais_fundamental", 
			"Censo Anos Finais (Fundamental): " 
			+ decimalFormatPercentage.format(state.getCensos()[state.getCensos().length
			- 1].getElementarySchoolFinalYears()));
		this.stateInformation.put("censo_ensino_medio", "Censo Ensino M�dio: " 
			+ decimalFormatPercentage.format(state.getCensos()[state.getCensos().length
			- 1].getHighSchool()));
		this.stateInformation.put("censo_eja_fundamental",
			"Censo EJA (Fundamental): " + decimalFormatPercentage.format
			(state.getCensos()[state.getCensos().length - 1]
			.getEJAElementarySchool()));
		this.stateInformation.put("censo_eja_medio", "Censo EJA (Medio): " 
			+ decimalFormatPercentage.format(state.getCensos()[state.getCensos().length
			- 1].getEJAHighSchool()));
	}
	
	/*
	 * This method take all data from one state and fills the hashmap 
	 * "stateInformation" with the data.
	 */
	private void writeStateWithAllInformation(State state) {
		String temporaryString = "";

		fulfillNameAcronymAndPopulation(state);

		for(int counter = 0, year = 1995; counter < state.getPIBPercentParticipation()
			.length; counter++, year++) {
			temporaryString += year + ": " + decimalFormatPercentage.format
				(state.getPIBPercentParticipation()[counter]) 
				+ "%\n";
		}

		this.stateInformation.put("percentual_participacao_pib", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2003; counter < state.getScienceTechnologyProjects()
			.length-1; counter++, year++) {
			temporaryString += year + ": " + "Quantidade: " 
				+ state.getScienceTechnologyProjects()[counter].getQuantity() +
				" projetos\n" + "\t\t " + "  Valor investido: R$ " 
				+ decimalFormatValue.format(state.getScienceTechnologyProjects()[counter]
				.getValue()) + " (em mil)\n\n";
		}

		this.stateInformation.put("projetos_ciencia_tecnologia", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2005; counter < state.getIdebs().length; counter++, year += 2) {
			temporaryString += year + ": " + "Ensino Fundamental (s�ries finais): " 
				+ decimalFormatPercentage.format(state.getIdebs()[counter].getElementarySchool()) +
				"\n" + "\t\t  " + "Ensino M�dio: " + decimalFormatPercentage.format
				(state.getIdebs()[counter].getHighSchool()) + "\n" + "\t\t  " +
				"Ensino Fundamental (S�ries iniciais): " + decimalFormatPercentage.format
				(state.getIdebs()[counter].getEarlyGrades()) + "\n\n";
		}

		this.stateInformation.put("ideb", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2007; counter < state.getFirstProjects().length-1;
			counter++, year++) {
			temporaryString += year + ": " + "Quantidade: " + state.
				getFirstProjects()[counter].getQuantity() + " projetos\n" +
				"\t\t  " + "Valor investido: R$ " + decimalFormatValue.format
				(state.getFirstProjects()[state.getFirstProjects()
				.length - 1].getValue()) + " (em mil)\n\n";
		}

		this.stateInformation.put("primeiros_projetos", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2001; counter < state.getCnpqSupportProjects().length-1;
			counter++, year++) {
			temporaryString += year + ": " + "Quantidade: " + state.
				getCnpqSupportProjects()[counter].getQuantity() + " projetos\n" +
				"\t\t  " + "Valor investido: R$ " + decimalFormatValue.format
				(state.getCnpqSupportProjects()[counter].getValue()) + " (em mil)\n\n";
		}

		this.stateInformation.put("cnpq", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2005; counter < state.getYoungResearchersProject().
			length - 1; counter++, year++) {
			temporaryString += year + ": " + "Quantidade: " + state
				.getYoungResearchersProject()[counter].getQuantity() +
				" projetos\n" + "\t\t  " + "Valor investido: R$ " +
				decimalFormatValue.format(state.getYoungResearchersProject()[counter].
				getValue()) + " (em mil)\n\n";
		}

		this.stateInformation.put("jovens_pesquisadores", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2008; counter < state.getInctProjects().length-1;
			counter++, year++) {
			temporaryString += year + ": " + "Quantidade: " + state.getInctProjects()[counter]
				.getQuantity() + " projetos\n" + "\t\t  " + 
				"Valor investido: R$ " + decimalFormatValue.format
				(state.getInctProjects()[counter].getValue()) + " (em mil)\n\n";
		}

		this.stateInformation.put("projetos_inct", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2007; counter < state.getAverageClassSize().length;
			counter++, year++) {
			temporaryString += year + ": " + 
				"Quantidade media de alunos por turma (Fundamental): " +
				decimalFormatValue.format(state.getAverageClassSize()[counter].
				getElementarySchool()) + "\n" +
				"Quantidade media de alunos por turma (Medio): " + decimalFormatValue.
				format(state.getAverageClassSize()[counter].getHighSchool()) + 
				"\n\n";
		}

		this.stateInformation.put("alunos_por_turma_ensino_medio", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2007; counter < state.getAverageClassSize().length; 
			counter++, year++) {
			temporaryString += year + ": " +
				"Quantidade media de horas de aula(Fundamental): " + decimalFormatValue.
				format(state.getAverageClassHours()[state.getAverageClassHours()
				.length - 1].getElementarySchool()) + "\n" +
				"Quantidade media de horas de aula (Medio): " + decimalFormatValue.format
				(state.getAverageClassHours()[state.getAverageClassHours().length -
				1].getHighSchool()) + "\n\n";
		}

		this.stateInformation.put("horas_aula_ensino_medio", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2006; counter < state.getAgeSeriesDistortionRate()
			.length; counter++, year++) {
			temporaryString += year + ": " + 
				"Quantidade de Distor��o da Idade(Fundamental): " +
				decimalFormatPercentage.format(state.getAgeSeriesDistortionRate()[counter]
				.getElementarySchool()) 
				+ "\n" + "Quantidade de Distor��o da Idade (Medio): " 
				+ decimalFormatPercentage.format(state.getAgeSeriesDistortionRate()[counter]
				.getHighSchool()) + "\n\n";
		}

		this.stateInformation.put("taxa_distorcao", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2007; counter < state.getUtilizationRate().length;
			counter++, year++) {
			temporaryString += year + ": " + "Taxa de Aprova��o (Fundamental): " 
				+ decimalFormatPercentage.format(state.getUtilizationRate()[counter].
					getElementarySchool()) + "\n" + "\t\t  " +
				"Taxa de Aprova��o (Medio): " 
				+ decimalFormatPercentage.format(state.getUtilizationRate()[counter]
				.getHighSchool()) 
				+ "\n\n";
		}

		this.stateInformation.put("taxa_aprovacao", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2007; counter < state.getDropoutRate().length; year++,
			counter++) {
			temporaryString += year + ": " + "Taxa de Abandono (Fundamental): " 
				+ decimalFormatPercentage.format(state.getDropoutRate()[counter]
				.getElementarySchool()) + "\n" + "\t\t  " +
				"Taxa de Abandono (Medio): " 
				+ decimalFormatPercentage.format(state.getDropoutRate()[counter]
				.getHighSchool()) + "\n\n";
		}

		this.stateInformation.put("taxa_abandono", temporaryString);
		temporaryString = "";

		for(int counter = 0, year = 2010; counter < state.getCensos().length; year++, counter++) {
			temporaryString += year + ": " + "Censo Anos Iniciais (Fundamental): " 
				+ decimalFormatPercentage.format(state.getCensos()[counter]
				.getElementarySchoolEarlyYears()) + "\n" + "\t\t  " + 
				"Censo Anos Finais (Fundamental): " + decimalFormatPercentage.format
				(state.getCensos()[counter].getElementarySchoolFinalYears()) + "\n" 
				+ "\t\t  " + "Censo Ensino M�dio: " + decimalFormatPercentage.format
				(state.getCensos()[counter].getHighSchool()) + "\n" + "\t\t  " 
				+ "Censo EJA (Fundamental): " + decimalFormatPercentage.format
				(state.getCensos()[counter].getEJAElementarySchool()) + "\n" + "\t\t  " 
				+ "Censo EJA (Medio): " + decimalFormatPercentage.format(state
				.getCensos()[state.getCensos().length - 1].getEJAHighSchool()) 
				+ "\n\n";
		}

		this.stateInformation.put("censo", temporaryString);
	}
	
	/*
	 * This method fills the hashmap stateInformation with the name, acronym
	 * and the amount of population of a state.
	 */
	private void fulfillNameAcronymAndPopulation(State state) {
		this.stateInformation.clear();

		this.stateInformation.put("sigla", state.getAcronym());
		this.stateInformation.put("nome", state.getName());
		this.stateInformation.put("populacao", decimalFormatPopulation.format(state
			.getPopulation()) + " habitantes");
	}
}