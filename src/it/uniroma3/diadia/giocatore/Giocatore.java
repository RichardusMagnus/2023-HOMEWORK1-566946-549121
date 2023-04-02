package it.uniroma3.diadia.giocatore;

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	int cfu = CFU_INIZIALI;
	Borsa borsa = new Borsa();
	
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public Borsa getBorsa() {
		return this.borsa;		
	}
}

