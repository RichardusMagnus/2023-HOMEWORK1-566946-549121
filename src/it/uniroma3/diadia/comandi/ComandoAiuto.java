package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;

public class ComandoAiuto implements Comando {
	private IO console = new IOConsole();
	static final private String[] elencoComandi = {"aiuto", "vai", "prendi", "posa", "dai", "guarda", "fine"};

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i<elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
		console.mostraMessaggio("\n");

	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub

	}

}
