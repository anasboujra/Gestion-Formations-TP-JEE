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


public class ListeCandidats extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PARM_DELETE = "delete";
	private static final String ATT_MAP_CANDIDATS = "mapCandidats";
	
	private static final String VUE_LISTE_CANDIDATS = "/WEB-INF/view/listeCandidats.jsp";
	
	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String delete = request.getParameter(PARM_DELETE);
		
		if(delete != null) {
			HttpSession session = request.getSession();
			Map<String, Candidat> mapCandidats = new HashMap<String, Candidat>();
			mapCandidats = (Map<String, Candidat>) session.getAttribute(ATT_MAP_CANDIDATS);
		
			if(mapCandidats != null) {
				mapCandidats.remove(delete);
				session.setAttribute(ATT_MAP_CANDIDATS, mapCandidats);
			}
		}
		this.getServletContext().getRequestDispatcher(VUE_LISTE_CANDIDATS).forward(request, response);
	}


}
