package com.ecetech.b3.poo.beans;

public class Promotion {

	/**
	 * Attributes
	 */
	private int id_promo;
	private String libelle_promo;
	private String abreviation_promo;
	
	
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
	 * @return The name of the promotion
	 */
	public String getLibelle_promo() {
		return libelle_promo;
	}
	
	/**
	 * @param libelle_promo
	 *            The name of the promotion
	 */
	public void setLibelle_promo(String libelle_promo) {
		this.libelle_promo = libelle_promo;
	}
	
	/**
	 * @return The abbreviation of the promotion
	 */
	public String getAbreviation_promo() {
		return abreviation_promo;
	}
	
	/**
	 * @param abreviation_promo
	 *            The abbreviation of the promotion
	 */
	public void setAbreviation_promo(String abreviation_promo) {
		this.abreviation_promo = abreviation_promo;
	}
	
	/**
	 * Constructor
	 * 
	 * @param id_promo
	 *            The id of the promotion
	 * @param libelle_promo
	 *            The name of the promotion
	 * @param abreviation_promo
	 *            The abbreviation of the promotion
	 */
	public Promotion(int id_promo, String libelle_promo, String abreviation_promo) {
		this.id_promo = id_promo;
		this.libelle_promo = libelle_promo;
		this.abreviation_promo = abreviation_promo;
	}
	
	public Promotion(){
		this(0, null, null);
	}
	
}
