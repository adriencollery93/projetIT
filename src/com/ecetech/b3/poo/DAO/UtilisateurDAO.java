package com.ecetech.b3.poo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.poo.beans.Utilisateur;
import com.ecetech.b3.poo.common.SQLQueries;
import com.ecetech.b3.poo.connection.Connector;

public class UtilisateurDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;
	
	/**
	 * Constructor
	 */
	public UtilisateurDAO() {
	}
	
	/**
	 * Retrieves all users in databases
	 * 
	 * @param id
	 *            The identifying number of the user to retrieve from the
	 *            database
	 * @return An Utilisateur object with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Utilisateur getUtilisateur(int id) throws SQLException {
		String query = SQLQueries.GET_UTILISATEUR_QUERY + id;
		ResultSet rs = null;
		Utilisateur utilisateur = null;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				utilisateur = new Utilisateur();
				utilisateur.setMdp_utilisateur(rs.getString("mdp_utilisateur"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return utilisateur;
	}
	
	/**
	 * Retrieves all Utilisateurs from the database and then puts them all in a list
	 * 
	 * @return A list of Utilisateur objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Utilisateur> getUtilisateurAll() throws SQLException {
		String query = SQLQueries.GET_UTILISATEUR_ALL_QUERY;
		ResultSet rs = null;
		ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setId_utilisateur(rs.getInt("id_utilisateur"));
				utilisateur.setMdp_utilisateur(rs.getString("mdp_utilisateur"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateurs.add(utilisateur);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return utilisateurs;
	}
	
	/**
	 * Retrieves an id of an user in databases
	 * 
	 *
	 * @return An id of the last user
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Utilisateur getIdUtilisateur() throws SQLException {
		String query = SQLQueries.GET_ID_UTILISATEUR_LAST_QUERY ;
		ResultSet rs = null;
		Utilisateur utilisateur = new Utilisateur();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				utilisateur.setId_utilisateur(rs.getInt("id_utilisateur"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return utilisateur;
	}

	/**
	 * Inserts a new Utilisateur into the database
	 * 
	 * @param mdp_utilisateur
	 *            The password of the user
	 * @param nom
	 * 			  The family name
	 * @param prenom
	 * 			  The first name
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void insertUtilisateur(String mdp, String nom, String prenom) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_UTILISATEUR_QUERY ;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, mdp);
			req.setString(2, nom);
			req.setString(3, prenom);
			//statement.executeUpdate(query);
			System.out.println(req);
			req.execute();
			System.out.println("Utilisateur ajouté.");
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
	}
	
	/**
	 * Updates an Utilisateur already in the database
	 * 
	 * @param mdp_utilisateur
	 *            The password of the user
	 * @param nom
	 * 			  The family name
	 * @param prenom
	 * 			  The first name
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void updateUtilisateur(int id, String mdp, String nom, String prenom) throws SQLException {
		PreparedStatement req;
		String query = SQLQueries.UPDATE_UTILISATEUR_QUERY + id;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, mdp);
			req.setString(2, nom);
			req.setString(3, prenom);
			//statement.executeUpdate(query);
			req.execute();
			System.out.println("Utilisateur modifié.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
	/**
	 * Deletes an Utilisateur from the database
	 * 
	 * @param id
	 *            The identifying number of the user to delete
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void deleteUtilisateur(int id) throws SQLException {
		String query = SQLQueries.DELETE_UTILISATEUR_QUERY + id;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Utilisateur supprimé.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
}
