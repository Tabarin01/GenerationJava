package main;

import java.util.Scanner;

public class NameExercise {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String nome1,nome2,nome3,nome4,nome5;

		System.out.println("Inserisci il primo nome: ");
		nome1 = scanner.nextLine().toLowerCase();
		System.out.println("Inserisci il secondo nome: ");
		nome2 = scanner.nextLine().toLowerCase();
		System.out.println("Inserisci il terzo nome: ");
		nome3 = scanner.nextLine().toLowerCase();
		System.out.println("Inserisci il quarto nome: ");
		nome4 = scanner.nextLine().toLowerCase();
		System.out.println("Inserisci il quinto nome: ");
		nome5 = scanner.nextLine().toLowerCase();

		String risultato ="";													
		
        //Primo nome
		if(nome1.equals("uberto")|| nome1.equals("zenelao")) {
			risultato += " nome raro;";
		}else if(nome1.equals("estella")||nome1.equals("frisella")) {
			risultato += " nome esotico;";
		}else if(nome1.equals("mario")) {
			risultato += " come l'idrauilico più famoso al mondo;";
		}else {
			risultato += " nome comune;";
		}

		if(nome1.endsWith("a")) {
			risultato += " finisce con la 'a';";
		}else if(nome1.lastIndexOf("o") == nome1.length() -1) {
			risultato += " finisce con la 'o';";
		}
		if(nome1.length()>7) {
			risultato += " è lungo;";
		}
		System.out.println("\t Scheda nomi selezionati \n"    +
				"Il nome: '"+ nome1.toUpperCase() + " è: "+ risultato);
		
		//Secondo nome
		if(nome2.equals("uberto")|| nome2.equals("zenelao")) {
			risultato = " nome raro;";
		}else if(nome2.equals("estella")||nome2.equals("frisella")) {
			risultato += " nome esotico;";
		}else if(nome2.equals("mario")) {
			risultato += " come l'idrauilico più famoso al mondo;";
		}else {
			risultato += " nome comune;";
		}

		if(nome2.endsWith("a")) {
			risultato += " finisce con la 'a';";
		}else if(nome2.lastIndexOf("o") == nome2.length() -1) {
			risultato += " finisce con la 'o';";
		}
		if(nome2.length()>7) {
			risultato += " è lungo;";
		}
		System.out.println("\n"    +
				"Il nome: '"+ nome2.toUpperCase() + " è: "+ risultato);
		
		//Terzo nome
		if(nome3.equals("uberto")|| nome3.equals("zenelao")) {
			risultato = " nome raro;";
		}else if(nome3.equals("estella")||nome3.equals("frisella")) {
			risultato += " nome esotico;";
		}else if(nome3.equals("mario")) {
			risultato += " come l'idrauilico più famoso al mondo;";
		}else {
			risultato += " nome comune;";
		}

		if(nome3.endsWith("a")) {
			risultato += " finisce con la 'a';";
		}else if(nome3.lastIndexOf("o") == nome3.length() -1) {
			risultato += " finisce con la 'o';";
		}
		if(nome3.length()>7) {
			risultato += " è lungo;";
		}
		System.out.println("\n"    +
				"Il nome: '"+ nome3.toUpperCase() + " è: "+ risultato);
		
		//Quarto nome
		if(nome4.equals("uberto")|| nome4.equals("zenelao")) {
			risultato = " nome raro;";
		}else if(nome4.equals("estella")||nome4.equals("frisella")) {
			risultato += " nome esotico;";
		}else if(nome4.equals("mario")) {
			risultato += " come l'idrauilico più famoso al mondo;";
		}else {
			risultato += " nome comune;";
		}

		if(nome4.endsWith("a")) {
			risultato += " finisce con la 'a';";
		}else if(nome4.lastIndexOf("o") == nome4.length() -1) {
			risultato += " finisce con la 'o';";
		}
		if(nome4.length()>7) {
			risultato += " è lungo;";
		}
		System.out.println("\n"    +
				"Il nome: '"+ nome4.toUpperCase() + " è: "+ risultato);
		
		//Quinto nome
		if(nome5.equals("uberto")|| nome5.equals("zenelao")) {
			risultato = " nome raro;";
		}else if(nome5.equals("estella")||nome5.equals("frisella")) {
			risultato += " nome esotico;";
		}else if(nome5.equals("mario")) {
			risultato += " come l'idrauilico più famoso al mondo;";
		}else {
			risultato += " nome comune;";
		}

		if(nome5.endsWith("a")) {
			risultato += " finisce con la 'a';";
		}else if(nome5.lastIndexOf("o") == nome5.length() -1) {
			risultato += " finisce con la 'o';";
		}
		if(nome5.length()>7) {
			risultato += " è lungo;";
		}
		System.out.println("\n"    +
				"Il nome: '"+ nome5.toUpperCase() + " è: "+ risultato);
	}

}


