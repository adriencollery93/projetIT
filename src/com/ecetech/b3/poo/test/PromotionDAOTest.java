package com.ecetech.b3.poo.test;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;

import com.ecetech.b3.poo.DAO.PromotionDAO;
import com.ecetech.b3.poo.beans.Promotion;

public class PromotionDAOTest extends TestCase{

	/**
	 * Test the retrieve of all promotion in databases
	 * 
	 * @throws Exception
	 */
	public void testGetPromotion() throws Exception {
		PromotionDAO promotionDAOTest = new PromotionDAO();
		Promotion promotionTest = new Promotion();
		promotionTest = promotionDAOTest.getPromotion(1);
		assertEquals("B3 DWM",promotionTest.getAbreviation_promo());		
		System.out.println(promotionTest.getId_promo());		
		}

	/**
	 * Test the retrieve of all Promotions from the database and then puts them all in a list
	 * 
	 * @throws Exception
	 */
	public void testGetPromotionAll() throws Exception {
		PromotionDAO promotionDAOTest = new PromotionDAO();
		ArrayList<Promotion> promotionTest = new ArrayList<Promotion>();
		promotionTest = promotionDAOTest.getPromotionAll();
		Iterator<Promotion> it = promotionTest.iterator();
		while(it.hasNext()){
			Promotion promotion = it.next();
			System.out.println(promotion.getId_promo());
			System.out.println(promotion.getLibelle_promo());
			System.out.println(promotion.getAbreviation_promo());			
		}
	}
	
	/**
	 * Test the retrieve of an id of a promotion in databases
	 * 
	 * @throws Exception
	 */
	public void testGetIdPromotion() throws Exception {
		PromotionDAO promotionDAOTest = new PromotionDAO();
		Promotion promotionTest = new Promotion();
		promotionTest = promotionDAOTest.getIdPromotion();
		assertEquals(3,promotionTest.getId_promo());		
		//System.out.println(utilisateurTest.getId_utilisateur());		
	}
	
	/**
	 * Test the insert of a new Promotion into the database
	 * 
	 * @throws Exception
	 */
	public void testInsertPromotion() throws Exception {
		PromotionDAO promotionDAOTest = new PromotionDAO();
		promotionDAOTest.insertPromotion("bts sio", "bts sio");
		Promotion promotionTest = new Promotion();
		promotionTest = promotionDAOTest.getPromotion(3);
		assertEquals("bts sio",promotionTest.getAbreviation_promo());
	}
	
	/**
	 * Test the update of a Promotion already in the database
	 * 
	 * @throws Exception
	 */
	public void testUpdatePromotion() throws Exception {
		PromotionDAO promotionDAOTest = new PromotionDAO();
		promotionDAOTest.updatePromotion(3, "BTS SIO", "BTS SIO");
		Promotion promotionTest = new Promotion();
		promotionTest = promotionDAOTest.getPromotion(3);
		assertEquals("BTS SIO",promotionTest.getAbreviation_promo());
	}
	
	/**
	 * Test the delete of a Promotion from the database
	 * 
	 * @throws Exception
	 */
	public void testDeletePromotion() throws Exception {
		PromotionDAO promotionDAOTest = new PromotionDAO();
		promotionDAOTest.deletePromotion(3);
		Promotion promotionTest = new Promotion();
		promotionTest = promotionDAOTest.getPromotion(3);
		assertFalse("bts sio" == promotionTest.getAbreviation_promo());
	}

	
}
