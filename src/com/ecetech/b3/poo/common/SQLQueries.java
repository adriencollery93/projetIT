package com.ecetech.b3.poo.common;

public class SQLQueries {

	
	/** QUERIES UTILISATEUR **/
	public static final String GET_UTILISATEUR_QUERY = "SELECT * FROM Utilisateur WHERE id_utilisateur=";
	public static final String GET_UTILISATEUR_ALL_QUERY = "SELECT * FROM Utilisateur";
	public static final String GET_ID_UTILISATEUR_LAST_QUERY = "SELECT id_utilisateur FROM Utilisateur "
															+ "ORDER BY id_utilisateur DESC LIMIT 1";
	public static final String INSERT_UTILISATEUR_QUERY = "INSERT INTO Utilisateur(mdp_utilisateur, nom, prenom)"
														+ " VALUES (?,?,?)";
	public static final String UPDATE_UTILISATEUR_QUERY = "UPDATE Utilisateur "
														+ "SET mdp_utilisateur=?, nom=?, prenom=?"
														+ " WHERE id_utilisateur=";
	public static final String DELETE_UTILISATEUR_QUERY = "DELETE FROM Utilisateur WHERE id_utilisateur=";
	
	/** QUERIES ADMINISTRATEUR **/
	public static final String GET_ADMINISTRATEUR_QUERY = "SELECT * FROM Administrateur WHERE id_admin=";
	public static final String GET_ADMINISTRATEUR_ALL_QUERY = "SELECT * FROM Administrateur";
	public static final String GET_ID_ADMINISTRATEUR_LAST_QUERY = "SELECT id_admin FROM Administrateur "
															+ "ORDER BY id_admin DESC LIMIT 1";
	public static final String INSERT_ADMINISTRATEUR_QUERY = "INSERT INTO Administrateur(id_utilisateur)"
														+ " VALUES (?)";
	public static final String UPDATE_ADMINISTRATEUR_QUERY = "UPDATE Administrateur "
														+ "SET id_utilisateur=?"
														+ " WHERE id_admin=";
	public static final String DELETE_ADMINISTRATEUR_QUERY = "DELETE FROM Administrateur WHERE id_admin=";

	/** QUERIES ELEVE **/
	public static final String GET_ELEVE_QUERY = "SELECT * FROM Eleve WHERE id_eleve=";
	public static final String GET_ELEVE_ALL_QUERY = "SELECT * FROM Eleve";
	public static final String GET_ID_ELEVE_LAST_QUERY = "SELECT id_eleve FROM Eleve "
															+ "ORDER BY id_eleve DESC LIMIT 1";
	public static final String INSERT_ELEVE_QUERY = "INSERT INTO Eleve(id_utilisateur, id_promo)"
														+ " VALUES (?, ?)";
	public static final String UPDATE_ELEVE_QUERY = "UPDATE Eleve "
														+ "SET id_utilisateur=? , id_promo=?"
														+ " WHERE id_eleve=";
	public static final String DELETE_ELEVE_QUERY = "DELETE FROM Eleve WHERE id_eleve=";

	/** QUERIES PROFESSEUR **/
	public static final String GET_PROFESSEUR_QUERY = "SELECT * FROM Professeur WHERE id_professeur=";
	public static final String GET_PROFESSEUR_ALL_QUERY = "SELECT * FROM Professeur";
	public static final String GET_ID_PROFESSEUR_LAST_QUERY = "SELECT id_professeur FROM Professeur "
															+ "ORDER BY id_professeur DESC LIMIT 1";
	public static final String INSERT_PROFESSEUR_QUERY = "INSERT INTO Professeur(id_utilisateur)"
														+ " VALUES (?)";
	public static final String UPDATE_PROFESSEUR_QUERY = "UPDATE Professeur "
														+ "SET id_utilisateur=?"
														+ " WHERE id_professeur=";
	public static final String DELETE_PROFESSEUR_QUERY = "DELETE FROM Professeur WHERE id_professeur=";

	/** QUERIES PROMOTION **/
	public static final String GET_PROMOTION_QUERY = "SELECT * FROM Promotion WHERE id_promo=";
	public static final String GET_PROMOTION_ALL_QUERY = "SELECT * FROM Promotion";
	public static final String GET_ID_PROMOTION_LAST_QUERY = "SELECT id_promo FROM Promotion "
															+ "ORDER BY id_promo DESC LIMIT 1";
	public static final String INSERT_PROMOTION_QUERY = "INSERT INTO Promotion(libelle_promo, abreviation_promo)"
														+ " VALUES (?,?)";
	public static final String UPDATE_PROMOTION_QUERY = "UPDATE Promotion "
														+ "SET libelle_promo=?, abreviation_promo=?"
														+ " WHERE id_promo=";
	public static final String DELETE_PROMOTION_QUERY = "DELETE FROM Promotion WHERE id_promo=";
	
	/** QUERIES MATIERE **/
	public static final String GET_MATIERE_QUERY = "SELECT * FROM Matiere WHERE id_matiere=";
	public static final String GET_MATIERE_ALL_QUERY = "SELECT * FROM Matiere";
	public static final String GET_ID_MATIERE_LAST_QUERY = "SELECT id_matiere FROM Matiere "
															+ "ORDER BY id_matiere DESC LIMIT 1";
	public static final String INSERT_MATIERE_QUERY = "INSERT INTO Matiere(abreviation_mat, nom_matiere, id_prof)"
														+ " VALUES (?,?,?)";
	public static final String UPDATE_MATIERE_QUERY = "UPDATE Matiere "
														+ "SET abreviation_mat=?, nom_matiere=?, id_prof=?"
														+ " WHERE id_matiere=";
	public static final String DELETE_MATIERE_QUERY = "DELETE FROM Matiere WHERE id_matiere=";
	
	/** QUERIES FICHIER **/
	public static final String GET_FICHIER_QUERY = "SELECT * FROM Fichier WHERE id_fichier=";
	public static final String GET_FICHIER_ALL_QUERY = "SELECT * FROM Fichier";
	public static final String GET_ID_FICHIER_LAST_QUERY = "SELECT id_fichier FROM Fichier "
															+ "ORDER BY id_fichier DESC LIMIT 1";
	public static final String INSERT_FICHIER_QUERY = "INSERT INTO Fichier(nom_fichier,date_fichier,commentaires, id_matiere, fichier)"
														+ " VALUES (?,CURDATE(),?,?,?)";
	public static final String UPDATE_FICHIER_QUERY = "UPDATE Fichier "
														+ "SET nom_fichier=? ,commentaires=?, id_matiere=?, fichier=?"
														+ " WHERE id_fichier=";
	public static final String DELETE_FICHIER_QUERY = "DELETE FROM Fichier WHERE id_fichier=";
	
}
