package com.locauto.model;

import java.text.ParseException;


import javax.servlet.http.HttpServletRequest;

public class Veiculo {
	
	
	
	private String placa;
	private String marca;
	private String modelo;
	private int ano;
	//private String categoria;
	private String status;
	private double valor_diaria;
	

	
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	/*public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}*/

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getValor_diaria() {
		return valor_diaria;
	}

	public void setValor_diaria(double valor_diaria) {
		this.valor_diaria = valor_diaria;
	}

	public Veiculo(){}
	 
	public Veiculo(HttpServletRequest request) throws ParseException {
		//-- campos obrigatórios para todos
		placa=request.getParameter("placa");
		marca=request.getParameter("marca");
		modelo=request.getParameter("modelo");
		ano=Integer.parseInt(request.getParameter("ano"));
	//	categoria=request.getParameter("categoria");
		status=request.getParameter("status");
		valor_diaria=Double.parseDouble(request.getParameter("valor_diaria"));
		
		
	} 
	
		 
	}
	

	
	
	
