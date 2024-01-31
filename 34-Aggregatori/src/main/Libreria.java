package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

//Classe aggregatrice: ha il compito di fare da luogo di assembramento tra tutti gli oggetti delle
//					   nostri classi modello. Solitamente ha un nome che richiama il luogo nella 
//					   vita di tutti i giorni in cui troviamo gli elementi aggregati.

public class Libreria 
{

	//ATTRIBUTI
	Libro[] libri;


	//COSTRUTTORE
	Libreria(String path) throws FileNotFoundException
	{

		Scanner file = new Scanner(new File(path));

		libri = new Libro[Integer.parseInt(file.nextLine())];

		int i = 0;

		while(file.hasNextLine())
		{

			String[] infoRiga = file.nextLine().split(";");
			Libro l = new Libro(
					infoRiga[0],  						//Titolo
					infoRiga[1],						//Autore
					infoRiga[2],						//Genere
					infoRiga[3],						//Casa Editrice
					Integer.parseInt(infoRiga[4]),		//Numero Pagine
					Integer.parseInt(infoRiga[5]),		//Anno Pubblicazione
					infoRiga[6].equalsIgnoreCase("s")	//Prima edizione
					);


			libri[i] = l;

			i++;

		}

		file.close();

	}

	//Metodi
	String listaSchede() 
	{

		String ris = "";

		for(int i = 0; i < libri.length; i++)
			ris += libri[i].scheda();


		return ris;

	}

	String piuCari() 
	{

		double max = 0;
		String ris = "";

		for(int i = 0; i < libri.length; i++)
			if(libri[i].prezzo() > max) 
			{
				max = libri[i].prezzo();
				ris = libri[i].scheda();
			}
			else if(libri[i].prezzo()==max)
				ris += libri[i].scheda();


		return ris;

	}

	String piuLunghi() 
	{

		int max = 0;
		String ris = "";

		for (int i = 0; i < libri.length; i++) {
			if (libri[i].numeroPagine > max) {
				max = libri[i].numeroPagine;
				ris = libri[i].scheda();
			} else if (libri[i].numeroPagine == max) {
				ris += libri[i].scheda();
			}
		}

		return ris;

	}

	String autoreScelto(String autoreCercato) {
		String ris = "";

		for (int i = 0; i < libri.length; i++) {
			if (libri[i].autore.equalsIgnoreCase(autoreCercato)) {
				ris += libri[i].scheda();
			}
		}

		ris = ris.isEmpty() ? "Nessun libro trovato per l'autore: " : "\n\tLibri di " + autoreCercato + "\n" + ris ;


		return ris;
	}

	String genereScelto(String genere) 
	{

		String ris = "";
		double somma = 0;
		int conta = 0;

		for(int i = 0; i < libri.length; i++) 
			if(libri[i].genere.equalsIgnoreCase(genere)) {

				somma += libri[i].prezzo();
				conta++;
			}

		if(conta > 0)
			ris = "Il prezzo medio dei libri di genere " + genere.toUpperCase() + " è di " + (somma/conta) + "$";
		else
			ris = "Non esistono libri di genere " + genere.toUpperCase() + " in magazzino";

		return ris;

	}

	String cerca( double soldini) 
	{
		String ris = "";
		for(int i = 0; i < libri.length; i++)
			if(libri[i].prezzo() <= soldini)
				ris+= "\n-" + libri[i].titolo + ":" + (int) libri[i].prezzo() + "$";

		return ris.length() == 0 ? "Sei povero!" : "Ecco a te: " + ris;
	}
}//classe Libreria
