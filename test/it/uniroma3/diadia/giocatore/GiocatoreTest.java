package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	Giocatore player = new Giocatore();

	//TEST GET CFU
	@Test
	public void testGetCfu_0() {
		player.setCfu(0);
		assertEquals(0, player.getCfu());
	}

	@Test
	public void testGetCfu_10() {
		player.setCfu(10);
		assertEquals(10, player.getCfu());
	}
}
