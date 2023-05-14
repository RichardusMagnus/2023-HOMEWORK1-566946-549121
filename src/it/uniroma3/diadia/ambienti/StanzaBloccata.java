package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	private final String chiave;
	private final String dirBloc;
	private final String messBloc;

	public StanzaBloccata(String nome, String dirBloc, String chiave) {
		super(nome);
		this.chiave = chiave;
		this.dirBloc = dirBloc;
		this.messBloc = "\nLa porta in direzione " + getDirBloc() +
					" è bloccata! Serve un attrezzo che "
					+ "possa forzarne l'apertura.";
	}

	@Override
	public String getDescrizione() {
		if (!this.hasAttrezzo(chiave))
			return super.getDescrizione() + getMessBloc();
		return super.getDescrizione();
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (dirBloc.equals(direzione) && !this.hasAttrezzo(chiave)) {
			return this;
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
