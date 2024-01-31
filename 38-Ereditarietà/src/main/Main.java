package main;

import java.io.FileNotFoundException;

import entities.Concessionaria;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		// Scrivere un programma che gestisca una concessionaria di auto e moto.
		// I dati che avrete a disposizione saranno formattati nel seguente modo:
		// a,marca,modello,colore,ariacondizionata,cerchiinlega,capienzaserbatoio,chilometriallitro
		// m,marca,modello,colore,capienzaserbatoio,chilometriallitro,passeggero,bauletti
		// Scrivere le classi, leggere i dati e poi rispondere alle domande:
		// -Elenco delle auto
		// -Elenco delle moto
		// -Veicoli con maggiore autonomia
		// -veicoli che data una distanza e il numero di passeggeri, possono portarti a destinazione
		// -veicoli di una marca cercata
		
		Concessionaria c = new Concessionaria("src/res/Dati.txt");
		
		System.out.println(c.elencoAuto());
		System.out.println(c.elencoMoto());
		System.out.println(c.maggiorAutonomia());
		System.out.println(c.raggiunge(1000,4));
		System.out.println(c.cerca("fiat"));
		
		
		
		
		

	}//main

}//class
