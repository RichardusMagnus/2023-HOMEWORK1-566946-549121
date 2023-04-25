package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	private IO console;
	private final String CNV = "Comando non valido.";

	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio(CNV);
	}

	@Override
	public void setParametro(String parametro) {}

}
