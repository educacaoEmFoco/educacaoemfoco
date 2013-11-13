package com.mdsgpp.eef.modelo;

public class Projeto {
	private int quantidade;
	private double valor;
	private Estado estado;
	// ano
	private int ano;
	
	public Projeto() {
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getAno(){
		return ano;
	}
	public void setAno(int ano){
		this.ano = ano;
	}

	
}
