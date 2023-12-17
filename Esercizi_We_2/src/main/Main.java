package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		int ex;



		while(true) {
			System.out.println("\t\nChoose an exercise: \n" + 
					"1.Serie di Fibonacci\n" +
					"2.Somma numeri fino a 27\n"+
					"3.Ingressi Cinema\n"+
					"4.Voti scolastici\n"+
					"5.Agenzia Viaggi\n"+
					"0.Exit");

			try {
				ex = Integer.parseInt(userInput.nextLine());
				if(ex == 0) {
					System.out.println("GoodBye...");
					break;
				}

				switch(ex) {

				case 1:
					esercizioFibonacci(userInput);
					break;
				case 2:
					sommaFino27(userInput);
					break;
				case 3:
					cinemaEs(userInput);
					break;
				case 4:
					esercizioVoti(userInput);
					break;
				case 5:
					esercizioAgenzia();
					break;
				default:
					System.out.println("Invalid choise. Please entare a valid number!");
					break;

				}
			}catch(Exception e){
				System.out.println("Error: "+e.getMessage());

			}
		}
		userInput.close();


	}

	public static void esercizioFibonacci(Scanner userInput) {
		int numeroUtente, i = 0, num =1, num2 = 1, temp;

		System.out.println("SERIE DI FIBONACCI!"+
				"\nDigita quanti numeri della serie vuoi: ");
		numeroUtente = Integer.parseInt(userInput.nextLine());

		while(i < numeroUtente) {
			System.out.print(num + ", ");
			temp = num + num2;
			num = num2;
			num2 = temp;
			i++;
		}

	}

	public static void sommaFino27(Scanner userInput) {

		int numero, somma = 0, cont = 0;
		System.out.println("Somma fino a 27!!");
		while (somma < 27) {
			System.out.println("Digita un numero da sommare: ");
			numero = Integer.parseInt(userInput.nextLine());

			somma += numero;

			numero = numero > 10 ? cont++ : 0;
		}
		System.out.println("Loop completato, somma finale: "+ somma);
		System.out.println("Numero più grande di 10 digitato: "+ cont + " volte");
	}

	public static void cinemaEs(Scanner userInput) {

		String nome,
		lavoro,
		gruppo,
		sconto = " ";
		int eta,
		numPersone = 1;
		double ticket = 8,
				prezzoTotale = 0;


		System.out.println("Sei in gruppo? si/no: ");
		gruppo = userInput.nextLine();

		if(gruppo.equalsIgnoreCase("si")) {
			System.out.println("Quanti siete?  ");
			numPersone = Integer.parseInt(userInput.nextLine());
		}
		for(int i = 0; i < numPersone; i++) {

			System.out.println("Nome: ");
			nome = userInput.nextLine();
			System.out.println("Età: ");
			eta = Integer.parseInt(userInput.nextLine());
			System.out.println("Lavoro: ");
			lavoro = userInput.nextLine();

			double totaleBiglietto = ticket;


			switch(lavoro.toLowerCase()){

			case "studente":
				totaleBiglietto -= 2;
				sconto = "Sconto studente";
				break;
			case "militare":
			case "poliziotto":
				totaleBiglietto -= 3;
				sconto = "Sconto accademico";
				break;
			case "medico":
				totaleBiglietto += 2;
				sconto = "Sovrapprezzo medico";
				break;  
			default:
				break;
			}

			if(eta > 65) {
				totaleBiglietto /= 2;
				sconto += "\nSconto over65";
			}else if(eta >= 25 && eta <= 32) {
				totaleBiglietto += 1;
				sconto += "\nSovrapprezzo adulto";
			}

			prezzoTotale += totaleBiglietto;
			System.out.println("Nome: " + nome +
					"\nPrezzo biglietto: " + totaleBiglietto +
					"\nOfferta: " + (sconto = sconto.isEmpty()? " nessuna" : sconto));
		}


		prezzoTotale -= numPersone > 5 ? 2 : 0;

		System.out.println("Prezzo Totale: " + prezzoTotale);

	}

	public static void esercizioVoti(Scanner userInput) {

		String nome,  
		risposta = "";
		int votoIta,
		votoIng,
		votoInf, 
		votoMat;
		int cont,
		nStudenti, 
		bocciato = 0,
		studentiInf = 0, 
		i = 0; 

		try {
			System.out.println("Digita quanti studenti: ");
			nStudenti = Integer.parseInt(userInput.nextLine());

			while(i < nStudenti) {

				cont = 0;

				System.out.println("Nome: ");
				nome = userInput.nextLine();

				System.out.println("Voto italiano: ");
				votoIta = Integer.parseInt(userInput.nextLine());
				cont += votoIta > 5 ? 1 : 0;

				System.out.println("Voto Inglese: ");
				votoIng = Integer.parseInt(userInput.nextLine());
				cont += votoIng > 5 ? 1 : 0;

				System.out.println("Voto Informatica: ");
				votoInf = Integer.parseInt(userInput.nextLine());
				cont += votoInf > 5 ? 1 : 0;

				System.out.println("Voto Matematica: ");
				votoMat = Integer.parseInt(userInput.nextLine());
				cont += votoMat > 5 ? 1 : 0;

				double average = (votoIta + votoIng + votoInf + votoMat)/4;

				risposta += "\nMedia di: "+ nome + ": "+ average;

				if(average >= 6 && cont >=3) {

					risposta += "\nStudente " + nome.toUpperCase() + ": Promosso!";

				}else {
					risposta += "\nStudente " + nome.toUpperCase()+": Bocciato!";
					bocciato++;
				}

				studentiInf += votoInf > 8 ? 1 : 0;

				risposta += "\n";

				i++;
			} 

		}catch(Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}



		System.out.println("\t OUTPUT" + risposta +
				"\nNumero di studenti bocciati: "+ bocciato +
				"\nNumero di studenti con voto di informatica maggiore: "+ studentiInf);
	}

	public static void esercizioAgenzia() {

		Scanner file;

		String destinazione, 
		veicolo,  
		rispDestinazione = ", ", 
		rispVeicolo =", ", 
		viaggioLusso = "",
		recap = "",
		viaggioEco = "";
		double prezzoQuot,
		prezzoTotale,
		sconto,
		prezzoGiorni,
		totalCostAereo = 0,
		totalCostDubai = 0,
		prezzoMin = Double.MAX_VALUE,
		prezzoMax = Double.MIN_VALUE;
		int numPersone,
		giorni,
		cont = 1,
		contAereo = 0,
		contDubai = 0;


		try {

			file = new Scanner(new File("src/res/Travel.txt"));

			while(file.hasNextLine()) {

				prezzoTotale = 100;

				destinazione = file.nextLine();
				veicolo = file.nextLine();
				giorni = Integer.parseInt(file.nextLine());
				prezzoQuot = Double.parseDouble(file.nextLine());
				numPersone = Integer.parseInt(file.nextLine());

				prezzoGiorni = prezzoQuot * giorni;

				prezzoTotale += prezzoGiorni;

				//Condizione stampa delle destinazioni e dei veicoli senza ripetizioni
				rispDestinazione = rispDestinazione.toLowerCase().contains(", " + destinazione.toLowerCase() + ", ") ? rispDestinazione : rispDestinazione + destinazione + ", ";

				rispVeicolo = rispVeicolo.toLowerCase().contains(", " +veicolo.toLowerCase()+ ", ") ? rispVeicolo : rispVeicolo + veicolo + ", ";


				//Condizione destinazione
				switch(destinazione.toLowerCase()) {

				case "dubai":
					prezzoTotale += 200;
					totalCostDubai += prezzoTotale;
					contDubai++;
					break;
				case "tokyo":
					prezzoTotale += 200;
					break;
				case "dublino":
				case "londra":
					prezzoTotale += 150;
					break;
				case "new york":
				case "miami":
					prezzoTotale += 300;
					break;
				default:
					prezzoTotale += 50;
				}


				//Condizione veicolo
				switch(veicolo.toLowerCase()) {

				case "aereo":
					prezzoTotale += 500;
					totalCostAereo += prezzoTotale;
					contAereo++;
					break;
				case "traghetto":
					prezzoTotale += 500;
					break;
				case "treno":
					prezzoTotale += 200;
					break;
				case "auto":
				case "pullman":
					prezzoTotale += 100;
					break;
				default:
					prezzoTotale += 1000;
				}

				if(numPersone > 10) {
					sconto = prezzoTotale*10/100;
					prezzoTotale -= sconto;
					totalCostAereo -= sconto;

				}else if(numPersone > 5 && numPersone < 10) {

					sconto = prezzoTotale*5/100;
					prezzoTotale -= sconto;
				}				


				//Output dei viaggi del file
				recap +="Viaggio " + cont + "\n" +
						"Destinazione: " + destinazione.toUpperCase() + "\n" +
						"Mezzo di Trasporto: " + veicolo.toUpperCase() + "\n" +
						"Numero Persone: " + numPersone + "\n" +
						"Giorni: "+ giorni + "\n"+
						"Costo giornaliero: "+ prezzoQuot + " $\n"+
						"Prezzo Totale: " + prezzoTotale + " $\n"+
						"--------------\n";
				cont ++;
				

				//Viaggio economico

				if(prezzoTotale < prezzoMin) {
					prezzoMin = prezzoTotale;
					viaggioEco = "Viaggio " + cont + "\n" +
							"Destinazione: " + destinazione.toUpperCase() + "\n" +
							"Mezzo di Trasporto: " + veicolo.toUpperCase() + "\n" +
							"Numero Persone: " + numPersone + "\n" +
							"Giorni: "+ giorni + "\n"+
							"Costo giornaliero: "+ prezzoQuot + " $\n"+
							"Prezzo Totale: " + prezzoTotale + " $\n"+
							"--------------\n";
				}else if(prezzoTotale == prezzoMin) {
					prezzoMin = prezzoTotale;
					viaggioEco += "Viaggio " + cont + "\n" +
							"Destinazione: " + destinazione.toUpperCase() + "\n" +
							"Mezzo di Trasporto: " + veicolo.toUpperCase() + "\n" +
							"Numero Persone: " + numPersone + "\n" +
							"Giorni: "+ giorni + "\n"+
							"Costo giornaliero: "+ prezzoQuot + " $\n"+
							"Prezzo Totale: " + prezzoTotale + " $\n"+
							"--------------\n";
				}

				//Viaggio di lusso
				if(prezzoTotale > prezzoMax) {
					prezzoMax = prezzoTotale;
					viaggioLusso = "Viaggio " + cont + "\n" +
							"Destinazione: " + destinazione.toUpperCase() + "\n" +
							"Mezzo di Trasporto: " + veicolo.toUpperCase() + "\n" +
							"Numero Persone: " + numPersone + "\n" +
							"Giorni: "+ giorni + "\n"+
							"Costo giornaliero: "+ prezzoQuot + " $\n"+
							"Prezzo Totale: " + prezzoTotale + " $\n"+
							"--------------\n";
				}else if(prezzoTotale == prezzoMax) {
					prezzoMax = prezzoTotale;
					viaggioLusso += "Viaggio " + cont + "\n" +
							"Destinazione: " + destinazione.toUpperCase() + "\n" +
							"Mezzo di Trasporto: " + veicolo.toUpperCase() + "\n" +
							"Numero Persone: " + numPersone + "\n" +
							"Giorni: "+ giorni + "\n"+
							"Costo giornaliero: "+ prezzoQuot + " $\n"+
							"Prezzo Totale: " + prezzoTotale + " $\n"+
							"--------------\n";
				}

			}

			file.close();

			rispDestinazione = rispDestinazione.substring(2, rispDestinazione.length()-2);
			rispVeicolo = rispVeicolo.substring(2, rispVeicolo.length()-2);

			//Costo medio Aereo e Dubai
			totalCostAereo = contAereo > 0 ? totalCostAereo/contAereo : 0;
			totalCostDubai = contDubai > 0 ? totalCostDubai/contDubai : 0;


			System.out.println(recap + "\n" + 
					"Destinazioni: \n" + rispDestinazione.toUpperCase() + "\n" +
					"Mezzi di trasporto: \n" + rispVeicolo.toUpperCase()+ "\n"+
					"\nCosto medio viaggi in aereo " + (int) totalCostAereo + " $\n"+
					"Costo medio viaggi a Dubai " + (int) totalCostDubai + " $\n"+
					"\n\tViaggio economico: "+ viaggioEco + "\n" +
					"\tViaggio di lusso: "+ viaggioLusso);

		} catch (FileNotFoundException e) {
			e.getMessage();
		}


	}
}

