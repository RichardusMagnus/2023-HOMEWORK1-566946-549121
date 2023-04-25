package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private final String chiave;
	private final String dirBloc;
	private StanzaBloccata questaStanza;
	private final String messBloc = "La porta in direzione " + getDirBloc() +
			" è bloccata! Serve un attrezzo che "
			+ "possa forzarne l'apertura.\n";

	public StanzaBloccata(String nome, String dirBloc, String chiave) {
		super(nome);
		this.chiave = chiave;
		this.dirBloc = dirBloc;
		this.questaStanza = this;
	}

	@Override
	public String getDescrizione() {
		if (getAttrezzi()[0]!=null) {
			for (int i=0; i<getAttrezzi().length; i++)
				if (getAttrezzi()[i].getNome()==chiave) return super.getDescrizione();
		}
		return super.getDescrizione() + getMessBloc();
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzione==dirBloc) {
			if (getAttrezzi()[0]!=null) {
				for (int i=0; i<getAttrezzi().length; i++)
					if (getAttrezzi()[i].getNome()==chiave) return super.getStanzaAdiacente(direzione);
			}
			return this.questaStanza;
		}
		else return super.getStanzaAdiacente(direzione);
	}

	public String getMessBloc() {
		return this.messBloc;
	}

	public String getDirBloc() {
		return this.dirBloc;
	}

	public String getChiave() {
		return this.chiave;
	}

}
