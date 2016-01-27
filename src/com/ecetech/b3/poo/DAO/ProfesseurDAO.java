package com.ecetech.b3.poo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.poo.beans.Professeur;
import com.ecetech.b3.poo.common.SQLQueries;
import com.ecetech.b3.poo.connection.Connector;

public class ProfesseurDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;
	
	/**
	 * Constructor
	 */
	public ProfesseurDAO() {
	}
	
	/**
	 * Retrieves all professor in databases
	 * 
	 * @param id
	 *            The identifying number of the professor to retrieve from the
	 *            database
	 * @return A Professeur object with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Professeur getProfesseur(int id) throws SQLException {
		String query = SQLQueries.GET_PROFESSEUR_QUERY + id;
		ResultSet rs = null;
		Professeur professeur = null;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				professeur = new Professeur();
				professeur.setId_utilisateur(rs.getInt("id_utilisateur"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return professeur;
	}
	
	/**
	 * Retrieves all Professeur from the database and then puts them all in a list
	 * 
	 * @return A list of Professeur objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Professeur> getProfesseurAll() throws SQLException {
		String query = SQLQueries.GET_PROFESSEUR_ALL_QUERY;
		ResultSet rs = null;
		ArrayList<Professeur> professeurs = new ArrayList<Professeur>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Professeur professeur = new Professeur();
				professeur.setId_utilisateur(rs.getInt("id_utilisateur"));
				professeurs.add(professeur);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return professeurs;
	}
	
	/**
	 * Retrieves an id of a professor in databases
	 * 
	 *
	 * @return An id of the last professor
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Professeur getIdProfesseur() throws SQLException {
		String query = SQLQueries.GET_ID_PROFESSEUR_LAST_QUERY ;
		ResultSet rs = null;
		Professeur professeur = new Professeur();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				professeur.setId_professeur(rs.getInt("id_professeur"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return professeur;
	}
	
	/**
	 * Inserts a new Professeur into the database
	 * 
	 * @param id_utilisateur
	 *            The id of the user
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void insertProfesseur( int id_utilisateur) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_PROFESSEUR_QUERY ;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, id_utilisateur);
			//statement.executeUpdate(query);
			req.execute();
			System.out.println("Professeur ajouté.");
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
	}
	
	/**
	 * Updates an Professeur already in the database
	 * 
	 * @param id_utilisateur
	 *            The id of the user
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void updateProfesseur(int id, int id_utilisateur) throws SQLException {
		PreparedStatement req;
		String query = SQLQueries.UPDATE_PROFESSEUR_QUERY + id;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, id_utilisateur);
			//statement.executeUpdate(query);
			req.execute();
			System.out.println("Professeur modifié.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}

	/**
	 * Deletes a Professor from the database
	 * 
	 * @param id
	 *            The identifying number of the professor to delete
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void deleteProfesseur(int id) throws SQLException {
		String query = SQLQueries.DELETE_PROFESSEUR_QUERY + id;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Professeur supprimé.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
	
}
