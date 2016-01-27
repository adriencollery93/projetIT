package com.ecetech.b3.poo.beans;

public class Administrateur {

	/**
	 * Attributes
	 */
	private int id_admin;
	private int id_utilisateur;
	
	/**
	 * @return The id of the administrator
	 */
	public int getId_admin() {
		return id_admin;
	}
	
	/**
	 * @param id_admin
	 *            The id of the administrator
	 */
	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
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
	 * @param id_admin
	 *            The id of the administrator
	 * @param id_utilisateur
	 *            The id of the user
	 */
	public Administrateur(int id_admin, int id_utilisateur) {
		this.id_admin = id_admin;
		this.id_utilisateur = id_utilisateur;
	}
	
	public Administrateur(){
		this(0,0);
	}
	
}
