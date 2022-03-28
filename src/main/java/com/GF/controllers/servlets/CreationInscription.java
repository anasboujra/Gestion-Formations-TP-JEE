package com.GF.controllers.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.GF.beans.Candidat;
import com.GF.beans.Inscription;
import com.GF.services.CreationInscriptionForm;


public class CreationInscription extends HttpServlet {
	
private static final long serialVersionUID = 1L;
	
	private static final String ATT_CANDIDAT = "candidat";
	private static final String ATT_INSCRIPTION = "inscription";
	private static final String ATT_FORM = "form";
	private static final String ATT_MAP_CANDIDATS = "mapCandidats";
	private static final String ATT_MAP_INSCRIPTIONS = "mapInscriptions";
	private static final String RADIO_NA = "radioNouveauAncien";

	private static final String VUE_CREATION = "/WEB-INF/view/creerInscription.jsp";
	private static final String VUE_LISTE_INSCRIPTIONS = "ListeInscriptions";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(request, response);
	}

	
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CreationInscriptionForm form = new CreationInscriptionForm();
		Inscription inscription = form.creerInscription(request);
		Candidat candidat = form.getCandidat();
		
		request.setAttribute(ATT_CANDIDAT, candidat);
		request.setAttribute(ATT_INSCRIPTION, inscription);
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(RADIO_NA, request.getParameter(RADIO_NA));
		
		if(form.getErreurs().isEmpty()) {
			HttpSession session = request.getSession();
			
			Map<String, Candidat> mapCandidats;
			mapCandidats = (Map<String, Candidat>) session.getAttribute(ATT_MAP_CANDIDATS);
			
			if(mapCandidats == null) {
				mapCandidats = new HashMap<String, Candidat>();
			}
			
			mapCandidats.put(candidat.getCin(), candidat);
			session.setAttribute(ATT_MAP_CANDIDATS, mapCandidats);
			
			
			Map<Integer, Inscription> mapInscriptions;
			mapInscriptions = (Map<Integer, Inscription>) session.getAttribute(ATT_MAP_INSCRIPTIONS);
			
			if(mapInscriptions==null || mapInscriptions.isEmpty()) {
				mapInscriptions = new HashMap<Integer, Inscription>();
				inscription.setId(1);
				
			}else {
				int newID = Collections.max(mapInscriptions.keySet())+1;
				inscription.setId(newID);
			}
			
			mapInscriptions.put(inscription.getId(), inscription);
			session.setAttribute(ATT_MAP_INSCRIPTIONS, mapInscriptions);
			
			response.sendRedirect(VUE_LISTE_INSCRIPTIONS);
			
		} else {
			this.getServletContext().getRequestDispatcher(VUE_CREATION).forward(request, response);
		}
		
		
	}

}
