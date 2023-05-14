package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private final String messBuio;
	private final String luce;

	public StanzaBuia(String nome, String luce) {
		super(nome);
		this.luce = luce;
		this.messBuio = "E' tutto buio, c'è bisogno di qualcosa di luminoso per poter vedere l'interno di questa stanza.";
	}

	@Override
	public String getDescrizione() {
		if (!this.hasAttrezzo(luce))
			return getMessBuio();
		else
			return super.getDescrizione();

	}

	
	public String getMessBuio() {
		return this.messBuio;
	}
	
}
