package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	private final String buio = "E' tutto buio, c'è bisogno di qualcosa di luminoso per vedere.";
	private final String luce;

	public StanzaBuia(String nome, String luce) {
		super(nome);
		this.luce = luce;
	}

	@Override
	public String getDescrizione() {
		if(getAttrezzi()[0]!=null) {
			for(int i=0; i<getAttrezzi().length; i++) {
				if(getAttrezzi()[i].getNome() == this.luce) return super.getDescrizione();
			}
		}
		return getMessBuio();

	}

	
	public String getMessBuio() {
		return this.buio;
	}
}
