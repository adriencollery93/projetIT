package com.ecetech.b3.poo.test;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import com.ecetech.b3.poo.DAO.EleveDAO;
import com.ecetech.b3.poo.beans.Eleve;

public class EleveDAOTest extends TestCase{

	/**
	 * Test the retrieve of all students in databases
	 * 
	 
	 * @throws Exception
	 */
	public void testGetEleve() throws Exception {
		EleveDAO eleveDAOTest = new EleveDAO();
		Eleve eleveTest = new Eleve();
		eleveTest = eleveDAOTest.getEleve(1);
		assertEquals(3,eleveTest.getId_utilisateur());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
		}

	/**
	 * Test the retrieve of all Students from the database and then puts them all in a list
	 * 
	 
	 * @throws Exception
	 */
	public void testGetEleveAll() throws Exception {
		EleveDAO eleveDAOTest = new EleveDAO();
		ArrayList<Eleve> eleveTest = new ArrayList<Eleve>();
		eleveTest = eleveDAOTest.getEleveAll();
		Iterator<Eleve> it = eleveTest.iterator();
		while(it.hasNext()){
			Eleve eleve = it.next();
			System.out.println(eleve.getId_eleve());
			System.out.println(eleve.getId_utilisateur());
			System.out.println(eleve.getId_promo());;			
		}
	}
	
	/**
	 * Test the retrieve of an id of an student in databases
	 * 
	 * @throws Exception
	 */
	public void testGetIdEleve() throws Exception {
		EleveDAO eleveDAOTest = new EleveDAO();
		Eleve eleveTest = new Eleve();
		eleveTest = eleveDAOTest.getIdEleve();
		assertEquals(5,eleveTest.getId_eleve());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
	}
	
	/**
	 * Test the insert of a new Eleve into the database
	 * 
	 
	 * @throws Exception
	 */
	public void testInsertEleve() throws Exception {
		EleveDAO eleveDAOTest = new EleveDAO();
		eleveDAOTest.insertEleve(1,1);
		Eleve eleveTest = new Eleve();
		eleveTest = eleveDAOTest.getEleve(6);
		assertEquals(1,eleveTest.getId_utilisateur());	
	}

	/**
	 * Test of the update of an Eleve already in the database
	 * 
	 * @throws Exception
	 */
	public void testUpdateEleve() throws Exception {
		EleveDAO eleveDAOTest = new EleveDAO();
		eleveDAOTest.updateEleve(3, 4 ,2);
		Eleve eleveTest = new Eleve();
		eleveTest = eleveDAOTest.getEleve(3);
		assertEquals(4,eleveTest.getId_utilisateur());	
	}

	/**
	 * Test the delete of an Eleve from the database
	 * 
	 
	 * @throws Exception
	 */
	public void testDeleteUtilisateur() throws Exception {
		EleveDAO eleveDAOTest = new EleveDAO();
		eleveDAOTest.deleteEleve(6);
		Eleve eleveTest = new Eleve();
		eleveTest = eleveDAOTest.getEleve(6);
		assertFalse(1==eleveTest.getId_utilisateur());	
	}
	
}
