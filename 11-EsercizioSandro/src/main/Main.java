package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String nome, cognome, destinazione;
		double costoBagaglio =20, prezzo = 50;
		int eta, numBagagli, sconto = 0;


		System.out.println("Benvenuti su Ryanair \nInserite il vostro nome: ");
		nome = input.nextLine();
		System.out.println("Inserite il vostro cognome: ");
		cognome = input.nextLine();
		System.out.println("Inserite la vostra eta': ");
		eta = Integer.parseInt(input.nextLine());
		System.out.println("Quanti bagagli portate con voi: ");
		numBagagli = Integer.parseInt(input.nextLine());
		System.out.println("Inserite la vostra destinazione: ");
		destinazione = input.nextLine();

		costoBagaglio *= numBagagli;
		prezzo += costoBagaglio;

		switch(destinazione.replace(" ", "").toLowerCase()) {
		case "newyork":
			prezzo += 200;
			break;
		case "milano":
			prezzo += 150;
			break;
		case "madrid":
			prezzo += 100;
			break;
		default:
			prezzo +=600;
		}

		if(eta < 18) {
			sconto = 50;
			prezzo -= prezzo*50/100;
		}else if(eta>70) {
			sconto = 25;
			prezzo -= prezzo*25/100;
		}

		System.out.println(
				"\t SCHEDA VIAGGIO \n"
						+ " Nominativo: "+ nome.toUpperCase() +" "+ cognome.toUpperCase()+"\n"
						+ " Anni: "+ eta +"\n"
						+ " Numero Bagagli: "+ numBagagli +"\n"
						+ " Destinazione: "+ destinazione.toUpperCase() +"\n"
						+ " Sconto: " + sconto + "%\n"
						+ " Totale biglietto: "+ prezzo +"$\n");


	}

}
