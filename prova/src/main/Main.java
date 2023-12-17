package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		//D
		Scanner file;
		String destinazione;
		String mezzoTrasporto;
		int giorniVacanza;
		double costoGiornaliero;
		int numeroPersone;
		double prezzoBase;
		double prezzoTotale;
		
		double dubaiTokyo;
		double dublinoLondra;
		double newYorkMiami;
		double altraDestinazione;
		
		double aereoTraghetto;
		double treno;
		double autoPullman;
		double altriMezzi;
		
		double sconto5;
		double sconto10;
		
		String risposta;
		String percorsoLocale;
		
		String listaDestinazioni;
		String listaMezziTrasporto;
		
		int contatoreAereo;
		double prezzoAereo;
		double mediaAereo;
		int contatoreDubai;
		double prezzoDubai;
		double mediaDubai;
		
		double minorCosto;
		String viaggioEconomico;
		
		double maggiorCosto;
		String viaggioCostoso;
		
		percorsoLocale = "src/res/Viaggi.txt";
		prezzoBase = 100;
		dubaiTokyo = 200;
		dublinoLondra = 150;
		prezzoTotale = 0;
		altraDestinazione = 50;
		newYorkMiami = 300;
		
		aereoTraghetto = 500;
		treno = 200;
		autoPullman = 100;
		altriMezzi = 1000;
		sconto5 = 5;
		sconto10 = 10;
		
		listaDestinazioni = "";
		listaMezziTrasporto = "";
		
		contatoreAereo = 0;
		prezzoAereo = 0;
		mediaAereo = 0;
		
		contatoreDubai = 0;
		prezzoDubai = 0;
		mediaDubai = 0;
		
		minorCosto = Integer.MAX_VALUE;
		viaggioEconomico = "";
		
		maggiorCosto = Integer.MIN_VALUE;
		viaggioCostoso = "";
		
		file = new Scanner(new File(percorsoLocale));
		risposta ="";
		
		while(file.hasNextLine())
		{
			destinazione = file.nextLine();
			mezzoTrasporto = file.nextLine();
			giorniVacanza = Integer.parseInt(file.nextLine());
			costoGiornaliero = Double.parseDouble(file.nextLine());
			numeroPersone = Integer.parseInt(file.nextLine());
			
			switch(destinazione.toLowerCase())
			{
			case "dubai":
			case "tokyo":
				prezzoTotale += prezzoBase + dubaiTokyo;
				break;
			case "dublino":
			case "londra":
				prezzoTotale += prezzoBase + dublinoLondra;
				break;
			case "new york":
			case "miami":
				prezzoTotale += prezzoBase + newYorkMiami;
				break;
			default :
				prezzoTotale += prezzoBase + altraDestinazione;
				break;
			}
			
			switch(mezzoTrasporto.toLowerCase())
			{
			case "aereo":
			case "traghetto":
				prezzoTotale += aereoTraghetto;
				break;
			case "treno":
				prezzoTotale += treno;
				break;
			case "auto":
			case "pullman":
				prezzoTotale += autoPullman;
				break;
			default:
				prezzoTotale += altriMezzi;
				break;
			}
			
			if(numeroPersone > 5)
			{
				prezzoTotale -= (prezzoTotale * sconto5 /100);
			}
			else if(numeroPersone > 10)
			{
				prezzoTotale -= (prezzoTotale * sconto10 /100);
			}
			
			
		
			risposta += "\t\nSCHEDA VIAGGIO:" + 
						"\nDestinazione: "  + destinazione +
						"\nMezzo di trasporto: " + mezzoTrasporto +
						"\nGiorni di vacanza: " + giorniVacanza +
						"\nCosto Giornaliero: " + costoGiornaliero +
						"\nNumero Persone: " + numeroPersone +
						"\nTotale Viaggio: " + prezzoTotale+
						"\n---------------------------------\n";
		
			
			if(listaDestinazioni.contains(destinazione)== false)
			{
				listaDestinazioni += "- " + destinazione + "\n";
			}
			
			if(listaMezziTrasporto.contains(mezzoTrasporto)== false)
			{
				listaMezziTrasporto += "- " + mezzoTrasporto + "\n";
			}
			
			contatoreAereo += mezzoTrasporto.equalsIgnoreCase("aereo") ? 1 : 0;
			prezzoAereo += mezzoTrasporto.equalsIgnoreCase("aereo") ? prezzoTotale : 0;
			contatoreDubai += destinazione.equalsIgnoreCase("dubai") ? 1 : 0;
			prezzoDubai += destinazione.equalsIgnoreCase("dubai") ? prezzoTotale : 0;
			
			if(minorCosto > prezzoTotale)
			{
				minorCosto = prezzoTotale;
				viaggioEconomico = "\t\nVIAGGIO PIU ECONOMICO:" + 
						"\nDestinazione: "  + destinazione +
						"\nMezzo di trasporto: " + mezzoTrasporto +
						"\nGiorni di vacanza: " + giorniVacanza +
						"\nCosto Giornaliero: " + costoGiornaliero +
						"\nNumero Persone: " + numeroPersone +
						"\nTotale Viaggio: " + prezzoTotale+
						"\n";
			}
			else if(minorCosto == prezzoTotale)
			{
				viaggioEconomico += "\nDestinazione: "  + destinazione +
									"\nMezzo di trasporto: " + mezzoTrasporto +
									"\nGiorni di vacanza: " + giorniVacanza +
									"\nCosto Giornaliero: " + costoGiornaliero +
									"\nNumero Persone: " + numeroPersone +
									"\nTotale Viaggio: " + prezzoTotale+
									"\n";
			}
			
			if(maggiorCosto < prezzoTotale)
			{
				maggiorCosto = prezzoTotale;
				viaggioCostoso = "\t\nVIAGGIO COSTOSO:" + 
						"\nDestinazione: "  + destinazione +
						"\nMezzo di trasporto: " + mezzoTrasporto +
						"\nGiorni di vacanza: " + giorniVacanza +
						"\nCosto Giornaliero: " + costoGiornaliero +
						"\nNumero Persone: " + numeroPersone +
						"\nTotale Viaggio: " + prezzoTotale+
						"\n";
			}
			else if(maggiorCosto == prezzoTotale)
			{
				viaggioCostoso += "\nDestinazione: "  + destinazione +
									"\nMezzo di trasporto: " + mezzoTrasporto +
									"\nGiorni di vacanza: " + giorniVacanza +
									"\nCosto Giornaliero: " + costoGiornaliero +
									"\nNumero Persone: " + numeroPersone +
									"\nTotale Viaggio: " + prezzoTotale+
									"\n";
			}
		
		}//fine while

		file.close();
		mediaAereo = prezzoAereo / contatoreAereo;
		mediaDubai = prezzoDubai / contatoreDubai;
		risposta += "\t\nLista destinazioni:\n" + listaDestinazioni + "\n---------------------------------\n" +
					"\t\nLista Mezzi :\n" + listaMezziTrasporto + "\n---------------------------------\n" +
					"\t\nPrezzo Medio Aereo: " + mediaAereo + "\n" +
					"\t\nPrezzo Medio Dubai: " + mediaDubai + "\n";
		
		
		System.out.println(risposta + viaggioEconomico + viaggioCostoso);
	}//DO NOT TOUCH

}
