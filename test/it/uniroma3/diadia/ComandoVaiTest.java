package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	
	Partita game = new Partita();
	Stanza start = new Stanza("start");
	Stanza nord = new Stanza("nord");
	Stanza lock = new StanzaBloccata("stanza bloccata", "nord", "chiave");
	Comando comando = new ComandoVai();
	
	@Before
	public void setUp() {
		this.game.setStanzaCorrente(start);
		start.impostaStanzaAdiacente("nord", nord);
	}

	@Test
	public void testEsegui() {
		comando.setParametro("nord");
		comando.esegui(game);
		
		assertTrue(game.getStanzaCorrente()==nord);
	}
	
	@Test
	public void testEseguiDirInesistente() {
		comando.setParametro("aaa");
		comando.esegui(game);
		
		assertTrue(game.getStanzaCorrente()==start);
	}
	
	@Test
	public void testEseguiDirNonData() {
		comando.esegui(game);
		
		assertTrue(game.getStanzaCorrente()==start);
	}
	
	@Test
	public void testEseguiStanzaBloccata() {
		this.game.setStanzaCorrente(lock);
		Stanza inizio = this.game.getStanzaCorrente();
		comando.setParametro("nord");
		comando.esegui(game);
		
		assertEquals(inizio, this.game.getStanzaCorrente());
	}
}
