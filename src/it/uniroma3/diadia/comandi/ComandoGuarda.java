package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class ComandoGuarda extends AbstractComando implements Comando {
	IO console = new IOConsole();

	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());

	}
}