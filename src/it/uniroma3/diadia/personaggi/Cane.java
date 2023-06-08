package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends Personaggio {
	private IO io = new IOConsole();
	private static String MSG_morso = "CANE: -Grrrrr arf arf (Ti ho tolto un CFU!) *chomp*";
	String nomeOggettoPreferito = null;
	Attrezzo attrezzoTenuto = null;

	public Cane(String nome, String presentaz, String oggPref, Attrezzo attTen) {
		super(nome, presentaz);
		this.nomeOggettoPreferito = oggPref;
		this.attrezzoTenuto = attTen;
	}

	@Override
	public String agisci(Partita partita) {
		io.mostraMessaggio("TU: -Qui bel cagnolin... AHIA!!");
		int cfu = partita.getGiocatore().getCfu();
		cfu--;
		partita.getGiocatore().setCfu(cfu);
		return MSG_morso;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo.getNome().equals(nomeOggettoPreferito)) {
			io.mostraMessaggio("Sembra che il cane abbia apprezzato il tuo regalo!");
			partita.getStanzaCorrente().addAttrezzo(attrezzoTenuto);
			return "CANE: -Bau bau!! (Wow, lo adoro! Ti lascio questo oggetto.)";
		}
		else {
			io.mostraMessaggio("Il cane non smebra gradire...");
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			int cfu = partita.getGiocatore().getCfu();
			partita.getGiocatore().setCfu(cfu-1);
			return "CANE: -Bau bau!! (Che vuoi che io me ne faccia?? Ti tolgo un CFU.) *chomp*";
		}
	}

}
