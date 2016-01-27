package com.ecetech.b3.poo.test;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import com.ecetech.b3.poo.DAO.ProfesseurDAO;
import com.ecetech.b3.poo.beans.Professeur;

public class ProfesseurDAOTest extends TestCase {

	/**
	 * Test the retrieve of all professor in databases
	 * 
	 * @throws Exception
	 */
	public void testGetProfesseur() throws Exception {
		ProfesseurDAO professeurDAOTest = new ProfesseurDAO();
		Professeur professeurTest = new Professeur();
		professeurTest = professeurDAOTest.getProfesseur(1);
		assertEquals(2,professeurTest.getId_utilisateur());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
		}
	
	/**
	 * Test the retrieve of all Professeur from the database and then puts them all in a list
	 * 
	 * @throws Exception
	 */
	public void testGetProfesseurAll() throws Exception {
		ProfesseurDAO professeurDAOTest = new ProfesseurDAO();
		ArrayList<Professeur> professeurTest = new ArrayList<Professeur>();
		professeurTest = professeurDAOTest.getProfesseurAll();
		Iterator<Professeur> it = professeurTest.iterator();
		while(it.hasNext()){
			Professeur professeur = it.next();
			System.out.println(professeur.getId_professeur());
			System.out.println(professeur.getId_utilisateur());	
		}
	}
	
	/**
	 * Test the retrieve of an id of a professor in databases
	 * 
	 * @throws Exception
	 */
	public void testGetIdProfesseur() throws Exception {
		ProfesseurDAO professeurDAOTest = new ProfesseurDAO();
		Professeur professeurTest = new Professeur();
		professeurTest = professeurDAOTest.getIdProfesseur();
		assertEquals(3,professeurTest.getId_professeur());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
	}
	
	/**
	 * Test the insert of a new Professeur into the database
	 *
	 * @throws Exception
	 */
	public void testInsertProfesseur() throws Exception {
		ProfesseurDAO professeurDAOTest = new ProfesseurDAO();
		professeurDAOTest.insertProfesseur(5);
		Professeur professeurTest = new Professeur();
		professeurTest = professeurDAOTest.getProfesseur(6);
		assertEquals(5,professeurTest.getId_utilisateur());		
	}

	/**
	 * Test the update of an Professeur already in the database
	 * 
	 * @throws Exception
	 */
	public void testUpdateProfesseur() throws Exception {
		ProfesseurDAO professeurDAOTest = new ProfesseurDAO();
		professeurDAOTest.updateProfesseur(3, 2);
		Professeur professeurTest = new Professeur();
		professeurTest = professeurDAOTest.getProfesseur(3);
		assertEquals(2,professeurTest.getId_utilisateur());	
	}

	/**
	 * Test the delete of a Professor from the database
	 * 
	 * @throws Exception
	 */
	public void testDeleteProfesseur() throws Exception {
		ProfesseurDAO professeurDAOTest = new ProfesseurDAO();
		professeurDAOTest.deleteProfesseur(2);
		Professeur professeurTest = new Professeur();
		professeurTest = professeurDAOTest.getProfesseur(2);
		assertFalse(2 == professeurTest.getId_utilisateur());	
	}
}
