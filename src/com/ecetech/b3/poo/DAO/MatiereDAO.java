package com.ecetech.b3.poo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.poo.beans.Matiere;
import com.ecetech.b3.poo.common.SQLQueries;
import com.ecetech.b3.poo.connection.Connector;

public class MatiereDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;
	
	/**
	 * Constructor
	 */
	public MatiereDAO() {
	}
	
	/**
	 * Retrieves all subject in databases
	 * 
	 * @param id
	 *            The identifying number of the subject to retrieve from the
	 *            database
	 * @return A Subject object  with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Matiere getMatiere(int id) throws SQLException {
		String query = SQLQueries.GET_MATIERE_QUERY + id;
		ResultSet rs = null;
		Matiere matiere = null;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				matiere = new Matiere();
				matiere.setAbreviation_matiere(rs.getString("abreviation_mat"));
				matiere.setNom_matiere(rs.getString("nom_matiere"));
				matiere.setId_prof(rs.getInt("id_prof"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return matiere;
	}
	
	/**
	 * Retrieves all Subjects from the database and then puts them all in a list
	 * 
	 * @return A list of Matiere objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Matiere> getMatiereAll() throws SQLException {
		String query = SQLQueries.GET_MATIERE_ALL_QUERY;
		ResultSet rs = null;
		ArrayList<Matiere> matieres = new ArrayList<Matiere>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Matiere matiere = new Matiere();
				matiere.setAbreviation_matiere(rs.getString("abreviation_mat"));
				matiere.setNom_matiere(rs.getString("nom_matiere"));
				matiere.setId_prof(rs.getInt("id_prof"));
				matieres.add(matiere);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return matieres;
	}
	
	/**
	 * Retrieves an id of an subject in databases
	 * 
	 *
	 * @return An id of the last subject
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Matiere getIdMatiere() throws SQLException {
		String query = SQLQueries.GET_ID_MATIERE_LAST_QUERY ;
		ResultSet rs = null;
		Matiere matiere = new Matiere();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				matiere.setId_matiere(rs.getInt("id_matiere"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return matiere;
	}
	
	/**
	 * Inserts a new Matiere into the database
	 * 
	 * @param abreviation_promo 
	 * 			The abbreviation of the promotion
	 * @param nom_matiere 
	 * 			The name of the subject
	 * @param id_prof 
	 * 			The id of the professor
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void insertMatiere(String abreviation_promo, String nom_matiere, int id_prof) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_MATIERE_QUERY ;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, abreviation_promo);
			req.setString(2, nom_matiere);
			req.setInt(3, id_prof);
			//statement.executeUpdate(query);
			System.out.println(req);
			req.execute();
			System.out.println("Matière ajoutée.");
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
	}
	
	/**
	 * Updates a Matiere already in the database
	 * 
	 * 
	 * @param id
	 * 			The id of the subject
	 * @param abreviation_promo 
	 * 			The abbreviation of the promotion
	 * @param nom_matiere 
	 * 			The name of the subject
	 * @param id_prof 
	 * 			The id of the professor
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void updateMatiere(int id, String abreviation_mat, String nom_matiere, int id_prof) throws SQLException {
		PreparedStatement req;
		String query = SQLQueries.UPDATE_MATIERE_QUERY + id;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, abreviation_mat);
			req.setString(2, nom_matiere);
			req.setInt(3, id_prof);
			//statement.executeUpdate(query);
			req.execute();
			System.out.println("Matière modifiée.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
	/**
	 * Deletes an Matiere from the database
	 * 
	 * @param id
	 *            The identifying number of the subject to delete
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void deleteMatiere(int id) throws SQLException {
		String query = SQLQueries.DELETE_MATIERE_QUERY + id;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Matiere supprimée.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
}
