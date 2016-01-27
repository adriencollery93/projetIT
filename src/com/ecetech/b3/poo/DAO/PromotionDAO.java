package com.ecetech.b3.poo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ecetech.b3.poo.beans.Promotion;
import com.ecetech.b3.poo.common.SQLQueries;
import com.ecetech.b3.poo.connection.Connector;

public class PromotionDAO {

	/**
	 * Attributes
	 */
	private Connection connection;
	private Statement statement;
	
	/**
	 * Constructor
	 */
	public PromotionDAO() {
	}
	
	/**
	 * Retrieves all promotion in databases
	 * 
	 * @param id
	 *            The identifying number of the promotion to retrieve from the
	 *            database
	 * @return A Promotion object with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Promotion getPromotion(int id) throws SQLException {
		String query = SQLQueries.GET_PROMOTION_QUERY + id;
		ResultSet rs = null;
		Promotion promotion = null;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			if (rs.next()) {
				promotion = new Promotion();
				promotion.setLibelle_promo(rs.getString("libelle_promo"));
				promotion.setAbreviation_promo(rs.getString("abreviation_promo"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return promotion;
	}

	/**
	 * Retrieves all Promotions from the database and then puts them all in a list
	 * 
	 * @return A list of Promotion objects with all their attributes from the
	 *         database
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public ArrayList<Promotion> getPromotionAll() throws SQLException {
		String query = SQLQueries.GET_PROMOTION_ALL_QUERY;
		ResultSet rs = null;
		ArrayList<Promotion> promotions = new ArrayList<Promotion>();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while (rs.next()) {
				Promotion promotion = new Promotion();
				promotion.setLibelle_promo(rs.getString("libelle_promo"));
				promotion.setAbreviation_promo(rs.getString("abreviation_promo"));
				promotions.add(promotion);
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return promotions;
	}
	
	/**
	 * Retrieves an id of a promotion in databases
	 * 
	 * @return An id of the last promotion
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public Promotion getIdPromotion() throws SQLException {
		String query = SQLQueries.GET_ID_PROMOTION_LAST_QUERY ;
		ResultSet rs = null;
		Promotion promotion = new Promotion();
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			while(rs.next()) {
				promotion.setId_promo(rs.getInt("id_promo"));
			}
		} finally {
			if (statement != null)
				statement.close();
			if (rs != null)
				rs.close();
			connection.close();
		}
		return promotion;
	}
	
	/**
	 * Inserts a new Promotion into the database
	 * 
	 * @param libelle_promo
	 *            The name of the promotion
	 * @param abreviation_promo
	 *            The abbreviation of the promotion
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void insertPromotion(String libelle_promo, String abreviation_promo) throws SQLException {
		PreparedStatement req = null;
		String query = SQLQueries.INSERT_PROMOTION_QUERY ;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, libelle_promo);
			req.setString(2, abreviation_promo);
			//statement.executeUpdate(query);
			System.out.println(req);
			req.execute();
			System.out.println("Promotion ajoutée.");
		} finally {
			if (req != null)
				req.close();
			connection.close();
		}
	}
	
	/**
	 * Updates a Promotion already in the database
	 * 
	  * @param id_promo
	 *            The id of the promotion of the student
	 * @param libelle_promo
	 *            The name of the promotion
	 * @param abreviation_promo
	 *            The abbreviation of the promotion
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void updatePromotion(int id, String libelle_promo, String abreviation_promo) throws SQLException {
		PreparedStatement req;
		String query = SQLQueries.UPDATE_PROMOTION_QUERY + id;
		try {
			connection = Connector.getConnection();
			req = connection.prepareStatement(query);
			req.setString(1, libelle_promo);
			req.setString(2, abreviation_promo);
			//statement.executeUpdate(query);
			req.execute();
			System.out.println("Promotion modifiée.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
	/**
	 * Deletes a Promotion from the database
	 * 
	 * @param id
	 *            The identifying number of the promotion to delete
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void deletePromotion(int id) throws SQLException {
		String query = SQLQueries.DELETE_PROMOTION_QUERY + id;
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Promotion supprimée.");
		} finally {
			if (statement != null)
				statement.close();
			connection.close();
		}
	}
	
}

