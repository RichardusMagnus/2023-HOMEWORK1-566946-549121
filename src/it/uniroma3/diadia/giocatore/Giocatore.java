package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;

public class Giocatore {
	static final private int CFU_INIZIALI = 100;
	int cfu = CFU_INIZIALI;
	Borsa borsa = new Borsa();
	
	
	public int getCfu() {
		if (this.cfu == 0) {
			IO console = new IOConsole();
			console.mostraMessaggio("Hai esaurito i CFU: sei stato bocciato...");
		}
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return this.borsa;		
	}
}

