package main;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Leggere da un file le informazioni riguardanti alcuni film proiettati al cinema
		// I dati saranno: titolo, genere, durata(minuti), annoUscita, vietatoMinori(bool)
		// Scrivere un menù che permetta all'utente le seguenti scelte:
		// - Schede complete dei singoli film
		// - Il titolo dei film antecedenti al 1992
		// - Il numero di film vietati ai minori
		// - Il titolo del film più lungo (o dei film)
		// - La durata media dei film di genere Azione

		Scanner file;
		Scanner tastiera;
		String risposta,
		legenda,
		cmd,
		titolo,
		genere;
		int durata,
		annoUscita,
		cont,
		contMinori,
		durataMassima = Integer.MIN_VALUE,
		durataTotaleAzione = 0,
		contAzione = 0;
		boolean vietatoMinori;


		tastiera = new Scanner(System.in);

		risposta = "";
		legenda = 	
				"\n\tMENU\n" 									+
						"\n1 > Schede complete dei singoli film" 		+
						"\n2 > Titoli antecedenti al 1992" 				+
						"\n3 > Numero film vietati ai minori" 			+
						"\n4 > Film maggior durata" 					+
						"\n5 > Durata media film d'azione" 				+
						"\n0 > Esci"									;


		System.out.println("Benvenut* nel cineraccolta!");

		try {

			do {
				cont = 0;
				contMinori = 0;

				System.out.println("\n"+ legenda);
				cmd = tastiera.nextLine();

				risposta = "";

				file = new Scanner(new File("src/res/Film.txt"));

				while(file.hasNextLine()) {

					titolo = file.nextLine();
					genere = file.nextLine();
					durata = Integer.parseInt(file.nextLine());
					annoUscita = Integer.parseInt(file.nextLine());
					vietatoMinori = Boolean.parseBoolean(file.nextLine());

					cont++;


					switch(cmd) {

					case "1":

						risposta += "\tSCHEDA FILM n." 
								 + cont                                       + "\n" 
								 + "Titolo: "    + titolo                     + "\n"
								 + "Genere: "    + genere                     + "\n"
								 + "Durata: "    + durata                     + " minuti\n"
								 + "Anno: "      + annoUscita                 + "\n"
								 + (vietatoMinori ? "Vietato ai minori" : "") + 
								 "\n-------------------\n";


						if(risposta.isEmpty())
							risposta = "Nessuna corrispondenza trovata";

						break;

					case "2":

						if(annoUscita < 1992) {

							risposta += titolo + "\n"; 

						}
						risposta.substring(2, risposta.length()-2);

						if(risposta.isEmpty())
							risposta = "Nessuna corrispondenza trovata";

						break;
					case "3":

						contMinori += vietatoMinori ? 1 : 0;

						risposta = "Numero film vietati ai minori: " + contMinori;

						if(risposta.isEmpty())
							risposta = "Nessuna corrispondenza trovata";

						break;
					case "4":

						if(durata > durataMassima) {

							durataMassima = durata;
							risposta = "Film di maggior durata: " + titolo;

						}else if(durata == durataMassima) {
							durataMassima = durata;
							risposta += ", "+ titolo;
						}

						if(risposta.isEmpty())
							risposta = "Nessuna corrispondenza trovata";

						break;

					case "5":

						if(genere.equalsIgnoreCase("azione")) {
							durataTotaleAzione += durata;
							contAzione++;
						}

						if(risposta.isEmpty())
							risposta = "Nessuna corrispondenza trovata";
						break;

					case "0" :
						risposta = "Arrivederci!";
						break;
					default :
						risposta = "Comando inesistente";

					}
				}

				if(cmd.equals("5") && contAzione > 0) {
					int durataMediaAzione = durataTotaleAzione / contAzione; 
					risposta = "Durata media film d'azione: " + durataMediaAzione;
				}else if(cmd.equals("5") && contAzione == 0) {
					risposta = "Nessun film di genere d'Azione trovato!";
				}

				System.out.println(risposta);

			}while(!cmd.equalsIgnoreCase("0"));

			tastiera.close();
			System.out.println("END");

		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
