package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//La classe Main si chiama CLASSE DI AVVIO, perchè non fa da modello a degli oggetti
//Ha il compito di interfacciarsi con l'esterno, cioè con la console.
//OCCHIO: potete avere tutte le classi modello che volete, 
//ma in un programma esiste UNA E UNA SOLA classe di avvio per volta

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		/*

		PROGRAMMAZIONE A OGGETTI: Cosa sono gli oggetti?

		Di base, un oggetto è una variabile che rappresenta un elemento concreto nel mondo reale
		Ogni elemento reale ha delle cartteristiche che lo rappresentano: per distinguere i singoli
		oggetti ci serve sapere il valore associato a quelle caratteristiche.

		L'oggetto è il caso concreto ( cioè l'insieme dei valori delle sue caratteristiche) mentre ciò
		 che determina quali caratteristiche ci interessano si chiama CLASSE.

		DEFINIZIONE
		La classe è l'idea, il modello di un elemento, l'oggetto è il caso concreto

		 */

		Scanner tastiera = new Scanner(System.in);
		Scanner file = new Scanner(new File("src/res/Dati.txt"));

		int dim = Integer.parseInt(file.nextLine());

		//Ogni riga del file rappresenta un oggetto, quindi d'ora in poi i nostri vettori
		//non conterranno più dati semplici (int,String, ecc), ma conterranno oggetti.
		//Il tipo degli oggetti è sempre il nome della loro classe di appartenenza
		//Quindi avremo una variabile "persone" che sarà di tipo "vettore di Persone".

		Persona[] persone = new Persona[dim];

		// I comandi in programmazione si leggono sempre al contrario di come si scrivono:
		// se le cose le scrivo da sx a dx, allora verrano eseguite da dx a sx, per cui
		// nella riga 41 si esegue prima il contenitore e poi decido cosa metterci dentro (tipo Persona).

		dim = 0;

		while(file.hasNextLine()) {

			String[] infoRiga = file.nextLine().split(";");

			// Questo è come si dichiara e inizializza a vuoto un oggetto.
			Persona persona = new Persona();

			//Ora assegno alle proprietà dell'oggetto vuoto i valori letti da file
			persona.nome = infoRiga[0];
			persona.cognome = infoRiga[1];
			persona.eta = Integer.parseInt(infoRiga[2]);
			persona.patentato = infoRiga[3].equalsIgnoreCase("s");

			// Ora che il mio oggetto è pieno lo posso salvare nel vettore

			persone[dim] = persona;

			dim++;

		}

		file.close();
		//---------------------------------------------------------------------------------


		System.out.println("\n\tSchede di tutte le persone\n");
		for(int i = 0; i < persone.length; i++) {
			System.out.println(persone[i].scheda());
		}


		// Voglio vedere le schede delle persone che possono guidare
		System.out.println("\n\tSchede delle persone patentate\n");
		for(int i = 0; i < persone.length; i++ ) {
			if(persone[i].patentato)
				System.out.println(persone[i].scheda());
		}

		//Voglio vedere la scheda delle persona o delle persone più anziane
		int maxEta = Integer.MIN_VALUE;
		String ris = "";
		System.out.println("\n\tScheda dell* person* più anziana\n ");
		for (int i = 0; i < persone.length; i++) {
			if (persone[i].eta > maxEta) {
				maxEta = persone[i].eta;
				ris = persone[i].scheda();
			}else if(persone[i].eta == maxEta) {
				ris += persone[i].scheda();
			}
		}
		System.out.println(ris);

		space();

		System.out.println("\tESERCIZIETTI: \n");
		// Voglio sapere quante persone sono maggiorenni;
		int contMaggiorenni = 0;
		for(int i = 0; i< persone.length; i++) {
			if(persone[i].eta > 18) {
				contMaggiorenni++;
			}
		}
		System.out.println("\nCi sono " + contMaggiorenni + " maggiorenni");

		space();

		//Voglio sapere i nomi dei minorenni con la patente
		ris = "";
		for(int i = 0; i < persone.length; i++) {
			if(persone[i].patentato == true && persone[i].eta < 18) {
				ris += "\nMinorenni con la patente: " + persone[i].nome + "\n";
			}
		}
		System.out.println(ris);

		space();

		//Voglio sapere quante persone hanno la patente da almeno 20 anni
		//(Immaginate che tutti l'abbiano presa a 18 anni)
		int contPatenteVentanni = 0;
		for (int i = 0; i < persone.length; i++) {

			if (persone[i].eta > 38 && persone[i].patentato) {
				contPatenteVentanni++;
			}
		}
		System.out.println("\nCi sono " + contPatenteVentanni + " patentati da minimo 20 anni");

		space();

		// Voglio permettere all'utente di cercare la scheda di una persona tramite il suo cognome
		System.out.println("Inserisci il cognome desiderato: ");
		String cognomeScelto = tastiera.nextLine();

		for(int i = 0; i < persone.length; i++) {
			if(cognomeScelto.equalsIgnoreCase(persone[i].cognome))
				System.out.println(persone[i].scheda());
		}

		space();

		tastiera.close();
	}//main

	private static void space() {
		System.out.println("\n//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\n");
	}
}//classe


