package com.locauto.controller;

import java.io.IOException;
import java.text.ParseException;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

 
import com.locauto.dao.VeiculoDao; 
import com.locauto.model.Veiculo;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/VeiculoControlador")
public class VeiculoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
	public VeiculoControlador() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processaRequisicao(request, response);
	}

	private void processaRequisicao(HttpServletRequest request,
			HttpServletResponse response) {

		HttpSession sessao = request.getSession();
		
		String acao = request.getParameter("acao");
		Veiculo veiculo;
		
		try {
		
			if (acao.equals("create")) {
	 				
				 veiculo = new Veiculo(request);
					
					VeiculoDao veiculoDao = new VeiculoDao();
					veiculoDao.conectar(); 
					sessao.setAttribute("error", veiculoDao.create(veiculo)); 
					//getServletContext().getRequestDispatcher("/veiculos_list.jsp").forward(request, response);
					response.sendRedirect("VeiculoControlador?acao=search");
					
			}else if (acao.equals("find")) {
				 		 		
		 		String placa = request.getParameter("placa");
		 		sessao.setAttribute("tmp_placa", placa); // utilizado para o update		 		

				VeiculoDao veiculoDao = new VeiculoDao();
				veiculoDao.conectar();
				veiculo = (Veiculo) veiculoDao.find(placa);

				if (veiculo == null) {
					sessao.setAttribute("error", "Veículo não encontrado");
				    getServletContext().getRequestDispatcher("/veiculos_list.jsp")
								.forward(request, response);
				 
				} else {
					sessao.setAttribute("mensagem", "Veiculo encontrado com sucesso");
					sessao.setAttribute("veiculo", veiculo);
					getServletContext().getRequestDispatcher("/veiculo_edit.jsp")
								.forward(request, response); 
				} 
				
				
				
				
				
				
				
			}else if (acao.equals("update")) {
				 			 			
					veiculo = new Veiculo(request);	
					VeiculoDao veiculoDao = new VeiculoDao();
					veiculoDao.conectar(); 
					sessao.setAttribute("error", veiculoDao.update(veiculo,(String) sessao.getAttribute("tmp_placa") )); 
					response.sendRedirect("VeiculoControlador?acao=search");			
					
			}else if (acao.equals("search")) {
				 
				VeiculoDao veiculoDao = new VeiculoDao();
				veiculoDao.conectar();
				
				sessao.setAttribute("veiculos", veiculoDao.where(request.getParameter("search")));
				 
					getServletContext().getRequestDispatcher("/veiculos_list.jsp")
							.forward(request, response);
				 
				
			}else{
				
			} 
		
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
 
	}
 
}
