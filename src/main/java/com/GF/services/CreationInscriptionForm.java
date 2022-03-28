package com.GF.services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.GF.beans.Candidat;
import com.GF.beans.Inscription;

public class CreationInscriptionForm {
	private final static String CHAMP_FORMATION = "formation";
	private final static String CHAMP_DATE_DEBUT = "dateDebut";
	private final static String CHAMP_TYPE = "type";
	private final static String CHAMP_TYPE_PAIEMENT = "typePaiement";
	private final static String CHAMP_MONTANT = "montant";
	private static final String RADIO_NA = "radioNouveauAncien";

	private static final String ATT_MAP_CANDIDATS = "mapCandidats";
	private static final String CANDIDAT_SELECTIONNE = "candidatSelectionne";
	

	private Candidat candidat = new Candidat();
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	
	
	@SuppressWarnings("unchecked")
	public Inscription creerInscription(HttpServletRequest request) {
		String nomFormation = request.getParameter(CHAMP_FORMATION);
		String dateDebut = request.getParameter(CHAMP_DATE_DEBUT);
		String type = request.getParameter(CHAMP_TYPE);
		String typePaiement = request.getParameter(CHAMP_TYPE_PAIEMENT);
		String montantString = request.getParameter(CHAMP_MONTANT);
		
		String radioNA = request.getParameter(RADIO_NA);
		
		if(radioNA != null) {
			request.setAttribute(RADIO_NA, radioNA);
			
			if(radioNA.equals("ancien")) {
				String candidatSelectionne = request.getParameter(CANDIDAT_SELECTIONNE);
				HttpSession session = request.getSession();
				
				Map<String, Candidat> mapCandidats;
				mapCandidats = (HashMap<String, Candidat>) session.getAttribute(ATT_MAP_CANDIDATS);
				candidat = mapCandidats.get(candidatSelectionne);
				
			} else {
				CreationCandidatForm form = new CreationCandidatForm();
				candidat = form.creerCandidat(request);
				erreurs = form.getErreurs();
			}
		} else {
			CreationCandidatForm form = new CreationCandidatForm();
			candidat = form.creerCandidat(request);
			erreurs = form.getErreurs();
		}
		
		candidat.incNbInscriptions();
		
		Inscription inscription = new Inscription();
		inscription.setIdCandidat(candidat.getCin());
		
		try {
			validationFormation(nomFormation);
		}catch(Exception e) {
			erreurs.put(CHAMP_FORMATION, e.getMessage());
		}
		inscription.setFormation(nomFormation);
		
		try {
			validationDateDebut(dateDebut);
		}catch(Exception e) {
			erreurs.put(CHAMP_DATE_DEBUT, e.getMessage());
		}
		inscription.setDateDebut(dateDebut);
		
		try {
			validationType(type);
		}catch(Exception e) {
			erreurs.put(CHAMP_TYPE, e.getMessage());
		}
		inscription.setType(type);
		
		try {
			validationTypePaiement(typePaiement);
		}catch(Exception e) {
			erreurs.put(CHAMP_TYPE_PAIEMENT, e.getMessage());
		}
		inscription.setTypePaiement(typePaiement);
		
		double montant = 0;
		try {
			montant = validationMontant(montantString);
		}catch(Exception e) {
			erreurs.put(CHAMP_MONTANT, e.getMessage());
		}
		inscription.setMontant(montant);
		
		if(erreurs.isEmpty()) {
			resultat = "Succès de l'inscription.";
		}
		else {
			resultat = "Echec de l'inscription.";
		}
		
		return inscription;
	}
	
	private void validationFormation(String nomFormation) throws Exception{
		if(nomFormation == null || nomFormation.length() == 0) {
			throw new Exception("Saisir une formation");
		}
		else if(!nomFormation.matches(".{1,}")) {
			throw new Exception("Saisir une formation valide");
		}
	}
	
	private void validationDateDebut(String dateDebut) throws Exception{
		if(dateDebut == null || dateDebut.length() == 0) {
			throw new Exception("Saisir une date");
		}
		else if(!dateDebut.matches("\\d{2}[\\-]\\d{2}[\\-]\\d{4}")) {
			throw new Exception("Saisir une date valide");
		}
	}
	
	private void validationType(String type) throws Exception{
		if(type == null || type.length() == 0) {
			throw new Exception("Saisir un type");
		}
		else if(!type.matches(".{1,}")) {
			throw new Exception("Saisir un type valid");
		}
	}
	
	private void validationTypePaiement(String typePaiement) throws Exception{
		if(typePaiement == null || typePaiement.length() == 0) {
			throw new Exception("Saisir un type de paiement");
		}
		else if(!typePaiement.matches(".{1,}")) {
			throw new Exception("Saisir un type de paiement valid");
		}
	}
	
	private double validationMontant(String montantString) throws Exception{
		double montant = 0 ;
		if(montantString == null || montantString.length() == 0) {
			throw new Exception("Saisir un montant");
		}
		else {
			try {
				montant = Double.parseDouble(montantString);
				if(montant < 0) {
					throw new Exception("Saisir un montant valide (superieur à 0)");
				}
			} catch (Exception e) {
				throw new Exception("Saisir un montant valide (un nombre)");
			}
		}
		return montant;
	}
	
	
	public String getResultat() {
		return resultat;
	}
	
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
}
