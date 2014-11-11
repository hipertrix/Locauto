package com.locauto.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class Usuario {
	
	SimpleDateFormat date_db = new SimpleDateFormat("yyyy-MM-dd");	
	SimpleDateFormat date_view = new SimpleDateFormat("dd/MM/yyyy");
	
	private String cpf;
	private String nome;
	private String telefone;
	private Date nascimento;
	private String email;
	private String senha;
	private String cnh;
	private String endereco;
	private String cidade;
	private int tipo_usuario;
	private int status;
	private String usuario_cadastrador;
	
	private String tipo_usuario_nome;
	
	
	public Usuario(){}
	 
	public Usuario(HttpServletRequest request) throws ParseException {
		//-- campos obrigatórios para todos
		cpf=request.getParameter("cpf");
		nome=request.getParameter("nome");
		email=request.getParameter("email");
		senha=request.getParameter("senha");
		
		//tipo_usuario = Integer.parseInt(request.getParameter("tipo_usuario"));
		//status= Integer.parseInt(request.getParameter("status"));
		
		
		//-- campos incomuns, (requer valor default)
		cnh= ( request.getParameter("cnh") == null ? "" : request.getParameter("cnh"));
		telefone= ( request.getParameter("telefone") == null ? "" : request.getParameter("telefone"));
		endereco=( request.getParameter("endereco") == null ? "" :request.getParameter("endereco"));
		cidade=( request.getParameter("cidade") == null ? "" :request.getParameter("cidade"));
		usuario_cadastrador=request.getParameter("usuario_cadastrador");
		
		
		if(request.getParameter("nascimento") != null)
		{
			nascimento= date_db.parse(request.getParameter("nascimento"));
		}		
		
		 
	}
	
	
	 
	
	
	
	
	
	public String getTipoUsuarioNome() {
		return tipo_usuario_nome;
	}
	public void setTipoUsuarioNome(String tipo_usuario_nome) {
		this.tipo_usuario_nome = tipo_usuario_nome;
	}
	
	
	
	
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date date)   {
		this.nascimento = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getTipo_usuario() {
		return tipo_usuario;
	}
	public void setTipo_usuario(int tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUsuario_cadastrador() {
		return usuario_cadastrador;
	}
	public void setUsuario_cadastrador(String usuario_cadastrador) {
		this.usuario_cadastrador = usuario_cadastrador;
	}
	
	
	
	
}
