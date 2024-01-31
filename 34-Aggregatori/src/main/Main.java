package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{

		Scanner tastiera = new Scanner(System.in);

		/*
		 Scritto così ci fidiamo che il percorso funzioni, ma le cose non sempre vanno

		 Mi comporto come nel modo seguente nel caso in cui volessi tenere in conto
		 degli imprevisti legati al file dei dati(viene spostato, viene rinominato...

		 GESTIONE DELLE ECCEZIONI: significa gestire bene gli errori che possiamo incontrare
		 */
		Libreria l = null;
		String path = "src/ris/Dati.txt";

		do {


			try 
			{
				// Come dice il nome, qui "tento" l'esecuzione delle righe di codice che so
				// possono dare vita a eccezioni
				l = new Libreria(path);
				break;


			}catch(FileNotFoundException e) 
			{
				// Ha il compito di "catturare" l'eccezione prima che questa possa far crashare il programma
				// Inoltre offre un percorso alternativo a quello che ha portato all'errore
				System.out.println("Percorso errato\n Digita il percorso corretto (es. src/res/File.txt)");
				path = tastiera.nextLine();

			}
			//catch(Exception ex)
			//{
			// Possiamo mettere tutti i catch che vogliamo basta che siano in ordine dal più specifico al più generico!
			//}

			//	finally                       FACOLTATIVO OCCHIO AD USARLO
			//	{
			// è facoltativo!!
			// Viene eseguito SEMPRE, sia che le cose vadano bene, sia che le cose vadano male
			// Ha una prorità così alta che blocca addirittura il crash dell'appllicazione
			//	}


		}while(true);


		//	Libreria l = new Libreria("src/res/Dati.txt");  commentato per introdurre le eccezioni



		String menu = "\n\tLEGENDA" 					+
				"\n1-Lista dei libri"					+
				"\n2-Libri più cari" 					+
				"\n3-Libri più lunghi"  				+
				"\n4-Libri di un autore a scelta" 		+
				"\n5-Prezzo Medio per un genere a scelta";

		String cmd, ris;


		System.out.println("Benventuo nella mia libreria!"+
				"\nEcco il menu: " 			 			  + 
				menu);

		do 
		{

			ris = "";

			System.out.println("\nDigita M per il menu\nComando: ");
			cmd = tastiera.nextLine();

			switch(cmd) 
			{

			case "1":
				ris = "\n\tLISTA DEI LIBRI" + l.listaSchede();
				break;

			case "2":
				ris = "\n\tLIBRI COSTOSI\n" + l.piuCari();
				break;

			case "3":
				ris = "\n\tLIBRI LUNGHI\n" + l.piuLunghi();
				break;

			case "4":
				String sceltaAutore;
				System.out.println("Digita il nome di un autore: ");
				sceltaAutore = tastiera.nextLine();

				ris = l.autoreScelto(sceltaAutore.toUpperCase());
				break;

			case "5":
				System.out.println("Che genere ti interessa?");
				String genere = tastiera.nextLine();

				ris = l.genereScelto(genere);
				break;
			case "6":
				double convertInDouble;

				do 
				{
					System.out.println("Quanto puoi svenarti?");
					String valore = tastiera.nextLine();

					try 
					{
						convertInDouble = Double.parseDouble(valore);
						break;
					}
					catch(NumberFormatException e) 
					{
						System.out.println("Scelta errata, inserisci un numero!");
					}
				}while(true);

				ris = l.cerca(convertInDouble);
				break;

			case "0":
				ris = "Fine programma!";
				break;

			default:
				ris = "Comando non valido";

			}

			System.out.println(ris);

		}while(!cmd.equals("0"));

		tastiera.close();
		System.out.println("GoodBye!");


	}//main

}//classe di avvio
