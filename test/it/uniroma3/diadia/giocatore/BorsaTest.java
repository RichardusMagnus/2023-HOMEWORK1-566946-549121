package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {
	
	Borsa bag = new Borsa();

	//ADD ATTREZZO
	@Test
	public void testAddAttrezzo_primo() {
		assertTrue(bag.addAttrezzo(new Attrezzo("item1", 1)));
	}

	@Test
	public void testAddAttrezzo_ultimo() {
		for(int i=0; i<9; i++) bag.addAttrezzo(new Attrezzo("item", 1));
		assertTrue(bag.addAttrezzo(new Attrezzo("item10", 1)));
	}

	@Test
	public void testAddAttrezzo_troppo() {
		for(int i=0; i<10; i++) bag.addAttrezzo(new Attrezzo("item", 1));
		assertFalse(bag.addAttrezzo(new Attrezzo ("item11", 1)));
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
		assertEquals(0, bag.getPeso());
	}
	
	@Test
	public void testGetPeso_uno() {
		bag.addAttrezzo(new Attrezzo("osso", 5));
		assertEquals(5, bag.getPeso());
	}
	
	@Test
	public void testGetPeso_tanti() {
		bag.addAttrezzo(new Attrezzo("osso", 5));
		bag.addAttrezzo(new Attrezzo("ramarro", 5));
		assertEquals(10, bag.getPeso());
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
	public final void testRemoveAttrezzo_null() {
		assertNull(bag.removeAttrezzo("barbabietola"));
	}
	
	@Test
	public final void testRemoveAttrezzo_manca() {
		Attrezzo osso = new Attrezzo("osso", 5);
		bag.addAttrezzo(osso);
		assertNull(bag.removeAttrezzo("barbaietola"));
	}
	
	@Test
	public final void testRemoveAttrezzo_unoSolo() {
		Attrezzo osso = new Attrezzo("osso", 2);
		bag.addAttrezzo(osso);
		//assertEquals(osso, bag.removeAttrezzo("osso"));
		bag.removeAttrezzo("osso");
		assertTrue(bag.isEmpty());
	}
	
	@Test
	public final void testRemoveAttrezzo_dueUguali() {
		Attrezzo osso1 = new Attrezzo("osso", 2);
		Attrezzo osso2 = new Attrezzo("osso", 2);
		bag.addAttrezzo(osso1);
		bag.addAttrezzo(osso2);
		assertEquals(osso1, bag.removeAttrezzo("osso"));
	}
	
	@Test
	public final void testRemoveAttrezzo_dueDiversiUltimo() {
		Attrezzo barbabietola = new Attrezzo("barbabietola", 2);
		Attrezzo osso2 = new Attrezzo("osso", 2);
		bag.addAttrezzo(barbabietola);
		bag.addAttrezzo(osso2);
		assertEquals(osso2, bag.removeAttrezzo("osso"));
	}
	
	@Test
	public final void testRemoveAttrezzo_dueDiversiPrimo() {
		Attrezzo osso1 = new Attrezzo("osso", 2);
		Attrezzo barbabietola = new Attrezzo("barbabietola", 2);
		bag.addAttrezzo(osso1);
		bag.addAttrezzo(barbabietola);
		assertEquals(osso1, bag.removeAttrezzo("osso"));
	}
	
	@Test
	public final void testRemoveAttrezzo_rimastiUno() {
		Attrezzo osso = new Attrezzo("osso", 5);
		bag.addAttrezzo(osso);
		bag.removeAttrezzo("osso");
		assertEquals(0, bag.numeroAttrezzi);
	}
	
	@Test
	public final void testRemoveAttrezzo_rimastiDue() {
		Attrezzo osso = new Attrezzo("osso", 5);
		bag.addAttrezzo(osso);
		bag.addAttrezzo(osso);
		bag.removeAttrezzo("osso");
		assertEquals(1, bag.numeroAttrezzi);
	}

}
