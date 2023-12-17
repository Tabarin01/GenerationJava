package main;

/*  AGENZIA VIAGGI
 * 
 *  Organizzare un viaggio all'estero
 * 
 *  Dal cliente vi farete passare le seguenti informazioni
 * 
 *  -1 destinazione
 *  -2 mezzo di locomozione
 *  -3 durata viaggio
 *  -4 numero partecipanti al viaggio
 * 
 *  Dovete creare una scheda ordinata con le informazioni 
 *  che vi hanno passato 
 *  e dovete calcolare il prezzo del viaggio 
 *  per i singoli partecipanti
 *  sapendo che:
 *  il costo in base al mezzo di locomozione varia: 
 * 
 * - aereo: 500$
 * - treno: 300$
 * - traghetto: 450$
 * - pullman: 350$
 * - altro: 1000$
 * 
 *  Il costo in base alla destinazione varia: 
 * 
 *  - Roma: 50$
 *  - Dubai: 200$
 *  - Tokyo: 500$
 *  - Dublino: 150$
 *  - Amsterdam: 90$
 *  - altro: 1500$
 *  
 *  Ogni giorno di viaggio ha una base FISSA di 10.50$
 *  Se il numero di partecipanti e' inferiore o uguale a 10 si calcoli
 *  una penale aggiuntiva del 2%, 
 *  se sono tra 11 e 20 pagano una penale del 0.5%, * 
 *  se sono piu' di 20 hanno diritto allo sconto
 *  comitiva del 5% sul totale.
 *
 *  Nella scheda riassuntiva va mandato in output tutti i dati
 *  che sono stati passati dal cliente, il prezzo complessivo del viaggio
 *  e il prezzo che paga la singola persona che partecipa al viaggio.
 * 
 *  Esempio output
 * 
 *  SCHEDA VIAGGIO
 * 
 *  Destinazione: Dubai
 *  Mezzo: Monopattino Elettrico
 *  Durata: 40 giorni
 *  Partecipanti: 30 persone
 * 
 *  Costo totale: millemila euro
 *  [Sconto 5% / Sconto 0.5% / Penale 2%]
 *  Costo per partecipante: 10 euro cadauno;
 * 
 * */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String destinazione, mezzo;
		int partecipanti, giorni;
		double costoMezzo=0, costoDestinazione =0, costoBase= 10.50;

		System.out.println("Dove vuoi andare: ");
		destinazione = input.nextLine();
		System.out.println("Quale mezzo vuoi usare: ");
		mezzo = input.nextLine();
		System.out.println("Per quanti giorni: ");
		giorni = Integer.parseInt(input.nextLine());
		System.out.println("In quanti siete: ");
		partecipanti = Integer.parseInt(input.nextLine());
		
		input.close();

		switch(mezzo.toLowerCase()) {
		case "aereo":
			costoMezzo=500;
			break;
		case "treno":
			costoMezzo=300;
			break;
		case "traghetto":
			costoMezzo=450;
			break;
		case "pullman":
			costoMezzo=350;
			break;
		default:
			costoMezzo=1000;
			break;
		}
		switch(destinazione.toLowerCase()){
		case "roma":
			costoDestinazione=50;
			break;
		case "dubai":
			costoDestinazione=200;
			break;
		case "tokyo":
			costoDestinazione=500;
			break;
		case "dublino":
			costoDestinazione=150;
			break;
		case "amsterdam":
			costoDestinazione=90;
			break;
		default:
			costoDestinazione=1500;
			break;
		}

		double costoTotale = (costoBase * giorni) + costoDestinazione + costoMezzo;
		System.out.println(costoTotale);
		double penale = 0;
		double sconto = 0;

		if (partecipanti <= 10) {
			penale = 2;  // Penale del 2%
			costoTotale += (costoTotale*penale/100);
		} else if (partecipanti > 11 && partecipanti <= 20) {
			penale = 0.5;  // Penale del 5%
			costoTotale += (costoTotale*penale/100);
		} else {
			sconto = 5;   // Sconto del 5%
			costoTotale -= (costoTotale*sconto/100);
		}

		double costoPartecipante = costoTotale / partecipanti;


		System.out.println("SCHEDA DI VIAGGIO "+ 
				"\n* Destinazione: "+ destinazione + 
				"\n* Mezzo: "+ mezzo + 
				"\n* Giorni: "+ giorni + 
				"\n* Partecipanti: "+ partecipanti+
				"\n* Sconto: "+ sconto +
				"\n* Penale: "+ penale +
				"%\n*Costo Totale: "+ costoTotale+
				"\n* Costo singola persona: " + costoPartecipante);





	}

}
