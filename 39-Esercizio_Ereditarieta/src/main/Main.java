package main;

import java.io.FileNotFoundException;


import entities.MezziTrasporto;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Scrivere un programma che gestisca i mezzi di trasporto di una città
        // Avrete un file che seguirà la seguente formattazione:
        // tram,linea,vagoni,posti a sedere, posti in piedi,binario singolo(boolean),notturno(boolean)
        // metro,linea,vagoni,posti a sedere,posti in piedi,passa in superficie(boolean),notturno(boolean)
        // autobus,linea,posti a sedere,posti in piedi,doppio piano(boolean),notturno(boolean)
        // Capite che grado di parentela c'è tra le classi necessarie, poi leggete il file
        // e rispondete alle seguenti domande:
        // - elenco tram
        // - elenco metro
        // - elenco autobus
        // - elenco notturni
        // - trovare il mezzo migliore per gestire il numero di persone dato
        // - trovare il mezzo con minore capienza
        // - trovare il mezzo per una linea cercata

		MezziTrasporto m = new MezziTrasporto("src/res/Dati.txt");
		
		System.out.println(m.elencoTram());
		System.out.println(m.elencoMetro());
		System.out.println(m.elencoAutobus());
		System.out.println(m.trovaNotturni());
		System.out.println(m.mezzoPerLinea("B"));
		System.out.println(m.minorCapienza());
		System.out.println(m.migliorGestione(16));
		
		
	}

}
