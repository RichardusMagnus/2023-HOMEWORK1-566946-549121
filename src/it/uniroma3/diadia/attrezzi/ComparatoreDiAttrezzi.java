package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreDiAttrezzi implements Comparator<Attrezzo>{
	
	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		int ris = o1.getPeso() - o2.getPeso();
		if (ris == 0) return o1.compareTo(o2);
		else return ris;
	}

}
