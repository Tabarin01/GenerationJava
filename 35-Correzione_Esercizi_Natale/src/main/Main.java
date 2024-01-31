package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entites.Aggregatore;

// Classe di avvio
public class Main
{
	public static void main(String[] args)
	{
//		In un file dati scrivere i dettagli anagrafici di un gruppo di persone
//		nome, cognome, dob, residenza (citt�), professione, figliACarico, stipendio
//		Scrivere la classe modello Persona con le propriet�, il costruttore,
//		e i metodi:
//		scheda(),
//		int eta(),
//		boolean sbarcare() -> sottrae 100 euro per ogni figlio a carico dallo stipendio.
//			Per vivere a Milano si pagano al mese 900 euro,
//			per vivere a Roma se ne pagano 850,
//			per vivere in altre citt� se ne pagano 550.
//			Il metodo torna true se lo stipendio rimanente � superiore al 30% dello stipendio mensile
//		Scrivere una classe aggregatrice che legga il file dei dati, salvi
//		tutto in un vettore di oggetti e poi
//		- String listaCompleta()
//		- String poveracci() -> Tutti coloro che non riescono a sbarcare
//		- String nababbo() -> Tutti coloro che prendo lo stipendio pi� alto
//		- String cercaPer(String professione)
//		- String sostituisci(String residenzaAbbandonata, String nuovaResidenza) -> cambierete tutte le residenze uguali a
//		residenzaAbbandanata con il valore di nuovaResidenza
//		Scrivere una classe di avvio in cui testare i metodi
		
		// Apro un canale con la console(mi serve per il path errato ma anche per i parametri che potrei volere)
		Scanner tastiera = new Scanner(System.in);
		// Scrivo un percorso probabile, non � detto che sia sempre giusto per�
		String path = "src/res/Dati.txt";
		// Inizializzo a vuoto l'oggetto aggregatore (se il percorso sar� giusto questo oggetto diventer� pieno)
		Aggregatore a = null;
		// Apro un doWhile cos� che il programma vada avanti solo se ottiene un percorso valido, in caso contrario
		// non avrebbe senso procedere perch� saremmo senza dati da usare nei calcoli
		do
		{
			// Tento una prima connessione con il file: se il path va bene si attiva il break e procedo col codice 
			// successivo al ciclo, in caso contrario finisco nel cath
			try
			{
				a = new Aggregatore(path);
				break;
			}
			catch(FileNotFoundException e)
			{
				// Casco qui solo nel caso in cui si generi un errore legato al percorso del file: mi faccio 
				// poi passare dall'utente un percorso si spera corretto e dato che poi non ci sono pi� istruzioni,
				// torno ad eseguire il try con il nuovo percorso ottenuto
				System.out.println("File non trovato!\n\nInserisci un nuovo percorso:");
				path = tastiera.nextLine();
			}
		}while(true);
		
		// Quando arrivo qui significa che ho avuto un path corretto e che l'aggregatore ha salvato tutti i dati nel posto 
		// giusto, quindi faccio le stampe dei vari metodi per vedere se lavorano bene come voglio io
		//System.out.println(a.listaCompleta());
		//System.out.println(a.poveracci());
		//System.out.println(a.nababbo());
		//System.out.println(a.cercaPer("studente"));
		System.out.println(a.sostituisci("milano", "Napoli"));
		
		tastiera.close();
	}
}