package main;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {


		// Mappe

		// Definizione

		// Una mappa è un insieme di coppie chiave-valore

		// Le mappe per loro natura tendono al disordine, cioè non esiste un indice che tenga ordinato
		// l'insieme di dati che salviamo nella variabile

		//Al posto dell'indice numerico classico, le mappe hanno le chiavi
		//Una chiave può essere del tipo che si vuole
		// L'unica cosa a cui bisogna prestare attenzione è non far ripetere mai la chiave

		// Ogni chiave mi permetterà di identificare con assoluta certezza il valore a lei associato
		// del tipo a piacere(double int eccetera)
		// il tipo della chiav e il tipo del valore non devono essere per forza uguali

		// Le mappe sono principalmente di due tipi:
		// - ordinate: significa che mantiene l'ordine di inserimento
		// - disordinate: significa che restituiscono un ordine diverso da quello di inserimento

		// DICHIARAZIONE
		// Map e' un'interfaccia che ci permette di scegliere dopo se usare una 
		// mappa ordinata o disordinata
		// IMPORTANTE importare Map da java.util.
		// SINTASSI Map<tipoChiave, tipoValore> nomeMappa;
		Map<String, Integer> merciOrdinate;
		Map<String, Integer> merciDisordinate;

		merciOrdinate = new LinkedHashMap<String, Integer>();  // ordinata

		merciDisordinate = new HashMap<String, Integer>(); // disordinata

		// VALORIZZAZIONE
		// metodo .put(chiave, valore);

		merciOrdinate.put("Pane", 5);
		merciOrdinate.put("Tergicristallo", 1);
		merciOrdinate.put("Latte", 6);
		merciOrdinate.put("Cereali", 1);
		merciOrdinate.put("Pane", 10); // Sovrascrive in base alla chiave, ATTENZIONE

		// STAMPARE Map
		System.out.println(merciOrdinate);


		merciDisordinate.put("Sugo", 1);
		merciDisordinate.put("Succo d'arancia", 2);
		merciDisordinate.put("Pasta", 2);
		merciDisordinate.put("Yogurt", 2);

		System.out.println("\n\n" + merciDisordinate + "\n");


		//COME CICLARE una Map

		// Il ciclo for indicizzato con le mappe non funziona
		// l'unico ciclo che si presta con le mappe è il foreach

		// Le mappe si possono ciclare sia per le chiavi che per i valori
		//         CICLO PER CHIAVI:
		// 				vantaggio-- si possono ottenere sia le informazioni delle chiavi che dei valori collegati alle chiavi
		for(String s : merciOrdinate.keySet()) // keySet() metodo delle mappe che ci restituisce una lista delle chiavi
		{
			System.out.println("Chiave " + s + "   Valore "+ merciOrdinate.get(s));
		}

		// mappa.get(key) --- Restituisce il valore associato alla chiava key


		//			CICLO PER VALORI
		//					posso ottenere solo le informazioni legati ai singoli valori (non sia chiave che valore)
		for(Integer value : merciOrdinate.values()) 
		{
			System.out.println("Valore: " + value);
		}
		
		// CANCELLARE un valore DA MAP
		//		 attraverso il remove(), di solito avviene per chiave, ma si può rimuovere anche per chiave-valore
		merciOrdinate.remove("Pane");
		System.out.println(merciOrdinate);
		
		

	}

}
