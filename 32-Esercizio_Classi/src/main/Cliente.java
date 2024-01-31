package main;

import java.time.LocalDate;

public class Cliente {


	//ATTRIBUTI
	String nome, cognome, dob, pT, obiettivo;	
	boolean abbonamento;

	//COSTRUTTORE: ha il compito di costruire un oggetto, 
	//			   cioè ha il compito di valore
	// 
	//In sostanza un costruttore è un metodo un po' più particolare degli altri.

		Cliente(){
	//		
	//		// Scritto così si chiama COSTRUTTORE VUOTO ed è sempre presente in
	//		// automatico se voi non scrivete nulla.
	//		//Nel momento in cui scrivete a mano un costruttore, quello vuoto si disattiva
	//	
		}

	//COSTRUTTORE PIENO: Significa che ha dei PARAMETRI, cioè chiede dei dati in input per fare i calcoli nel metodo
	Cliente(String nome, String cognome, String dob, String pT, String obiettivo, boolean abbonamento){

		//Proprietà = Parametro -> THIS si usa solo nei casi di omonimia (cioè stesso nome) e nel nostro caso indica
		// 							quale delle due è la proprietà

		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.pT = pT;
		this.obiettivo = obiettivo;
		this.abbonamento = abbonamento;

	}

	//Quanti costruttori posso avere in una classe? Potenzialmente infiniti, l'unico limite sarà dettato dalla natura
	//												dei parametri che vogliono scrivere nella firma del metodo




	//METODI

	String scheda() {
		String ris = "";

		ris = "Cliente: "       + nome  + " "         + cognome +
				"\nNato il "    + dob   + " di anni " + eta()   +
				"\nSeguito da " + pT    +
				"\nObiettivo: " + obiettivo 		  +
				"\nAbbonato: "  + (abbonamento ? "Sì" : "No")   +
				"\n--------------------------------------\n";


		return ris;
	}

	int eta() {

		int ris = 0;
		String[] data = dob.split("-");  // -> "gg" posizione 0,"mm" posizione 1,"yyyy" posizione 
		String anno = data[2];
		int annoNascita = Integer.parseInt(anno);


		//SCRITTURA COMPRESSA
		//int annoNascita = Integer.parseInt(dob.split("-")[2]);

		//LocalDate.now().getYear() ->
		//Dove: 
		//LocalDate importa una classe dalla JDK che gestisce le date
		// .now() Preleva la data del sistema
		// .getYear() estrapola solo l'anno
		ris = LocalDate.now().getYear() - annoNascita;

		return ris;

	}


}
