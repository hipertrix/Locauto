package com.locauto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 





 
import com.locauto.model.Veiculo;

public class VeiculoDao extends DAO {

	 
	public String create(Object obj) {	
		Veiculo veiculo = (Veiculo) obj;
		String error = "";
		PreparedStatement declaracao;
		try {		
			
				declaracao = conexao.prepareStatement("INSERT INTO veiculos (placa,marca,modelo,ano,status,valor_diaria) "
						+ "VALUES (?,?,?,?,?,?)");
				declaracao.setString(1, veiculo.getPlaca());
				declaracao.setString(2, veiculo.getMarca()); 
				declaracao.setString(3, veiculo.getModelo()); 
				declaracao.setInt(4, veiculo.getAno()); 
				declaracao.setString(5, veiculo.getStatus()); 
				declaracao.setDouble(6, veiculo.getValor_diaria());
				
				if (declaracao.executeUpdate() <= 0) {
					error = "Não foi possível incluir o veículo";
				} 
		} catch (SQLException e) { 
			error = "Nao pode realizar o cadastro!" + e.getMessage();
		}
		return error;		
	} 
	
	
	public String update(Object obj, String placa_id) {	

		Veiculo veiculo = (Veiculo) obj;
		String error = "";
		PreparedStatement declaracao;
		try {
		
			declaracao = conexao.prepareStatement("UPDATE veiculos set placa=?,marca=?,modelo=?,ano=?,status=?,valor_diaria=? WHERE placa=?");

			declaracao.setString(1, veiculo.getPlaca());
			declaracao.setString(2, veiculo.getMarca()); 
			declaracao.setString(3, veiculo.getModelo()); 
			declaracao.setInt(4, veiculo.getAno()); 
			declaracao.setString(5, veiculo.getStatus()); 
			declaracao.setDouble(6, veiculo.getValor_diaria());
			declaracao.setString(7, placa_id);

			if (declaracao.executeUpdate() <= 0) {
				error = "Não foi possível atualizar os dados do veículo";
			}
		} catch (SQLException e) { 
			error = "Não pode processar, erro: " + e.getMessage(); 
		}
		return error;		
	}
	
	
	
	public Object find(String key) {		
		try {
			Statement declaracao = conexao.createStatement();
			ResultSet resultados;
			resultados = declaracao
					.executeQuery("SELECT * FROM veiculos where placa = '"
			                        + key + "';");
			resultados.next();
			
			Veiculo veiculo = new Veiculo();			
			veiculo.setPlaca( resultados.getString("placa")); 
			veiculo.setAno(resultados.getInt("ano"));
			veiculo.setMarca(resultados.getString("marca"));
			veiculo.setModelo(resultados.getString("modelo"));
			veiculo.setStatus(resultados.getString("status"));
			veiculo.setValor_diaria(resultados.getDouble("valor_diaria"));
		
			return veiculo;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		
		}
	}
	
	
	 
	 
	public Object where(String key) { 
		
		String sql = "select * from veiculos  where 1=1 ";
		try{
			if(key.equals("")){
			}else{
				sql =  sql + " and (placa like '%"+key+"%'  or marca like '%"+key+"%'  or modelo like '%"+key+"%' or ano like '%"+key+"%' ) ";
			}
		} catch (Exception e) { 		
		}
				
		sql += " order by placa asc ";
		
		
		try {
			Statement declaracao = conexao.createStatement();			 
			return declaracao.executeQuery(sql);
			
		} catch (SQLException e) {		
			//e.printStackTrace();
			return null;
		
		}
	} 
	
	
	
	/*
	public String[][] getVeiculosEnablesList(){
		 String[][] list;
		  
		  
		  String sql = "select DISTINCT veiculos.placa, veiculos.modelo from veiculos"
			  		+ "  left join locacao on locacao.veiculo = veiculos.placa  order by veiculos.modelo asc ";
					
			
			try {
				Statement declaracao = conexao.createStatement();		 
				 ResultSet rs = declaracao.executeQuery(sql);
				 while(rs.next()) {
					 list[0] = {rs.getString("placa"), 
	                 list.add(rs.getString("placa"));
	             }
				
			} catch (SQLException e) {		
				//e.printStackTrace();
			
			}
			
			 	  
		  return list;
		  
	};
	*/
	 
	
} 
