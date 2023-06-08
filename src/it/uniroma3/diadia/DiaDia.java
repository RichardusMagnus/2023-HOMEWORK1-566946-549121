package it.uniroma3.diadia;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

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


	private Partita partita;
	private IO console;

	public DiaDia(Labirinto labirinto, IO console) {
		this.console = console;
		this.partita = new Partita(labirinto);
	}

	
	public void gioca() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String istruzione; 
		FabbricaDiComandi costruttore = new FabbricaDiComandiFisarmonica();
		Comando daEseguire;

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do	{
			istruzione = console.leggiRiga();
			daEseguire = costruttore.costruisciComando(istruzione);
			daEseguire.esegui(partita);
		}
		while (!this.partita.isFinita());
	}

	public static void main(String[] argc) throws InstantiationException, IllegalAccessException, ClassNotFoundException, FileNotFoundException, FormatoFileNonValidoException {
		IO io = new IOConsole();
		
		Labirinto lab = new LabirintoBuilder()
				.addStanzaIniziale("atrio")
				.addStanzaVincente("biblioteca")
				.addAdiacenza("atrio", "biblioteca", Direzione.nord)
				.getLabirinto();
		
		DiaDia gioco = new DiaDia(lab, io);
		gioco.gioca();
	}
}