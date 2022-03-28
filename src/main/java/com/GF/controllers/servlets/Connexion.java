package com.GF.controllers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GF.beans.Utilisateur;
import com.GF.services.ConnexionForm;


public class Connexion extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String ATT_FORM = "form";
	private static final String ATT_UTILISATEUR = "utilisateur";
	private static final String ATT_SESSION_UTILISATEUR = "sessionUtilisateur";
	
	private static final String VUE_CONNEXION = "/WEB-INF/view/connexion.jsp";
	private static final String VUE_INSCRIPTIONS = "ListeInscriptions";
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		
//		Si l'utilisateur n'est pas connecté on le redirect vers la page de connexion
		if(session.getAttribute(ATT_SESSION_UTILISATEUR) == null) {
			this.getServletContext().getRequestDispatcher(VUE_CONNEXION).forward(request, response);
		}else {
//			Si il est connecté on le redirect vers la page de liste des inscriptions
			response.sendRedirect(VUE_INSCRIPTIONS);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ConnexionForm form = new ConnexionForm();
		Utilisateur utilisateur = form.connexionUtilisateur(request);
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_UTILISATEUR, utilisateur);
		HttpSession session = request.getSession();
		
//		Si les informations saisies sont valides on le redirect vers la page de liste des inscriptions
		if(form.getErreurs().isEmpty()) {
			session.setAttribute(ATT_SESSION_UTILISATEUR, utilisateur);
			response.sendRedirect(VUE_INSCRIPTIONS);
		}
		else {
//			Sinon on le redemande de saisir les informations
			session.setAttribute(ATT_SESSION_UTILISATEUR, null);
			this.getServletContext().getRequestDispatcher("/WEB-INF/view/connexion.jsp").forward(request, response);
		}
		
		
		
		
	}


}
