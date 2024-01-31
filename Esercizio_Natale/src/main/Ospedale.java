package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Ospedale {


	Paziente[] pazienti;
	Medico[] medici;

	Ospedale(String path, Scanner tastiera) throws FileNotFoundException
	{
		Scanner file = new Scanner(new File(path));
		String[] dim = file.nextLine().split(",");

		pazienti = new Paziente[Integer.parseInt(dim[0])];
		medici = new Medico[Integer.parseInt(dim[1])];

		int indicePazienti = 0;
		int indiceMedici = 0;
		int j;

		try 
		{
			for (int i = 0; file.hasNextLine(); i++) 
			{
				String[] infoRiga = file.nextLine().split(",");
				String[] categoria = {"ruolo","nome","cognome","data di nascita","residenza","patologia","reparto","contagioso","probabilità di morte"};
				try {
					if (infoRiga[0].equalsIgnoreCase("paziente")) {
						for (j = 0; j < infoRiga.length; j++) {
							if (infoRiga[j].isEmpty()) {
								System.out.println("Il dato " + categoria[j].toUpperCase() + " alla riga " + i + " del file è vuoto, vuoi inserirne uno? (s/n)");
								String ris = tastiera.nextLine();
								if (ris.equalsIgnoreCase("s")) {
									System.out.println("Inserisci il dato " + categoria[j].toUpperCase());
									infoRiga[j] = tastiera.nextLine();
								}
							}

						
							if (j == 8) 
							{
								try 
								{
									Integer.parseInt(infoRiga[j]);
								} catch (NumberFormatException e) {
									System.err.println("Errore nella riga " + (i + 2)  + ": il dato alla colonna " + j + " deve essere un numero!");

								
									boolean inputValido = false;
									while (!inputValido) 
									{
										try 
										{
											System.out.println("Inserisci di nuovo il dato "+ categoria[j] + " (deve essere un numero): ");
											String input = tastiera.nextLine();
											Integer.parseInt(input);
											infoRiga[j] = input;
											inputValido = true;
										} catch (NumberFormatException ex) {
											System.err.println("Input non valido. Riprova.");
										}
									}
								}
							}
						}

						Paziente p = new Paziente(
								infoRiga[1],
								infoRiga[2],
								infoRiga[3],
								infoRiga[4],
								infoRiga[5],
								infoRiga[6],
								infoRiga[7].equalsIgnoreCase("s"),
								Integer.parseInt(infoRiga[8]));

						pazienti[indicePazienti++] = p;

					} else if (infoRiga[0].equalsIgnoreCase("medico")) 
					{
						String[] categoriaMedico = {"ruolo","nome","cognome","data di nascita","residenza","reparto","anni di esperienza","pazienti curati","pazienti persi"};
						for(j = 0; j < infoRiga.length; j++)
						{
							if(infoRiga[j].isEmpty())
							{

								System.out.println("Il dato " + categoriaMedico[j].toUpperCase() + " alla riga " + (i + 2) + " del file è vuoto, vuoi inserirne uno? (s/n)");
								String ris = tastiera.nextLine();
								if(ris.equalsIgnoreCase("s")) {
									System.out.println("Inserisci il dato " + categoriaMedico[j].toUpperCase());
									infoRiga[j] = tastiera.nextLine();
								}

							}
							if (j == 6 || j == 7 || j == 8) 
							{
								try 
								{
									Integer.parseInt(infoRiga[j]);
								} catch (NumberFormatException e) {
									System.err.println("Errore nella riga " + (i + 2) + ": il dato alla colonna " + j + " deve essere un numero!");

									
									boolean inputValido = false;
									while (!inputValido) 
									{
										try 
										{
											System.out.println("Inserisci di nuovo il dato (deve essere un numero):");
											String input = tastiera.nextLine();
											Integer.parseInt(input); 
											infoRiga[j] = input;
											inputValido = true;
										} catch (NumberFormatException ex) 
										{
											System.err.println("Input non valido. Riprova.");
										}
									}
								}
							}
						}

						Medico m = new Medico(
								infoRiga[1],
								infoRiga[2],
								infoRiga[3],
								infoRiga[4],
								infoRiga[5],
								Integer.parseInt(infoRiga[6]),
								Integer.parseInt(infoRiga[7]),
								Integer.parseInt(infoRiga[8]));

						medici[indiceMedici++] = m;
					}
				} catch (ArrayIndexOutOfBoundsException e) 
				{
					System.err.println("Errore nella riga " + (i + 2) + " del file: Dati mancanti!!");

				} catch (NumberFormatException e) 
				{
					System.err.println("Errore nella riga " + (i + 2) +  ": quel dato deve essere un numero!");
				}
			}
		} catch (Exception e) 
		{
			System.err.println("Errore durante la lettura del file: " + e.getMessage());
		} 

	}


	//Metodi
	String listaPazienti() 
	{
		String ris = "";
		for(int i = 0; i < pazienti.length; i++) {
			if(pazienti[i]!=null)
				ris += pazienti[i].scheda();
		}

		return ris.isEmpty() ? "Nessun risultato trovato." : "\n\tLISTA DEI PAZIENTI!\n"+ intestazionePazienti() + ris + chiusuraPazienti();
	}

	String listaMedici() 
	{
		String ris ="";
		for(int i = 0; i< medici.length; i++) {
			if(medici[i]!=null)
				ris += medici[i].schedaMedici();
		}

		return ris.isEmpty() ? "Nessun risultato trovato." : "\n\tLISTA DEI MEDICI!\n" + intestazioneMedici() + ris + chiusuraMedici();
	}

	String listaTotale() {
		String listaPazienti = listaPazienti();
		String listaMedici = listaMedici();

		if (listaPazienti.isEmpty() && listaMedici.isEmpty()) {
			return "Nessun risultato trovato.";
		}

		return "\n\tLISTA TOTALE\n\n" + "\n\n" + listaPazienti + "\n\n" + listaMedici;
	}


	String nomiKiller() {
		String ris = "";
		String nomiKillers = "";

		for (int i = 0; i < medici.length; i++) {
			if (medici[i].killer()) {
				nomiKillers += 	" - " + (medici[i].nome.toUpperCase() + " " + medici[i].cognome.toUpperCase() + 
						" - Ha perso piu del 50% dei suoi pazienti con " + medici[i].anniDiSkill + " anni di esperienza." +"\n");
			}
		}
		ris = nomiKillers;

		return ris.isEmpty() ? "Nessun risultato trovato." : "\n\t LISTA DEI MEDICI KILLER:\n\n" + ris;
	}

	String cerca(String cercaPatologia) {

		String ris = "";

		for(int i = 0; i < pazienti.length; i++) {
			if(pazienti[i].patologia.equalsIgnoreCase(cercaPatologia))
				ris += " - " + pazienti[i].nome + " " + pazienti[i].cognome +"\n";	
		}

		return ris = ris.isEmpty() ? "Nessun paziente con la patologia richiesta" : "\nRiscontri per " + cercaPatologia.toUpperCase() + ": \n\n" + ris;
	}

	String cerca(String nome, String cognome)
	{
		String ris = "";
		for(int i = 0; i < pazienti.length; i++)
			if(pazienti[i].nome.equalsIgnoreCase(nome) && pazienti[i].cognome.equalsIgnoreCase(cognome))
				ris += intestazionePazienti() + pazienti[i].scheda() + chiusuraPazienti();
		for(int i = 0; i < medici.length; i++)
			if(medici[i].nome.equalsIgnoreCase(nome) && medici[i].cognome.equalsIgnoreCase(cognome))
				ris += intestazioneMedici() + medici[i].schedaMedici() + chiusuraMedici();
		return ris.isEmpty() ? "Nessun risultato trovato." : "Ecco il risultato della ricerca\n\n" + ris;
	}

	String rischiosi()
	{
		String ris = "";

		for(int i = 0; i < pazienti.length; i++)
		{
			if(pazienti[i].rischioZombie() == true)
			{
				ris += " - " + pazienti[i].nome + " " +  pazienti[i].cognome + "\n";
			}
		}
		return ris.isEmpty() ? "Nessun risultato trovato." : "\nPazienti a rischio zombificazione: \n\n" + ris;
	}

	String statistichePazienti()
	{
		String ris = "";
		int contGravi = 0;
		int contLieve = 0;


		for(int i = 0; i < pazienti.length; i++)
		{
			if(pazienti[i].probMorte > 80)
				contGravi ++;
			else
				contLieve ++;
		}
		if (contGravi > 0 && contLieve > 0) {
			ris = "\n\tSTATISTICHE PAZIENTI:\n" +
					"\n - Casi gravi: "  + contGravi +
					"\n - Casi lievi: "  + contLieve;
		} else if (contGravi > 0) {
			ris = "Nessun caso lieve presente.\nI casi gravi sono " + contGravi;
		} else if (contLieve > 0) {
			ris = "Nessun caso grave presente.\nI casi lievi sono " + contLieve;
		} else {
			ris = "Nessun risultato trovato.";
		}

		return ris;

	}

	String intestazionePazienti()
	{
		return 	"+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+-----------------------+\n" +
				"| Nome         | Cognome      | Data di nascita | Residenza    | Patologia    | Reparto            | Contagioso  | Probabilita' di morte |\n" +
				"+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+-----------------------+\n" ;
	}

	String chiusuraPazienti()
	{
		return "+--------------+--------------+-----------------+--------------+--------------+--------------------+-------------+-----------------------+\n";
	}

	String intestazioneMedici()
	{
		return 	"+--------------+--------------+-----------------+--------------+-----------------+------------------+-----------------+-----------------+\n" +
				"| Nome         | Cognome      | Data di nascita | Residenza    | Reparto         | Anni di servizio | Pazienti curati | Pazienti persi  |\n" +
				"+--------------+--------------+-----------------+--------------+-----------------+------------------+-----------------+-----------------+\n" ;
	}

	String chiusuraMedici()
	{
		return	"+--------------+--------------+-----------------+--------------+-----------------+------------------+-----------------+-----------------+\n";
	}










}