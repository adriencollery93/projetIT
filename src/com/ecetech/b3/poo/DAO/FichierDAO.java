package com.ecetech.b3.poo.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.poo.beans.Fichier;
import com.ecetech.b3.poo.common.SQLQueries;
import com.ecetech.b3.poo.connection.Connector;

public class FichierDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;
	
	/**
	 * Constructor
	 */
	public FichierDAO() {
	}
	
	/**
	 * Retrieves all files in databases
	 * 
	 * @param id
	 *            The identifying number of the file to retrieve from the
	 *            database
	 * @return A File object with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Fichier getFichier(int id) throws SQLException {
		String query = SQLQueries.GET_FICHIER_QUERY + id;
		ResultSet rs = null;
		Fichier fichier = null;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				fichier = new Fichier();
				fichier.setNom_fichier(rs.getString("nom_fichier"));
				fichier.setDate_fichier(rs.getDate("date_fichier"));
				fichier.setCommentaire(rs.getString("commentaire"));
				fichier.setId_matiere(rs.getInt("id_matiere"));
				fichier.setFichier(rs.getBytes("fichier"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return fichier;
	}
	
	/**
	 * Retrieves all Files from the database and then puts them all in a list
	 * 
	 * @return A list of Fichier objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Fichier> getFichierAll() throws SQLException {
		String query = SQLQueries.GET_FICHIER_ALL_QUERY;
		ResultSet rs = null;
		ArrayList<Fichier> fichiers = new ArrayList<Fichier>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Fichier fichier = new Fichier();
				fichier.setNom_fichier(rs.getString("nom_fichier"));
				fichier.setDate_fichier(rs.getDate("date_fichier"));
				fichier.setCommentaire(rs.getString("commentaire"));
				fichier.setId_matiere(rs.getInt("id_matiere"));
				fichier.setFichier(rs.getBytes("fichier"));
				fichiers.add(fichier);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return fichiers;
	}
	
	/**
	 * Retrieves an id of a file in databases
	 * 
	 *
	 * @return An id of the last file
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Fichier getIdFichier() throws SQLException {
		String query = SQLQueries.GET_ID_FICHIER_LAST_QUERY ;
		ResultSet rs = null;
		Fichier fichier = new Fichier();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				fichier.setId_fichier(rs.getInt("id_fichier"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return fichier;
	}
	
	/**
	 * Inserts a new File into the database
	 * 
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
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void insertFichier( String nom_fichier, String commentaire, int id_matiere,
			byte[] fichier) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_FICHIER_QUERY ;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, nom_fichier);
			req.setString(2, commentaire);
			req.setInt(3, id_matiere);
			req.setBytes(4, fichier);
			//statement.executeUpdate(query);
			System.out.println(req);
			req.execute();
			System.out.println("Fichier ajouté.");
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
	}

	/**
	 * Updates an Fichier already in the database
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
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void updateFichier(int id, String nom_fichier, Date date_fichier, String commentaire, int id_matiere,
			byte[] fichier) throws SQLException {
		PreparedStatement req;
		String query = SQLQueries.UPDATE_FICHIER_QUERY + id;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, nom_fichier);
			req.setString(2, commentaire);
			req.setInt(3, id_matiere);
			req.setBytes(4, fichier);
			//statement.executeUpdate(query);
			req.execute();
			System.out.println("Fichier modifié.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
	/**
	 * Deletes a File from the database
	 * 
	 * @param id
	 *            The identifying number of the file to delete
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void deleteFichier(int id) throws SQLException {
		String query = SQLQueries.DELETE_FICHIER_QUERY + id;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Fichier supprimé.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
}
