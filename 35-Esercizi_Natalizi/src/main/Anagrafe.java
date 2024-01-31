package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Anagrafe {

	Persona[] persone;


	Anagrafe(String path) throws FileNotFoundException
	{

		Scanner file = new Scanner(new File(path));

		persone = new Persona[Integer.parseInt(file.nextLine())];

		for(int i = 0; file.hasNextLine(); i++) 
		{
			String[] infoRiga = file.nextLine().split(";");

			Persona p = new Persona(
					infoRiga[0],
					infoRiga[1],
					infoRiga[2],
					infoRiga[3],
					infoRiga[4],
					Integer.parseInt(infoRiga[5]),
					Double.parseDouble(infoRiga[6]));

			persone[i] = p;
		}

		file.close();

	}
	// Lista completa di tutti i dati
	String listaCompleta() 
	{
		String ris ="";
		for(int i = 0; i < persone.length; i++)
			ris += persone[i].scheda();

		return ris.isEmpty() ? "Nessuna persona trovata" : "\n\t\t\tLista completa!\n"+ intestazionePersone() + ris;
	}

	// Metodo che restituisce le persone che non arrivano a fine mese
	String poveracci() {
	    String ris = "";
	    
	    for (int i = 0; i < persone.length; i++) {
	        
	        if (!persone[i].sbarcare()) {
	            ris += persone[i].nome + " " + persone[i].cognome + ", ";
	        }
	    }

	    return ris.isEmpty() ? "Nessun risultato trovato" : "\nPoveracci: \n\n" + ris.substring(0,ris.length()-2);
	}

	//	- String nababbo() -> Tutti coloro che prendono lo stipendio più alto
	String nababbo() 
	{
		String ris = "";
		double stipendioMax = 0;
		String personeIncluse = "";

		for (int i = 0; i < persone.length; i++) 
		{
			String persona = persone[i].nome + " " + persone[i].cognome + " (" + persone[i].dob + ")";

			if (persone[i].stipendio > stipendioMax) 
			{
				stipendioMax = persone[i].stipendio;
				ris = "- " + persona + ", ";
				personeIncluse = persona;

			} else if (persone[i].stipendio == stipendioMax 
					&& !personeIncluse.contains(persona)) 
			{
				ris += persona + ", ";
				personeIncluse += persona;
			}
		}

		return ris.isEmpty() ? "Nessun risultato trovato" : "\nI Nababbi con lo stipendio più alto:\n\n" + ris.substring(0,ris.length()-2);
	}

	String cercaPer(String professione) 
	{
		String ris = "";

		for(int i = 0; i < persone.length; i++) 
		{
			if(persone[i].professione.equalsIgnoreCase(professione))
				ris += " - " + persone[i].nome + " " + persone[i].cognome + "\n";
		}

		return ris = ris.isEmpty() ? "Nessuna persona che svolge la professione selezionata" : "Riscontri trovati per " + professione.toUpperCase() + ": \n\n" + ris;

	}

	String sostituisci(String residenzaAbbandonata, String nuovaResidenza) 
	{
		String ris = "";
		boolean residenza = false;

		for(int i = 0; i < persone.length; i++) 
		{
			if(persone[i].residenza.equalsIgnoreCase(residenzaAbbandonata)) 
			{
				persone[i].residenza = nuovaResidenza;
				ris+= persone[i].scheda();
				residenza = true;
			}
			
		}

		return ris.isEmpty() && residenza == false ? "Residenza non trovata" : "\n\t\t\tNuove residenze!\n"+ intestazionePersone() + ris;

	}
	
	String palindromoDue(String name){
		
		String ris = "", temp = "";
		
		for(int i = name.length()-1; i>=0; i--) 
		{
			temp += name.charAt(i);
		}
		
		ris = name.equalsIgnoreCase(temp) ? "-" + name.toUpperCase() + " è palindromo" : "-" + name.toUpperCase() + " non è palindromo";
		
		return (ris.isEmpty() || name.isEmpty()) ? "Non hai inserito nulla" : ris;
	}
	
	String palindromo() {
		String ris = "";

		for (int i = 0; i < persone.length; i++) {
		    boolean isPalindromo = true;

		    for (int j = 0; j < persone[i].nome.length() / 2; j++) {
		        if (persone[i].nome.toLowerCase().charAt(j) != persone[i].nome.toLowerCase().charAt(persone[i].nome.length() - 1 - j)) {
		            isPalindromo = false;
		            break;
		        }
		    }

		    if (isPalindromo && !ris.contains(persone[i].nome.toUpperCase())) {
		        ris += persone[i].nome.toUpperCase() + ", ";
		    }
		}

	    return ris.isEmpty() ? "Ops qualcosa è andato storto" : "\nNomi palindromi: \n" + ris.substring(0,ris.length()-2);
	}

	
	String intestazionePersone()
	{
		return 	"+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+\n" +
				"| Nome         | Cognome      | Data di nascita | Residenza    | Professione  | Figli a carico     | Stipendio   |\n" +
				"+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+\n" ;
	}

}
