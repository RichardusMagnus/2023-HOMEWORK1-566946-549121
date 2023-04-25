package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	Stanza room = new Stanza("Stanza");
	StanzaBuia darkRoom = new StanzaBuia("Stanza", "torcia");
	Attrezzo item1 = new Attrezzo("torcia",1);

	@Test
	public void testGetDescrizioneLuce() {
		room.addAttrezzo(item1);
		darkRoom.addAttrezzo(item1);
		assertEquals(room.getDescrizione(), darkRoom.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneBuio() {
		assertEquals(darkRoom.getMessBuio(), darkRoom.getDescrizione());
	}
}
