package main;


import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {


		String[] titoli;
		String[] generi;
		int[] numeroStagioni;
		int[] numeroEpisodiMedi;
		int numSerie = 0;

		try {

			Scanner file = new Scanner(new File("src/res/Serie.txt"));
			numSerie = Integer.parseInt(file.nextLine());
			titoli = new String[numSerie];
			generi = new String[numSerie];
			numeroStagioni = new int[numSerie];
			numeroEpisodiMedi = new int[numSerie];


			for (int i = 0; i < numSerie; i++) {
				String[] serieInfo = file.nextLine().split(",");
				titoli[i] = serieInfo[0];
				generi[i] = serieInfo[1];
				numeroStagioni[i] = Integer.parseInt(serieInfo[2]);
				numeroEpisodiMedi[i] = Integer.parseInt(serieInfo[3]);
			}



			Scanner tastiera = new Scanner(System.in);
			String cmd, ris = "";

			String menu = "\n\t MENU" +
					"\n0-Esci" +
					"\n1-Lista delle serie Tv coi loro dettagli" + 
					"\n2-Nome della serie con maggior numero di stagioni"+
					"\n3-Nome della serie con maggior numero di puntate a stagione"+
					"\n4-Nome della serie con il minore numero di stagioni"+
					"\n5-Nome della serie con il minore numero di puntate a stagione"+
					"\n6-Numero medio di stagioni tra tutte le serie del file"+
					"\n7-Cerca serie"+
					"\n8-Cerca per genere"+
					"\n9-Serie per genere"+
					"\n10-Titoli con episodi minori rispetto la media"+
					"\n";


			System.out.println(menu);
			do {

				ris = "";
				System.out.println("\nDigita M per il menu\nComando: ");
				cmd = tastiera.nextLine();

				switch (cmd.toLowerCase()) {

				case "1":
					System.out.println("\nLista delle serie TV coi loro dettagli:");
					ris = "";
					for (int i = 0; i < titoli.length; i++) {

						if (!ris.contains(titoli[i].toUpperCase())) {
							ris +=
									"\nTitolo: " + titoli[i].toUpperCase() +
									"\nGenere: " + generi[i].toUpperCase() +
									"\nNumero di stagioni: " + numeroStagioni[i] +
									"\nNumero di episodi medi a stagione: " + numeroEpisodiMedi[i] +
									"\n-------------------------------;";
						}
					}


					break;
				case "2":

					int stagioniMax = 0;
					for (int i = 0; i < titoli.length; i++) {

						if (!ris.contains(titoli[i].toUpperCase()))
							if (numeroStagioni[i] > numeroStagioni[stagioniMax]) {

								stagioniMax = i;
								ris = "Serie con piu' stagioni: " + titoli[stagioniMax].toUpperCase();

							}else if(numeroStagioni[i] == numeroStagioni[stagioniMax]) {

								stagioniMax = i;
								ris += ", "+ titoli[stagioniMax].toUpperCase();
							}
					}

					ris = ris.isEmpty() ? "Nessuna serie presente nel file." : ris;

					break;
				case "3":

					int episodiMax = 0;
					for (int i = 0; i < titoli.length; i++) {

						if (!ris.contains(titoli[i].toUpperCase()))
							if (numeroEpisodiMedi[i] > numeroEpisodiMedi[episodiMax]) {

								episodiMax = i;
								ris = "Serie con il maggior numero di puntate a stagione: " + titoli[episodiMax];

							}else if (numeroEpisodiMedi[i] == numeroEpisodiMedi[episodiMax]) {

								episodiMax = i;
								ris += ", " + titoli[episodiMax].toUpperCase();
							}
					}

					ris = ris.isEmpty() ? "Nessuna serie presente nel file." : ris;

					break;

				case "4":

					int stagioniMin = 0;
					for (int i = 1; i < titoli.length; i++) {

						if (!ris.contains(titoli[i].toUpperCase()))
							if (numeroStagioni[i] < numeroStagioni[stagioniMin]) {

								stagioniMin = i;
								ris = "Serie con meno stagioni: " + titoli[stagioniMin].toUpperCase();

							}else if(numeroStagioni[i] == numeroStagioni[stagioniMin]) {

								stagioniMin = i;
								ris += ", "+ titoli[stagioniMin].toUpperCase();
							}
					}

					ris = ris.isEmpty() ? "Nessuna serie presente nel file." : ris;

					break;

				case "5":

					int episodiMin = 0;
					for (int i = 1; i < titoli.length; i++) {

						if (!ris.contains(titoli[i].toUpperCase()))
							if (numeroEpisodiMedi[i] < numeroEpisodiMedi[episodiMin]) {

								episodiMin = i;
								ris = "Serie con meno episodi per stagione: " + titoli[episodiMin].toUpperCase();

							}else if(numeroEpisodiMedi[i] == numeroEpisodiMedi[episodiMin]) {

								episodiMin = i;
								ris += ", "+ titoli[episodiMin].toUpperCase();
							}
					}

					ris = ris.isEmpty() ? "Nessuna serie presente nel file." : ris;

					break;
				case "6":

					int sommaStagioni = 0;
					for (int i = 0; i < titoli.length; i++) {
						sommaStagioni += numeroStagioni[i];
					}
					double mediaStagioni = (double) sommaStagioni / titoli.length;
					ris = "Numero medio di stagioni tra tutte le serie del file: " + mediaStagioni + " episodi";


					break;
				case "7":

					System.out.println("\nInserisci il nome della serie da cercare: ");
					String serieDaCercare = tastiera.nextLine();

					for (int i = 0; i < titoli.length; i++) {

						if (titoli[i].equalsIgnoreCase(serieDaCercare)) {

							ris = "\n\tDettagli della serie:" +
									"\nTitolo: " + titoli[i].toUpperCase() +
									"\nGenere: " + generi[i].toUpperCase() +
									"\nNumero di stagioni: " + numeroStagioni[i] +
									"\nNumero di episodi medi a stagione: " + numeroEpisodiMedi[i];


							break;
						}
					}

					ris = ris.isEmpty() ? "\nSerie non presente nel file! " : ris;

					break;

				case "8":


					System.out.print("Inserisci il genere da cercare: ");
					String genereDaCercare = tastiera.nextLine();

					System.out.println("Serie nel genere '" + genereDaCercare + "':");
					for (int i = 0; i < titoli.length; i++) {

						if (!ris.contains(titoli[i].toUpperCase()))
							if (generi[i].equalsIgnoreCase(genereDaCercare)) {

								ris +="\n-" + titoli[i].toUpperCase();

							}
					}

					ris = ris.isEmpty() ? "\nGenere non presente nel file! " : ris;

					break;

				case "9":

					String elencoSenzaRipetizioni = "";

					for(int i = 0; i < generi.length; i++) {
						if (!elencoSenzaRipetizioni.toLowerCase().contains(generi[i].toLowerCase() + ";")) {
							elencoSenzaRipetizioni += generi[i] + ";";
						}
					}

					elencoSenzaRipetizioni = elencoSenzaRipetizioni.substring(0, elencoSenzaRipetizioni.length() - 1);

					String[] generiSingoli = elencoSenzaRipetizioni.split(";");

					for (int i = 0; i < generiSingoli.length; i++) {
						int conta = 0;

						for (int j = 0; j < generi.length; j++) {
							if (generiSingoli[i].equalsIgnoreCase(generi[j])) {
								conta++;
							}
						}

						ris += "Genere: " + generiSingoli[i].toUpperCase() + " " + conta + " serie\n";
					}

					ris = ris.isEmpty() ? "\nNessun genere presente nel file! " : ris;
					break;

				case "10":

					System.out.println("\n\t Titoli con episodi minori rispetto la media ");
					double mediaTotaleEpisodi = 0;
					for (int i = 0; i < titoli.length; i++) {
						mediaTotaleEpisodi += numeroStagioni[i] * numeroEpisodiMedi[i];
					}
					mediaTotaleEpisodi = titoli.length > 0 ? mediaTotaleEpisodi/= titoli.length : 0;

					for (int i = 0; i < titoli.length; i++) {
						if (!ris.contains(titoli[i].toUpperCase()))
							if ((numeroStagioni[i] * numeroEpisodiMedi[i]) < mediaTotaleEpisodi) {
								ris +="\n -" + titoli[i].toUpperCase();
							}
					}

					ris = ris.isEmpty() ? "\nNessun episodio presente nel file! " : ris;

					break;

				case "m":

					System.out.println(menu);
					break;

				case "0":

					System.out.println("Fine programma.");
					break;

				default:
					System.out.println("Scelta non valida. Riprova.");

				}

				System.out.println(ris);

			} while (!cmd.equals("0"));

			tastiera.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

		}
	}
}

