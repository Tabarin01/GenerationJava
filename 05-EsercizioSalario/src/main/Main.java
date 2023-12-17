package main;

import java.util.Scanner;
import java.text.NumberFormat;

public class Main {
	
	/*Programma che calcoli le entrate annuali di un lavoratore
	 * Dati: nome, stipendio medio mensile, mensilita' contrattuali (13esima), 
	 * Stampare in console "Buonasera sign. [cognome] il suo lordo annuale vale [calcolo]"
	 * */	

	public static void main(String[] args) {
		
		String nome;
		String cognome;
		
		double stipendio;
		double bonus;
		double totale;
		
		Scanner tastiera;
		
		stipendio = 0;
		bonus = 0;
		totale = 0;
		
		tastiera = new Scanner(System.in);
		
		System.out.println("Inserisci il tuo cognome: ");
		cognome = tastiera.nextLine();
		
		System.out.println("Inserisci il tuo stipendio medio mensile: ");
		stipendio = tastiera.nextDouble();
		
		System.out.println("Inserisci il bonus: ");
		bonus = tastiera.nextDouble();
		
		totale = ((stipendio * 12)+ bonus);
		
		System.out.println("Buonasera sign. "+ cognome + " il suo lordo annuale vale: "+ totale + "euro");

		tastiera.close();
	}

}
