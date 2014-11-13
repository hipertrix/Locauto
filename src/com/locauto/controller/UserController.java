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
			HttpServletResponse response) {

		HttpSession sessao = request.getSession();

		String acao = request.getParameter("acao"); 
		
		Usuario usuario ;
		
		
		if (acao.equals("incluir_funcionario")) {
			try { 				
				//-- padrão cadastra funcionário				
				usuario = new Usuario(request);	
				sessao.setAttribute("error", create_user(usuario)); 

				try {
					getServletContext().getRequestDispatcher("/novo_funcionario.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}		
			 

		}else{
			sessao.setAttribute("mensagem", "Nenhuma ação foi selecionada");
		}	
		
	}
	
	
	private String create_user(Usuario usuario){
		 	UsuarioDao usuarioDao;
			usuarioDao = new UsuarioDao();
			usuarioDao.conectar();			
			return  usuarioDao.novo_usuario(usuario,usuario.getTipo_usuario());
	}
	
}
