package com.GF.beans;

public class Candidat {
	
	private String cin;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String email;
	private String niveau;
	private int nbInscriptions = 0;
	
	
	public Candidat() {
		super();
	}
	
	public Candidat(String cin, String nom, String prenom, String adresse, String tel, String email, String niveau, int nbInscriptions) {
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.email = email;
		this.niveau = niveau;
		this.setNbInscriptions(nbInscriptions);
	}

	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public int getNbInscriptions() {
		return nbInscriptions;
	}

	public void setNbInscriptions(int nbInscriptions) {
		this.nbInscriptions = nbInscriptions;
	}
	
	public void incNbInscriptions() {
		nbInscriptions = nbInscriptions+1;
	}
	
	public void decNbInscriptions() {
		nbInscriptions = nbInscriptions-1;
	}
	

	
	
}
