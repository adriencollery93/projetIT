package com.ecetech.b3.poo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.poo.beans.Administrateur;
import com.ecetech.b3.poo.common.SQLQueries;
import com.ecetech.b3.poo.connection.Connector;

public class AdministrateurDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;
	
	/**
	 * Constructor
	 */
	public AdministrateurDAO() {
	}
	
	/**
	 * Retrieves all administrator in databases
	 * 
	 * @param id
	 *            The identifying number of the administrator to retrieve from the
	 *            database
	 * @return An Administrateur object with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Administrateur getAdministrateur(int id) throws SQLException {
		String query = SQLQueries.GET_PROFESSEUR_QUERY + id;
		ResultSet rs = null;
		Administrateur administrateur = null;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				administrateur = new Administrateur();
				administrateur.setId_utilisateur(rs.getInt("id_utilisateur"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return administrateur;
	}
	
	/**
	 * Retrieves all Administrateur from the database and then puts them all in a list
	 * 
	 * @return A list of Administrateur objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Administrateur> getAdministrateurAll() throws SQLException {
		String query = SQLQueries.GET_ADMINISTRATEUR_ALL_QUERY;
		ResultSet rs = null;
		ArrayList<Administrateur> administrateurs = new ArrayList<Administrateur>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Administrateur administrateur = new Administrateur();
				administrateur.setId_utilisateur(rs.getInt("id_utilisateur"));
				administrateurs.add(administrateur);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return administrateurs;
	}
	
	/**
	 * Retrieves an id of an administrator in databases
	 * 
	 *
	 * @return An id of the last administrator
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Administrateur getIdAdministrateur() throws SQLException {
		String query = SQLQueries.GET_ID_ADMINISTRATEUR_LAST_QUERY ;
		ResultSet rs = null;
		Administrateur administrateur = new Administrateur();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				administrateur.setId_admin(rs.getInt("id_admin"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return administrateur;
	}
	
	/**
	 * Inserts a new Administrateur into the database
	 * 
	 * @param id_utilisateur
	 *            The id of the user
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void insertAdministrateur( int id_utilisateur) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_ADMINISTRATEUR_QUERY ;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, id_utilisateur);
			//statement.executeUpdate(query);
			req.execute();
			System.out.println("Administrateur ajouté.");
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
	}
	
	/**
	 * Updates an Administrateur already in the database
	 * 
	 * @param id_utilisateur
	 *            The id of the user
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void updateAdministrateur(int id, int id_utilisateur) throws SQLException {
		PreparedStatement req;
		String query = SQLQueries.UPDATE_ADMINISTRATEUR_QUERY + id;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, id_utilisateur);
			//statement.executeUpdate(query);
			req.execute();
			System.out.println("Administrateur modifié.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}

	/**
	 * Deletes an Administrator from the database
	 * 
	 * @param id
	 *            The identifying number of the administrator to delete
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void deleteAdministrateur(int id) throws SQLException {
		String query = SQLQueries.DELETE_ADMINISTRATEUR_QUERY + id;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Administrateur supprimé.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
}
