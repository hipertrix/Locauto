package com.locauto.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.locauto.dao.UsuarioDao;
import com.locauto.model.StatusUsuario;
import com.locauto.model.Usuario;
 
@WebServlet("/IndexControlador")
public class IndexControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexControlador() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
		}


	private void processaRequisicao(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession sessao = request.getSession();

		String acao = request.getParameter("acao"); 
		
		Usuario usuario ;
		UsuarioDao usuarioDao;
		
		if (acao.equals("logout")) { 
			sessao.setAttribute("usuario", null);	 
			
			try {
				response.sendRedirect("index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}else if (acao.equals("incluir")) {
			try { 
				
				//-- padrão para usuários (Clientes) 
				
				usuario = new Usuario(request);
				
				 
				
				usuarioDao = new UsuarioDao();
				usuarioDao.conectar();
				sessao.setAttribute("error", usuarioDao.novo_usuario(usuario,0));
				sessao.setAttribute("usuario", usuario);

				try {
					getServletContext().getRequestDispatcher("/conta_criada.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			
		}else if (acao.equals("login")) {	
			sessao.setAttribute("error", "");
			
			try {

			usuarioDao = new UsuarioDao();
			usuarioDao.conectar();
			usuario = (Usuario) usuarioDao.login(request.getParameter("cpf"), request.getParameter("senha"));

			if (usuario.getCpf() == null) {
				sessao.setAttribute("error", "Usuário inválido. Verifique seu CPF e senha.");
				getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
			} else {
				if(usuario.getStatus()==1){
					sessao.setAttribute("usuario", usuario);
					response.sendRedirect("home.jsp");					
					//getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);			
				}else{
					sessao.setAttribute("error","Seu acesso está bloqueado. Motivo " + StatusUsuario.get_tipo_usuario_by_index(usuario.getStatus()));
					getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
					
				}						
			}
			
				
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 		
 

		}else{
			sessao.setAttribute("mensagem", "Nenhuma ação foi selecionada");
		}
		
	}
}
