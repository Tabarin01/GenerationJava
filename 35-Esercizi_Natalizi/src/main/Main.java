package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args)
	{

		Scanner tastiera = new Scanner(System.in);

		String path = "src/res/Dati.txt";
		Anagrafe a = null;

		do 
		{
			try 
			{
				a = new Anagrafe(path);
				break;
			}catch(FileNotFoundException e) 
			{
				System.out.println("Percorso errato\nDigita il percoso corretto: ");
				path = tastiera.nextLine();
			}

		}while(true);

		String menu = "\n\tMENU" 							+
				"\n1-Lista completa"						+
				"\n2-Nomi dei poveracci" 					+
				"\n3-Nomi dei nababbi"  					+
				"\n4-Cerca per professione" 				+
				"\n5-Sostituisci residenza "				+
				"\n6-Nomi palindromi nel file" 				+
				"\n7-Nomi palindromi da input" 				+
				"\n0-EXIT"									;

		String cmd, ris;

		System.out.println("Benvenuto negli esercizi di natale 2023" + "\nEcco il menu: "+ menu);

		do 
		{
			ris = "";
			System.out.println("\nDigita M per il menu\nComando: ");
			cmd = tastiera.nextLine();

			switch(cmd.toLowerCase()) 
			{
			case "1":
				ris = a.listaCompleta();
				break;
			case "2":
				ris = a.poveracci();
				break;
			case "3":
				ris = a.nababbo();
				break;
			case "4":
				System.out.println("Digita una professione: ");
				String job = tastiera.nextLine();
				ris = a.cercaPer(job);
				break;
			case "5":
				System.out.println("Digita la residenza che vuoi cambiare!");
				String residenza = tastiera.nextLine();
				System.out.println("Digita la nuova residenza");
				String newResidenza = tastiera.nextLine();
				ris = a.sostituisci(residenza, newResidenza);
				break;
			case "6":
				ris = a.palindromo();
				break;
			case "7":
				System.out.println("Digita una parola per vedere se è palindroma: ");
				String nome = tastiera.nextLine();
				System.out.println(a.palindromoDue(nome));
				break;
			case "0":
				ris = "Grazie e arrivederci";
				break;
			case "m":
				ris = menu;
				break;
			default:
				ris = "Scelta non valida, riprovare!";
			}

			System.out.println(ris);

		}while(!cmd.equals("0"));

		tastiera.close();
	}//main

}//class
