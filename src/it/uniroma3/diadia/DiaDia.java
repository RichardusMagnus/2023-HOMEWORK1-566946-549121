package it.uniroma3.diadia;
import java.util.Scanner;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine"};

	private Partita partita;

	private IOConsole console;

	public DiaDia() {
		this.console = new IOConsole();
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do	{
			istruzione = console.leggiRiga();
			processa(istruzione);
		}
		while (!this.partita.isFinita());
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private void processa(String istruzione) { //na bella fisarmonica: qui c'è una duplicazione del codice per ogni casistica concepita
		Comando daEseguire = new Comando(istruzione);

		final String nomeComando = daEseguire.getNome();

		if (nomeComando != null) {
			if (nomeComando.equals("fine")) {
				this.fine(); 

			}
			else if (nomeComando.equals("vai")) {
				this.vai(daEseguire.getParametro());
			}
			else if (nomeComando.equals("prendi")) {
				this.prendi(daEseguire.getParametro());
			}
			else if (nomeComando.equals("posa")) {
				this.posa(daEseguire.getParametro());
			}
			else if (nomeComando.equals("aiuto"))
				this.aiuto();
			else
				console.mostraMessaggio("Comando sconosciuto.");

			if (this.partita.vinta()) {
				console.mostraMessaggio("Hai vinto!!!");
			}
		}
		else {
			console.mostraMessaggio("Comando invalido.");

		}
	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i<elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		console.mostraMessaggio("\n");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null) {
			console.mostraMessaggio("Dove vuoi andare?");
			direzione = console.leggiRiga();
		}

		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione non disponibile.");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu-1);
		} 
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione() + "\nCFU rimanenti: [" + this.partita.getGiocatore().getCfu() + "]");
	}

	private boolean prendi(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			console.mostraMessaggio("Quale attrezzo vuoi prendere?");
			nomeAttrezzo = console.leggiRiga();
		}

		Attrezzo a = this.partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(a != null) {
			this.partita.getGiocatore().getBorsa().addAttrezzo(a);
			this.partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
			console.mostraMessaggio("Aggiunto alla borsa " + this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
			return true;
		}
		else {
			console.mostraMessaggio("L'attrezzo scelto non c'è nella stanza...");
			return false;
		}
	}

	private boolean posa(String nomeAttrezzo) {
		if(nomeAttrezzo == null) {
			console.mostraMessaggio("Quale attrezzo vuoi posare?");
			nomeAttrezzo = console.leggiRiga();
		}

		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (a != null) {
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			console.mostraMessaggio("Hai posato l'oggetto!");
			return true;
		}
		else {
			console.mostraMessaggio("Non hai quell'oggetto nella borsa...");
			return false;
		}
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}