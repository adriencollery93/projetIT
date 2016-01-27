package com.ecetech.b3.poo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.poo.beans.Eleve;
import com.ecetech.b3.poo.common.SQLQueries;
import com.ecetech.b3.poo.connection.Connector;

public class EleveDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;
	
	/**
	 * Constructor
	 */
	public EleveDAO() {
	}
	
	/**
	 * Retrieves all students in databases
	 * 
	 * @param id
	 *            The identifying number of the student to retrieve from the
	 *            database
	 * @return An Student object with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Eleve getEleve(int id) throws SQLException {
		String query = SQLQueries.GET_ELEVE_QUERY + id;
		ResultSet rs = null;
		Eleve eleve = null;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				eleve = new Eleve();
				eleve.setId_utilisateur(rs.getInt("id_utilisateur"));
				eleve.setId_promo(rs.getInt("id_promo"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return eleve;
	}
	
	/**
	 * Retrieves all Students from the database and then puts them all in a list
	 * 
	 * @return A list of Eleve objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Eleve> getEleveAll() throws SQLException {
		String query = SQLQueries.GET_ELEVE_ALL_QUERY;
		ResultSet rs = null;
		ArrayList<Eleve> eleves = new ArrayList<Eleve>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Eleve eleve = new Eleve();
				eleve.setId_utilisateur(rs.getInt("id_utilisateur"));
				eleve.setId_promo(rs.getInt("id_promo"));
				eleves.add(eleve);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return eleves;
	}
	
	/**
	 * Retrieves an id of an student in databases
	 * 
	 *
	 * @return An id of the last student
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Eleve getIdEleve() throws SQLException {
		String query = SQLQueries.GET_ID_ELEVE_LAST_QUERY ;
		ResultSet rs = null;
		Eleve eleve = new Eleve();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				eleve.setId_eleve(rs.getInt("id_eleve"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return eleve;
	}

	/**
	 * Inserts a new Eleve into the database
	 * 
	 * @param id_utilisateur
	 *            The id of the user
	 * @param id_promo
	 *            The id of the promotion
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void insertEleve( int id_utilisateur, int id_promo) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_ELEVE_QUERY ;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, id_utilisateur);
			req.setInt(2, id_promo);
			//statement.executeUpdate(query);
			System.out.println(req);
			req.execute();
			System.out.println("Eleve ajouté.");
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
	}
	
	/**
	 * Updates an Eleve already in the database
	 * 
	 * @param id_eleve
	 *            The id of the student
	 * @param id_utilisateur
	 *            The id of the user
	 * @param id_promo
	 *            The id of the promotion
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void updateEleve(int id, int id_utilisateur, int id_promo) throws SQLException {
		PreparedStatement req;
		String query = SQLQueries.UPDATE_ELEVE_QUERY + id;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setInt(1, id_utilisateur);
			req.setInt(2, id_promo);
			//statement.executeUpdate(query);
			req.execute();
			System.out.println("Eleve modifié.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
	/**
	 * Deletes an Eleve from the database
	 * 
	 * @param id
	 *            The identifying number of the student to delete
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void deleteEleve(int id) throws SQLException {
		String query = SQLQueries.DELETE_ELEVE_QUERY + id;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Eleve supprimé.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
}
