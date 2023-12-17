package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Scrivere un programma che chieda all'utente di inserire una serie di numeri positivi.
		// Se il numero inserito è negativo, segnalare tramite una stampa che il numero non va bene 
		// e non considerarlo nei calcoli.
		// Per terminare il programma indicare all'utente di scrivere 0
		// Il programma deve:
		// - fare la somma di tutti i numeri inseriti
		// - fare la somma dei numeri pari
		// - fare il prodotto dei numeri multipli di 3
		// - contare quanti numeri dispari scrive l'utente
		// BONUS
		// - trovare il numero maggiore inserito dall'utente

		// Stampare infine in console in modo ordinato le richieste precedenti

		Scanner userInput = new Scanner(System.in);
		int numero, 
		sommaNumeri = 0, 
		sommaPari = 0, 
		multipli3 = 1,
		contatoreDispari = 0,
		numeroMax = 0;
		boolean multipli = false;

		System.out.println("Digita 0 per uscire dal loop!");

		while (true) {

			System.out.println("Inserisci un numero positivo: ");
			numero = Integer.parseInt(userInput.nextLine());
			if(numero == 0)break;

			//Ternary Mode
			numeroMax = numero > numeroMax ? numero: numeroMax;
			
//classic	if(numeroMax < numero) {
//way		numeroMax = numero;
//			}

			if(numero > 0) {

				sommaNumeri += numero;

				if(numero % 2 == 0) {

					sommaPari += numero;

				}else {

					contatoreDispari++;
				}

				if(numero %3 == 0) {
					multipli = true;
					multipli3 *= numero;
					
				}
	
			}else {
				System.out.println(numero + " numero negativo, non viene considerato" );	
			}

            multipli3 = multipli ? multipli3 : 0;

		}

		userInput.close();

		System.out.println("Somma dei numeri inseriti: "+ sommaNumeri + 
				           "\nSomma dei numeri pari: " + sommaPari + 
				           "\nProdotto multipli di 3: " + multipli3 + 
				           "\nConteggio dispari: "+ contatoreDispari+
				           "\nNumero maggiore: "+ numeroMax);



	}

}
