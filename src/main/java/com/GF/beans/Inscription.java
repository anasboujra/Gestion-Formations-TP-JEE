package com.GF.beans;


public class Inscription {
	private int id;
	private String idCandidat;
	private String formation;
	private String dateDebut;
	private String type;
	private String typePaiement;
	private double montant;
	
	
	
	public Inscription() {
		super();
	}
	public Inscription(int id, String idCandidat, String formation, String dateDebut, String type, String typePaiement,
			double montant) {
		this.id = id;
		this.idCandidat = idCandidat;
		this.formation = formation;
		this.dateDebut = dateDebut;
		this.type = type;
		this.typePaiement = typePaiement;
		this.montant = montant;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIdCandidat() {
		return idCandidat;
	}
	public void setIdCandidat(String idCandidat) {
		this.idCandidat = idCandidat;
	}
	public String getFormation() {
		return formation;
	}
	public void setFormation(String formation) {
		this.formation = formation;
	}
	public String getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypePaiement() {
		return typePaiement;
	}
	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
}
