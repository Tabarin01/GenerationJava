package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args)
	{

		Scanner tastiera = new Scanner(System.in);



		String path = "src/res/Dati.txt";
		Ospedale o = null;

		do 
		{
			try 
			{
				o = new Ospedale(path,tastiera);
				break;

			}catch(FileNotFoundException e) 
			{
				System.out.println("Percorso errato\nDigita il percoso corretto: ");
				path = tastiera.nextLine();
			}
		}while(true);


		String menu = "\n\tMENU" 							+
				"\n1-Lista dei pazienti"					+
				"\n2-Lista dei medici" 						+
				"\n3-Lista completa medici pazienti"  		+
				"\n4-Medici Killer" 						+
				"\n5-Cerca per nome e cognome "				+
				"\n6-Cerca per patologia" 					+
				"\n7-Pazienti a rischio zombificazione"		+
				"\n8-Statistiche pazienti"					+
				"\n0-EXIT"									;

		String cmd, ris;

		System.out.println("Benventuo nell'Ospedale Generation!"+
				"\nEcco il menu: " 			 			  + 
				menu);

		do 
		{
			ris = "";
			System.out.println("\nDigita M per il menu\nComando: ");
			cmd = tastiera.nextLine();

			switch(cmd.toLowerCase()) 
			{
			case "1":
				ris = o.listaPazienti();
				break;
			case "2":
				ris = o.listaMedici();
				break;
			case "3":
				ris = o.listaTotale();
				break;
			case "4":
				ris = o.nomiKiller();
				break;
			case "5":
				System.out.println("\nInserisci il NOME: ");
				String nomeScelto = tastiera.nextLine();
				System.out.println("\nInserisci il COGNOME: ");
				String cognomeScelto = tastiera.nextLine();
				ris = o.cerca(nomeScelto, cognomeScelto);
				break;
			case "6":
				String patologia;
				System.out.println("Inserisci la patologia: ");
				patologia = tastiera.nextLine();
				ris = o.cerca(patologia);
				break;
			case "7":
				ris = o.rischiosi();
				break;
			case "8":
				ris = o.statistichePazienti();
				break;
			case "0":
				ris = "Grazie e arrivederci!";
				break;
			case "m": 
				ris = menu;
				break;
			default:
				ris = "Scelta non valida, riprovare!";
			}

			System.out.println(ris);

		}while(!cmd.equalsIgnoreCase("0"));

		tastiera.close();
	}

}
