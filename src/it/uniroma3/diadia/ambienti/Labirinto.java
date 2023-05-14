package it.uniroma3.diadia.ambienti;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Labirinto {
	public Stanza stanzaIniziale;
	public Stanza stanzaVincente;
	public Set<Stanza> tutteLeStanze;
	public Set<Attrezzo> tuttiGliAttrezzi;

	public Labirinto() {
		creaLabirinto();
	}
	
	private void creaLabirinto() {

		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo chiave = new Attrezzo("evaihc", 1);
		Attrezzo ariete = new Attrezzo("ariete", 10);
		Attrezzo sasso = new Attrezzo("sasso", 2);
		Attrezzo passepartout = new Attrezzo("passepartout", 0);
		Attrezzo diario = new Attrezzo("diario_del_fuorisede", 5);
		Attrezzo torcia = new Attrezzo("torcia",2);
		Attrezzo caffe = new Attrezzo("caffè", 1);
		Attrezzo striscione = new Attrezzo("striscione_elettorale", 10);
		
		this.tuttiGliAttrezzi.add(lanterna);
		this.tuttiGliAttrezzi.add(osso);
		this.tuttiGliAttrezzi.add(chiave);
		this.tuttiGliAttrezzi.add(ariete);
		this.tuttiGliAttrezzi.add(sasso);
		this.tuttiGliAttrezzi.add(passepartout);
		this.tuttiGliAttrezzi.add(diario);
		this.tuttiGliAttrezzi.add(torcia);
		this.tuttiGliAttrezzi.add(caffe);
		this.tuttiGliAttrezzi.add(striscione);
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new StanzaBloccata("Aula N11","sud","caffè");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		Stanza covo = new Stanza ("Il Covo di Studenti alla Terza");
		Stanza fogne = new StanzaBuia("Sistema Fognario", "torcia");
		Stanza segreta = new Stanza("Camera dei Segreti");
		Stanza aulaStudio = new Stanza("Aula Studio");
		Stanza aulaN5 = new Stanza("Aula N5");
		Stanza bar = new Stanza("Bar");
		Stanza mensa = new StanzaBloccata("Mensa","sud","chiave");
		Stanza portineria = new Stanza("Portineria");
		Stanza wc = new Stanza("Bagno");
		Stanza ufficio = new StanzaMagica("Ufficio del Rettore");
		
		this.tutteLeStanze.add(atrio);
		this.tutteLeStanze.add(aulaN11);
		this.tutteLeStanze.add(aulaN10);
		this.tutteLeStanze.add(laboratorio);
		this.tutteLeStanze.add(biblioteca);
		this.tutteLeStanze.add(covo);
		this.tutteLeStanze.add(fogne);
		this.tutteLeStanze.add(segreta);
		this.tutteLeStanze.add(aulaStudio);
		this.tutteLeStanze.add(aulaN5);
		this.tutteLeStanze.add(bar);
		this.tutteLeStanze.add(mensa);
		this.tutteLeStanze.add(portineria);
		this.tutteLeStanze.add(wc);
		this.tutteLeStanze.add(ufficio);
		
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", portineria);
		atrio.impostaStanzaAdiacente("ovest", aulaN11);
		atrio.impostaStanzaAdiacente("est", aulaStudio);
		aulaN11.impostaStanzaAdiacente("est", atrio);
		aulaN11.impostaStanzaAdiacente("nord", aulaN10);
		aulaN11.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("sud", wc);
		aulaN10.impostaStanzaAdiacente("sud", aulaN11);
		laboratorio.impostaStanzaAdiacente("est", aulaN11);
		wc.impostaStanzaAdiacente("sciacquone", fogne);
		wc.impostaStanzaAdiacente("nord", aulaN11);
		fogne.impostaStanzaAdiacente("tombino", wc);
		fogne.impostaStanzaAdiacente("ovest", segreta);
		fogne.impostaStanzaAdiacente("sud", covo);
		fogne.impostaStanzaAdiacente("teletrasporto", ufficio);
		ufficio.impostaStanzaAdiacente("teletrasporto", atrio);
		aulaStudio.impostaStanzaAdiacente("ovest", atrio);
		aulaStudio.impostaStanzaAdiacente("nord", aulaN5);
		aulaN5.impostaStanzaAdiacente("sud", aulaStudio);
		aulaN5.impostaStanzaAdiacente("ovest", portineria);
		aulaN5.impostaStanzaAdiacente("nord", bar);
		portineria.impostaStanzaAdiacente("sud", atrio);
		portineria.impostaStanzaAdiacente("est", aulaN5);
		bar.impostaStanzaAdiacente("sud", aulaN5);
		bar.impostaStanzaAdiacente("est", mensa);
		mensa.impostaStanzaAdiacente("sud", biblioteca);
		mensa.impostaStanzaAdiacente("ovest", bar);
		segreta.impostaStanzaAdiacente("est", fogne);
		covo.impostaStanzaAdiacente("nord", fogne);

        /* pone gli attrezzi nelle stanze */
		laboratorio.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		mensa.addAttrezzo(chiave);
		portineria.addAttrezzo(passepartout);
		portineria.addAttrezzo(ariete);
		wc.addAttrezzo(sasso);
		aulaN5.addAttrezzo(torcia);
		bar.addAttrezzo(caffe);
		segreta.addAttrezzo(diario);
		covo.addAttrezzo(striscione);
		

		// il gioco comincia nell'atrio
        this.stanzaIniziale = atrio;  
		this.stanzaVincente = biblioteca;
    }

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}
}