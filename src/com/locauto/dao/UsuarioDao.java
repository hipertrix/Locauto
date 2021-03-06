package com.locauto.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.locauto.model.TipoUsuario;
import com.locauto.model.Usuario;

public class UsuarioDao extends DAO {
	
	String[] tipo_usuario = TipoUsuario.get_all_tipo_usuario();	
	
	public String novo_usuario(Object obj, int tipo) {	

		Usuario usuario = (Usuario) obj;
		String error = "";
		PreparedStatement declaracao;
		try {
			
			if(tipo == 0){
				declaracao = conexao.prepareStatement("INSERT INTO usuario (cpf,nome,email,senha,cnh,tipo_usuario,status) "
						+ "VALUES (?,?,?,?,?,0,0)");
		declaracao.setString(1, usuario.getCpf());
		declaracao.setString(2, usuario.getNome()); 
		declaracao.setString(3, usuario.getEmail()); 
		declaracao.setString(4, usuario.getSenha()); 
		declaracao.setString(5, usuario.getCnh());
				
			}else{
				declaracao = conexao.prepareStatement("INSERT INTO usuario (cpf,nome,email,"
						+ "senha,tipo_usuario,status) "
						+ "VALUES (?,?,?,?,?,?,1)");
		declaracao.setString(1, usuario.getCpf());
		declaracao.setString(2, usuario.getNome()); 
		declaracao.setString(3, usuario.getEmail()); 
		declaracao.setString(4, usuario.getSenha()); 
		declaracao.setInt(6,tipo);
			}
			
			

			if (declaracao.executeUpdate() <= 0) {
				error = "Não foi possível incluir o " + tipo_usuario[tipo];
			}
		} catch (SQLException e) { 
			error = "Não pode realizar o cadastro!" + e.getMessage();
			e.printStackTrace();
		}
		return error;		
	}
	
	
	
	public Usuario login(String cpf, String senha){
		Usuario usuario = new Usuario();		
		PreparedStatement declaracao;
		try {
			
			
			declaracao = conexao.prepareStatement("SELECT * from usuario WHERE senha = ? and cpf = ? ");
			declaracao.setString(1, senha);
			declaracao.setString(2, cpf); 
			
			ResultSet resultados;
			resultados = declaracao.executeQuery();
			resultados.next();
			
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
			 							
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return usuario;
	} 
	 
} 
