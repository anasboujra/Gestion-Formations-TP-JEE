package com.GF.services;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.GF.beans.Utilisateur;

public class ConnexionForm {
	
	private final static String CHAMP_EMAIL = "email";
	private final static String CHAMP_MOTDEPASSE = "motDePasse";
	
	private Map<String, String> erreurs = new HashMap<String, String>();
	private String resultat;
	
	
	public Utilisateur connexionUtilisateur(HttpServletRequest request) {
		
		Utilisateur utilisateur = new Utilisateur();
		String email = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter(CHAMP_MOTDEPASSE);
		
		try {
			validationEmail(email);
		}catch(Exception e){
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
		utilisateur.setEmail(email);
		
		try {
			validationMotDePasee(motDePasse);
		}catch(Exception e){
			erreurs.put(CHAMP_MOTDEPASSE, e.getMessage());
		}
		utilisateur.setMotDePasse(motDePasse);
		
		if(erreurs.isEmpty()) {
			resultat = "Succès de la connexion.";
		}
		else {
			resultat = "Echec de la connexion.";
		}
		
		return utilisateur;
	}
	
	
	private void validationEmail(String email) throws Exception{
		if(email==null || email.length()==0) {
			throw new Exception("Merci de saisir une adresse mail");
		}
		else if(!email.matches("([^.@]+)([^@])*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide");
		}
		else if(!email.equals("anas@email.com")) {
			throw new Exception("Cette adresse mail n'existe pas");
		}
	}

	private void validationMotDePasee(String motDePasse) throws Exception {
		if(motDePasse==null || motDePasse.length()==0) {
			throw new Exception("Merci de saisir un mot de passe");
		}
		else if(!motDePasse.matches(".{8,30}")) {
			throw new Exception("Merci de saisir un mot de passe de 8 caracters au minimum");
		}
		else if(!motDePasse.equals("00000000") && erreurs.isEmpty()) {
			throw new Exception("Ce mot de passe est incorrect");
		}
	}

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}
	
}
