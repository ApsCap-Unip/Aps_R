package Main;

import Historia.Historia;
import Personagem.Personagem;

public class Main {
	
	public static void main (String[] args) {
		Personagem personagem = new Personagem();
		Historia historia = new Historia(personagem);
		historia.iniciarDia(1);
	}
}
