package it.uniroma3.attrezzi;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreDiAttrezzi;

public class ComparatoreDiAttrezziTest {
	Attrezzo a1;
	Attrezzo a2;
	ComparatoreDiAttrezzi c = new ComparatoreDiAttrezzi();

	@Test
	public void testComparePesoDiverso1() {
		a1 = new Attrezzo("A",1);
		a2 = new Attrezzo("B", 2);
		
		assertTrue(c.compare(a1, a2)<0);
	}
	
	@Test
	public void testComparePesoDiverso2() {
		a1 = new Attrezzo("A",2);
		a2 = new Attrezzo("B", 1);
		
		assertTrue(c.compare(a1, a2)>0);
	}
	
	@Test
	public void testCompareStessoPeso() {
		a1 = new Attrezzo("A",1);
		a2 = new Attrezzo("B", 1);
		
		assertTrue(c.compare(a1, a2)<0);
	}

}
