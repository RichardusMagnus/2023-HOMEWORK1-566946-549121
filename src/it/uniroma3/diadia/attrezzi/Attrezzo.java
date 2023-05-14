package it.uniroma3.diadia.attrezzi;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * Una semplice classe che modella un attrezzo.
 * Gli attrezzi possono trovarsi all'interno delle stanze
 * del labirinto.
 * Ogni attrezzo ha un nome ed un peso.
 *
 * @author  docente di POO
 * @see StanzaProtected
 * @version base
 */
public class Attrezzo {

	private String nome;
	private int peso;

	/**
	 * Crea un attrezzo
	 * @param nome il nome che identifica l'attrezzo
	 * @param peso il peso dell'attrezzo
	 */
	public Attrezzo(String nome, int peso) {
		this.peso = peso;
		this.nome = nome;
	}

	/**
	 * Restituisce il nome identificatore dell'attrezzo
	 * @return il nome identificatore dell'attrezzo
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Restituisce il peso dell'attrezzo
	 * @return il peso dell'attrezzo
	 */
	public int getPeso() {
		return this.peso;
	}

	/**
	 * Restituisce una rappresentazione stringa di questo attrezzo
	 * @return la rappresentazione stringa
	 */
	public String toString() {
		return this.getNome()+" ("+this.getPeso()+"kg)";
	}
	
	/**
	 * Imposta il nome dell'attrezzo
	 * @param nome
	 */
	public void setNomeAttrezzo(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Imposta il peso dell'attrezzo
	 * @param peso
	 */
	public void setPesoAttrezzo(int peso) {
		this.peso = peso;
	}
	
	/**
	 * Verifica che due attrezzi siano l'uno il duplicato dell'altro
	 * @param a
	 * @return
	 */
	public boolean equals(Object o) {
		Attrezzo that = (Attrezzo)o;
		return this.getNome()==that.getNome();
	}
	
	/**
	 * Ritorna l'hashcode di un attrezzo
	 */
	public int hashCode() {
		return this.getNome().hashCode();
	}

}