package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	
	Labirinto lab = new Labirinto();
	Partita game = new Partita(lab);
	Stanza start = new Stanza("start");
	Stanza nord = new Stanza("nord");
	Stanza lock = new StanzaBloccata("stanza bloccata", "nord", "chiave");
	Comando comando = new ComandoVai();
	
	@Before
	public void setUp() {
		this.game.getLabirinto().setStanzaCorrente(start);
		start.impostaStanzaAdiacente("nord", nord);
	}

	@Test
	public void testEsegui() {
		comando.setParametro("nord");
		comando.esegui(game);
		
		assertTrue(game.getLabirinto().getStanzaCorrente()==nord);
	}
	
	@Test
	public void testEseguiDirInesistente() {
		comando.setParametro("aaa");
		comando.esegui(game);
		
		assertTrue(game.getLabirinto().getStanzaCorrente()==start);
	}
	
	@Test
	public void testEseguiDirNonData() {
		comando.esegui(game);
		
		assertTrue(game.getLabirinto().getStanzaCorrente()==start);
	}
	
	@Test
	public void testEseguiStanzaBloccata() {
		this.game.getLabirinto().setStanzaCorrente(lock);
		Stanza inizio = this.game.getLabirinto().getStanzaCorrente();
		comando.setParametro("nord");
		comando.esegui(game);
		
		assertEquals(inizio, this.game.getLabirinto().getStanzaCorrente());
	}
}
