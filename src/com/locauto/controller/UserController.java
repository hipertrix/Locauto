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
import com.locauto.model.Usuario;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
		}


	private void processaRequisicao(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		HttpSession sessao = request.getSession();

		String acao = request.getParameter("acao"); 
		
		Usuario usuario ;
		
		try { 	
		
		if (acao.equals("incluir_funcionario")) {						 			
				usuario = new Usuario(request);	
				sessao.setAttribute("error", create_user(usuario)); 
				getServletContext().getRequestDispatcher("/novo_funcionario.jsp").forward(request, response);

		}else if(acao.equals("update_user")){			
	 			
				usuario = new Usuario(request);	
				sessao.setAttribute("error", update_user(usuario, (String) sessao.getAttribute("tmp_cpf") )); 
				response.sendRedirect("UserController?acao=pesquisa_usuarios");
	 
			
	 	}else if (acao.equals("edit_user") ) { 
	 		 
	 		
	 		String chave = request.getParameter("cpf");
	 		sessao.setAttribute("tmp_cpf", chave); // utilizado para o update		
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.conectar();
			usuario = (Usuario) usuarioDao.consultar(chave);

			if (usuario == null) {
				sessao.setAttribute("error", "Usuário não encontrado");
				getServletContext().getRequestDispatcher("/userlist.jsp")
							.forward(request, response);			 

			} else {
				sessao.setAttribute("mensagem", "Usuário encontrado com sucesso");
				sessao.setAttribute("tmp_usuario", usuario);
				getServletContext().getRequestDispatcher("/user_edit.jsp")
							.forward(request, response);			 
			} 
		 	
		
		}else if (acao.equals("pesquisa_usuarios") ) { 
		 
				UsuarioDao usuarioDao = new UsuarioDao();
				usuarioDao.conectar();				
				sessao.setAttribute("usuarios", usuarioDao.pesquisaUsuarios(request.getParameter("search"), 0));
		        getServletContext().getRequestDispatcher("/userlist.jsp")
							.forward(request, response);
				 
		}else{
			sessao.setAttribute("mensagem", "Nenhuma ação foi selecionada");
		}	
		
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ServletException e) {
			 e.printStackTrace();
		} catch (IOException e) {
			 e.printStackTrace();
		} 
		
	}
	
	
	private String create_user(Usuario usuario){
		 	UsuarioDao usuarioDao;
			usuarioDao = new UsuarioDao();
			usuarioDao.conectar();			
			return  usuarioDao.novo_usuario(usuario,usuario.getTipo_usuario());
	}
	
	

	private String update_user(Usuario usuario, String cpf){
		 	UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.conectar();			
			return  usuarioDao.update_user(usuario, cpf);
	}
	
	 
	
}
