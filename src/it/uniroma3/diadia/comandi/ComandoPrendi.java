package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	private IO console = new IOConsole();
	private String nomeAttrezzo = null;

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			console.mostraMessaggio("Quale attrezzo vuoi prendere? Devi specificare l'attrezzo.");
			return;
		}

		Attrezzo a = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(a != null) {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
			console.mostraMessaggio("Aggiunto alla borsa " + partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
			return;
		}
		else {
			console.mostraMessaggio("L'attrezzo scelto non c'è nella stanza...");
			return;
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

}