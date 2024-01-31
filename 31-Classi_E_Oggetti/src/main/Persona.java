package main;


/*
 Questa è una CLASSE, 
 in particolare si chiama CLASSE MODELLO

 */
public class Persona {


	//Una classe si compone di due elementi diversi:

	//-1) PROPRIETA': sono le caratteristiche che mi interessa rappresentare nel concreto con i miei oggetti
	String nome;
	String cognome;
	int eta;
	boolean patentato;

	//             					ATTENZIONE
	//			MAI MAI MAI MAI MAI Inizializzare le proprietà in linea!
	// SI dichiarano e basta
	// Esistono pochissime eccezioni a questa regola

	//-2) METODO: è un algoritmo che dato un input calcola un output
	//		Ogni metodo si compone di una cosa chiamata FIRMA DEL METODO
	//		La firma del metodo è data dal nome (scheda) e dal contenuto delle parentesi tonde che siano piene o vuote poco importa
	//		Prima della firma del metodo dobbiamo sempre mettere il così detto TIPO di RITORNO
	// 		return è il tipo di dato che vogliamo dare in output
	//TIPO    FIRMA
	String scheda() {
		// le graffe indicano il corpo del metodo
		
		String ris = "";

		ris = "Nominativo: " + nome + " " + cognome 			           +
			  "\ndi anni "   + eta  							 		   +
			  "\n" 			 + (patentato ? "Patentato" : "Senza patente") +
			  "\n-----------------------------------------\n";

		// RETURN è la parola chaive che spedisce all'esterno di un metodo il valore della variabile
		// o del calcolo che gli scriviamo accanto
		// Se ho un tipo di ritorno, devo per forza avere un return del tipo dichiarato nel metodo

		return ris;
	}







}
