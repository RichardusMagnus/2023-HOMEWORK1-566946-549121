package it.uniroma3.diadia.ambienti;


import static org.junit.Assert.*;

import java.awt.geom.Area;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza area = new Stanza("area");
	
	//GET NOME
	@Test
	public void testGetNome() {
		assertEquals("area", area.getNome());
	}
	
	@Test
	public void testGetNome_diverso() {
		assertNotEquals("zona", area.getNome());
	}
	
	@Test
	public void testGetNome_nonNullo() {
		assertNotNull(area);
	}
	
	
	//ADD ATTREZZO
	@Test
	public void testAddAttrezzo_primo() {
		assertTrue(area.addAttrezzo(new Attrezzo("item1", 1)));
	}
	
	@Test
	public void testAddAttrezzo_ultimo() {
		for(int i=0; i<9; i++) area.addAttrezzo(new Attrezzo("item", 1));
		assertTrue(area.addAttrezzo(new Attrezzo("item10", 10)));
	}	
	
	//GET ATTREZZO
	@Test
	public void testGetAttrezzo_listaVuota() {
		assertNull(area.getAttrezzo("barbabietola"));
	}
	
	@Test
	public void testGetAttrezzo_manca() {
		area.addAttrezzo(new Attrezzo("osso", 1));
		area.addAttrezzo(new Attrezzo("coso", 2));
		
		assertNull(area.getAttrezzo("barbabietola"));
	}
	
	@Test
	public void testGetAttrezzo_trovatoPrimo() {
		area.addAttrezzo(new Attrezzo("osso", 1));
		area.addAttrezzo(new Attrezzo("coso", 2));
		
		assertEquals("osso", area.getAttrezzo("osso").getNome());
	}
	
	@Test
	public void testGetAttrezzo_trovatoSecondo() {
		area.addAttrezzo(new Attrezzo("osso", 1));
		area.addAttrezzo(new Attrezzo("coso", 2));
		
		assertEquals("coso", area.getAttrezzo("coso").getNome());
	}
	
	
	//HAS ATTREZZO
	@Test
	public void testHasAttrezzo_listaVuota() {
		assertFalse(area.hasAttrezzo("barbabietola"));
	}

	@Test
	public void testHasAttrezzo_manca() {
		area.addAttrezzo(new Attrezzo("osso", 1));
		area.addAttrezzo(new Attrezzo("coso", 2));

		assertFalse(area.hasAttrezzo("barbabietola"));
	}

	@Test
	public void testHasAttrezzo_trovatoPrimo() {
		area.addAttrezzo(new Attrezzo("osso", 1));
		area.addAttrezzo(new Attrezzo("coso", 2));

		assertTrue(area.hasAttrezzo("osso"));
	}

	@Test
	public void testHasAttrezzo_trovatoSecondo() {
		area.addAttrezzo(new Attrezzo("osso", 1));
		area.addAttrezzo(new Attrezzo("coso", 2));

		assertTrue(area.hasAttrezzo("coso"));
	}
		
	
	//ADD STANZA ADIACENTE
	@Test
	public void testImpostaStanzaAdiacente_prima() {
		area.impostaStanzaAdiacente("direzione", new Stanza("adiacente"));
		assertNotNull(area.getStanzaAdiacente("direzione"));
	}
	
	@Test
	public void testImpostaStanzaAdiacente_sostituisce() {
		area.impostaStanzaAdiacente("direzione", new Stanza("adiacente"));
		area.impostaStanzaAdiacente("direzione", new Stanza("sostituto"));
		assertEquals("sostituto", area.getStanzaAdiacente("direzione").getNome());
	}
	
	@Test
	public void testImpostaStanzaAdiacente_overflow() {
		area.impostaStanzaAdiacente("nord", new Stanza("area1"));
		area.impostaStanzaAdiacente("est", new Stanza("area2"));
		area.impostaStanzaAdiacente("ovest", new Stanza("area3"));
		area.impostaStanzaAdiacente("sud", new Stanza("area4"));
		area.impostaStanzaAdiacente("direzione", new Stanza("overflow"));
		assertNull(area.getStanzaAdiacente("overflow"));
	}
	
	
	//GET STANZA ADIACENTE
	@Test
	public void testGetStanzaAdiacente_nulla() {
		assertNull(area.getStanzaAdiacente("direzione"));
	}
	
	@Test
	public void testGetStanzaAdiacente_manca() {
		area.impostaStanzaAdiacente("nord", new Stanza("area1"));
		area.impostaStanzaAdiacente("est", new Stanza("area2"));
		area.impostaStanzaAdiacente("ovest", new Stanza("area3"));
		area.impostaStanzaAdiacente("sud", new Stanza("area4"));
		assertNull(area.getStanzaAdiacente("direzione"));
	}
	
	@Test
	public void testGetStanzaAdiacente_trovataUnica() {
		Stanza eccola = new Stanza("Eccola!");
		area.impostaStanzaAdiacente("direzione", eccola);
		assertEquals(eccola, area.getStanzaAdiacente("direzione"));
	}
	
	@Test
	public void testGetStanzaAdiacente_trovata() {
		Stanza area3 = new Stanza("area3");
		area.impostaStanzaAdiacente("nord", new Stanza("area1"));
		area.impostaStanzaAdiacente("est", new Stanza("area2"));
		area.impostaStanzaAdiacente("ovest", area3);
		area.impostaStanzaAdiacente("sud", new Stanza("area4"));
		assertEquals(area3, area.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public void testGetStanzaAdiacente_diversa() {
		area.impostaStanzaAdiacente("nord", new Stanza("area1"));
		area.impostaStanzaAdiacente("est", new Stanza("area2"));
		area.impostaStanzaAdiacente("ovest", new Stanza("area3"));
		area.impostaStanzaAdiacente("sud", new Stanza("area4"));
		Stanza errore = new Stanza("Errore");
		assertNotEquals(errore, area.getStanzaAdiacente("ovest"));
	}
	
	@Test
	public final void testRemoveAttrezzo_null() {
		assertFalse(area.removeAttrezzo("barbabietola"));
	}
	
	@Test
	public final void testRemoveAttrezzo_manca() {
		Attrezzo osso = new Attrezzo("osso", 5);
		area.addAttrezzo(osso);
		assertFalse(area.removeAttrezzo("barbabietola"));
	}
	
	@Test
	public final void testRemoveAttrezzo_unoSolo() {
		Attrezzo osso = new Attrezzo("osso", 2);
		area.addAttrezzo(osso);
		assertTrue(area.removeAttrezzo("osso"));
	}
	
	@Test
	public final void testRemoveAttrezzo_dueUguali() {
		Attrezzo osso1 = new Attrezzo("osso", 2);
		Attrezzo osso2 = new Attrezzo("osso", 2);
		area.addAttrezzo(osso1);
		area.addAttrezzo(osso2);
		assertTrue(area.removeAttrezzo("osso"));
	}
	
	@Test
	public final void testRemoveAttrezzo_dueDiversiUltimo() {
		Attrezzo barbabietola = new Attrezzo("barbabietola", 2);
		Attrezzo osso2 = new Attrezzo("osso", 2);
		area.addAttrezzo(barbabietola);
		area.addAttrezzo(osso2);
		assertTrue(area.removeAttrezzo("osso"));
	}
	
	@Test
	public final void testRemoveAttrezzo_dueDiversiPrimo() {
		Attrezzo osso1 = new Attrezzo("osso", 2);
		Attrezzo barbabietola = new Attrezzo("barbabietola", 2);
		area.addAttrezzo(osso1);
		area.addAttrezzo(barbabietola);
		assertTrue(area.removeAttrezzo("osso"));
	}
	
	@Test
	public final void testRemoveAttrezzo_rimastiUno() {
		Attrezzo osso = new Attrezzo("osso", 5);
		area.addAttrezzo(osso);
		area.removeAttrezzo("osso");
		
		assertTrue(area.getAttrezzi().isEmpty());
	}
}
