package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//Creare un programma che gestisca un agenzia viaggi.
//Formattare un file con le seguenti informazioni:
//    destinazione,mezzo di trasporto,giorni di vacanza,costo giornaliero,numero persone.
//
//Creare un programma che acquisite le informazioni dal file sia in grado di 
//creare un vettore di oggetti di tipo Viaggio.
//Scrivere il costruttore e i metodi
//scheda()
//prezzo() : REGOLE
//          Calcolo del prezzo:
//Prezzo base 100;
//se la destinazione è Dubai o Tokyo aggiungo 200, se è Dublino o Londra aggiungo 150,
//                    se è New York o Miami aggiungo 300. In tutti gli altri casi aggiungo 50
//se il mezzo di trasporto è aereo o traghetto aggiungo 500, se è treno aggiungo 200,
//                    e è automobile o autobus aggiungo 100. In tutti gli altri casi aggiungo 1000
//se le persone sono più di 5 scontare il viaggio del 5%, se invece sono più di 10 scontare il
//                    viaggio del 10%.
//
//Stampare in console tramite un menù:
//-Scheda di ogni viaggio disponibile nel file
//-Lista destinazioni(senza ripetizioni)
//-Lista mezzi di trasporto(senza ripetizioni)
//-Costo medio dei viaggi in aereo
//-Costo medio dei viaggi a Dubai
//-Viaggi più economici(Viaggio/i che costano meno tra tutti quelli nel file)
//-Viaggi di lusso(Viaggio/i che costano di più tra tutti quelli del file)
//-Numero di viaggi per ogni destinazione presente nel file
//-I viaggi che costano meno della media generale
//-Permettete all'utente di cercare dei viaggi in base a una destinazione e a un mezzo a scelta


public class Main {

