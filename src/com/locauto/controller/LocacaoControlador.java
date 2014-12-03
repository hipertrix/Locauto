package com.locauto.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.locauto.dao.LocacaoDao;
import com.locauto.model.Locacao;
import com.locauto.model.Usuario;

/**
 * Servlet implementation class LocacaoControlador
 */
@WebServlet("/LocacaoControlador")
public class LocacaoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocacaoControlador() {
        super();
        // TODO Auto-generated constructor stub
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
    		Locacao locacao;
    		
    		try {
    		
    			if (acao.equals("create")) {
    	 				
    				 locacao = new Locacao(request);
    					
    					LocacaoDao locacaoDao = new LocacaoDao();
    					locacaoDao.conectar(); 
    					sessao.setAttribute("error", locacaoDao.create(locacao)); 
    					
    					Usuario u = (Usuario) sessao.getAttribute("usuario");
    							
    					if(u.getTipo_usuario() > 0 ){
    					 
    						response.sendRedirect("LocacaoControlador?acao=search");
    					}else{

    						response.sendRedirect("LocacaoControlador?acao=minhasreservas");
    					}
    					
    					//getServletContext().getRequestDispatcher("/locacoes_list.jsp").forward(request, response);
    					
    					
    			}else if (acao.equals("find")) {
    				 		 		
    		 		int cod = Integer.parseInt(request.getParameter("cod"));
    		 		 
    				LocacaoDao locacaoDao = new LocacaoDao();
    				locacaoDao.conectar();
    				locacao = (Locacao) locacaoDao.find(cod);

    				if (locacao == null) {
    					sessao.setAttribute("error", "Veículo não encontrado");
    				    getServletContext().getRequestDispatcher("/locacoes_list.jsp")
    								.forward(request, response);
    				 
    				} else {
    					sessao.setAttribute("mensagem", "locacao encontrado com sucesso");
    					sessao.setAttribute("locacao", locacao);
    					getServletContext().getRequestDispatcher("/locacao_edit.jsp")
    								.forward(request, response); 
    				} 
    				
    				 
    				
    				
    				
    			}else if (acao.equals("update")) {
    				 			 			
    					locacao = new Locacao(request);	
    					LocacaoDao locacaoDao = new LocacaoDao();
    					locacaoDao.conectar(); 
    					sessao.setAttribute("error", locacaoDao.update(locacao)); 
    					response.sendRedirect("LocacaoControlador?acao=search");			
    					
    			}else if (acao.equals("search")) {
    				 
    				LocacaoDao locacaoDao = new LocacaoDao();
    				locacaoDao.conectar();
    				
    				sessao.setAttribute("locacoes", locacaoDao.where(request.getParameter("search")));
    				 
    					getServletContext().getRequestDispatcher("/locacoes_list.jsp")
    							.forward(request, response);
    				 
    			}else if (acao.equals("minhasreservas")) {
    				LocacaoDao locacaoDao = new LocacaoDao();
    				locacaoDao.conectar();
    				Usuario u = (Usuario) sessao.getAttribute("usuario");
    				
    				sessao.setAttribute("locacoes", locacaoDao.find_by_user(u));
    				 
    					getServletContext().getRequestDispatcher("/locacoes_list.jsp")
    							.forward(request, response);
    			}else if (acao.equals("novareserva")) {
    				
    			}else{
    				
    			} 
    		 
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (ServletException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}	
     
    	}
     
    }
