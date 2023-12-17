package main;

import java.util.Scanner;

// ESERCIZIO

// Dovete gestire una libreria.
// Chiedete all'utente i dati dei libri.
// Del libro vi interessa sapere: 
//    titolo, autore, genere, anno di pubblicazione, numero di pagine, 
//    casa editrice e tipo di copertina(rigida o no)
// Il compito del programma è quello di calcolare il prezzo di copertina secondo queste regole:
//  - Il costo per stampare una pagina del libro è di 0.05 euro
//  - La copertina rigida implica 3 euro di spesa in più
//  - Se l'autore è King +5.5, se è Rowling +2.1, se è Manfredi +4, se è Carrisi +6.5, per gli altri +2.5
//  - Se il genere è Horror +5.5, se è Thriller o Giallo +6.5, se è storico +2.1, se è romanzo +8, gli altri generi +1.9
//  - Se la casa editrice è rizzoli +3.5, se è mondadori +5.5, se è hoepli -0.5
//  - Se l'anno di pubblicazione è antecedente al 2000 -4.5, se è compreso tra 2000 e 2015, -2.1, se ha meno di 2 anni +0.9
//  - In ogni caso, un libro non può mai costare meno delle spese della materia prima
//  - Siamo in periodo saldi, quindi tutti i libri con un costo superiore ai 25 euro saranno scontati del 5%

// Stampare in console la scheda ordinata del libro, il suo costo totale e, se è presente, lo sconto applicato in euro

/*
         [titoloLibro] di [autore]
         Copertina: [rigida o flessibile]
         Pubblicato nel: [anno] da [casa editrice]
         [numero di pagine] pagine 
         Costo Totale: [costo del libro] 
         Applicato lo sconto del 5% -> [sconto in euro]€
         Costo Finale: [costo del libro scontato]
 */


public class Main {


	public static void main(String[] args) {

		Scanner inp = new Scanner(System.in);
		String titolo, autore, genere, casaEditrice, copertina;
		int anno, numeroPagine;


		System.out.println("\tIBS Generation\n"+ "Inserisci il titolo del libro: ");
		titolo = inp.nextLine();
		System.out.println("Inserisci l'autore: ");
		autore = inp.nextLine();
		System.out.println("Inserisci genere: ");
		genere = inp.nextLine();
		System.out.println("Inserisci anno di pubblicazione: ");
		anno = Integer.parseInt(inp.nextLine());
		System.out.println("Inserisci numero di pagine: ");
		numeroPagine = Integer.parseInt(inp.nextLine());
		System.out.println("Inserisci casa editrice: ");
		casaEditrice = inp.nextLine();
		System.out.println("Tipo di copertina (rigida o flessibile):  ");
		copertina = inp.nextLine();

		inp.close();

		double costoPagine = 0.05 * numeroPagine;
		double costoCopertina = copertina.equalsIgnoreCase("rigida") ? 3 : 0;
		double costoTotale = 0;
		double costoBase = costoPagine + costoCopertina;
		costoTotale += costoBase;

		switch(autore.toLowerCase()) {
		case "king":
			costoTotale += 5.5;
			break;
		case "rowling":
			costoTotale += 2.1;
			break;
		case "manfredi":
			costoTotale += 4;
			break;
		case "carrisi":
			costoTotale += 6.5;
			break;
		default:
			costoTotale += 2.5;
		}

		switch (genere.toLowerCase()) {
		case "horror":
			costoTotale += 5.5;
			break;
		case "thriller":
		case "giallo":
			costoTotale += 6.5;
			break;
		case "storico":
			costoTotale += 2.1;
			break;
		case "romanzo":
			costoTotale += 8;
			break;
		default:
			costoTotale += 1.9;
		}

		switch (casaEditrice.toLowerCase()) {
		case "rizzoli":
			costoTotale += 3.5;
			break;
		case "mondadori":
			costoTotale += 5.5;
			break;
		case "hoepli":
			costoTotale -=0.5;
			break;
		default:
			costoTotale += 0;
		}

		if (anno < 2000) {
			costoTotale -= 4.5;
		} else if (anno <= 2015) {
			costoTotale -=2.1;
		} else {
			costoTotale -= 0.9;
		}

		double scontoNatalizio = costoTotale > 25 ? 0.05 * costoTotale : 0;
		double costoFinale = costoTotale - scontoNatalizio;


		if(costoFinale < costoBase) {
			System.out.println("Il costo del libro non deve essere inferiore a: " + costoBase);
		}else {
			System.out.println("\t SCHEDA LIBRO\n" + 
					"Titolo: " + titolo.toUpperCase() + ";\n" + 
					"Autore: " + autore.toUpperCase() + ";\n" +
					"Copertina: " + copertina.toUpperCase()+ ";\n" +
					"Pubblicato nel: " + anno +";\n" +
					"Numero di pagine: " + numeroPagine + ";\n" +
					"Costo Totale: " + costoTotale + "$;\n");
			if(scontoNatalizio > 0) {
				System.out.println("Scontato del 5%: " + scontoNatalizio + ";$");
				System.out.println("Costo Finale: " + costoFinale + ";$");
			}
		}
		//
	}
	//
}
