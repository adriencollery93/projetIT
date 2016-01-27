package com.ecetech.b3.poo.beans;

import java.sql.Date;

public class Fichier {

	/**
	 * Attributes
	 */
	private int id_fichier;
	private String nom_fichier;
	private Date date_fichier;
	private String commentaire;
	private int id_matiere;
	private byte[] fichier;
	
	
	/**
	 * @return The id of the file
	 */
	public int getId_fichier() {
		return id_fichier;
	}
	
	/**
	 * @param id_fichier 
	 * 			The id of the file
	 */
	public void setId_fichier(int id_fichier) {
		this.id_fichier = id_fichier;
	}
	
	/**
	 * @return The name of the file
	 */
	public String getNom_fichier() {
		return nom_fichier;
	}
	
	/**
	 * @param nom_fichier 
	 * 			The name of the file
	 */
	public void setNom_fichier(String nom_fichier) {
		this.nom_fichier = nom_fichier;
	}
	
	/**
	 * @return The date of the file
	 */
	public Date getDate_fichier() {
		return date_fichier;
	}
	
	/**
	 * @param date_fichier 
	 * 			The date of the file
	 */
	public void setDate_fichier(Date date_fichier) {
		this.date_fichier = date_fichier;
	}
	
	/**
	 * @return The comment of the file
	 */
	public String getCommentaire() {
		return commentaire;
	}
	
	/**
	 * @param commentaire 
	 * 			The comment of the file
	 */
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	/**
	 * @return The id of the subject
	 */
	public int getId_matiere() {
		return id_matiere;
	}
	
	/**
	 * @param id_matiere 
	 * 			The comment of the file
	 */
	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}
	
	/**
	 * @return The file
	 */
	public byte[] getFichier() {
		return fichier;
	}
	
	/**
	 * @param fichier 
	 * 			The file
	 */
	public void setFichier(byte[] fichier) {
		this.fichier = fichier;
	}
	
	/**
	 * Constructor
	 * 
	 * @param id_fichier 
	 * 			The id of the file
	 * @param nom_fichier 
	 * 			The name of the file
	 * @param date_fichier 
	 * 			The date of the file
	 * @param commentaire 
	 * 			The comment of the file
	 * @param id_matiere 
	 * 			The comment of the file
	 * @param fichier 
	 * 			The file
	 */
	public Fichier(int id_fichier, String nom_fichier, Date date_fichier, String commentaire, int id_matiere,
			byte[] fichier) {
		this.id_fichier = id_fichier;
		this.nom_fichier = nom_fichier;
		this.date_fichier = date_fichier;
		this.commentaire = commentaire;
		this.id_matiere = id_matiere;
		this.fichier = fichier;
	}
	
	public Fichier(){
		this(0, null, null, null, 0, null);
	}
	
}
