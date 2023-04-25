package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public interface Comando {
	/**
	 * Esegue genericamente comandi. Lascia la responsabilità di eseguire lo specifico
	 * comando a un oggetto di tipo corrispondente.
	 * @param partita
	 */
	public void esegui(Partita partita);
	
	/**
	 * Definisce il parametro dei comandi che lo richiedono
	 * @param parametro
	 */
	public void setParametro(String parametro);
}