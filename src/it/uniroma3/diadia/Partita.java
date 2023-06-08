package it.uniroma3.diadia;
import java.io.Console;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private Labirinto labirinto;
	public Stanza stanzaCorrente;
	private Giocatore player;
	private boolean finita;
	

	public Partita(Labirinto labirinto){
		this.labirinto = labirinto;
		this.player = new Giocatore();
		this.finita = false;
	}

	public Giocatore getGiocatore() {
		return this.player;
	}
	
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		if (this.getLabirinto().getStanzaCorrente() == labirinto.getStanzaVincente())  {
			IO c = new IOConsole();
			c.mostraMessaggio("+++ Hai vinto! Grazie per aver giocato. +++");
			return true;
		}
		else return false;
		
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return (this.finita || vinta() || (player.getCfu() == 0));
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	public void setStanzaCorrente(Stanza s) {
		this.stanzaCorrente = s;
	}
}
