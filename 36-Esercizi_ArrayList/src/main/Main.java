package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		/*
        CONSEGNA
1) Scrivere un programma che chieda all'utente di inserire dei numeri: quando l'uente scrive 0, 
    stampare in console: la somma dei pari, la lista dei multipli di 7, il numero più presente scritto
    (usate gli arraylist!!)
2) Leggere da un file una serie di nomi, salvarli in un AL e poi: stampare il nome più lungo,
    il nome con più vocali presenti, cancellare tutti i nomi che iniziano per G 
3) Riempire un AL con numeri generati casualmente tra 1 e 10 compresi finchè la loro somma non supera 40,
    poi stampare: elenco dei numeri, il numero dei pari, il numero dei diapari, cancellare i numeri 
    multipli di 3, modificare tutti i numeri 9 con il numero 0
		 */
		
		// Esercizio 2
		ArrayList<String> nomi;

		Scanner file = null;
		String path = "src/res/Nomi.txt";
		Scanner tastiera = new Scanner(System.in);

		do 
		{
			try 
			{
				file = new Scanner(new File(path));
				nomi = new ArrayList<String>();

				break;

			}catch(FileNotFoundException e)
			{
				System.out.println("File non trovato nel percorso " + path + "\nDigita un nuovo percorso:");
				path = tastiera.nextLine();
			}
		}while(true);

		tastiera.close();


		while(file.hasNextLine())
		{
			String[] info = file.nextLine().split(",");
			for(String s: info)
				nomi.add(s);
		}

		System.out.println("\nNomi lunghi: " + nomiMax(nomi));
		System.out.println("\nNomi con piu' vocali: "+ nomiVocali(nomi));

		ArrayList<String> nomiCopia = (ArrayList<String>) nomi.clone();

		System.out.println("\nNomi originali: "+ nomi + "\nNomi dopo cancellazione: " + nomiDopoCancellazione(nomiCopia));


	}//main

	public static String nomiMax(ArrayList<String> nomi) 
	{
		int max = 0;
		String nomeMax = "";

		for(String e : nomi) 
		{
			if(e.length() > max)
			{
				max = e.length();
				nomeMax = e;
			}
			else if(e.length()==max)
			{
				nomeMax += ", " + e;
			}
		}
		return nomeMax;
	}

	public static String nomiVocali(ArrayList<String> nomi) 
	{
		String ris = "";
		int max = 0;
		int conta;
		for(int i = 0; i<nomi.size(); i++) 
		{
			conta = 0;
			String[] lettereNome = nomi.get(i).split("");

			for(String e : lettereNome) 
			{
				if(e.equalsIgnoreCase("a") || 
						e.equalsIgnoreCase("e") ||
						e.equalsIgnoreCase("i") || 
						e.equalsIgnoreCase("o") || 
						e.equalsIgnoreCase("u")) 
				{
					conta++;
				}
			}
			if(conta > max)
			{
				max = conta;
				ris = nomi.get(i);
			}
			else if(max == conta) 
			{
				ris += ", " + nomi.get(i);
			}
		}
		return ris;
	}

	public static String nomiDopoCancellazione(ArrayList<String> nomi) 
	{
		String ris= "";

		for(int i = nomi.size()-1; i > 0;i--) 
		{
			boolean cancellato = false;
			if(nomi.get(i).toLowerCase().startsWith("l")) 
			{
				nomi.remove(i);
				cancellato = true;
			}
			if(!cancellato)
				ris += nomi.get(i) + ", ";
		}

		return ris.isEmpty() ? "Errore risposta vuota" : ris.substring(0,ris.length()-2);
	}
}//class
