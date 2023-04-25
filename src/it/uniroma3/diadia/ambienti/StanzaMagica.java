package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{
	private int contatoreMagico = 0;
	final int sbloccaMagico = 3;

	public StanzaMagica(String nome) {
		super(nome);
	}

	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		contatoreMagico++;
		if (contatoreMagico>=sbloccaMagico) incantesimo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}

	public void incantesimo(Attrezzo attrezzo) {
		String nome = attrezzo.getNome();
		char[] daInvertire = nome.toCharArray();
		
		String nomeNuovo = new String();
		for (int i=daInvertire.length-1; i>=0; i--) {
			nomeNuovo = nomeNuovo + daInvertire[i];
		}

		attrezzo.setNomeAttrezzo(nomeNuovo);
		attrezzo.setPesoAttrezzo(attrezzo.getPeso()*2);
	}
	@Override
	public String getDescrizione() {
		return "Questa stanza è molto strana... Chissà che succede se lascio in giro troppi oggetti.\n" + super.getDescrizione();
	}

	public int getContatore() {
		return this.contatoreMagico;
	}

	public int getMaxMag() {
		return this.sbloccaMagico;
	}

}
