package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa bag = new Borsa();
	Attrezzo a1 = new Attrezzo("A", 1);
	Attrezzo b2 = new Attrezzo("B", 2);
	Attrezzo c1 = new Attrezzo("C", 1);
	
	Map<String, Attrezzo> nomi2Attrezzi = new HashMap<>();
	

	//ADD ATTREZZO
	@Test
	public void testAddAttrezzo_primo() {
		assertTrue(bag.addAttrezzo(a1));
		assertEquals(a1, bag.getAttrezzi().get("A"));
		assertFalse(bag.getAttrezzi().containsKey("B"));
	}
	
	@Test
	public void testAddAttrezzo_nomeUguale() {
		bag.addAttrezzo(a1);
		bag.addAttrezzo(new Attrezzo("A", 2));
		assertEquals(2, bag.getAttrezzi().get("A").getPeso());
		assertNotEquals(1, bag.getAttrezzi().get("A").getPeso());
	}


	//GET ATTREZZO
	@Test
	public void testGetAttrezzo_listaVuota() {
		assertNull(bag.getAttrezzo("barbabietola"));
	}

	@Test
	public void testGetAttrezzo_manca() {
		bag.addAttrezzo(new Attrezzo("osso", 1));
		bag.addAttrezzo(new Attrezzo("coso", 2));

		assertNull(bag.getAttrezzo("barbabietola"));
	}

	@Test
	public void testGetAttrezzo_trovatoPrimo() {
		bag.addAttrezzo(new Attrezzo("osso", 1));
		bag.addAttrezzo(new Attrezzo("coso", 2));

		assertEquals("osso", bag.getAttrezzo("osso").getNome());
	}

	@Test
	public void testGetAttrezzo_trovatoSecondo() {
		bag.addAttrezzo(new Attrezzo("osso", 1));
		bag.addAttrezzo(new Attrezzo("coso", 2));

		assertEquals("coso", bag.getAttrezzo("coso").getNome());
	}

	
	@Test
	public void testGetPeso_null() {
		assertEquals(0, bag.getPesoBorsa());
	}
	
	@Test
	public void testGetPeso_uno() {
		bag.addAttrezzo(new Attrezzo("osso", 5));
		assertEquals(5, bag.getPesoBorsa());
	}
	
	@Test
	public void testGetPeso_tanti() {
		bag.addAttrezzo(new Attrezzo("osso", 5));
		bag.addAttrezzo(new Attrezzo("ramarro", 5));
		assertEquals(10, bag.getPesoBorsa());
	}
	

	@Test
	public void testIsEmpty() {
		assertTrue(bag.isEmpty());
	}
	
	@Test
	public void testIsEmpty_falso() {
		bag.addAttrezzo(new Attrezzo("osso", 5));
		assertFalse(bag.isEmpty());
	}

	@Test
	public void testHasAttrezzo_listaVuota() {
		assertFalse(bag.hasAttrezzo("barbabietola"));
	}

	@Test
	public void testHasAttrezzo_manca() {
		bag.addAttrezzo(new Attrezzo("osso", 1));
		bag.addAttrezzo(new Attrezzo("coso", 2));

		assertFalse(bag.hasAttrezzo("barbabietola"));
	}

	@Test
	public void testHasAttrezzo_trovatoPrimo() {
		bag.addAttrezzo(new Attrezzo("osso", 1));
		bag.addAttrezzo(new Attrezzo("coso", 2));

		assertTrue(bag.hasAttrezzo("osso"));
	}

	@Test
	public void testHasAttrezzo_trovatoSecondo() {
		bag.addAttrezzo(new Attrezzo("osso", 1));
		bag.addAttrezzo(new Attrezzo("coso", 2));

		assertTrue(bag.hasAttrezzo("coso"));
	}
	

	@Test
	public void testRemoveAttrezzo_null() {
		assertNull(bag.removeAttrezzo("barbabietola"));
	}
	
	@Test
	public void testRemoveAttrezzo_manca() {
		Attrezzo osso = new Attrezzo("osso", 5);
		bag.addAttrezzo(osso);
		assertNull(bag.removeAttrezzo("barbaietola"));
	}
	
	@Test
	public void testRemoveAttrezzo_unoSolo() {
		Attrezzo osso = new Attrezzo("osso", 2);
		bag.addAttrezzo(osso);
		//assertEquals(osso, bag.removeAttrezzo("osso"));
		bag.removeAttrezzo("osso");
		assertTrue(bag.isEmpty());
	}
	
	@Test
	public void testRemoveAttrezzo_dueUguali() {
		Attrezzo osso1 = new Attrezzo("osso", 2);
		Attrezzo osso2 = new Attrezzo("osso", 2);
		bag.addAttrezzo(osso1);
		bag.addAttrezzo(osso2);
		assertEquals(osso1, bag.removeAttrezzo("osso"));
	}
	
	@Test
	public void testRemoveAttrezzo_dueDiversiUltimo() {
		Attrezzo barbabietola = new Attrezzo("barbabietola", 2);
		Attrezzo osso2 = new Attrezzo("osso", 2);
		bag.addAttrezzo(barbabietola);
		bag.addAttrezzo(osso2);
		assertEquals(osso2, bag.removeAttrezzo("osso"));
	}
	
	@Test
	public void testRemoveAttrezzo_dueDiversiPrimo() {
		Attrezzo osso1 = new Attrezzo("osso", 2);
		Attrezzo barbabietola = new Attrezzo("barbabietola", 2);
		bag.addAttrezzo(osso1);
		bag.addAttrezzo(barbabietola);
		assertEquals(osso1, bag.removeAttrezzo("osso"));
	}
	
	@Test
	public void testRemoveAttrezzo_rimastiUno() {
		Attrezzo osso = new Attrezzo("osso", 5);
		bag.addAttrezzo(osso);
		bag.removeAttrezzo("osso");
		assertTrue(bag.isEmpty());
	}
	
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_pesiDiversi() {
		bag.addAttrezzo(a1);
		bag.addAttrezzo(b2);
		
		List<Attrezzo> l = bag.getContenutoOrdinatoPerPeso();
		
		assertEquals(a1, l.get(0));
		assertEquals(b2, l.get(1));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso_pesiUguali() {
		bag.addAttrezzo(a1);
		bag.addAttrezzo(c1);
		
		List<Attrezzo> l = new ArrayList<>();
		l = bag.getContenutoOrdinatoPerPeso();
		
		assertEquals(a1, l.get(0));
		assertEquals(c1, l.get(1));
	}
	
	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		bag.addAttrezzo(b2);
		bag.addAttrezzo(c1);
		
		List<Attrezzo> l = new ArrayList<>();
		l = bag.getContenutoOrdinatoPerPeso();
		
		assertEquals(c1, l.get(0));
		assertEquals(b2, l.get(1));
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_pesiDiversi() {
		bag.addAttrezzo(b2);
		bag.addAttrezzo(a1);
		
		
		SortedSet<Attrezzo> s = new TreeSet<>();
		s = bag.getSortedSetOrdinatoPerPeso();
		
		assertEquals(a1, s.first());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso_pesiUguali() {
		bag.addAttrezzo(c1);
		bag.addAttrezzo(a1);
		
		
		SortedSet<Attrezzo> s = new TreeSet<>();
		s = bag.getSortedSetOrdinatoPerPeso();
		
		assertEquals(a1, s.first());
	}
	
	@Test
	public void testGetSortedSetOrdinatoPerPeso() {
		bag.addAttrezzo(c1);
		bag.addAttrezzo(b2);
		
		
		SortedSet<Attrezzo> s = new TreeSet<>();
		s = bag.getSortedSetOrdinatoPerPeso();
		
		assertEquals(c1, s.first());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome1() {
		bag.addAttrezzo(a1);
		bag.addAttrezzo(b2);
		
		SortedSet<Attrezzo> s = bag.getContenutoOrdinatoPerNome();
		
		assertEquals(a1, s.first());
	}
	
	@Test
	public void testGetContenutoOrdinatoPerNome2() {
		bag.addAttrezzo(c1);
		bag.addAttrezzo(b2);
		
		SortedSet<Attrezzo> s = bag.getContenutoOrdinatoPerNome();
		
		assertEquals(b2, s.first());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
		bag.addAttrezzo(a1);
		bag.addAttrezzo(b2);
		bag.addAttrezzo(c1);
		
		Map<Integer, List<Attrezzo>> m = bag.getContenutoRaggruppatoPerPeso();
		
		assertEquals(1, m.get(1).size());
		assertEquals(0, m.get(2).size());
	}
	
	

}
