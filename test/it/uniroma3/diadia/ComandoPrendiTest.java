package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {
	Partita game = new Partita();
	Stanza stanza = new Stanza("stanza");
	Borsa bag = this.game.getGiocatore().getBorsa();
	
	Attrezzo item1 = new Attrezzo("osso",1);
	Attrezzo item2 = new Attrezzo("lanterna",1);
	
	Comando daEseguire = new ComandoPrendi();

	@Before
	public void setUp() throws Exception {
		stanza.addAttrezzo(item1);
		stanza.addAttrezzo(item2);
		this.game.setStanzaCorrente(stanza);
	}

	@Test
	public void testEseguiUno() {
		daEseguire.setParametro("osso");
		daEseguire.esegui(game);
		
		int cBag = 0;
		for (int i=0; bag.getAttrezzi()[i]!=null; i++) {
			cBag++;
		}
		
		int cRoom = 0;
		for (int i=0; stanza.getAttrezzi()[i]!=null; i++) {
			cRoom++;
		}
		
		assertEquals(1, cBag);
		assertEquals(1, cRoom);
	}
	
	@Test
	public void testEseguiTutto() {
		daEseguire.setParametro("osso");
		daEseguire.esegui(game);
		daEseguire.setParametro("lanterna");
		daEseguire.esegui(game);
		
		int cBag = 0;
		for (int i=0; bag.getAttrezzi()[i]!=null; i++) {
			cBag++;
		}
		
		assertNull(stanza.getAttrezzi()[0]);
		assertEquals(2, cBag);
	}
	
	@Test
	public void eseguiNonCe() {
		daEseguire.setParametro("aaa");
		daEseguire.esegui(game);
		
		int cRoom = 0;
		for (int i=0; stanza.getAttrezzi()[i]!=null; i++) {
			cRoom++;
		}
		
		assertEquals(2, cRoom);
		assertNull(bag.getAttrezzi()[0]);
	}
	
	@Test
	public void eseguiSenzaParametro() {
		daEseguire.esegui(game);
		
		int cRoom = 0;
		for (int i=0; stanza.getAttrezzi()[i]!=null; i++) {
			cRoom++;
		}
		
		assertEquals(2, cRoom);
		assertNull(bag.getAttrezzi()[0]);
	}
	
	@Test
	public void eseguiOggettoGiusto() {
		daEseguire.setParametro("osso");
		daEseguire.esegui(game);
		boolean manca = true;
		for (int i=0; i<stanza.getAttrezzi().length; i++)
			if (stanza.getAttrezzi()[i] == item1) manca = false;
			
		assertEquals(item1, bag.getAttrezzi()[0]);
		assertTrue(manca);
	}
	

}
