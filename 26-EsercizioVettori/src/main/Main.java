package main;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	//	Scrivere un file che sia formattato nel seguente modo:
	//		nomeVideogioco (String)
	//		piattaforma (String)
	//		limite età (int)
	//		numero giocatori (int)
	//		primaPersona (boolean)
	//
	//		Leggere i dati del file e salvarli negli appositi vettori
	//		Scrivere un menu che permetta di :
	//		    
	//		Vedere tutte le schede dei videogiochi
	//		Vedere tutti i titoli sopra un limiteEta a scelta dell'utente
	//		Vedere quanti videogiochi ci sono in prima persona e quanti no
	//		Vedere il numero medio di giocatori per una piattaforma a scelta dell'utente
	//		
	//      BONUS:    
	//		Vedere il numero di giocatori medio per ogni piattaforma disponibile
	//		Vedere il numero totale di giochi per ogni limiteEta


	public static void main(String[] args) throws FileNotFoundException {

		Scanner file;
		String percorso;
		String[]giochi, piattaforma;
		int[] pegi, nGiocatori;
		boolean[] fps;

		int i, dimensione, cont =0;

		percorso = "src/res/Videogiochi.txt";

		file = new Scanner(new File (percorso));

		while(file.hasNextLine()) {
			file.nextLine();
			cont++;
		}

		cont /= 5;

		file.close();

		//		dimensione = Integer.parseInt(file.nextLine());

		giochi = new String[cont];
		piattaforma = new String[cont];
		pegi = new int[cont];
		nGiocatori = new int[cont];
		fps = new boolean [cont];

		i = 0;

		file = new Scanner(new File (percorso));

		while(file.hasNextLine()) {
			giochi[i] = file.nextLine();
			piattaforma[i] = file.nextLine();
			pegi[i] = Integer.parseInt(file.nextLine());
			nGiocatori[i] = Integer.parseInt(file.nextLine());
			fps[i] = Boolean.parseBoolean(file.nextLine());

			i++;
		}

		file.close();

		Scanner tastiera;
		String legenda;
		String cmd;
		String risposta;

		tastiera = new Scanner(System.in);
		cmd = "";
		risposta = "";
		legenda = "\n\tLEGENDA\n" 									+
				"1- Schede\n" 										+ 
				"2- Titoli sopra eta\n" 							+ 
				"3- FPS\n" 											+ 
				"4- Piattaforma\n" 									+ 
				"5- Giocatori medio per piattaforma\n" 				+
				"6- Totale giochi per ogni limite d'eta\n" 			+											
				"0- Esci\n"											;


		System.out.println("Benvenuto all'E3 ");

		do {
			System.out.println(legenda +"\n\nComando: ");
			cmd = tastiera.nextLine();
			risposta = "";

			switch(cmd) {

			case "1":
				System.out.println("\tSCHEDE");
				i = 0;

				while(i < giochi.length) {

					risposta +="\nTitolo: " + giochi[i] + "\nPiattaforma: " + piattaforma [i] +"\nPegi: " +
							pegi [i] +"\nNumero Giocatori: " + nGiocatori [i] +"\nFPS: " + fps [i] + "\n";

					i++;
				}
				if(risposta.isEmpty())
					risposta = "Nessun gioco disponibile!";

				break;

			case "2":
				System.out.println("Inserisci il pegi: ");
				int pegiCliente = Integer.parseInt(tastiera.nextLine());

				i = 0;

				while(i < giochi.length) {
					if(pegi[i] > pegiCliente) {
						risposta += " " + giochi [i];
					}
					i++;
				}
				if(risposta.isEmpty())
					risposta = "Nessun giochi corrispondente!";

				break;

			case "3":
				int conta = 0, contaNo = 0;


				i=0;

				while(i < fps.length) {

					if(fps[i]) {
						conta++;
					}else if(!fps[i]) {
						contaNo++;
					}

					i++;

				}
				risposta = "Giochi FPS: " + conta + "\nGiochi non fps: " +contaNo; 

				break;

			case "4":

				int sommaGiocatori = 0, countGiochi = 0;
				System.out.println("Inserisci la piattaforma: ");
				String piattaformaScelta = tastiera.nextLine();

				i = 0;

				while(i < piattaforma.length) {

					if(piattaforma[i].equalsIgnoreCase(piattaformaScelta)) {
						sommaGiocatori += nGiocatori[i];
						countGiochi++;
					}
					i++;
				}
				if (countGiochi > 0) {
					int mediaGiocatori = sommaGiocatori / countGiochi;
					risposta = "Numero medio di giocatori per la piattaforma " + piattaformaScelta + ": " + mediaGiocatori;
				} else {
					risposta = "Nessun videogioco trovato per la piattaforma specificata.";
				}

				break;

			case "5":

				System.out.println("Media dei giocatori per ogni piattaforma:");

				i = 0;

				while (i < piattaforma.length) {
					String piattaformaCorrente = piattaforma[i];

					if (!risposta.contains(piattaformaCorrente)) {
						int sommaGiocatoriP = 0;
						int countGiochiP = 0;

						int j = 0;

						while (j < piattaforma.length) {
							if (piattaforma[j].equalsIgnoreCase(piattaformaCorrente)) {
								sommaGiocatoriP += nGiocatori[j];
								countGiochiP++;
							}
							j++;
						}

						if (countGiochiP > 0) {
							int mediaGiocatori = sommaGiocatoriP / countGiochiP;
							risposta += "Piattaforma: " + piattaformaCorrente + ", Media Giocatori: " + mediaGiocatori + "\n";
						}
					}

					i++;
				}


				//				boolean[] piattaformeContate = new boolean[piattaforma.length];
				//				
				//				i = 0;
				//
				//				while (i < piattaforma.length) {
				//					String piattaformaCorrente = piattaforma[i];
				//
				//					
				//					boolean piattaformaGiaContata = false;
				//
				//					for(int k = 0; k < i; k++ ) {
				//						if (piattaforma[k].equalsIgnoreCase(piattaformaCorrente) && piattaformeContate[k]) {
				//							piattaformaGiaContata = true;
				//							break;
				//						}
				//						
				//					}
				//
				//					if (!piattaformaGiaContata) {
				//						piattaformeContate[i] = true;
				//
				//						int sommaGiocatoriP = 0;
				//						int countGiochiP = 0;
				//
				//						int j = 0;
				//
				//						for(j = 0; j < piattaforma.length; j ++) {
				//							if (piattaforma[j].equalsIgnoreCase(piattaformaCorrente)) {
				//								sommaGiocatoriP += nGiocatori[j];
				//								countGiochiP++;
				//							}
				//						}
				//
				//						if (countGiochiP > 0) {
				//							int mediaGiocatori = sommaGiocatoriP / countGiochiP;
				//							risposta += "Piattaforma: " + piattaformaCorrente + ", Media Giocatori: " + mediaGiocatori + "\n";
				//						}
				//					}
				//
				//					i++;
				//				}
				//				
				//				break;

			case "6":

				System.out.println("Numero totale di giochi per ogni limite di età:");

				i = 0;

				while (i < pegi.length) {
					int limiteEtaCorrente = pegi[i];

					if (!risposta.contains(String.valueOf(limiteEtaCorrente))) {
						int countGiochiEta = 0;

						int j = 0;

						while (j < pegi.length) {
							if (pegi[j] == limiteEtaCorrente) {
								countGiochiEta++;
							}
							j++;
						}

						risposta += "Limite di età: " + limiteEtaCorrente + ", Numero di giochi: " + countGiochiEta + "\n";
					}

					i++;
				}



				break;
			case "0" :
				risposta = "Arrivederci!";
				break;
			default :
				risposta = "Comando non valido";	
				break;

			}

			System.out.println(risposta);

		}while(!cmd.equals("0"));

		tastiera.close();
		System.out.println("END");


	}
}
