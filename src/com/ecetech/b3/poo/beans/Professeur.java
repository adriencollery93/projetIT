package com.ecetech.b3.poo.beans;

public class Professeur {

	/**
	 * Attributes
	 */
	private int id_professeur;
	private int id_utilisateur;
	
	/**
	 * @return The id of the professor
	 */
	public int getId_professeur() {
		return id_professeur;
	}
	
	/**
	 * @param id_professeur
	 *            The id of the professor
	 */
	public void setId_professeur(int id_professeur) {
		this.id_professeur = id_professeur;
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
	 * Constructor
	 * 
	 * @param id_professeur
	 *            The id of the professor
	 * @param id_utilisateur
	 *            The id of the user
	 */
	public Professeur(int id_professeur, int id_utilisateur) {
		this.id_professeur = id_professeur;
		this.id_utilisateur = id_utilisateur;
	}
	
	public Professeur(){
		this(0,0);
	}
	
	
	
}
