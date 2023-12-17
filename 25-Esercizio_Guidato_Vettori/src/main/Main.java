package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	//	Scrivere un file che contenga i prodotti venduti da un bar.
	//    Nel file troveremo: nomeOrdine, prezzo
	//    Scrivere un programma che apra un menu all'utente in cui si vede:
	//    Menu del bar
	//    Il nome dei prodotti piu economici
	//    Il costo medio di tutti i prodotti del bar
	//    Il costo medio dei prodotti che contengono la parola "caffe"
	//    Permettere all'utente di ordinare un prodotto

	public static void main(String[] args) throws FileNotFoundException {
		// BLOCCO che si occupa solo di leggere il file dei dati ------------------------------------
		//D
			Scanner file;
			String percorso;
			String[] prodotti;
			double[] prezzi;
			int dimensione; // Prima riga del file che sara' un numero intero
			int i;
			
		//I
			percorso = "src/res/Dati.txt";
			
			file = new Scanner(new File(percorso));
			
			// La prima riga del file mi rappresenta il numero di elementi che saranno salvati nei vettori
			dimensione = Integer.parseInt(file.nextLine());
			
			prodotti = new String[dimensione];
			prezzi = new double[dimensione];
			
		//C
			i = 0;
			
			// Modo 1 per leggere il file
			while(file.hasNextLine())
			{
				// Si legge "prodotti in posizione iesima uguale a file.nextLine"
				prodotti[i] = file.nextLine();
				prezzi[i] = Double.parseDouble(file.nextLine());
				
				i++;
			}
			
			// Modo 2 per leggere il file
			/*
				while(i < dimensione)
				{
					prodotti[i] = file.nextLine();
					prezzi[i] = Double.parseDouble(file.nextLine);
					i++;
				}
			 */
			
			file.close();
		//----------------------------------------------------------------------------------------------------
			
			// BLOCCO che si occupa solo del men� per l'utente
		//D
			Scanner tastiera;
			String legenda;
			String cmd;
			String risposta;
			
		//I
			tastiera = new Scanner(System.in);
			cmd = "";
			risposta = "";
			legenda = 	"\n\tLEGENDA\n" 													+
						"1- Menu del bar\n" 												+ 
						"2- Il nome dei prodotti pi� economici\n" 							+ 
						"3- Il costo medio di tutti i prodotti del bar\n" 					+ 
						"4- Il costo medio dei prodotti che contengono la parola caffe\n" 	+ 
						"5- Permettere all'utente di ordinare un prodotto\n" 				+
						"L- Legenda\n" 														+
						"0- Esci\n"															;
		//C
			System.out.println("Benvenuto nel mio bar!\nEccoti la legenda dei comandi" + legenda);
			
			do
			{
				System.out.println("Comando:");
				cmd = tastiera.nextLine();
				risposta = "";
				
				switch(cmd.toUpperCase())
				{
					case "1" :					
						i = 0;
						
						while(i < prodotti.length)
						{
							risposta += prodotti[i] + " --> " + prezzi[i] + "$\n";
							
							i++;
						}
						
						if(risposta.isEmpty())
							risposta = "\n\nNessun men$ disponibile";
						else
							risposta = "\n\n\tMENU'\n" + risposta;
						
						break;
					case "2" :
						// Variabile LOCALE: esiste solo dentro al blocco di codice in cui la si dichiara
						double min = Double.MAX_VALUE;
						
						i = 0;
						
						while(i < prezzi.length)
						{
							if(prezzi[i] < min)
							{
								min = prezzi[i];
								risposta = prodotti[i];
							}
							else if(prezzi[i] == min)
								risposta += ", " + prodotti[i];
							
							i++;
						}
						
						risposta = "\n\n\tProdotti Economici\n" + risposta;
						break;
					case "3" :
						double somma = 0;
						
						i = 0;
						
						while(i < prezzi.length)
						{
							somma += prezzi[i];
							
							i++;
						}
						
						if(somma > 0)
							risposta = "Il prezzo medio del bar vale: " + somma/prezzi.length + "$";
						else
							risposta = "Non ho elementi per calcolare il prezzo medio";
						
						break;
					case "4" :
						int conta = 0;
						somma = 0;
						
						i = 0;
						
						while(i < prezzi.length)
						{
							if(prodotti[i].toLowerCase().contains("caffe"))
							{
								somma += prezzi[i];
								conta++;
							}
							
							i++;
						}
						
						if(somma > 0)
							risposta = "Il prezzo medio dei prodotti con la parola caffe vale: " + somma/conta + "$";
						else
							risposta = "Non ho elementi per calcolare il prezzo medio dei prodotti con la parola caffe";
						
						break;
					case "5" :
						System.out.println("Cosa vuoi ordinare?");
						String ordineCliente = tastiera.nextLine();
						
						i = 0;
						
						while(i < prodotti.length)
						{
							if( prodotti[i].equalsIgnoreCase(ordineCliente) 
//								|| 
//								prodotti[i].toLowerCase().contains(ordineCliente.toLowerCase())
							  )
							{
								risposta += "Il prodotto " + prodotti[i].toUpperCase() + " costa " + prezzi[i] + "$";
							}
							
							i++;
						}
						
						if(risposta.isEmpty())
							risposta = "Non vendiamo " + ordineCliente.toUpperCase();
						
						break;
					case "L" :
						risposta = legenda;
						break;
					case "0" :
						risposta = "Arrivederci!";
						break;
					default :
						risposta = "Comando non valido";	
						break;
				}
				
				System.out.println(risposta);
			}while(!cmd.equalsIgnoreCase("0"));
			
		//O
			tastiera.close();
			System.out.println("END");		
		}
	}