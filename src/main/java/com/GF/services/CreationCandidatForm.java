package com.GF.services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.GF.beans.Candidat;

public class CreationCandidatForm {
	
	private final static String CHAMP_CIN = "cin";
	private final static String CHAMP_NOM = "nom";
	private final static String CHAMP_PRENOM = "prenom";
	private final static String CHAMP_ADRESSE = "adresse";
	private final static String CHAMP_TEL = "tel";
	private final static String CHAMP_EMAIL = "email";
	private final static String CHAMP_NIVEAU = "niveau";
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	
	
	public Candidat creerCandidat(HttpServletRequest request) {
		String cin = request.getParameter(CHAMP_CIN);
		String nom = request.getParameter(CHAMP_NOM);
		String prenom = request.getParameter(CHAMP_PRENOM);
		String adresse = request.getParameter(CHAMP_ADRESSE);
		String tel = request.getParameter(CHAMP_TEL);
		String email = request.getParameter(CHAMP_EMAIL);
		String niveau = request.getParameter(CHAMP_NIVEAU);
		
		Candidat candidat = new Candidat();
		
		try {
			validationCin(cin);
		}catch(Exception e) {
			erreurs.put(CHAMP_CIN, e.getMessage());
		}
		candidat.setCin(cin);
		
		try {
			validationNom(nom);
		}catch(Exception e) {
			erreurs.put(CHAMP_NOM, e.getMessage());
		}
		candidat.setNom(nom);
		
		try {
			validationPrenom(prenom);
		}catch(Exception e) {
			erreurs.put(CHAMP_PRENOM, e.getMessage());
		}
		candidat.setPrenom(prenom);
		
		try {
			validationAdresse(adresse);
		}catch(Exception e) {
			erreurs.put(CHAMP_ADRESSE, e.getMessage());
		}
		candidat.setAdresse(adresse);
		
		try {
			validationTel(tel);
		}catch(Exception e) {
			erreurs.put(CHAMP_TEL, e.getMessage());
		}
		candidat.setTel(tel);
		
		try {
			validationEmail(email);
		}catch(Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
		candidat.setEmail(email);
		
		try {
			validationNiveau(niveau);
		}catch(Exception e) {
			erreurs.put(CHAMP_NIVEAU, e.getMessage());
		}
		candidat.setNiveau(niveau);

		if(erreurs.isEmpty()) {
			resultat = "Succès de la creation.";
		}
		else {
			resultat = "Echec de la creation.";
		}
		
		return candidat;
	}


	private void validationCin(String cin) throws Exception{
		if(cin == null || cin.length() == 0) {
			throw new Exception("Saisir un CIN");
		}else if(!cin.matches("[0-9a-zA-Z]{7}")) {
			throw new Exception("Saisir un CIN valid (7 caracteres)");
		}
	}
	
	private void validationNom(String nom) throws Exception{
		if(nom == null || nom.length() == 0) {
			throw new Exception("Saisir un nom");
		}
		else if(!nom.matches("[0-9a-zA-Z]{2,}")) {
			throw new Exception("Saisir un nom valid (au moins 2 caracteres)");
		}
	}
	
	private void validationPrenom(String prenom) throws Exception{
		if(prenom == null || prenom.length() == 0) {
			throw new Exception("Saisir un prenom");
		}
		else if(!prenom.matches("[0-9a-zA-Z]{2,}")) {
			throw new Exception("Saisir un prenom valid (au moins 2 caracteres)");
		}
	}
	
	private void validationAdresse(String adresse) throws Exception{
		if(adresse == null || adresse.length() == 0) {
			throw new Exception("Saisir une adresse");
		}
		else if(!adresse.matches(".{10,}")) {
			throw new Exception("Saisir une adresse valide (au moins 10 caracteres)");
		}
	}
	
	private void validationTel(String tel) throws Exception{
		if(tel == null || tel.length() == 0) {
			throw new Exception("Saisir un numéro telephone");
		}
		else if(!tel.matches("[0]\\d{9}")) {
			throw new Exception("Saisir un numéro de telephone valid (0X XX XX XX XX)");
		}
	}
	
	private void validationEmail(String email) throws Exception{
		if(email == null || email.length() == 0) {
			throw new Exception("Saisir un email");
		}
		else if(!email.matches("([^.@]+)([^@])*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Saisir un email valid");
		}
	}
	
	private void validationNiveau(String niveau) throws Exception{
		if(niveau == null || niveau.length() == 0) {
			throw new Exception("Saisir un niveau");
		}
		else if(!niveau.matches(".{1,20}")) {
			throw new Exception("Saisir un niveau valid (entre 1 et 20 caracteres)");
		}
	}
	
	
	public String getResultat() {
		return resultat;
	}
	
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
}
