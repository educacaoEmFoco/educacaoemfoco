package com.mdsgpp.eef.modelo;

import java.util.ArrayList;
import java.util.HashMap;


public class State {

	private String name;
	private String acronym;
	private double PIBPercentParticipaion[];
	private int population;
	private Censo censos[]; 
	private Ideb idebs[];
	private Media averageClassSize[]; 
	private Media averageClassHours[]; 
	private Projeto scienceTechnologyProjects[];
	private Projeto firstProjects[];
	private Projeto InctProjects[];
	private Projeto CnpqSupportProjects[];
	private Projeto youngResearchersProject[];
	private Media ageSeriesDistortionRate[]; 
	private Media utilizationRate[]; 
	private Media droupoutRate[];
	
	public State(){
	}
	
	public State(String name, String acronym, HashMap<String,
		ArrayList<String[]>> information) {
		this.name = name;
		this.acronym = acronym;
		
		fulfillData(information);		
	}

	public Censo[] getCensos() {
		return censos;
	}

	public void setCensos(HashMap<String, ArrayList<String[]>> information) {
		ArrayList<String[]> finalElementarySchoolData;
		ArrayList<String[]> earlyElementarySchoolData;
		ArrayList<String[]> highSchoolData;
		ArrayList<String[]> EJAHighSchoolData;
		ArrayList<String[]> EJAElementarySchoolData;
		Censo censo[] = null;
		
		finalElementarySchoolData = information.get("censo_anos_finais");
		earlyElementarySchoolData = information.get("censo_anos_iniciais");
		highSchoolData = information.get("censo_ensino_medio");
		EJAHighSchoolData = information.get("censo_eja_medio");
		EJAElementarySchoolData = information.get("censo_eja_fundamental");
		
		censo = new Censo[highSchoolData.size()];
		for(int counter = 0; counter < censo.length; counter++) {
			censo[counter] = new Censo();
			censo[counter].setState(this); 
			censo[counter].setYear(Integer.parseInt(highSchoolData.get(counter)[0]));
			censo[counter].setFinalElementarySchoolYears(Double.parseDouble
				(finalElementarySchoolData.get(counter)[1].replaceAll("\\.", "")));
			censo[counter].setHighSchool(Double.parseDouble
				(highSchoolData.get(counter)[1].replaceAll("\\.", "")));
			censo[counter].setEarlyElementarySchoolYears(Double.parseDouble
				(earlyElementarySchoolData.get(counter)[1].replaceAll("\\.", "")));
			censo[counter].setEJAHighSchool(Double.parseDouble
				(EJAHighSchoolData.get(counter)[1].replaceAll("\\.", "")));
			censo[counter].setEJAElementarySchool(Double.parseDouble
				(EJAElementarySchoolData.get(counter)[1].replaceAll("\\.", "")));
		}
		
		this.censos = censo;
	}
	
	public double[] getPIBPercentParticipation() {
		if(PIBPercentParticipaion == null) {
			double[] empty = {0};
			return empty;
		}
		else {
			// Nothing to do.
		}
			
		return PIBPercentParticipaion;
	}
	
