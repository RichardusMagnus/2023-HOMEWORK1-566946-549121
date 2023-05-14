package it.uniroma3.diadia.giocatore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private HashMap<String, Attrezzo> attrezziPerNome;
	private HashMap<Integer, Set<Attrezzo>> attrezziPerPeso;
	int numeroAttrezzi;
	private int pesoMax;

	public Borsa() {
		this.pesoMax = DEFAULT_PESO_MAX_BORSA;
		attrezziPerNome = new HashMap<>();
		attrezziPerPeso = new HashMap<>();
		this.numeroAttrezzi = 0;
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		attrezziPerNome = new HashMap<>();
		attrezziPerPeso = new HashMap<>();
		this.numeroAttrezzi = 0;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPesoBorsa() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		else {
			this.getAttrezziPerNome().put(attrezzo.getNome(), attrezzo);
			if (this.getAttrezziPerPeso().containsKey(attrezzo.getPeso()))
				this.getAttrezziPerPeso().get(attrezzo.getPeso()).add(attrezzo);
			else {
				Set<Attrezzo> listaAttrezzi = new HashSet<>();
				this.getAttrezziPerPeso().put(attrezzo.getPeso(), listaAttrezzi);
			}
			return true;
		}
	}

	private HashMap<Integer, Set<Attrezzo>> getAttrezziPerPeso() {
		return this.attrezziPerPeso;
	}
	
	public HashMap<String, Attrezzo> getAttrezziPerNome() {
		return this.attrezziPerNome;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		this.attrezziPerNome.get(nomeAttrezzo);
		return null;
	}

	public int getPesoBorsa() {
		int peso = 0;
		for (String att : this.getAttrezziPerNome().keySet())
			peso += this.getAttrezziPerNome().get(att).getPeso();
		return peso;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.getAttrezziPerNome().remove(nomeAttrezzo);
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (peso occupato:"+this.getPesoBorsa()+"kg/"+this.getPesoMax()+"kg): ");
			for (String att : this.getAttrezziPerNome().keySet())
				s.append(this.getAttrezziPerNome().get(att).toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
