package main;

import java.util.Scanner;
import java.io.File;

//Scrivere un file con le informazioni legate alle scommesse sui cavalli.
//Il file sarà formattato con nome, numero, quotato, razza
//Stampare poi un menu che permetta all'utente di chiedere:
//> Lista dei cavalli dal file
//> Lista delle razze senza ripetizioni
//> Cavallo/i piu quotato/i
//> Quota media dei cavalli di una razza a richiesta dell'utente

public class Main {

	public static void main(String[] args)  {

		Scanner tastiera, 
		file;

		String nome, 
		razza, 
		menu,
		cmd = "",
		risposta,
		listaCavalli,
		listaRazzeSenzaRip,
		cavalloQuotazioneMassima = "",
		razzaRichiestaUtente;

		int numero,
		contRazze;

		double quotazione,
		quotazioneMassima,
		sommaQuotazioneRazzaRichiesta;

		try {
			file = new Scanner(new File("src/res/Dati.txt"));
			listaCavalli = "";
			listaRazzeSenzaRip = "";
			quotazioneMassima = 0;
			risposta = "";
			menu = 	        "\n\tMENU\n" 								    +
					"\n1 > Lista dei cavalli" 		        		+
					"\n2 > Lista delle razze" 						+
					"\n3 > Cavall* piu' quotat*" 					+
					"\n4 > Quota media dei cavalli di una razza" 	+
					"\n0 > Esci"									;

			while(file.hasNextLine()) {

				nome = file.nextLine();
				numero = Integer.parseInt(file.nextLine());
				quotazione = Double.parseDouble(file.nextLine());
				razza = file.nextLine();

				listaCavalli += "Nome: " + nome  +
						"\nRazza: "+ razza +
						"\nNumero: " + numero +
						"\nQuotato "+ quotazione + ":1" +
						"\n------------------------\n" ;

				if(!listaRazzeSenzaRip.toLowerCase().contains(razza.toLowerCase() + ", ")) {

					listaRazzeSenzaRip += razza + ", ";
				}
				if(quotazione > quotazioneMassima) {

					quotazioneMassima = quotazione;
					cavalloQuotazioneMassima = nome;
					
				}else if(quotazione == quotazioneMassima) {
					
					cavalloQuotazioneMassima += ", " + nome;
					
				}
			}

			file.close();
            listaRazzeSenzaRip = listaRazzeSenzaRip.substring(0, listaRazzeSenzaRip.length()-2);			

            tastiera = new Scanner(System.in);
            
            System.out.println("Benvenuto nel mio centro scommesse!\n Ecco i comandi: " + menu);

            
            
            do {
            	
            	System.out.println("Comando: ");
            	cmd = tastiera.nextLine();
            	
            	switch(cmd) {
            	
            	case "1":
            		risposta = listaCavalli;
            		break;
            	case "2":
            		risposta = listaRazzeSenzaRip;
            		break;
            	case "3":
            		risposta = cavalloQuotazioneMassima;
            		break;
            	case "4":
            		System.out.println("Che razza ti interessa? ");
            		razzaRichiestaUtente = tastiera.nextLine();
            		
            		contRazze = 0;
            		sommaQuotazioneRazzaRichiesta = 0;
            		
            		file = new Scanner(new File ("src/res/Dati.txt"));
            		
            		while(file.hasNextLine()) {
            			
            			nome = file.nextLine();
        				numero = Integer.parseInt(file.nextLine());
        				quotazione = Double.parseDouble(file.nextLine());
        				razza = file.nextLine();
        				
        				if(razza.equalsIgnoreCase(razzaRichiestaUtente)) {
        					sommaQuotazioneRazzaRichiesta += quotazione;
        					contRazze++;
        				}
            			
            		}
            		
            		file.close();
            		
            		if(contRazze == 0)
            			risposta = "Razza non presente nell'archivio";
            		else
            			risposta = "Quotazione media: " + (sommaQuotazioneRazzaRichiesta/contRazze);
            		break;
            	
            	}
            	
            }while(!cmd.equalsIgnoreCase("0"));

            System.out.println(risposta);
            

		}catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
