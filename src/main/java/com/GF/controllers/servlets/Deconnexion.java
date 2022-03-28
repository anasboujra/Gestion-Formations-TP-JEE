package com.GF.controllers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Deconnexion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String VUE_CONNEXION = "connexion";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect(VUE_CONNEXION);
	}
}
