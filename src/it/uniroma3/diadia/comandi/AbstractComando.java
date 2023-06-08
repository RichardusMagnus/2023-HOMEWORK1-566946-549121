package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public abstract class AbstractComando implements Comando{

	public AbstractComando() {
		super();
	}
	
	public abstract void esegui(Partita partita);
	
	public void setParametro(String parametro) {
		return;
	}

}