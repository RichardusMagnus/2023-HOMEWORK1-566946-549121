package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends AbstractComando {
	private String nomeAttrezzo;
	private IO console = new IOConsole();

	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo == null) {
			console.mostraMessaggio("Quale attrezzo vuoi posare? Devi specificare l'attrezzo insieme al comando.");
			return;
		}
		
		Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (a != null) {
			partita.getStanzaCorrente().addAttrezzo(a);
			partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			console.mostraMessaggio("Hai posato l'oggetto!");
			return;
		}
		else {
			console.mostraMessaggio("Non hai quell'oggetto nella borsa...");
			return;
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}

}
