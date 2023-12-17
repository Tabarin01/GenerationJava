package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Rifattorizzazione esercizio nomi

		Scanner scanner = new Scanner(System.in);
		String nome;
		int i = 1;
		String risultatoTotale ="";

		while (i < 6) {

			System.out.println("Inserisci il "+ i + "° nome: ");
			nome = scanner.nextLine().toLowerCase();

			String risultato = "";

			if(nome.isEmpty()) {
				risultato = "";
			}else {

				switch(nome) {

				case "uberto":
				case "zenelao":
					risultato += " nome raro;";
					break;
				case "estella":
				case "frisella":
					risultato += " nome esotico;";
					break;
				case "mario":
					risultato += " come l'idrauilico più famoso al mondo;";
					break;
				default: 
					risultato += " nome comune;";
					if(nome.endsWith("a")) {
						risultato += " finisce con la 'a';";
					}else if(nome.lastIndexOf("o") == nome.length() -1) {
						risultato += " finisce con la 'o';";
					}
					if(nome.length()>7) {
						risultato += " è lungo;";
					}
				}

			}


			risultatoTotale += nome.toUpperCase() + risultato + "\n";

			i++;

		}

		scanner.close();

		System.out.println("\tScheda nomi inseriti \n" + risultatoTotale);


	}

}
