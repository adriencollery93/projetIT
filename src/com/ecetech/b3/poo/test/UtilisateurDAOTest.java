package com.ecetech.b3.poo.test;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import com.ecetech.b3.poo.DAO.UtilisateurDAO;
import com.ecetech.b3.poo.beans.Utilisateur;


public class UtilisateurDAOTest extends TestCase{

	/**
	 * Test the retrieve of all users in databases
	 * 
	 * @throws Exception
	 */
	public void testGetUtilisateur() throws Exception {
		UtilisateurDAO utilisateurDAOTest = new UtilisateurDAO();
		Utilisateur utilisateurTest = new Utilisateur();
		utilisateurTest = utilisateurDAOTest.getUtilisateur(2);
		assertEquals("Ridene",utilisateurTest.getNom());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
		}
	
	/**
	 * Test the retrieve of all Utilisateurs from the database and then puts them all in a list
	 * 
	 * @throws Exception
	 */
	public void testGetUtilisateurAll() throws Exception {
		UtilisateurDAO utilisateurDAOTest = new UtilisateurDAO();
		ArrayList<Utilisateur> utilisateurTest = new ArrayList<Utilisateur>();
		utilisateurTest = utilisateurDAOTest.getUtilisateurAll();
		Iterator<Utilisateur> it = utilisateurTest.iterator();
		while(it.hasNext()){
			Utilisateur utilisateur = it.next();
			System.out.println(utilisateur.getId_utilisateur());
			System.out.println(utilisateur.getMdp_utilisateur());
			System.out.println(utilisateur.getNom());
			System.out.println(utilisateur.getPrenom());			
		}
	}
	
	/**
	 * Test the retrieve of an id of an user in databases
	 * 
	 * @throws Exception
	 */
	public void testGetIdUtilisateur() throws Exception {
		UtilisateurDAO utilisateurDAOTest = new UtilisateurDAO();
		Utilisateur utilisateurTest = new Utilisateur();
		utilisateurTest = utilisateurDAOTest.getIdUtilisateur();
		assertEquals(6,utilisateurTest.getId_utilisateur());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
	}
	
	/**
	 * Test the insert of a new Utilisateur into the database
	 * 
	 * @throws Exception
	 */
	public void testInsertUtilisateur() throws Exception {
		UtilisateurDAO utilisateurDAOTest = new UtilisateurDAO();
		utilisateurDAOTest.insertUtilisateur("bda", "Castain", "Amélie");
		Utilisateur utilisateurTest = new Utilisateur();
		utilisateurTest = utilisateurDAOTest.getUtilisateur(7);
		assertEquals("Castain",utilisateurTest.getNom());
	}
	
	/**
	 * Test the update of an Utilisateur already in the database
	 *
	 * @throws Exception
	 */
	public void testUpdateUtilisateur() throws Exception {
		UtilisateurDAO utilisateurDAOTest = new UtilisateurDAO();
		utilisateurDAOTest.updateUtilisateur(3, "itparis", "COLLERY", "ADRIEN");
		Utilisateur utilisateurTest = new Utilisateur();
		utilisateurTest = utilisateurDAOTest.getUtilisateur(3);
		assertEquals("COLLERY",utilisateurTest.getNom());
	}
	
	/**
	 * Test the delete of an Utilisateur from the database
	 * 
	 * @throws Exception
	 */
	public void testDeleteUtilisateur() throws Exception {
		UtilisateurDAO utilisateurDAOTest = new UtilisateurDAO();
		utilisateurDAOTest.deleteUtilisateur(7);
		Utilisateur utilisateurTest = new Utilisateur();
		utilisateurTest = utilisateurDAOTest.getUtilisateur(7);
		assertFalse("Castain" == utilisateurTest.getNom());
	}

}
