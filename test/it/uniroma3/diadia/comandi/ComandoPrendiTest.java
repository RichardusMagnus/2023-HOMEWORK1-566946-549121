package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {
	Labirinto lab = new Labirinto();
	Partita game = new Partita(lab);
	Stanza stanza = new Stanza("stanza");
	Borsa bag = this.game.getGiocatore().getBorsa();
	
	Attrezzo item1 = new Attrezzo("osso",1);
	Attrezzo item2 = new Attrezzo("lanterna",1);
	
	Comando daEseguire = new ComandoPrendi();

	@Before
	public void setUp() throws Exception {
		stanza.addAttrezzo(item1);
		stanza.addAttrezzo(item2);
		this.game.getLabirinto().setStanzaCorrente(stanza);
	}

	@Test
	public void testEseguiUno() {
		daEseguire.setParametro("osso");
		daEseguire.esegui(game);
		
		assertTrue(bag.getAttrezzi().containsKey("osso"));
		assertEquals(item1, bag.getAttrezzi().get("osso"));
	}
	
	@Test
	public void testEseguiTutto() {
		daEseguire.setParametro("osso");
		daEseguire.esegui(game);
		daEseguire.setParametro("lanterna");
		daEseguire.esegui(game);
		
		assertTrue(stanza.getAttrezzi().isEmpty());
		assertEquals(item1, bag.getAttrezzi().get("osso"));
		assertEquals(item2, bag.getAttrezzi().get("lanterna"));
	}
	
	@Test
	public void eseguiNonCe() {
		daEseguire.setParametro("aaa");
		daEseguire.esegui(game);
		
		assertTrue(bag.getAttrezzi().isEmpty());
	}
	
	@Test
	public void eseguiSenzaParametro() {
		daEseguire.esegui(game);
		
		assertTrue(stanza.getAttrezzi().isEmpty());
	}	
}
