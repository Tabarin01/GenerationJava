package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {


		// Leggere da un file le informazioni riguardanti alcuni film proiettati al cinema
		// I dati saranno: titolo, genere, durata(minuti), annoUscita, vietatoMinori(bool)
		// Scrivere un menù che permetta all'utente le seguenti scelte:
		// - Schede complete dei singoli film
		// - Il titolo dei film antecedenti al 1992
		// - Il numero di film vietati ai minori
		// - Il titolo del film più lungo (o dei film)
		// - La durata media dei film di genere Azione



		Scanner tastiera, 
		file;

		String  titolo,
		genere,
		risposta, 
		legenda,
		cmd = "";

		int durata,
		annoUscita,
		cont = 0,
		contMinori = 0,
		durataMassima = Integer.MIN_VALUE;

		boolean vietatoMinori;


		file = new Scanner(new File("src/res/Film.txt"));
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
		
		System.out.println(legenda);

		while(!cmd.equals("0")) {

			cmd = tastiera.nextLine();

			while(file.hasNextLine()) {

				titolo = file.nextLine();
				genere = file.nextLine();
				durata = Integer.parseInt(file.nextLine());
				annoUscita = Integer.parseInt(file.nextLine());
				vietatoMinori = Boolean.parseBoolean(file.nextLine());

				switch(cmd) {

				case "0":
					risposta += "Arrivederci e grazie!";
					break;
				case "1":

					risposta += "\tSCHEDA FILM n." 
							+  cont                                      + "\n" 
							+ "Titolo: "    + titolo                     + "\n"
							+ "Genere: "    + genere                     + "\n"
							+ "Durata: "    + durata                     + " minuti\n"
							+ "Anno: "      + annoUscita                 + "\n"
							+ (vietatoMinori ? "Vietato ai minori" : "") + 
							"\n-------------------\n";


					if(risposta.isEmpty())
						risposta = "Nessuna corrispondenza trovata";
					
					cont++;

					break;

				case "2":

					if(annoUscita < 1992) {

						risposta += titolo + ", "; 

					}
					risposta.substring(2, risposta.length()-2);

					if(risposta.isEmpty())
						risposta = "Nessuna corrispondenza trovata";

					break;
				case "3":

					contMinori += vietatoMinori ? 1 : 0;

					risposta += "" + contMinori;

					if(risposta.isEmpty())
						risposta = "Nessuna corrispondenza trovata";

					break;
				case "4":

					if(durata > durataMassima) {

						durataMassima = durata;
						risposta = titolo;

					}else if(durata == durataMassima) {
						durataMassima = durata;
						risposta += ", "+ titolo;
					}

					if(risposta.isEmpty())
						risposta = "Nessuna corrispondenza trovata";

					break;
				case "5":


					if(risposta.isEmpty())
						risposta = "Nessuna corrispondenza trovata";
					break;


				}
				

				System.out.println(risposta + "\n"+ legenda);


			}

			
		}




	}

}
