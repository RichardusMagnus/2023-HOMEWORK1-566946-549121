package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends Personaggio {


	private static final String MESSAGGIO_SI = "Ti farò un bel regalo, giovanotto... ABRACADABRA!";
	private static final String MESSAGGIO_NO = "Sei proprio maleducato! VIA DI QUI! *woosh*";
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}
	@Override
	public String agisci(Partita partita) {
		partita.setStanzaCorrente(this.destinazione(partita, this.haSalutato()));
		if (this.haSalutato()) return MESSAGGIO_SI;
		else return MESSAGGIO_NO;
	}
	
	public Stanza destinazione(Partita partita, Boolean saluto) {
		Stanza dest = null;
		if (saluto) {
			int maggiore = 0;
			for (Stanza i : partita.getStanzaCorrente().getStanzeAdiacenti()) {
				if (i.getNumeroAttrezzi()>maggiore) {
					maggiore = i.getNumeroAttrezzi();
					dest = i;
				}
			}
		}
		else {
			int minimo = 1000000000;
			for (Stanza i : partita.getStanzaCorrente().getStanzeAdiacenti()) {
				if (i.getNumeroAttrezzi()<minimo) {
					minimo = i.getNumeroAttrezzi();
					dest = i;
				}
			}
		}
		
		return dest;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "Ah ah ah! Credi davvero che io abbia bisogno di queste cianfrusaglie da babbano?";
	}

}
