package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando {
	private String direzione;
	private IO console = new IOConsole();

	@Override
	public void esegui(Partita partita) {
		if(direzione==null) {
			console.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione.");
			return;
		}

		Stanza prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
		if (prossimaStanza == null){
			console.mostraMessaggio("Direzione non disponibile.");
			return;
		}
		else {
			partita.setStanzaCorrente(prossimaStanza);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu-1);
		} 
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione() + "\nCFU rimanenti: [" + partita.getGiocatore().getCfu() + "]");
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	public String getParametro() {
		return this.direzione;
	}
	
}