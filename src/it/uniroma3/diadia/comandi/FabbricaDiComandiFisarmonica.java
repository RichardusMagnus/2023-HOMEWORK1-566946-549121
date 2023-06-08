package it.uniroma3.diadia.comandi;

import java.util.Scanner;

import it.uniroma3.diadia.IO;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{
	
	@Override
	public Comando costruisciComando (String istruzione) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		Class<? extends Comando> classeDiComando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
		
		StringBuilder nomeClasseComando = new StringBuilder("it.uniroma3.diadia.comandi.Comando");
		nomeClasseComando.append(Character.toUpperCase(nomeClasseComando.charAt(0)));
		nomeClasseComando.append(nomeClasseComando.substring(1));
		
		comando = (Comando)Class.forName(nomeClasseComando.toString()).newInstance();
		
		comando.setParametro(parametro);
		
		return comando;
		
	}
}
