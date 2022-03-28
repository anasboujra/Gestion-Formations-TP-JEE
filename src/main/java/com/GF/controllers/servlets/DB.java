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

public class DB extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final String ATT_MAP_CANDIDATS = "mapCandidats";
	private static final String ATT_MAP_INSCRIPTIONS = "mapInscriptions";
	
	private static final String VUE_LISTE_CANDIDATS = "ListeCandidats";

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, Candidat> mapCandidats = new HashMap<String, Candidat>();
		mapCandidats = (Map<String, Candidat>) session.getAttribute(ATT_MAP_CANDIDATS);
		
		if(mapCandidats == null || mapCandidats.isEmpty()) {
			mapCandidats = new HashMap<String, Candidat>();
			mapCandidats.put("JK31093",new Candidat("JK31093", "Zanir", "Mohamed", "Agadir Tilila rue 8", "0603481977", "zanir.med@gmail.com", "Bac+5", 1));
			mapCandidats.put("JL41982",new Candidat("JL41982", "Noami", "Ali", "Agadir Tikouine Zaitoune Bloc E", "0711317803", "infonoami98@gmail.com", "Bac+4", 0));
			mapCandidats.put("EF89237",new Candidat("EF89237", "Oularri", "Saida", "Marrakech Masmoudi Targua", "0637836202", "soulrrr11@gmail.com", "Bac+1", 2));
			session.setAttribute(ATT_MAP_CANDIDATS, mapCandidats);
			

			Map<Integer, Inscription> mapInscriptions = new HashMap<Integer, Inscription>();
			mapInscriptions = (Map<Integer, Inscription>) session.getAttribute(ATT_MAP_INSCRIPTIONS);
			
			if(mapInscriptions == null || mapInscriptions.isEmpty()) {
				mapInscriptions = new HashMap<Integer, Inscription>();
				mapInscriptions.put(1 ,new Inscription(1, "JK31093", "Spring", "01-01-2022", "Normale", "MasterCard", 3500));
				mapInscriptions.put(2 ,new Inscription(2, "EF89237", "React", "01-02-2022", "Difficile", "PayPal", 4400));
				mapInscriptions.put(3 ,new Inscription(3, "EF89237", "Hibernate", "01-12-2021", "Facile", "PayPal", 1800));
				session.setAttribute(ATT_MAP_INSCRIPTIONS, mapInscriptions);
			}
			
			
		}
		response.sendRedirect(VUE_LISTE_CANDIDATS);
	}
}