	public void setPIBPercentParticipaion(HashMap<String, ArrayList<String[]>> information) {		
		double percentParticipation[];
		ArrayList<String[]> data = information.get("participacao_estadual_pib");
			
		percentParticipation = new double[data.size()];
		for(int counter = 0; counter < data.size(); counter++) {
			percentParticipation[counter] = Double.parseDouble
				(data.get(counter)[1].replaceAll(",", "."));
		}
			
		this.PIBPercentParticipaion = percentParticipation;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(HashMap<String, ArrayList<String[]>> information) {		
		ArrayList<String[]> data = information.get("populacao");
		this.population = Integer.parseInt(data.get(0)[1].replaceAll(",", "."));
	}

	public Ideb[] getIdebs() {
		if(idebs == null) {
			Ideb empty[] = {new Ideb(0,0,0)};
			return empty;
		}
		else {
			// Nothing to do.
		}
		
		return idebs;
	}
	
	public void setIdebs(HashMap<String, ArrayList<String[]>> information) {
		ArrayList<String[]> finalElementarySchoolData;
		ArrayList<String[]> earlyElementarySchoolData;
		ArrayList<String[]> highSchoolData;
		Ideb ideb[] = null;
		
		finalElementarySchoolData = information.get("5a_8a");
		earlyElementarySchoolData = information.get("series_iniciais");
		highSchoolData = information.get("ensino_medio");
		
		ideb = new Ideb[highSchoolData.size()];
		for(int counter = 0; counter < ideb.length; counter++) {
			ideb[counter] = new Ideb();
			ideb[counter].setState(this);

			if(counter < (ideb.length - 1)) {
				ideb[counter].setYear(Integer.parseInt(highSchoolData.get(counter)[0]));
			}
			else {
				// Nothing to do.
			}
			
			ideb[counter].setFundamental(Double.parseDouble
				(finalElementarySchoolData.get(counter)[1].replaceAll(",", ".")));
			ideb[counter].setMedio(Double.parseDouble
				(highSchoolData.get(counter)[1].replaceAll(",", ".")));
			ideb[counter].setSeriesIniciais(Double.parseDouble
				(earlyElementarySchoolData.get(counter)[1].replaceAll(",", ".")));
		}
		
		this.idebs = ideb;
	}

	public Media[] returnEmptyAverage() {
		Media emptyAverage[] = {new Media(0,0)};
		emptyAverage[0].setYear(0);
		
		return emptyAverage;
	}
	
	public Media[] setAverage(HashMap<String, ArrayList<String[]>> information, 
		String[] indicativeNames) {
		ArrayList<String[]> elementarySchoolData;
		ArrayList<String[]> highSchoolData;
		Media readAverage[] = null;
		
		elementarySchoolData = information.get(indicativeNames[0]);
		highSchoolData = information.get(indicativeNames[1]);
		
		readAverage = new Media[highSchoolData.size()];
		for(int counter = 0; counter < readAverage.length; counter++) {
			readAverage[counter] = new Media();
			readAverage[counter].setState(this); 
			readAverage[counter].setYear(Integer.parseInt(highSchoolData.get(counter)[0]));
			readAverage[counter].setElementarySchool(Double.parseDouble
				(elementarySchoolData.get(counter)[1].replaceAll(",", ".")));
			readAverage[counter].setHighSchool(Double.parseDouble
				(highSchoolData.get(counter)[1].replaceAll(",", ".")));
		}
		
		return readAverage;
	}
	
	public Media[] getAverageClassSize() {
		if(averageClassSize == null) {
			return returnEmptyAverage();
		}
		else {
			// Nothing to do.
		}
		
		return averageClassSize;
	}

	public void setAverageClassSize(HashMap<String, ArrayList<String[]>> information, 
		String[] indicativeNames) {
		this.averageClassSize = this.setAverage(information, indicativeNames);
	}

	public Media[] getAverageClassHours() {
		if(averageClassHours == null) {
			return returnEmptyAverage();
		}
		else {
			// Nothing to do.
		}
		
		return averageClassHours;
	}

	public void setAverageClassHours(HashMap<String,ArrayList<String[]>> information, 
		String[] indicativeNames) {
		this.averageClassHours = this.setAverage(information, indicativeNames);
	}

	public Media[] getAgeSeriesDistortionRate() {
		if(ageSeriesDistortionRate == null) {
			return returnEmptyAverage();
		}
		else {
			// Nothing to do.
		}
		
		return ageSeriesDistortionRate;
	}

	public void setAgeSeriesDistortionRate(HashMap<String,ArrayList<String[]>> information, 
		String[] indicativeNames) {
		this.ageSeriesDistortionRate = this.setAverage(information, indicativeNames);
	}

	public String getName() {
		if(name == null) {
			return "Sem nome";
		}
		else {
			// Nothing to do.
		}
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcronym() {
		if(acronym == null) {
			return "Sem sigla";
		}
		else {
			// Nothing to do.
		}
		
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
	
	// Create and returns an empty Array of the type "Projeto".
	public Projeto[] returnEmptyProject() {
		Projeto emptyProject[] = {new Projeto()};
		emptyProject[0].setQuantity(0);
		emptyProject[0].setValue(0);
		emptyProject[0].setYear(0);
		
		return emptyProject;
	}
	
	public Projeto[] setProjects(HashMap<String, ArrayList<String[]>> information,
		String[] indicativeNames) {
		ArrayList<String[]> amoutInvestedData = null;
		ArrayList<String[]> quantityProjectsData = null;
		Projeto readProjects[] = null;
		
		if(information.containsKey(indicativeNames[0])) {
			quantityProjectsData = information.get(indicativeNames[0]);
			readProjects = new Projeto[quantityProjectsData.size()];
			amoutInvestedData = information.get(indicativeNames[1]);			
		}
		else {
			// Nothing to do.
		}
		
		for(int counter = 0; readProjects != null && counter < readProjects.length; counter++) { 
			readProjects[counter] = new Projeto();
			readProjects[counter].setEstado(this);
			if(counter  < (readProjects.length - 1)) {
				readProjects[counter].setYear(Integer.parseInt
					(quantityProjectsData.get(counter)[0]));
			}
			else {
				// Nothing to do.
			}
			
			readProjects[counter].setQuantity(Integer.parseInt
				(quantityProjectsData.get(counter)[1].replaceAll(",", ".")));
			readProjects[counter].setValue(Double.parseDouble
				(amoutInvestedData.get(counter)[1].replaceAll(",", ".")));
		}
		
		return readProjects;
	}
	
	public Projeto[] getScienceTechnologyProjects() {
		if(scienceTechnologyProjects == null) {
			return returnEmptyProject();
		}
		else {
			// Nothing to do.
		}
		
		return scienceTechnologyProjects;
	}

	public void setScienceTechnologyProjects(HashMap<String, ArrayList<String[]>> information, 
		String[] indicativeNames) {
		this.scienceTechnologyProjects = this.setProjects(information, indicativeNames);
	}
	
	public Projeto[] getFirstProjects() {
		if(firstProjects == null) {
			return returnEmptyProject();
		}
		else {
			// Nothing to do.
		}
		
		return firstProjects;
	}

	public void setFirstProjects(HashMap<String, ArrayList<String[]>> information, 
		String[] indicativeNames) {
		this.firstProjects = this.setProjects(information, indicativeNames);
	}

	public Projeto[] getInctProjects() {
		if(InctProjects == null) {
			return returnEmptyProject();
		}
		else {
			// Nothing to do.
		}
		
		return InctProjects;
	}

	public void setInctProjects(HashMap<String, ArrayList<String[]>> information, 
		String[] indicativeNames) {
		this.InctProjects = this.setProjects(information, indicativeNames);
	}

	public Projeto[] getCnpqSupportProjects() {
		if(CnpqSupportProjects == null) {
			return returnEmptyProject();
		}
		else {
			// Nothing to do.
		}
		
		return CnpqSupportProjects;
	}

	public void setCnpqSupportProjects(HashMap<String, ArrayList<String[]>> information, 
		String[] indicativeNames) {
		this.CnpqSupportProjects = this.setProjects(information, indicativeNames);
	}

	public Projeto[] getYoungResearchersProject() {
		if(youngResearchersProject == null) {
			return returnEmptyProject();
		}
		else {
			// Nothing to do.
		}
		
		return youngResearchersProject;
	}

	public void setYoungResearchersProject(HashMap<String, ArrayList<String[]>> information, 
		String[] indicativeNames) {
		this.youngResearchersProject = this.setProjects(information, indicativeNames);
	}

	public Media[] getUtilizationRate() {
		if(utilizationRate == null) {
			return returnEmptyAverage();
		}
		else {
			// Nothing to do.
		}
		
		return utilizationRate;
	}

	public void setUtilizationRate(HashMap<String, ArrayList<String[]>> information, 
		String[] indicativeNames) {
		this.utilizationRate = this.setAverage(information, indicativeNames);
	}

	public Media[] getDropoutRate() {
		if(droupoutRate == null) {
			return returnEmptyAverage();
		}
		else {
			// Nothing to do.
		}
		
		return droupoutRate;
	}

	public void setDroupoutRate(HashMap<String, ArrayList<String[]>> information, 
		String[] indicativeNames) {
		this.droupoutRate = this.setAverage(information, indicativeNames);
	}
	
	/*
	 * This method fills the variables of State class with
	 * the information received.
	 */
	public void fulfillData(HashMap<String, ArrayList<String[]>> information) {
		String[] indicativeAverageClassHours = {"horas_aula_ensino_fundamental", 
			"horas_aula_ensino_medio"};
		String[] indicativeAverageClassSize = 
			{"alunos_por_turma_ensino_fundamental", 
			"alunos_por_turma_ensino_medio"};
		String[] indicativeScienceTechnologyProjects = {"numero_projetos",
			"valor_investido"};
		String[] indicativeFirstProjects = {"programa_primeiros_projetos", 
			"valores_programa_primeiros_projetos"};
		String[] indicativeCnpqSupport = {"projetos_apoio_pesquisa_cnpq", 
			"valores_projetos_apoio_pesquisa_cnpq"};
		String[] indicativeYoungResearchers = {"jovens_pesquisadores", 
			"valores_jovens_pesquisadores"};
		String[] indicativeInctProjects = {"projetos_inct", 
			"valores_projetos_inct"};
		String[] ageSeriesDistortionRate = {"taxa_distorcao_fundamental", 
			"taxa_distorcao_ensino_medio"};
		String[] utilizationRate = {"taxa_aprovacao_fundamental",
			"taxa_aprovacao_medio"};
		String[] droupoutRate = {"taxa_abandono_fundamental", 
			"taxa_abandono_medio"};
		
		this.setPopulation(information);
		this.setCensos(information);
		this.setIdebs(information);
		this.setPIBPercentParticipaion(information);
				
		this.setInctProjects(information, indicativeInctProjects);
		this.setYoungResearchersProject(information,
			indicativeYoungResearchers);
		this.setCnpqSupportProjects(information, indicativeCnpqSupport);
		this.setFirstProjects(information, indicativeFirstProjects);
		this.setScienceTechnologyProjects(information,
			indicativeScienceTechnologyProjects);
		
		this.setAverageClassSize(information, 
			indicativeAverageClassSize);
		this.setAverageClassHours(information, indicativeAverageClassHours);
		this.setAgeSeriesDistortionRate(information, ageSeriesDistortionRate);
		this.setUtilizationRate(information, utilizationRate);
		this.setDroupoutRate(information, droupoutRate);
	}	
}