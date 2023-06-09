package it.uniroma3.diadia;
import static org.junit.Assert.*;

import java.awt.dnd.DropTargetListener;

import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

public class PartitaTest {
	Labirinto lab = new Labirinto();
	Partita partita = new Partita(lab);
	Stanza area = new Stanza("area");
	Stanza area2 = new Stanza("area 2");
	Giocatore player = new Giocatore();
	
	//SET STANZA CORRENTE
	@Test
	public void testSetStanzaCorrente_prima() {
		partita.getLabirinto().setStanzaCorrente(area);
		assertEquals(area, partita.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrente_sostituzione() {
		partita.getLabirinto().setStanzaCorrente(area);
		partita.getLabirinto().setStanzaCorrente(area2);
		assertEquals(area2, partita.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testSetStanzaCorrente_spostamento() {
		partita.getLabirinto().setStanzaCorrente(area);
		area.impostaStanzaAdiacente("direzione", area2);
		partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente("direzione"));
		assertEquals(area2, partita.getLabirinto().getStanzaCorrente());
	}
	
	//GET STANZA CORRENTE
	@Test
	public void testGetStanzaCorrente_null() {
		assertNotNull(partita.getLabirinto().getStanzaCorrente());
	}

	//TEST VINTA
	@Test
	public void testVinta() {
		this.partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.vinta());
	}
	
	@Test
	public void testVinta_falso() {
		partita.getLabirinto().setStanzaCorrente(area);
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
		partita.getLabirinto().setStanzaCorrente(partita.getLabirinto().getStanzaVincente());
		assertTrue(partita.isFinita());
	}
	
	@Test
	public void testIsFinita_fine() {
		partita.setFinita();
		assertTrue(partita.isFinita());
	}
}
