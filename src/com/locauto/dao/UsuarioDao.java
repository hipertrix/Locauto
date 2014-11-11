package com.locauto.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.locauto.model.TipoUsuario;
import com.locauto.model.Usuario;

public class UsuarioDao extends DAO {
	
	String[] tipo_usuario = TipoUsuario.get_all_tipo_usuario();	
	
	public String novo_cliente(Object obj) {	

		Usuario usuario = (Usuario) obj;
		String mensagem = "";
		PreparedStatement declaracao;
		try {
			
			
			declaracao = conexao.prepareStatement("INSERT INTO usuario (cpf,nome,email,senha,cnh,tipo_usuario,status) "
							+ "VALUES (?,?,?,?,?,2,0)");
			declaracao.setString(1, usuario.getCpf());
			declaracao.setString(2, usuario.getNome()); 
			declaracao.setString(3, usuario.getEmail()); 
			declaracao.setString(4, usuario.getSenha()); 
			declaracao.setString(5, usuario.getCnh()); 		

			if (declaracao.executeUpdate() > 0) {
				mensagem = tipo_usuario[2] + " incluido com sucesso";				 
			} else {
				mensagem = "Erro: Não foi possível incluir o " + tipo_usuario[2];
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mensagem;

		
	}
	
	
	
	
	
	
	
	
	
	@Override
	public String incluir(Object obj) {
		
		

		Usuario usuario = (Usuario) obj;
		String mensagem = "";
		PreparedStatement declaracao;

		try {
			declaracao = conexao
					.prepareStatement("INSERT INTO usuarios (cpf,nome,telefone,nascimento,email,senha,"
							+ "cnh,endereco,cidade,tipo_usuario,status,usuario_cadastrador) "
							+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			declaracao.setString(1, usuario.getCpf());
			declaracao.setString(2, usuario.getNome()); 
			declaracao.setString(3, usuario.getTelefone()); 
			declaracao.setDate(4, (Date) usuario.getNascimento()); 
			declaracao.setString(5, usuario.getEmail()); 
			declaracao.setString(6, usuario.getSenha()); 
			declaracao.setString(7, usuario.getCnh()); 
			declaracao.setString(8, usuario.getEndereco()); 
			declaracao.setString(9, usuario.getCidade()); 
			declaracao.setInt(10, usuario.getTipo_usuario()); 
			declaracao.setInt(11, usuario.getStatus()); 
			declaracao.setString(12, usuario.getUsuario_cadastrador()); 			

			if (declaracao.executeUpdate() > 0) {
				mensagem = tipo_usuario[usuario.getTipo_usuario()] + " incluido com sucesso";				 
			} else {
				mensagem = "Erro: Não foi possível incluir o " + tipo_usuario[usuario.getTipo_usuario()];
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mensagem;

	}

	@Override
	public Object consultar(String cpf) {
		try {

			Statement declaracao = conexao.createStatement();
			ResultSet resultados;
			resultados = declaracao
					.executeQuery("SELECT * FROM usuarios WHERE cpf = '" + cpf + "';");
			resultados.next();
			
			Usuario usuario = new Usuario();
			usuario.setCpf( resultados.getString("cpf"));
			usuario.setNome( resultados.getString("nome"));
			usuario.setTelefone( resultados.getString("telefone"));
			usuario.setNascimento( resultados.getDate("nascimento"));
			usuario.setEmail( resultados.getString("email"));
			usuario.setSenha( resultados.getString("senha"));
			usuario.setCnh( resultados.getString("cnh"));
			usuario.setEndereco( resultados.getString("endereco"));
			usuario.setCidade( resultados.getString("cidade"));
			usuario.setTipo_usuario( resultados.getInt("tipo_usuario"));
			usuario.setStatus( resultados.getInt("status"));
			usuario.setUsuario_cadastrador( resultados.getString("usuario_cadastrador"));		
			usuario.setTipoUsuarioNome(tipo_usuario[resultados.getInt("tipo_usuario")]);
			 
		
			return usuario;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			return null;
		
		} 
	}

	@Override
	public Object consultarLivros(Object obj) { 			
			Usuario u = (Usuario) obj; 
			String sql_add = "";
			
			if(u.getNome().length() > 0){
				sql_add += " and nome like '%" +  u.getNome() + "%' ";
			}
			
			if(u.getCpf().length() > 0){
				sql_add += " and cpf like '%" +  u.getCpf() + "%' ";
			}
			
			if(u.getEndereco().length() > 0){
				sql_add += " and  editora like '%" +  u.getEndereco() + "%' ";
			}
			 
			
			String sql = "select * from usuarios where 1=1 "+ sql_add + ";";		
			
						
			try {

				Statement declaracao = conexao.createStatement();			 
				return declaracao.executeQuery(sql);			 
				
			} catch (SQLException e) {
			
				e.printStackTrace();
				return null;
			
			}	
	}

} 
