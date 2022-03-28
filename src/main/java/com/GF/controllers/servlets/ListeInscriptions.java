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
import com.GF.beans.Inscription;


public class ListeInscriptions extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	private static final String PARM_DELETE = "delete";
	private static final String ATT_MAP_CANDIDATS = "mapCandidats";
	private static final String ATT_MAP_INSCRIPTIONS = "mapInscriptions";
	
	private static final String VUE_LISTE_INSCRIPTIONS = "/WEB-INF/view/listeInscriptions.jsp";
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deleteString = request.getParameter(PARM_DELETE);
		
		if(deleteString != null) {
			try {
				int delete = Integer.parseInt(deleteString);
				HttpSession session = request.getSession();
				Map<Integer, Inscription> mapInscriptions = new HashMap<Integer, Inscription>();
				mapInscriptions = (Map<Integer, Inscription>) session.getAttribute(ATT_MAP_INSCRIPTIONS);
				
				if(mapInscriptions != null) {
					Map<String, Candidat> mapCandidats = new HashMap<String, Candidat>();
					mapCandidats = (Map<String, Candidat>) session.getAttribute(ATT_MAP_CANDIDATS);
					
					if(mapCandidats != null) {
						String cin = mapInscriptions.get(delete).getIdCandidat();
						Candidat candidat = mapCandidats.get(cin);
						candidat.decNbInscriptions();
						mapCandidats.put(cin, candidat);
						session.setAttribute(ATT_MAP_CANDIDATS, mapCandidats);
					}		
					mapInscriptions.remove(delete);
					session.setAttribute(ATT_MAP_INSCRIPTIONS, mapInscriptions);
				}
			}catch (Exception e) {}
		}
			
		this.getServletContext().getRequestDispatcher(VUE_LISTE_INSCRIPTIONS).forward(request, response);
	}


}
