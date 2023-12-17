package main;

import java.util.Scanner;

public class SecondMain {

	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		String nome1,nome2,nome3,nome4,nome5;
		
		System.out.println("Inserisci il primo nome: ");
		nome1 = scanner.nextLine();
		System.out.println("Inserisci il secondo nome: ");
		nome2 = scanner.nextLine();
		System.out.println("Inserisci il terzo nome: ");
		nome3 = scanner.nextLine();
		System.out.println("Inserisci il quarto nome: ");
		nome4 = scanner.nextLine();
		System.out.println("Inserisci il quinto nome: ");
		nome5 = scanner.nextLine();
		
		System.out.println("\t Scheda nomi selezionati \n"    +
				           "Il nome: '"+ nome1.toUpperCase()
		                      + "' è: "+ controlloNome(nome1) +"\n" + 
				           "Il nome: '"+ nome2.toUpperCase()
		                      + "' è: "+ controlloNome(nome2) +"\n" +
				           "Il nome: '"+ nome3.toUpperCase()
		                      + "' è: "+ controlloNome(nome3) +"\n" +
				           "Il nome: '"+ nome4.toUpperCase() 
		                      + "' è: "+ controlloNome(nome4) +"\n" +
				           "Il nome: '"+ nome5.toUpperCase() 
		                      + "' è: "+ controlloNome(nome5) +"\n");
		
		
		
		
		
	}
	public static String controlloNome(String nome) {
		String risultato ="";
		nome = nome.toLowerCase();
				
		if(nome.equals("uberto")|| nome.equals("zenelao")) {
			risultato += " nome raro;";
		}else if(nome.equals("estella")||nome.equals("frisella")) {
			risultato += " nome esotico;";
		}else if(nome.equals("mario")) {
			risultato += " come l'idrauilico più famoso al mondo;";
		}else {
			risultato += " nome comune;";
		}
		
		if(nome.endsWith("a")) {
			risultato += " finisce con la 'a';";
		}else if(nome.lastIndexOf("o") == nome.length() -1) {
			risultato += " finisce con la 'o';";
		}
		if(nome.length()>7) {
			risultato += " è lungo;";
		}
		
		return risultato;
	}
}
