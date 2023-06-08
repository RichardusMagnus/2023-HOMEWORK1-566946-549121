package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends Personaggio {
	private IOConsole io = new IOConsole();
	
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private Attrezzo attrezzo;

	public Mago(String nome, String presentaz, Attrezzo attrezzo) {
		super(nome, presentaz);
		this.attrezzo = attrezzo;
	}

	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		int nuovoPeso = attrezzo.getPeso()/2;
		attrezzo.setPesoAttrezzo(nuovoPeso);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		this.io.mostraMessaggio("Il mago ha lasciato cadere " + attrezzo.getNome() + "che gli avevi regalato. Sembra più leggero.");
		return "Se belli si vuole apparire, un poco si deve dimagrire! Vale anche per gli oggetti.";
	}

}
