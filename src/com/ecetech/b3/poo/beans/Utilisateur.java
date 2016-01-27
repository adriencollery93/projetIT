package com.ecetech.b3.poo.beans;

public class Utilisateur {
	
	/**
	 * Attributes
	 */
	private int id_utilisateur;
	private String mdp_utilisateur;
	private String nom;
	private String prenom;
	
	
	/**
	 * @return The id of the user
	 */
	public int getId_utilisateur() {
		return id_utilisateur;
	}
	
	/**
	 * @param id_utilisateur
	 *            The id of the user
	 */
	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}
	
	/**
	 * @return The password of th user
	 */
	public String getMdp_utilisateur() {
		return mdp_utilisateur;
	}
	
	/**
	 * @param mdp_utilisateur
	 *            The password of the user
	 */
	public void setMdp_utilisateur(String mdp_utilisateur) {
		this.mdp_utilisateur = mdp_utilisateur;
	}
	
	/**
	 * @return The family name of the user
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * @param nom
	 *            The family name of the user
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * @return The first name of the user
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * @param prenom
	 *            The first name of the user
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Constructor
	 * 
	 * @param id_utilisateur
	 *            The id of the user
	 * @param mdp_utilisateur
	 *            The password of the user
	 * @param nom
	 *            The family name of the user
	 * @param prenom
	 *            The first name of the user
	 */
	public Utilisateur(int id_utilisateur, String mdp_utilisateur, String nom, String prenom) {
		this.id_utilisateur = id_utilisateur;
		this.mdp_utilisateur = mdp_utilisateur;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Utilisateur(){
		this(0,null,null,null);
	}
}
