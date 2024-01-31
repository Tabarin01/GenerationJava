package main;

import java.io.FileNotFoundException;
import java.util.Scanner;

import entities.Scuola;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		Scuola s = new Scuola("src/res/Dati.txt");
		Scanner tastiera = new Scanner(System.in);


		String ris, cmd;

		String menu = 
				"    |                           MENU                                |\r\n"
						+ "    |_______________________________________________________________|\r\n"
						+ "    | 0 ) Esci                                                      |\r\n"
						+ "    | M ) Menu                                                      |\r\n"
						+ "    | 1 ) Lista completa insegnanti e studenti                      |\r\n"
						+ "    | 2 ) Lista dei soli insegnanti                                 |\r\n"
						+ "    | 3 ) Lista dei soli studenti                                   |\r\n"
						+ "    | 4 ) Lista degli studenti promossi e il numero degli studenti  |\r\n"
						+ "    | 5 ) Numero degli studenti che possono andare in erasmus       |\r\n"
						+ "    | 6 ) Lista di insegnanti prossimi alla pensione                |\r\n"
						+ "    | 7 ) Totale stipendio degli insegnanti di italiano             |\r\n"
						+ "    | 8 ) Media degli stipendi di tutti gli insegnanti              |\r\n"
						+ "    | 9 ) Media degli stipendi degli insegnanti di matematica       |\r\n"
						+ "    | 10) Nome e media dello studente con la media maggiore         |\r\n"
						+ "    | 11) Nome ed età dell'insegnante più vecchio                   |\r\n"
						+ "    | 12) Nome, materia e stipendio dell'insegnante più pagato      |\r\n"
						+ "    | 13) Nome, età e classe dello studente più giovane             |\r\n"
						+ "    | 14) Ritorna il nome e gli anni fuori corso degli studenti     |\r\n"
						+ "    | 15) Nome dell'aula e il numero di studenti presenti           |\r\n"
						+ "    |_______________________________________________________________|";

		System.out.println(menu);

		do 
		{
			ris = "";
			System.out.println("\nDigita M per il menu\nComando");
			cmd = tastiera.nextLine();

			switch(cmd.toLowerCase()) 
			{
			case"1":
				ris = s.listaCompleta();
				break;
			case"2":
				ris = s.listaInsegnanti();
				break;
			case"3":
				ris = s.listaStudenti();
				break;
			case"4":
				ris = s.listaPromossi();
				break;
			case"5":
				ris = "Numero di studenti che possono andare in erasmus: " + s.nErasmus();
				break;
			case"6":
				ris = s.pensionamento();
				break;
			case"7":
				ris = "Totale stipendi insegnanti di italiano: " + s.totaleStipendiIta();
				break;
			case"8":
				ris = "Media di tutti gli insegnanti: " + s.mediaStipendi();
				break;
			case"9":
				ris = "Media stipendi insegnanti di matematica: " + s.mediaStipendiMate();
				break;
			case"10":
				ris = s.studenteBravo();
				break;
			case"11":
				ris = s.insegnanteVecchio();
				break;
			case"12":
				ris = s.insegnanteRicco();
				break;
			case"13":
				ris = s.studenteGiovane();
				break;
			case"14":
				ris = s.fuoriCorso();
				break;
			case"15":
				ris = s.studentiPerAula();
				break;
			case "0":
				ris = "Grazie e arrivederci";
				break;
			case "m":
				ris = menu;
				break;
			default:
				ris = "Scelta non valida, riprovare!";
			}
			System.out.println(ris);
		}while(!cmd.equals("0"));

		tastiera.close();
	}

}
