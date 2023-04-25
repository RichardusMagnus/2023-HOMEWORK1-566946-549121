package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected{
	protected int contatoreMagico = 0;
	static protected int sbloccaMagico = 10;

	public StanzaMagicaProtected(String nome) {
		super(nome);
	}
	
	public StanzaMagicaProtected(String nome, int sbloccaMagico) {
		super(nome);
		this.sbloccaMagico = sbloccaMagico;
	}

	@Override
	protected boolean addAttrezzo(Attrezzo attrezzo) {
		contatoreMagico++;
		if (contatoreMagico>=sbloccaMagico) incantesimo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}

	protected void incantesimo(Attrezzo attrezzo) {
		String nome = attrezzo.getNome();
		char[] daInvertire = nome.toCharArray();
		
		String nomeNuovo = new String();
		for (int i=daInvertire.length-1; i>=0; i--) {
			nomeNuovo = nomeNuovo + daInvertire[i];
		}

		attrezzo.setNomeAttrezzo(nomeNuovo);
		attrezzo.setPesoAttrezzo(attrezzo.getPeso()*2);
	}
	
	


}