package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.ambienti.StanzaMagica;


public class StanzaMagicaTest {
	StanzaMagica magicRoom = new StanzaMagica("laboratorio");
	Attrezzo item1 = new Attrezzo("attrezzo1",1);
	Attrezzo item2 = new Attrezzo("attrezzo2",1);
	Attrezzo item3 = new Attrezzo("attrezzo3",1);
	
	@Before
	public void setUp() {
		this.magicRoom.addAttrezzo(item1);
		this.magicRoom.addAttrezzo(item2);
	}

	@Test
	public void testContatore() {
		assertEquals(2, this.magicRoom.getContatore());
	}
	
	@Test
	public void testIncantesimo() {
		magicRoom.incantesimo(item1);
		assertEquals("1ozzertta", item1.getNome());
		assertEquals(2, item1.getPeso());
		
	}
	
	@Test
	public void testAddAttrezzoMag() {
		this.magicRoom.addAttrezzo(item3);
		assertEquals("3ozzertta", this.magicRoom.getAttrezzi()[2].getNome());
		assertEquals(2, this.magicRoom.getAttrezzi()[2].getPeso());
	}
}
