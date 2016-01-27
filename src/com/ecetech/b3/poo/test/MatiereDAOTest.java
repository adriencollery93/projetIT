package com.ecetech.b3.poo.test;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import com.ecetech.b3.poo.DAO.MatiereDAO;
import com.ecetech.b3.poo.beans.Matiere;

public class MatiereDAOTest extends TestCase{

	/**
	 * Test the retrieve of all subject in databases
	 * 
	 * @throws Exception
	 */	
	public void testGetMatiere() throws Exception {
		MatiereDAO matiereDAOTest = new MatiereDAO();
		Matiere matiereTest = new Matiere();
		matiereTest = matiereDAOTest.getMatiere(1);
		assertEquals("Dev JAVA",matiereTest.getAbreviation_matiere());		
		//System.out.println(matiereTest.getId_matiere());		
		}

	/**
	 * Test the retrieve of all Subjects from the database and then puts them all in a list
	 * 
	 * @throws Exception
	 */
	public void testGetMatiereAll() throws Exception {
		MatiereDAO matiereDAOTest = new MatiereDAO();
		ArrayList<Matiere> matiereTest = new ArrayList<Matiere>();
		matiereTest = matiereDAOTest.getMatiereAll();
		Iterator<Matiere> it = matiereTest.iterator();
		while(it.hasNext()){
			Matiere matiere = it.next();
			System.out.println(matiere.getId_matiere());
			System.out.println(matiere.getAbreviation_matiere());
			System.out.println(matiere.getNom_matiere());	
			System.out.println(matiere.getId_prof());
		}
	}
	
	/**
	 * Test the retrieve of an id of an subject in databases
	 * 
	 * @throws Exception
	 */
	public void testGetIdMatiere() throws Exception {
		MatiereDAO matiereDAOTest = new MatiereDAO();
		Matiere matiereTest = new Matiere();
		matiereTest = matiereDAOTest.getIdMatiere();
		assertEquals(2,matiereTest.getId_matiere());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
	}
	
	/**
	 * Test the insert of a new Matiere into the database
	 * 
	 * @throws Exception
	 */
	public void testInsertMatiere() throws Exception {
		MatiereDAO matiereDAOTest = new MatiereDAO();
		matiereDAOTest.insertMatiere("Projet IT", "Projet IT", 1);
		Matiere matiereTest = new Matiere();
		matiereTest = matiereDAOTest.getMatiere(2);
		assertEquals("Projet IT",matiereTest.getAbreviation_matiere());
	}
	
	/**
	 * Test the update of a Matiere already in the database
	 * 
	 * @throws Exception
	 */
	public void testUpdateMatiere() throws Exception {
		MatiereDAO matiereDAOTest = new MatiereDAO();
		matiereDAOTest.updateMatiere(2, "projet it", "Projet it", 1);
		Matiere matiereTest = new Matiere();
		matiereTest = matiereDAOTest.getMatiere(2);
		assertEquals("projet it",matiereTest.getAbreviation_matiere());
	}
	
	/**
	 * Test the delete of a Matiere from the database
	 * 
	 * @throws Exception
	 */	
	public void testDeleteMatiere() throws Exception {
		MatiereDAO matiereDAOTest = new MatiereDAO();
		matiereDAOTest.deleteMatiere(1);
		Matiere matiereTest = new Matiere();
		matiereTest = matiereDAOTest.getMatiere(1);
		assertFalse("projet it" == matiereTest.getAbreviation_matiere());
	}
}
