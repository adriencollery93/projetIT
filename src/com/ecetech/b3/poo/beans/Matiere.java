package com.ecetech.b3.poo.beans;

public class Matiere {

	/**
	 * Attributes
	 */
	private int id_matiere;
	private String abreviation_matiere;
	private String nom_matiere;
	private int id_prof;
	
	
	/**
	 * @return The id of the subject
	 */
	public int getId_matiere() {
		return id_matiere;
	}
	
	/**
	 * @param id_matiere 
	 * 			The id of the subject
	 */
	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}
	
	/**
	 * @return The abbreviation of the subject
	 */
	public String getAbreviation_matiere() {
		return abreviation_matiere;
	}
	
	/**
	 * @param abreviation_promo 
	 * 			The abbreviation of the subject
	 */
	public void setAbreviation_matiere(String abreviation_matiere) {
		this.abreviation_matiere = abreviation_matiere;
	}
	
	/**
	 * @return The name of the subject
	 */
	public String getNom_matiere() {
		return nom_matiere;
	}
	
	/**
	 * @param nom_matiere 
	 * 			The name of the subject
	 */
	public void setNom_matiere(String nom_matiere) {
		this.nom_matiere = nom_matiere;
	}
	
	/**
	 * @return The id of the professor
	 */
	public int getId_prof() {
		return id_prof;
	}
	/**
	 * @param id_prof 
	 * 			The id of the professor
	 */
	public void setId_prof(int id_prof) {
		this.id_prof = id_prof;
	}

	/**
	 * Constructor
	 * 
	 * @param id_matiere 
	 * 			The id of the subject
	 * @param abreviation_promo 
	 * 			The abbreviation of the promotion
	 * @param nom_matiere 
	 * 			The name of the subject
	 * @param id_prof 
	 * 			The id of the professor
	 */
	public Matiere(int id_matiere, String abreviation_promo, String nom_matiere, int id_prof) {
		this.id_matiere = id_matiere;
		this.abreviation_matiere = abreviation_promo;
		this.nom_matiere = nom_matiere;
		this.id_prof = id_prof;
	}
	
	public Matiere(){
		this(0,null, null, 0);
	}
	
}
