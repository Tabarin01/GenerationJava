package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		
		Scanner file;
		int dimensione;
		
		String[] nome;
		int [] quantita;
		double[] prezzoUnitario;
		double[] tassa;
		String[] componenti;
		String[] colori;
		
		dimensione = 0;
		file = new Scanner(new File("src/res/Dati.txt"));
		
		while(file.hasNextLine())
		{
			file.nextLine();
			dimensione ++;
		}
		file.close();
		
		//INIZIALIZZAZIONE 
		nome = new String[dimensione];
		quantita = new int[dimensione];
		prezzoUnitario = new double [dimensione];
		tassa = new double [dimensione];
		componenti = new String[dimensione];
		colori = new String[dimensione];
		
		file = new Scanner(new File("src/res/Dati.txt"));
		
		for(int i = 0;i< dimensione; i++)
		{
			String []riga = file.nextLine().split(";");
			
			nome[i] = riga[0];
			quantita[i] = Integer.parseInt(riga[1]);
			prezzoUnitario[i] = Double.parseDouble(riga[2]);
			tassa[i] = Double.parseDouble(riga[3]);
			componenti[i] = riga[4];
			colori[i] = riga[5];	
		}
		file.close();
		
		Scanner tastiera = new Scanner(System.in);
		String cmd;
		String risposta;
		String menu = "\n\tMENU\n"
	                + "  1- Mostra tutte le schede dei prodotti presenti in magazzino\n"
	                + "  2- Mostra i nomi dei prodotti da ordinare\n"
	                + "  3- Mostra i nomi dei prodotti con il costo al pubblico maggiori\n"
	                + "  4- Mostra i nomi dei prodotti meno tassati\n"
	                + "  5- Mostra i nomi dei prodotti con il maggior numero di colori\n"
	                + "  6- Mostra la scheda di un prodotto a scelta\n"
	                + "  7- Mostra una lista di prodotti acquistabili con un budget scelto\n"
	                + "  8- Mostra il prezzo medio dei prodotti con almeno 3 componenti terze\n"
	                + "  9- Mostra i nomi dei prodotti il cui rapporto (prezzoTassato/componentiTerze) è superiore alla media\n"
	                + " 10- Mostra il valore totale dei prodotti in magazzino\n"
	                + " 11- Mostra il costo totale per prodotto\n"
	                + "  M- Ristampa menù\n"
	                + "  0- Esci\n";

		System.out.println("Benvenuto nel nostro magazzino \n Eccoti la legenda dei comandi" + menu);
		
		do
		{
			System.out.println("Commando: ");
			cmd = tastiera.nextLine();
			risposta ="";
			
			switch(cmd.toUpperCase())
			{
				case "1":
					for(int i = 0; i< dimensione; i++)
					{
						risposta += "\nNome Prodotto: " 					+ nome[i] 						+
									"\nQuantità: " 							+ quantita[i] 					+
									"\nPrezzo al Pezzo: " 					+ prezzoUnitario[i] + "€"		+
									"\nTassa: "								+ tassa[i]						+
									"\nComponenti Terzi: " 					+ componenti[i].replace("-", ", ")+
									"\nColore: "							+ colori[i] 					+
									"\n--------------------------------\n"									;
					}
				
				break;
				case "2":
					//stampare i prodotti in cui la quantita é 
					risposta += "\n\tProdotti disponibili per l'ordine:";
					
					for(int i = 0; i < dimensione; i++)
					{
						if(quantita[i] <= 5)
						{
							 risposta += "\n- " + nome[i];
						}
					}
						
					break;
				case "3":
					//prodotti con il costo al pubblico maggiori
					double maxCifra = 0;
					for(int i = 0; i< dimensione; i++)
					{
						double prezzoPiuTassa = (prezzoUnitario[i] * tassa[i]/100)+ prezzoUnitario[i];
						
						if(maxCifra < prezzoPiuTassa)
						{
							maxCifra = prezzoPiuTassa;
							risposta = nome[i];
						}
						else if(maxCifra == prezzoPiuTassa)
						{
							risposta += ", " + nome[i];
						}
					}
					break;
				case "4":
					double minCifra = Integer.MAX_VALUE;
					for(int i = 0; i< dimensione; i++)
					{
						
						if(minCifra > tassa[i])
						{
							minCifra =  tassa[i];
							risposta = nome[i];
						}
						else if(minCifra ==  tassa[i])
						{
							risposta += ", " + nome[i];
						}
					}
					
					break;
				case "5":
					
					for(int i = 0; i < dimensione; i++)
					{
						int numeroColoriMax = 0;
						int numeroColori = colori[i].split("-").length;
						
						if(numeroColori > numeroColoriMax)
						{
							numeroColori = numeroColoriMax;
							risposta = nome[i];
						}
						else if(numeroColori == numeroColoriMax)
						{
							risposta += ", " + nome[i];
						}
					}
					break;
				case "6":
					
					System.out.println("Inserisci il nome di un prodotto");
					String prodottoRichiesto = tastiera.nextLine();
					
					for(int i = 0; i < dimensione; i++)
					{
						if(prodottoRichiesto.equalsIgnoreCase(nome[i]))
						{
							risposta = "\nNome Prodotto: " 					+ nome[i] 						+
										"\nQuantità: " 							+ quantita[i] 					+
										"\nPrezzo al Pezzo: " 					+ prezzoUnitario[i] + "€"		+
										"\nTassa: "								+ tassa[i]						+
										"\nComponenti Terzi: " 					+ componenti[i].replace("-", ", ")+
										"\nColore: "							+ colori[i] 					+
										"\n--------------------------------\n"									;
						}
					}
					risposta = risposta.isEmpty() ? "Non abbiamo quel prodotto" : risposta;
					break;
				case "7":
					System.out.println("Inserisci il tuo budget massimo");
					double budgetDisponibile = Double.parseDouble(tastiera.nextLine());
					
					for(int i = 0; i < dimensione; i++)
					{
						double prezzoTotale = (prezzoUnitario[i] * tassa[i]/100)+ prezzoUnitario[i];
						if(budgetDisponibile >= prezzoTotale)
						{
							risposta += "\nProdotto: " + nome[i] + " €" + prezzoTotale;
						}
					}
					risposta = risposta.isEmpty() ?  "Hai inserito un budget troppo basso" : risposta;
					break;
				case "8":
					double somma = 0;
					int conta = 0;
					for(int i = 0; i < dimensione; i ++)
					{	
						int numeroComponentiTerzi = componenti[i].split("-").length;
						if(numeroComponentiTerzi >= 3)
						{
							somma += (prezzoUnitario[i] * tassa[i]/100)+ prezzoUnitario[i];
							conta ++;
						}
					}
					double mediaProdotti =  somma/conta;
					risposta = "Il prezzo medio dei prodotti con almeno 3 componenti terzi é: " + mediaProdotti;
					break;
			
				case "9":
					String nomiRapporto = "";
	                double mediaPrezzoRapporto = 0;
	                int contaRapporti = 0;

	                for (int i = 0; i < dimensione; i++) {
	                    int nComponenti = componenti[i].split("-").length;
	                    if (nComponenti >= 1) {
	                        System.out.println(prezzoUnitario[i] * (1 + tassa[i] / 100));
	                        mediaPrezzoRapporto += prezzoUnitario[i] * (1 + tassa[i] / 100) / nComponenti;
	                        contaRapporti++;
	                    }
	                }

	                mediaPrezzoRapporto /= contaRapporti;

	                for (int i = 0; i < dimensione; i++) {
	                    int nComponenti = componenti[i].split("-").length;
	                    double rapportoPerProdotto = prezzoUnitario[i] * (1 + tassa[i] / 100) / nComponenti;
	                    if (rapportoPerProdotto > mediaPrezzoRapporto)
	                        nomiRapporto += "\n-" + nome[i] + " rapporto:  " + rapportoPerProdotto;
	                }

	                if (mediaPrezzoRapporto <= 0)
	                    risposta = "\nErrore: nessun prodotto disponibile";
	                else
	                    risposta = "\nLista dei prodotti con il maggior numero di colori (" + mediaPrezzoRapporto + "):" + nomiRapporto;
					break;
				case "10":
					double ricavoTotale = 0;
					for(int i = 0; i < dimensione; i ++)
					{
						ricavoTotale += quantita[i]*((prezzoUnitario[i] * tassa[i]/100)+ prezzoUnitario[i]);
					}
					risposta = "Il ricavo dell'azienda é di " + ricavoTotale + "€";
					break;
				case "11":
					double prezzoTotale = 0;
					for(int i = 0; i < dimensione; i ++)
					{
						prezzoTotale += quantita[i]*prezzoUnitario[i];
					}
					risposta = "Per prendere le gli stessi prodotti " + prezzoTotale + "€";
					break;
				case "0":
					risposta = "Arrivederci";
					break;
				case "M":
					risposta = menu;
					break;
				default:
					risposta = "Hai inserito un commando non valido";
			}//fine switch
			System.out.println(risposta);
		}while(!cmd.equalsIgnoreCase("0"));
		tastiera.close();
	}//DO NOT TOUCH

}//DO NOT TOUCH
