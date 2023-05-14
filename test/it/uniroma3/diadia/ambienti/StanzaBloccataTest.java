package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	Stanza stanzaqualsiasi = new Stanza("Stanza");
	StanzaBloccata lock = new StanzaBloccata("Stanza","nord","pass");
	Stanza adiacente = new Stanza("Adiacente");
	Attrezzo passepartout = new Attrezzo("pass",1);

	@Before
	public void setUp() throws Exception {
		lock.impostaStanzaAdiacente("nord", adiacente);
		stanzaqualsiasi.impostaStanzaAdiacente("nord", stanzaqualsiasi);
	}

	@Test
	public void testGetStanzaAdiacenteBloc() {
		assertEquals(lock, lock.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteSbloc() {
		lock.addAttrezzo(passepartout);
		assertEquals(adiacente, lock.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetDescrizioneBloc() {
		System.out.println(lock.getMessBloc());
		assertEquals(stanzaqualsiasi.getDescrizione() + lock.getMessBloc(), lock.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneSbloc() {
		lock.addAttrezzo(passepartout);
		stanzaqualsiasi.addAttrezzo(passepartout);
		assertEquals(stanzaqualsiasi.getDescrizione(), lock.getDescrizione());
	}

}
