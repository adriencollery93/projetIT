package com.ecetech.b3.poo.test;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import com.ecetech.b3.poo.DAO.AdministrateurDAO;
import com.ecetech.b3.poo.beans.Administrateur;

public class AdministrateurDAOTest extends TestCase {

	/**
	 * Test the retrieve of all administrator in databases
	 * 
	 * @throws Exception
	 */
	public void testGetAdministrateur() throws Exception {
		AdministrateurDAO administrateurDAOTest = new AdministrateurDAO();
		Administrateur administrateurTest = new Administrateur();
		administrateurTest = administrateurDAOTest.getAdministrateur(1);
		assertEquals(2,administrateurTest.getId_utilisateur());		
		//System.out.println(administrateurTest.getId_utilisateur());		
		}
	
	/**
	 * Test the retrieve of all Administrateur from the database and then puts them all in a list
	 *
	 * @throws Exception
	 */
	public void testGetAdministrateurAll() throws Exception {
		AdministrateurDAO administrateurDAOTest = new AdministrateurDAO();
		ArrayList<Administrateur> administrateurTest = new ArrayList<Administrateur>();
		administrateurTest = administrateurDAOTest.getAdministrateurAll();
		Iterator<Administrateur> it = administrateurTest.iterator();
		while(it.hasNext()){
			Administrateur administrateur = it.next();
			System.out.println(administrateur.getId_admin());
			System.out.println(administrateur.getId_utilisateur());	
		}
	}
	
	/**
	 * Test the retrieve of an id of an administrator in databases
	 * 
	 * @throws Exception
	 */
	public void testGetIdadministrateur() throws Exception {
		AdministrateurDAO administrateurDAOTest = new AdministrateurDAO();
		Administrateur administrateurTest = new Administrateur();
		administrateurTest = administrateurDAOTest.getIdAdministrateur();
		assertEquals(3,administrateurTest.getId_admin());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
	}
	
	/**
	 * Test the insert of a new Administrateur into the database
	 * 
	 * @throws Exception
	 */
	public void testInsertAdministrateur() throws Exception {
		AdministrateurDAO administrateurDAOTest = new AdministrateurDAO();
		administrateurDAOTest.insertAdministrateur(5);
		Administrateur administrateurTest = new Administrateur();
		administrateurTest = administrateurDAOTest.getAdministrateur(5);
		assertEquals(5,administrateurTest.getId_utilisateur());	
	}

	/**
	 * Test the update of an Administrateur already in the database
	 * 
	 * @throws Exception
	 */
	public void testUpdateAdministrateur() throws Exception {
		AdministrateurDAO administrateurDAOTest = new AdministrateurDAO();
		administrateurDAOTest.updateAdministrateur(2, 4);
		Administrateur administrateurTest = new Administrateur();
		administrateurTest = administrateurDAOTest.getAdministrateur(2);
		assertEquals(4,administrateurTest.getId_utilisateur());	
	}

	/**
	 * Test the delete of an Administrator from the database
	 * 
	 * @throws Exception
	 */
	public void testDeleteAdministrateur() throws Exception {
		AdministrateurDAO administrateurDAOTest = new AdministrateurDAO();
		administrateurDAOTest.deleteAdministrateur(2);
		Administrateur administrateurTest = new Administrateur();
		administrateurTest = administrateurDAOTest.getAdministrateur(2);
		assertFalse(4==administrateurTest.getId_utilisateur());	
	}

}