	public static void main(String[] args) throws FileNotFoundException	{ 

		Scanner file = new Scanner(new File("src/res/Dati.txt"));

		Viaggi[] viaggi= new Viaggi[Integer.parseInt(file.nextLine())];

		int index = 0;
		while(file.hasNextLine()) {

			String[] info = file.nextLine().split(";");

			Viaggi v = new Viaggi(
					info[0],
					info[1],
					Integer.parseInt(info[2]),
					Integer.parseInt(info[3]),
					Integer.parseInt(info[4])
					);

			viaggi[index] = v;

			index++;

		}
		file.close();

		String menu = "\n\tMENU\n"
				+ "  1- Mostra tutte le schede dei viaggi\n"
				+ "  2- Lista destinazioni senza ripetizioni\n"
				+ "  3- Lista mezzi di trasporto senza ripetizioni\n"
				+ "  4- Costo medio dei viaggi in aereo\n"
				+ "  5- Costo medio dei viaggi a Dubai\n"
				+ "  6- Viaggi più economici\n"
				+ "  7- Viaggi di lusso\n"
				+ "  8- Numero di viaggi per ogni destinazione\n"
				+ "  9- I viaggi che costano meno della media generale\n"
				+ " 10- Viaggi in base a destinazione e mezzo scelti da utente\n"
				+ "  M- Ristampa menù\n"
				+ "  0- Esci\n";


		Scanner tastiera = new Scanner(System.in);
		System.out.println("Benvenuto nella nostra agenzia!\n" + menu);
		String choice, ris;


		do {

			ris = "";
			System.out.println("Digita m per il menu \nComando");
			choice = tastiera.nextLine();

			switch (choice.toLowerCase()) {


			case "1":
				//-Scheda di ogni viaggio disponibile nel file
				System.out.println("\n\tSCHEDE VIAGGI \n");
				for(int i = 0; i < viaggi.length; i++)
					ris +=viaggi[i].scheda();
				break;

			case "2":
				//-Lista destinazioni(senza ripetizioni)
				System.out.println("\n\tLISTA DESTINAZIONI \n");

				for(int i = 0; i < viaggi.length; i++) {
					if(!ris.contains(viaggi[i].destinazione.toUpperCase())) {
						ris += viaggi[i].destinazione.toUpperCase() + "\n";
					}
				}
				break;

			case "3":
				//-Lista mezzi di trasporto(senza ripetizioni)
				System.out.println("\n\tLISTA MEZZI DI TRASPORTO \n");

				for(int i = 0; i < viaggi.length; i++) {
					if(!ris.contains(viaggi[i].mezzo.toUpperCase())) {
						ris += viaggi[i].mezzo.toUpperCase() + " ";
					}
				}

				break;


			case "4":
				//-Costo medio dei viaggi in aereo
				System.out.println("\n\tCOSTO MEDIO DEI VIAGGI IN AEREO \n");


				int sommaCostiAereo = 0;
				int numViaggiAereo = 0;


				for (int i =0;i < viaggi.length; i++) {
					if (viaggi[i].mezzo.equalsIgnoreCase("aereo")) {
						sommaCostiAereo += viaggi[i].calcoloPrezzo();
						numViaggiAereo++;
					}
				}


				int  costoMedioAereo = (numViaggiAereo > 0) ? sommaCostiAereo / numViaggiAereo : 0;
				ris += "Costo Medio dei Viaggi in Aereo: " + costoMedioAereo + " $\n";
				break;
			case "5":
				//-Costo medio dei viaggi a Dubai
				System.out.println("\n\tCOSTO MEDIO DEI VIAGGI A DUBAI \n");


				int sommaCostiDubai = 0;
				int numViaggiDubai = 0;


				for (int i =0;i < viaggi.length; i++) {
					if (viaggi[i].destinazione.equalsIgnoreCase("dubai")) {
						sommaCostiDubai += viaggi[i].calcoloPrezzo();
						numViaggiDubai++;
					}
				}


				int  costoMedioDubai = (numViaggiDubai > 0) ? sommaCostiDubai / numViaggiDubai : 0;
				ris += "Costo Medio dei Viaggi a Dubai: " + costoMedioDubai + " $\n";

				break;

			case "6":
				//-Viaggi più economici(Viaggio/i che costano meno tra tutti quelli nel file)
				System.out.println("\n\t VIAGGI ECONOMICI\n");
				double costoMin = Double.MAX_VALUE;

				for(int i = 0; i < viaggi.length; i++) {
					double costoViaggio = viaggi[i].calcoloPrezzo();
					if(costoViaggio < costoMin) {
						costoMin = costoViaggio;
					}
				}

				for(int i = 0; i < viaggi.length; i ++) {
					if(viaggi[i].calcoloPrezzo() == costoMin) {
						ris += viaggi[i].scheda();
					}
				}

				ris = ris.isEmpty() ? "\nNessun viaggio è il più economico!" : ris;

				break;

			case "7":
				//-Viaggi di lusso(Viaggio/i che costano di più tra tutti quelli del file)
				System.out.println("\n\t VIAGGI ECONOMICI\n");
				double costoMax = 0;

				for(int i = 0; i < viaggi.length; i++) {
					double costoViaggio = viaggi[i].calcoloPrezzo();
					if(costoViaggio > costoMax) {
						costoMax = costoViaggio;
					}
				}

				for(int i = 0; i < viaggi.length; i ++) {
					if(viaggi[i].calcoloPrezzo() == costoMax) {
						ris += viaggi[i].scheda();
					}
				}

				ris = ris.isEmpty() ? "\nNessun viaggio di lusso trovato!" : ris;

				break;

			case "8":
				//-Numero di viaggi per ogni destinazione presente nel file
				System.out.println("\n\tNUMERO DI VIAGGI PER OGNI DESTINAZIONE \n");

				String destinazioniSenzaRipetizioni = "";
				for (int i = 0; i < viaggi.length; i++) {
					if (!destinazioniSenzaRipetizioni.toLowerCase().contains(viaggi[i].destinazione.toLowerCase() + ";")) {
						destinazioniSenzaRipetizioni += viaggi[i].destinazione + ";";
					}
				}

				destinazioniSenzaRipetizioni = destinazioniSenzaRipetizioni.substring(0, destinazioniSenzaRipetizioni.length() - 1);


				String[] destinazioniSingole = destinazioniSenzaRipetizioni.split(";");
				for (int i = 0; i < destinazioniSingole.length; i++) {
					int conta = 0;

					for (int j = 0; j < viaggi.length; j++) {
						if (destinazioniSingole[i].equalsIgnoreCase(viaggi[j].destinazione)) {
							conta++;
						}
					}

					ris += "Destinazione: " + destinazioniSingole[i] + ", Numero di Viaggi: " + conta + "\n";
				}

				ris = ris.isEmpty() ? "\nNessuna destinazione presente nei viaggi!" : ris;
				break;

			case "9":
				//-I viaggi che costano meno della media generale
				double mediaGenerale = 0;
				for(int i = 0; i < viaggi.length; i++) {
					mediaGenerale += viaggi[i].calcoloPrezzo();
				}
				mediaGenerale /= viaggi.length;

				for(int i = 0; i < viaggi.length; i++) {
					if(viaggi[i].calcoloPrezzo() < mediaGenerale) {
						ris += viaggi[i].scheda();
					}
				}

				System.out.println(mediaGenerale);
				ris = ris.isEmpty() ? "\nNessun viaggio costa meno della media generale" : ris;

				break;

			case "10":
				//-Permettete all'utente di cercare dei viaggi in base a una destinazione e a un mezzo a scelta
				System.out.println("\n\t RICERCA VIAGGI PER DESTINAZIONE E MEZZO \n");

				System.out.print("Inserisci la destinazione: ");
				String destinazioneCercata = tastiera.nextLine();

				System.out.print("Inserisci il mezzo di trasporto: ");
				String mezzoCercato = tastiera.nextLine();

				for(int i = 0; i < viaggi.length; i++) {
					if(viaggi[i].destinazione.equalsIgnoreCase(destinazioneCercata) 
							&& viaggi[i].mezzo.equalsIgnoreCase(mezzoCercato)) {

						ris += "\n" + viaggi[i].scheda();
					}
				}

				ris = ris.isEmpty() ? "\nNessun viaggio trovato" : ris;

				break;
			case "0":
				System.out.println("Programma terminato.");
				break;
			case "m":
				System.out.println(menu);
				break;
			default:
				System.out.println("Scelta non valida. Riprova.");
			}

			System.out.println(ris);
		} while (!choice.equalsIgnoreCase("0"));

		tastiera.close();


		for(Viaggi elementi : viaggi)
			System.out.println(elementi.scheda());

	}//main

}//classe
