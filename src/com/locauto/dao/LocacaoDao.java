package com.locauto.dao;
 


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.locauto.model.Locacao;
import com.locauto.model.Usuario;
 


public class LocacaoDao extends DAO { 
	
	public String create(Object obj) {	
		Locacao locacao = (Locacao) obj;
		String error = "";
		PreparedStatement declaracao;
		try {		
			
				declaracao = conexao.prepareStatement("INSERT INTO locacao"
						+ " (usuario,operador,veiculo"
						+ ",data_locacao,data_devolucao,total_diarias) "
						+ "VALUES (?,?,?,?,?,?)");
				declaracao.setString(1, locacao.getUsuario());
				declaracao.setString(2, locacao.getOperador()); 
				declaracao.setString(3, locacao.getVeiculo()); 
				declaracao.setString(4,  locacao.getData_locacao()); 
				declaracao.setString(5,   locacao.getData_devolucao()); 
				declaracao.setDouble(6, locacao.getTotal_diarias());
				
				if (declaracao.executeUpdate() <= 0) {
					error = "Não foi possível incluir o veículo";
				} 
		} catch (SQLException e) { 
			error = "Nao pode realizar o cadastro!" + e.getMessage();
		}
		return error;		
	} 
	
	
	public String update(Object obj) {	

		Locacao locacao = (Locacao) obj;
		String error = "";
		PreparedStatement declaracao;
		try {
		
			declaracao = conexao.prepareStatement("UPDATE locacao "
					+ " set usuario=?,operador=?,veiculo=?"
						+ ",data_locacao=?,data_devolucao=?,total_diarias=?"
						+ " WHERE cod=?");

			declaracao.setString(1, locacao.getUsuario());
			declaracao.setString(2, locacao.getOperador()); 
			declaracao.setString(3, locacao.getVeiculo()); 
			declaracao.setString(4,  locacao.getData_locacao()); 
			declaracao.setString(5,   locacao.getData_devolucao()); 
			declaracao.setDouble(6, locacao.getTotal_diarias());
			declaracao.setInt(7, locacao.getCod());

			if (declaracao.executeUpdate() <= 0) {
				error = "Não foi possível atualizar os dados do veículo";
			}
		} catch (SQLException e) { 
			error = "Não pode processar, erro: " + e.getMessage(); 
		}
		return error;		
	}
	
	
	
	public Object find(int cod) {		
		try {
			Statement declaracao = conexao.createStatement();
			ResultSet resultados;
			resultados = declaracao
					.executeQuery("SELECT cod, usuario, operador, todal_diarias,"
							+ "veiculo , DATE_FORMAT(data_devolucao, '%d/%m/%Y') as data_devolucao, "
							+ " DATE_FORMAT(data_locacao, '%d/%m/%Y') as data_locacao "
							+ "FROM locacao where cod = "
			                        + cod + ";");
			resultados.next();
			
			Locacao locacao = new Locacao();
			locacao.setCod( resultados.getInt("cod")); 
			locacao.setUsuario( resultados.getString("usuario")); 
			locacao.setOperador(resultados.getString("operador"));
			locacao.setTotal_diarias(resultados.getDouble("total_diarias"));
			locacao.setVeiculo(resultados.getString("veiculo"));
			locacao.setData_devolucao(  resultados.getString("data_devolucao"));
			locacao.setData_locacao(resultados.getString("data_locacao"));
		
			return locacao;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		
		}
	}
	
	
	 
	 
	public Object where(String key) { 
		
		String sql = "select locacao.cod, locacao.usuario, locacao.operador, locacao.veiculo, "
				+ "DATE_FORMAT(data_devolucao, '%d/%m/%Y') as data_devolucao,   "
				+ "DATE_FORMAT(data_locacao, '%d/%m/%Y') as data_locacao, "
				+ "usuario.nome as usuario_nome"
				+ " from locacao left join usuario on usuario.cpf = locacao.usuario  where 1=1 ";
		try{
			if(key.equals("")){
			}else{
				sql =  sql + " and (veiculo like '%"+key+"%'  or usuario like '%"+key+"%'  or operador like '%"+key+"%' or usuario.nome like '%"+key+"%' ) ";
			}
		} catch (Exception e) { 		
		}
 
		sql += " order by usuario asc ";
		
		
		try {
			Statement declaracao = conexao.createStatement();			 
			return declaracao.executeQuery(sql);
			
		} catch (SQLException e) {		
			//e.printStackTrace();
			return null;
		
		}	

	} 
	

	public Object find_by_user(Usuario u) { 
		
		String sql = "select locacao.cod, locacao.usuario, locacao.operador, locacao.veiculo, "
				+ "DATE_FORMAT(data_devolucao, '%d/%m/%Y') as data_devolucao,   "
				+ "DATE_FORMAT(data_locacao, '%d/%m/%Y') as data_locacao, "
				+ "usuario.nome as usuario_nome"
				+ " from locacao left join usuario on usuario.cpf = locacao.usuario  where usuario = " + u.getCpf()  +" ";
	 
		sql += " order by cod asc ";
		
		
		try {
			Statement declaracao = conexao.createStatement();			 
			return declaracao.executeQuery(sql);
			
		} catch (SQLException e) {		
			//e.printStackTrace();
			return null;
		
		}	

	} 
	
	
	
	 
	
}    