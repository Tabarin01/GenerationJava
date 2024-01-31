package entites;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Classe Aggregatrice
public class Aggregatore
{
	Persona[] persone;
	
	public Aggregatore(String path) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(path));
		
		persone = new Persona[Integer.parseInt(file.nextLine())];
		
		Persona p;
		int i = 0;
		
		while(file.hasNextLine())
		{
			// Leggo la riga del file e la spezzo per avere le singole informazioni
			String[] infoFile = file.nextLine().split(";");
			
			// Coi dati ottenuti sopra costruisco un nuovo oggetto di tipo Persona
			p = new Persona(
							infoFile[0], //nome, 
							infoFile[1], //cognome, 
							infoFile[2], //dob, 
							infoFile[3], //residenza, 
							infoFile[4], //professione, 
							Integer.parseInt(infoFile[5]),  //figliACarico, 
							Double.parseDouble(infoFile[6]) //stipendio
							);
			
			// Salvo l'oggetto creato nel vettore così da averlo sempre a disposizione
			persone[i] = p;
			
			// Aumento l'indice per salvare le cose in posti diversi e non sovrascrivere sempre la stessa posizione
			i++;
		}

		file.close();
	}// Fine costruttore
	
//	- String listaCompleta()
	public String listaCompleta()
	{
		String ris = "";
		
		for(int i = 0; i < persone.length; i++)
			ris += persone[i].scheda();
		
		return ris;
	}
	
//	- String poveracci() -> Tutti coloro che non riescono a sbarcare
	public String poveracci()
	{
		String ris = "";
		
		for(int i = 0; i < persone.length; i++)
			if(!persone[i].sbarcare())
				ris += persone[i].scheda();
		
		return ris;
	}
	
//	- String nababbo() -> Tutti coloro che prendo lo stipendio più alto
	public String nababbo()
	{
		String ris = "";
		double max = 0;
		
		for(int i = 0; i < persone.length; i++)
			if(persone[i].stipendio > max)
			{
				max = persone[i].stipendio;
				ris = persone[i].scheda();
			}
			else if(persone[i].stipendio == max)
				ris += persone[i].scheda();
		
		return ris;
	}
	
//	- String cercaPer(String professione)
	public String cercaPer(String professione)
	{
		String ris = "";
		
		// FOREACH: si dice che cicla per elementi
		// Si compone da 
		//   for(TipoDiElemento nomeAlias : insiemeDaCiclare)
		// e si legge "per ogni persona p all'interno di persone"
		// Molto comodo perchè compatta di tanto la scrittura e grazie agli alias permette di accedere in modo
		// più veloce e facile alle proprietà/metodi degli oggetti.
		// Scomodo, perchè non avete il controllo del ciclo: andrà sempre dal primo elemento dell'insieme all'ultimo.
		// Scomodo anche perchè senza indice le operazioni di modifica/eliminazione dei dati nel vettore diventano impossibili
		// Solitamente come si sceglie tra un for indicizzato e un foreach:
		//  - for indicizzato: situazioni in cui volete modificare l'insieme dei dati (il vettore per capirci)
		//  - foreach : situzioni in cui vi interessa scorrere l'insieme per fare conti o ricerche
		for(Persona p : persone)
		{	
			if(p.professione.equalsIgnoreCase(professione))
				ris += p.scheda();
		}
		
		if(ris.isEmpty())
			ris = "Nessuna corrispondenza per la professione '" + professione.toUpperCase() + "'";
		
		return ris;
	}
	
//	- String sostituisci(String residenzaAbbandonata, String nuovaResidenza) -> cambierete tutte le residenze uguali a
//		residenzaAbbandanata con il valore di nuovaResidenza
	public String sostituisci(String residenzaAbbandonata, String nuovaResidenza)
	{
		String ris = "";
		
		for(Persona p : persone)
			if(p.residenza.equalsIgnoreCase(residenzaAbbandonata))
				p.residenza = nuovaResidenza;
		
		for(Persona p : persone)
			ris += p.scheda();
		
		return ris;
	}
	
}// Fine Classe