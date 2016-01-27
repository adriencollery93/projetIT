package com.ecetech.b3.poo.beans;

public class Eleve {
	
	/**
	 * Attributes
	 */
	private int id_eleve;
	private int id_utilisateur;
	private int id_promo;
	
	/**
	 * @return The id of the student
	 */
	public int getId_eleve() {
		return id_eleve;
	}
	
	/**
	 * @param id_eleve
	 *            The id of the student
	 */
	public void setId_eleve(int id_eleve) {
		this.id_eleve = id_eleve;
	}
	
	/**
	 * @return The id of the user
	 */
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	
	/**
	 * @param id_utilisateur
	 *            The id of the room
	 */
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	
	/**
	 * @return The id of the promotion of the student
	 */
	public int getId_promo() {
		return id_promo;
	}
	
	/**
	 * @param id_promo
	 *            The id of the promotion of the student
	 */
	public void setId_promo(int id_promo) {
		this.id_promo = id_promo;
	}

	/**
	 * Constructor
	 * 
	 * @param id_eleve
	 *            The id of the student
	 * @param id_utilisateur
	 *            The id of the user
	 * @param id_promo
	 *            The id of the promotion
	 */
	public Eleve(int id_eleve, int id_utilisateur, int id_promo) {
		this.id_eleve = id_eleve;
		this.id_utilisateur = id_utilisateur;
		this.id_promo = id_promo;
	}
	
	public Eleve(){
		this(0,0,0);
	}

	
	
}
