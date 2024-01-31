package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		//Lettura file
		Scanner file = new Scanner(new File("src/res/Dati.txt"));

		Cliente[] clienti = new Cliente[Integer.parseInt(file.nextLine())];

		int indice = 0;
		while(file.hasNextLine()) {

			String[] info = file.nextLine().split(";");

			Cliente c = new Cliente(
					info[0],
					info[1],
					info[2],
					info[3],
					info[4],
					info[5].equalsIgnoreCase("s")
					);


			//Così valorizziamo una proprietà alla volta, che va bene!
			//Ma siamo anche più soggetti a perderci dei pezzi.
			//Per evitare questi problemi, i programmatori si sono inventati una soluzione
			//che viene chiamata COSTRUTTORE
			//Questa soluzione va implementata (cioè scritta) nella classe, quindi andiamo a farlo

			//c.nome = info[0];	
			//c.cognome = info[1];
			//c.dob = info[2];
			//c.pT = info[3];
			//c.obiettivo = info[4];
			//c.abbonamento = info[5].equalsIgnoreCase("S");

			clienti[indice] = c;

			indice++;
		}

		file.close();
		//---------------------------------------------------------------
		space();
		//Proviamo a stampare in console i nostri oggetti
		for(int i = 0; i < clienti.length; i++) 
			System.out.println(clienti[i].scheda());

		// Scheda della persona più giovane

		int minEta = Integer.MAX_VALUE;
		String ris = "";
		System.out.println("\n\tScheda dell* person* più giovan*\n ");
		for (int i = 0; i < clienti.length; i++) {
			if (clienti[i].eta() < minEta) {
				minEta = clienti[i].eta();
				ris = clienti[i].scheda();
			}else if(clienti[i].eta() == minEta) {
				ris += clienti[i].scheda();
			}
		}
		System.out.println(ris);


		// Voglio vedere i nominativi dei clienti di un personal trainer a scelta dell'utente
		space();
		ris = "";
		Scanner tastiera = new Scanner(System.in);
		System.out.println("\nDigita il nome di un personal trainer");
		String cerca = tastiera.nextLine();

		for(int i = 0; i < clienti.length; i++) {
			if(cerca.equalsIgnoreCase(clienti[i].pT)) {
				ris += "\n-" + clienti[i].nome + " " + clienti[i].cognome + ",";
			}
		}

		System.out.println(ris.substring(0,ris.length()-1));

		tastiera.close();

		// Voglio vedere la persona più vecchia con un abbonamento
		space();
		ris = "";
		int maxEta = 0;

		for(int i = 0; i < clienti.length; i++) {

			if(clienti[i].eta() > maxEta && clienti[i].abbonamento) {
				maxEta = clienti[i].eta();
				ris = clienti[i].nome + " " + clienti[i].cognome + " ";


			}else if(clienti[i].eta() == maxEta && clienti[i].abbonamento) {
				maxEta = clienti[i].eta();
				ris += "\n" + clienti[i].nome + " "+ clienti[i].cognome + " ";
			}

		}
		System.out.println("La persona più vecchia con un abbonamento è: " + ris);



	}//main

	private static void space() {
		System.out.println("\n//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\n");
	}
}//classe
