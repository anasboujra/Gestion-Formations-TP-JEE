package com.GF.controllers.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GF.beans.Candidat;
import com.GF.services.CreationCandidatForm;

public class CreationCandidat extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String ATT_CANDIDAT = "candidat";
	private static final String ATT_FORM = "form";
	private static final String ATT_MAP_CANDIDATS = "mapCandidats";

	private static final String VUE_CREATION = "/WEB-INF/view/creerCandidat.jsp";
	private static final String VUE_LISTE_CANDIDATS = "ListeCandidats";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(request, response);
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CreationCandidatForm form = new CreationCandidatForm();
		Candidat candidat = form.creerCandidat(request);
		
		request.setAttribute(ATT_CANDIDAT, candidat);
		request.setAttribute(ATT_FORM, form);
		
		if(form.getErreurs().isEmpty()) {
			HttpSession session = request.getSession();
			
			Map<String, Candidat> mapCandidats;
			mapCandidats = (Map<String, Candidat>) session.getAttribute(ATT_MAP_CANDIDATS);
			
			if(mapCandidats == null) {
				mapCandidats = new HashMap<String, Candidat>();
			}
			
			mapCandidats.put(candidat.getCin(), candidat);
			session.setAttribute(ATT_MAP_CANDIDATS, mapCandidats);

			response.sendRedirect(VUE_LISTE_CANDIDATS);
			
		} else {
			this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(request, response);
		}
		
		
	}

}
