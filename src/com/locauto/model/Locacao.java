package com.locauto.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class Locacao {
 
	   
	   
	
	
	private int cod; // auto-increment no mysql
	private String usuario;
	private String operador;
	private String veiculo;	
	private String data_locacao;
	private String data_devolucao;
	private Double total_diarias;
	
	
	public Locacao(){}
	
	public Locacao(HttpServletRequest request)  { 
		String tmp_date = "";
		usuario=request.getParameter("usuario");
		operador=request.getParameter("operador");
		veiculo=request.getParameter("veiculo"); 
		if(request.getParameter("total_diarias") != null)
		{
			total_diarias = Double.parseDouble(request.getParameter("total_diarias")); 
		}
		 
		if(request.getParameter("data_locacao") != null)
		{ 
			 data_locacao= date_db(request.getParameter("data_locacao"));			 
		}	
		
		if(request.getParameter("data_devolucao") != null)
		{ 
			data_devolucao= date_db(request.getParameter("data_devolucao"));			 
		}		 
	}
	
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public String getData_locacao() {
		return data_locacao;
	}
	public void setData_locacao(String data_locacao) {
		this.data_locacao = data_locacao;
	}
	public String getData_devolucao() {
		return data_devolucao;
	}
	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	public Double getTotal_diarias() {
		return total_diarias;
	}
	public void setTotal_diarias(Double total_diarias) {
		this.total_diarias = total_diarias;
	}
	
	
	
	

	   public static String date_db(String data)  {
		   if(data.equals("")){
			   return "";
		   }else{
		    String[] d = data.split("/");
		    return "" + d[2] + "-" + d[1] + "-" + d[0];		   
		   }
	    }
	   
	   public static String date_view(String data)  {   
		   if(data.equals("")){
			   return "";
		   }else{
		    String[] d = data.split("-");
		    return "" + d[2] + "-" + d[1] + "-" + d[0];		   
		   }  
	    } 
	
	
}
