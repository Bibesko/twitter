package com.twitter.poruke;

/**
 * Predstavlja poruke sa Twittera.
 * 
 * @author bibesko
 * @version v1.0
 *
 */
public class TwitterPoruka {

	/**
	 * Nickname korisnika.
	 */
	private String korisnik;
	
	/**
	 * Tekst poruke.
	 */
	private String poruka;

	/**
	 * Metoda vraca nickname korisnika tj. vrednost atributa korisnik.
	 * 
	 * @return nickname korisnika kao string.
	 * 
	 */
	public String getKorisnik() {
		return korisnik;
	}

	/**
	 * Metoda postavlja nickname korisnika na zadatu vrednost.
	 * 
	 * @param novi nickname korisnika.
	 * @throws java.lang.RuntimeException ako je unet 
	 * prazan string ili null vrednost.
	 * 
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik == null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}

	/**
	 * Metoda vraca proruku to jest vrednost atributa poruka.
	 * 
	 * @return poruka kao string.
	 * 
	 */
	public String getPoruka() {
		return poruka;
	}

	/**
	 * Metoda postavlja vrednost poruke na zadatu vrednost iz parametra.
	 * 
	 * @param poruka nova poruka.
	 * @throws java.lang.RuntimeException ako poruka ima vise od 140 karaktera
	 * ili null vrednost.
	 * 
	 */
	public void setPoruka(String poruka) {
		if (poruka == null || poruka.length() > 140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}

	/**
	 * Metoda vraca vrednosti za korisnika i poruku i
	 * odgovarajuci tekst uz njih.
	 * 
	 */
	public String toString() {
		return "KORISNIK:" + korisnik + " PORUKA:" + poruka;
	}

}
