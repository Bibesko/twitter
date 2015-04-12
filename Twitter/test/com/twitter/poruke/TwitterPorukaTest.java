/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author bibesko
 *
 */
public class TwitterPorukaTest {

	private TwitterPoruka tp;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		tp.setKorisnik("Pera");
		
		assertEquals("Pera", tp.getKorisnik());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		tp.setKorisnik(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString() {
		tp.setKorisnik("");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		tp.setPoruka("Poruka");
		
		assertEquals("Poruka", tp.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		tp.setPoruka(null);		
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test(expected = java.lang.RuntimeException.class)
	public void testSetPorukaVelikaPoruka() {
		tp.setPoruka("Velika poruka koja ne moze da stane.Velika poruka koja ne moze da stane."
				+ "Velika poruka koja ne moze da stane.Velika poruka koja ne moze da stane."
				+ "Velika poruka koja ne moze da stane.Velika poruka koja ne moze da stane.");

	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {		
		tp.setPoruka("Poruka");
		tp.setKorisnik("Korisnik");
		
		assertEquals("KORISNIK:Korisnik PORUKA:Poruka", tp.toString());
	}
	
}
