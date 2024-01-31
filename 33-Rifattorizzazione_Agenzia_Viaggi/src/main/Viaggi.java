package main;

public class Viaggi {

	String destinazione,mezzo;
	int giorni, persone, prezzoQuotidiano;






	Viaggi(String destinazione, String mezzo, int giorni, int prezzoQuotidiano, int persone) {

		this.destinazione = destinazione;
		this.mezzo = mezzo;
		this.giorni = giorni;
		this.prezzoQuotidiano = prezzoQuotidiano;
		this.persone = persone;
	}





	String scheda() {
		String ris = "";

		ris = "Destinazione: "       + destinazione.toUpperCase() +
				"\nMezzo: "    + mezzo.toUpperCase() + 
				"\nGiorni: " + giorni    +
				"\nPrezzo giornaliero: " + prezzoQuotidiano + " $" +
				"\nNumero di persone: "  + persone   +
				"\nPrezzo totale: " + calcoloPrezzo() + " $" +
				"\n--------------------------------------\n";


		return ris;
	}



	//  Calcolo del prezzo:
	//Prezzo base 100;
	//se la destinazione è Dubai o Tokyo aggiungo 200, se è Dublino o Londra aggiungo 150,
	//            se è New York o Miami aggiungo 300. In tutti gli altri casi aggiungo 50
	//se il mezzo di trasporto è aereo o traghetto aggiungo 500, se è treno aggiungo 200,
	//            e è automobile o autobus aggiungo 100. In tutti gli altri casi aggiungo 1000
	//se le persone sono più di 5 scontare il viaggio del 5%, se invece sono più di 10 scontare il
	//            viaggio del 10%.

	double calcoloPrezzo() {

		double prezzoBase = (prezzoQuotidiano * giorni) + 100;

		switch(destinazione.toLowerCase()) {

		case "dubai":
		case "tokyo":
			prezzoBase += 200;
			break;
		case"dublino":
		case"londra":
			prezzoBase += 150;
			break;
		case"new york":
		case"miami":
			prezzoBase += 300;
			break;
		default:
			prezzoBase += 50;
		}

		switch(mezzo.toLowerCase()) {

		case "aereo":
		case "nave":
			prezzoBase += 500;
			break;
		case"treno":
			prezzoBase+=200;
			break;
		case"auto":
		case"autobus":
			prezzoBase +=100;
			break;
		default:
			prezzoBase +=1000;
		}

		if(persone > 5 && persone < 10)
			prezzoBase -= prezzoBase*5/100;
		if(persone > 10)
			prezzoBase -= prezzoBase*10/100;


		return prezzoBase;
	}


}
