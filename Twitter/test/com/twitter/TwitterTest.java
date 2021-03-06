/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author bibesko
 *
 */
public class TwitterTest {

	private Twitter t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		t = null;
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke() {
				
		LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
		
		assertEquals(poruke, t.vratiSvePoruke());
		
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesiKorisnikPorukaPrazan() {
		t.unesi("Mika", "Prva poruka.");
		t.unesi("Mika", "Druga poruka.");
				
		assertEquals("Mika", t.vratiSvePoruke().getLast().getKorisnik());
		assertEquals(false, t.vratiSvePoruke().isEmpty());
		assertEquals("Prva poruka.", t.vratiSvePoruke().getFirst().getPoruka());
		assertEquals(2, t.vratiSvePoruke().size());
	}
	

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeNull() {
		t.vratiPoruke(2, null);		
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testVratiPorukeEmpty() {
		t.vratiPoruke(2, "");		
	}
		
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukeVisePoruka() {
		t.unesi("Zika", "Poruka poruka poruka.");
		t.unesi("Zika", "Poruka poruka poruka.");
		t.unesi("Zika", "Poruka poruka poruka.");
		
		for (int i = 0; i < 2; i++) {					
		assertEquals("Poruka poruka poruka.", t.vratiPoruke(2, "Poruka")[i].getPoruka());
		}
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukeJednaPoruka() {
		t.unesi("Zika", "Poruka poruka poruka.");
								
		assertEquals("Poruka poruka poruka.", t.vratiPoruke(1, "Poruka")[0].getPoruka());		
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukePorukaVisePorukaSaTagom() {
		t.unesi("Zika", "Poruka poruka poruka.");
		t.unesi("Zika", "Poruka poruka poruka.");
		t.unesi("Zika", "message");
		
		for (int i = 0; i < 2; i++){	
		assertEquals("Poruka poruka poruka.", t.vratiPoruke(3, "Poruka")[0].getPoruka());
		}
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPorukePorukaVisePorukaBezTaga() {
		t.unesi("Zika", "Poruka poruka poruka.");
		t.unesi("Zika", "Poruka poruka poruka.");
		t.unesi("Zika", "message");
		
		for (int i = 0; i < 2; i++){	
		assertEquals(true, t.vratiPoruke(2, "Greska")[i] == null);
		}
	}
	
	
	
}
