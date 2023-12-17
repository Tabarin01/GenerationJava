package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File("src/res/Dati.txt"));
		String[] citta;

		// Modo valido se c'� UN SOLO vettore da popolare. 
		// Se i vettori sono 2 o pi� bisogna per forza usare la variabile di appoggio dimensione
		citta = new String[Integer.parseInt(file.nextLine())];

		int posizione = 0;

		while(file.hasNextLine())
		{
			citta[posizione] = file.nextLine();
			posizione++;
		}

		file.close();

		// STEP 1: Devo riuscire ad avere un campione di valori senza doppioni
		String elencoSenzaRipetizioni = "";

		for(int i = 0; i < citta.length; i++)
			if(!elencoSenzaRipetizioni.toLowerCase().contains(citta[i].toLowerCase() + ";"))
				elencoSenzaRipetizioni += citta[i] + ";";

		elencoSenzaRipetizioni = elencoSenzaRipetizioni.substring(0,elencoSenzaRipetizioni.length()-1);

		System.out.println(elencoSenzaRipetizioni + "\n");

		// STEP 2: Devo spezzare la stringa per ottenere le singole citt� senza ripetizioni
		String[] cittaSingole = elencoSenzaRipetizioni.split(";");

		// STEP 3: Conto quante volte una solo citt� si presenta nell'elenco completo di doppioni

		String ris = "";
		for(int i  = 0; i< cittaSingole.length; i++) {

			//Questo ciclo mi serve per vedere una citta senza doppioni alla volta

			//Coi numeri, questo vuol dire che:
			//i = 0; -> cittaSingole[0] -> "Milano"
			int conta = 0;

			for(int j = 0; j < citta.length; j++) {
				
				//Questo ciclo mi serve per vedere tutte le citta del file
				//Coi numeri, questo significa che: 
				//j =0; -> citta[0] -> "Milano"
				//j = 1; -> citta[1]-> "Milano"
				//j = 2; -> citta[2] -> "Roma"
				//j = 3; -> citta[3] -> "Napoli"
				//cosi via fino all'ultima posizione del vettore

				if(cittaSingole[i].equalsIgnoreCase(citta[j])) {

					//Qui dentro confronto il mio singolo con i dati del file
					//Coi numeri, significa che:
					//i = 0; j = 0; cittaSingole[0] e citta [0] -> "Milano" ? se si aggiungo 1,
					//												altrimenti ignoro e passo 
					//                                              alla j succesiva

					// i = 0; j = 0; cittaSingole [0] e citta [0] -> "Milano" = "Milano"? se si aggiungo 1 altrimenti ignoro e passo alla j successiva
					
					// i = 0; j = 0; cittaSingole [0] e citta [1] -> "Milano" = "Milano"? se si aggiungo 1 altrimenti ignoro e passo alla j successiva
					
					conta++;
	
				}

			}

			ris += "Citta: " + cittaSingole[i].toUpperCase() + " si presenta " + conta + "\n";

		}

		System.out.println(ris);
	}

}