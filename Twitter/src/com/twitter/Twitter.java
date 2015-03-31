package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Prikazuje sve poruke sa twittera.
 * 
 * @author bibesko
 * @version v1.0
 * 
 */
public class Twitter {
	
	/**
	 * Lista objekata TwitterPoruka.
	 */
	private LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();

	/**
	 * Metoda vraca listu poruke.
	 * 
	 * @return vraca listu poruke.
	 * 
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke() {
		return poruke;
	}

	/**
	 * Metoda kreira jednog korisnika unosi njegove podatke 
	 * i tog korisnika dodaje na kraj liste poruke.
	 * 
	 * @param korisnik nickname korisnika kao string.
	 * @param poruka poruka kao string.
	 * 
	 */
	public void unesi(String korisnik, String poruka) {		
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		poruke.addLast(tp);
	}

	/**
	 * <ul> 
	 * Metoda vraca niz poruka koje sadrze tag koji je dat 
	 * u parametru i vraca onoliko poruka koliko se unese kao maxBroj.
	 * </ul>
	 * 
	 * @param maxBroj maximalan broj poruka koji moze biti unet u novi niz.
	 * @param tag string koji treba da sadrzi poruka.
	 * @return niz poruka sa tagom.
	 * 
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {

		if (tag == null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");

		if (maxBroj <= 0)
			maxBroj = 100;

		int brojac = 0;

		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];

		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag) != -1)
				if (brojac < maxBroj) {
					rezultat[brojac + 1] = poruke.get(i);
					brojac++;
				} else
					break;
		return rezultat;
	}
}
