package it.uniroma3.diadia.ambienti;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

	@Test
	public void testGetStanzaVincente() {
		Stanza area = new Stanza("area");
		Labirinto lab = new Labirinto();
		lab.setStanzaIniziale(area);
		assertEquals(area, lab.getStanzaVincente());
	}

	@Test
	public void testGetStanzaIniziale() {
		Stanza area = new Stanza("area");
		Labirinto lab = new Labirinto();
		lab.setStanzaIniziale(area);
		assertEquals(area, lab.getStanzaIniziale());
	}

}
