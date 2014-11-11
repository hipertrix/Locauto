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
		
		if (acao.equals("incluir")) {

			try { 
				
				//-- padrão para usuários (Clientes) 
				
				usuario = new Usuario(request);
				
				 
				
				usuarioDao = new UsuarioDao();
				usuarioDao.conectar();
				sessao.setAttribute("mensagem", usuarioDao.novo_cliente(usuario));
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
			

		}else if (acao.equals("consultar")) {
			// -- Somente por CPF agora
			String cpf = request.getParameter("cpf");

			usuarioDao = new UsuarioDao();
			usuarioDao.conectar();
			usuario = (Usuario) usuarioDao.consultar(cpf);

			if (usuario == null) {
				sessao.setAttribute("mensagem", "CPF não encontrado");
			} else {
				sessao.setAttribute("mensagem", "Usuario encontrado com sucesso");
				sessao.setAttribute("usuario", usuario);				
			}
			
			try {
				getServletContext().getRequestDispatcher("/consulta_usuario.jsp")
						.forward(request, response);
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
