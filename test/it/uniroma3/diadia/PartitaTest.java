package it.uniroma3.diadia;
import static org.junit.Assert.*;

import java.awt.dnd.DropTargetListener;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {
	Partita partita = new Partita();
	Stanza area = new Stanza("area");
	Stanza area2 = new Stanza("area 2");
	Giocatore player = new Giocatore();
	
	//SET STANZA CORRENTE
	@Test
	public void testSetStanzaCorrente_prima() {
		partita.setStanzaCorrente(area);
		assertEquals(area, partita.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrente_sostituzione() {
		partita.setStanzaCorrente(area);
		partita.setStanzaCorrente(area2);
		assertEquals(area2, partita.getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrente_spostamento() {
		partita.setStanzaCorrente(area);
		area.impostaStanzaAdiacente("direzione", area2);
		partita.setStanzaCorrente(partita.getStanzaCorrente().getStanzaAdiacente("direzione"));
		assertEquals(area2, partita.getStanzaCorrente());
	}
	
	//GET STANZA CORRENTE
	@Test
	public void testGetStanzaCorrente_null() {
		assertNotNull(partita.getStanzaCorrente());
	}

	//TEST VINTA
	@Test
	public void testVinta() {
		this.partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testVinta_falso() {
		partita.setStanzaCorrente(area);
		assertFalse(partita.vinta());
	}
	
	//TEST IS FINITA
	@Test
	public void testIsFinita_cfu0() {
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_vinta() {
		partita.setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_fine() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
}
