package main;

import entities.Scuola;

import java.io.FileNotFoundException;



public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scuola s = new Scuola("src/res/Dati.txt");
		
		System.out.println(s.elenco());
		System.out.println(s.pendolari());
		System.out.println(s.personaVecchia());
		System.out.println(s.votoMedio());
		System.out.println(s.bonusView());
	
	}

}
