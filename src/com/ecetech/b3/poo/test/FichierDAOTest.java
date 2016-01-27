package com.ecetech.b3.poo.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import com.ecetech.b3.poo.DAO.FichierDAO;
import com.ecetech.b3.poo.beans.Fichier;


public class FichierDAOTest extends TestCase {
	
	/**
	 * Test the retrieve of all files in databases
	 * 
	 * @throws Exception
	 */
	public void testGetFichier() throws Exception {
		FichierDAO fichierDAOTest = new FichierDAO();
		Fichier fichierTest = new Fichier();
		fichierTest = fichierDAOTest.getFichier(1);
		assertEquals("Java",fichierTest.getNom_fichier());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
		}

	/**
	 * Test the retrieve of all Files from the database and then puts them all in a list
	 * 
	 * @throws Exception
	 */
	public void testGetFichierAll() throws Exception {
		FichierDAO fichierDAOTest = new FichierDAO();
		ArrayList<Fichier> fichierTest = new ArrayList<Fichier>();
		fichierTest = fichierDAOTest.getFichierAll();
		Iterator<Fichier> it = fichierTest.iterator();
		while(it.hasNext()){
			Fichier fichier = it.next();
			System.out.println(fichier.getId_fichier());
			System.out.println(fichier.getNom_fichier());	
		}
	}
	
	/**
	 * Test the retrieve of an id of a file in databases
	 * 
	 *
	 * @return An id of the last file
	 * @throws SQLException
	 *             SQL Exception in case it didn't work properly
	 */
	public void testGetIdFichier() throws Exception {
		FichierDAO fichierDAOTest = new FichierDAO();
		Fichier fichierTest = new Fichier();
		fichierTest = fichierDAOTest.getIdFichier();
		assertEquals(3,fichierTest.getId_fichier());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
	}
	
	/**
	 * Test the insert of a new File into the database
	 * 
	 * @throws Exception
	 */
	public void testInsertFichier() throws Exception {
		FichierDAO fichierDAOTest = new FichierDAO();
		fichierDAOTest.insertFichier("Java jdbc", "Dernier cours", 2, null);
		Fichier fichierTest = new Fichier();
		fichierTest = fichierDAOTest.getFichier(1);
		assertEquals(1,fichierTest.getId_fichier());	
	}
	
	/**
	 * Test the update of an Fichier already in the database
	 * 
	 * @throws Exception
	 */
	public void testUpdateFichier() throws Exception {
		FichierDAO fichierDAOTest = new FichierDAO();
		fichierDAOTest.updateFichier(1, "Java JDBC", null, "Dernier cours", 2, null);
		Fichier fichierTest = new Fichier();
		fichierTest = fichierDAOTest.getFichier(1);
		assertEquals("Java JDBC",fichierTest.getNom_fichier());
	}
	
	/**
	 * Test the delete of a File from the database
	 * 
	 * @throws Exception
	 */
	public void testDeleteFichier() throws Exception {
		FichierDAO fichierDAOTest = new FichierDAO();
		fichierDAOTest.deleteFichier(1);
		Fichier fichierTest = new Fichier();
		fichierTest = fichierDAOTest.getFichier(1);
		assertFalse("Java JDBC" == fichierTest.getNom_fichier());
	}
	
}
