package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreDiAttrezzi;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private HashMap<String, Attrezzo> attrezzi;
	private int pesoMax;

	public Borsa() {
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
		attrezzi = new HashMap<>();
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		attrezzi = new HashMap<>();
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPesoBorsa() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		else {
			this.attrezzi.put(attrezzo.getNome(), attrezzo);
			return true;
		}
	}

	public HashMap<String, Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPesoBorsa() {
		int peso = 0;
		for (String att : this.attrezzi.keySet())
			peso += this.attrezzi.get(att).getPeso();
		return peso;
	}

	public boolean isEmpty() {
		return this.attrezzi.isEmpty();
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo daRimuovere = this.getAttrezzi().remove(nomeAttrezzo);
		return daRimuovere;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (peso occupato:"+this.getPesoBorsa()+"kg/"+this.getPesoMax()+"kg): ");
			for (String att : this.getAttrezzi().keySet())
				s.append(this.getAttrezzi().get(att).toString()+" ");
		}
		else
			s.append("Borsa vuota.");
		return s.toString();
	}

	
	/**
	 * Restituisce una lista di attrezzi ordinata per peso.
	 * Oggetti di peso uguale sono ordinati per nome.
	 * @return
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> contenutoPerPeso = new ArrayList<Attrezzo>();
		
		contenutoPerPeso.addAll(this.attrezzi.values());
		contenutoPerPeso.sort(new ComparatoreDiAttrezzi());
		
		return contenutoPerPeso;
	}
	
	/**
	 * Restituisce un insieme di attrezzi ordinati per peso.
	 * Oggetti di peso uguale sono ordinati per nome.
	 * Nel cotruttore del TreeSet è stato passato un parametro costruttore che fa sì
	 * che l'albero non si ordini secondo le regole del compareTo() di Attrezzo.
	 * @return
	 */
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> insiemeSort = new TreeSet<Attrezzo>(new ComparatoreDiAttrezzi());
		insiemeSort.addAll(this.attrezzi.values());
		return insiemeSort;
		
	}
	
	/**
	 * Restituisce un insieme di attrezzi ordinati per nome, secondo il metodo compareTo()
	 * di Attrezzo.
	 * @return
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> contenutoPerNome = new TreeSet<>();
		
		for (String att : this.getAttrezzi().keySet())
			contenutoPerNome.add(this.getAttrezzi().get(att));
		
		return contenutoPerNome;
	}
	
	/**
	 * Costruisce una mappa di hash in cui ad ogni valore ammissibile di peso viene
	 * associata una lista di trabocco di attrezzi di tale peso.
	 * @return
	 */
	public Map<Integer, List<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer, List<Attrezzo>> gruppi = new HashMap<>();
		
		for (String att : this.getAttrezzi().keySet()) {
			int peso = this.getAttrezzi().get(att).getPeso();
			if (gruppi.containsKey(peso))
				gruppi.get(peso).add(this.getAttrezzi().get(att));
			else
				gruppi.put(peso, new ArrayList<Attrezzo>());
		}
		
		return gruppi;
	}
}
