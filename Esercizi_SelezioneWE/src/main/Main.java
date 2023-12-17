package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		int scelta;

		System.out.println("Quale esercizio vuoi controllare (digita il numero corrispondente)? \n \n"
				+ "-1.Area quadrato e rettangolo \n"
				+ "-2.Maggiore di 3 numeri\n"
				+ "-3.Media mensile del capitale\n"
				+ "-4.Biglietti adulti & bambini\n"
				+ "-5.Ingresso discoteca\n");
		scelta = Integer.parseInt(inp.nextLine());

		switch(scelta) {
		case 1:
			esercizioArea();
			break;
		case 2:
			System.out.println("Numero maggiore = " + esercizioMax());
			break;
		case 3:
			esercizioCapitale();
			break;
		case 4:
			esercizioBiglietti();
			break;
		case 5:
			esercizioDisco();
			break;
		default:
			System.out.println("Scelta non valida!");
		}
		inp.close();

	}


	public static void esercizioArea() {
		Scanner inp = new Scanner (System.in);
		int base, altezza, lato, areaRett, areaQuadr, perimRett, perimQuadr;

		System.out.println("Inserisci la base del rettangolo: ");
		base = Integer.parseInt(inp.nextLine());
		System.out.println("Inserisci l'altezza del rettangolo: ");
		altezza = Integer.parseInt(inp.nextLine());
		System.out.println("Inserisci il lato del quadrato: ");
		lato = Integer.parseInt(inp.nextLine());

		inp.close();

		perimRett = 2*(base + altezza);
		areaRett = base * altezza;
		System.out.println("\tAree parallelepipedi\n"+"- Perimetro rettangolo: "+ perimRett + " Area rettangolo: "+ areaRett);

		perimQuadr = lato * 4;
		areaQuadr = lato * lato;		
		System.out.println("- Perimetro quadrato: "+ perimQuadr + " Area quadrato: "+ areaQuadr);

		if(areaQuadr == areaRett) {
			System.out.println("- Le due figure hanno aree uguali");
		}else if(areaQuadr > areaRett){
			System.out.println("- Il quadrato ha l'area maggiore");
		}else {
			System.out.println("- Il rettangolo ha l'area maggiore");
		}
	}

	public static int esercizioMax() {

		Scanner input = new Scanner(System.in);
		int num1,num2,num3,max;


		System.out.println("Inserisci il primo numero: ");
		num1 = Integer.parseInt(input.nextLine());
		System.out.println("Inserisci il secondo numero: ");
		num2 = Integer.parseInt(input.nextLine());
		System.out.println("Inserisci il terzo numero: ");
		num3 = Integer.parseInt(input.nextLine());
		max = num1;

		if(max < num2) {
			max = num2;
		}
		if(num3 > max) {
			max = num3;
		}
		return max;
	}

	public static void esercizioCapitale() {
		Scanner inp = new Scanner(System.in);

		double capitale, tassoInteresse, interesse;
		float mediaMensile;
		int mesi, anni =0;

		System.out.println("Inserisci il capitale: ");
		capitale = Double.parseDouble(inp.nextLine());
		System.out.println("Inserisci il tasso di interesse: ");
		interesse = Integer.parseInt(inp.nextLine());
		System.out.println("Inserisci i mesi: ");
		mesi = Integer.parseInt(inp.nextLine());

		if(mesi < 0) {
			System.out.println("Tempo inserito non valido");
		}else {

			anni = mesi/12;
			tassoInteresse = capitale*interesse/100;

			mediaMensile = (float) ((capitale + (tassoInteresse * anni))/ mesi);

			System.out.println("Media mensile: "+ mediaMensile);

		}
	}

	public static void esercizioBiglietti() {
		Scanner inp = new Scanner(System.in);
		int costoTotale, adultiGratis;

		System.out.println("Quanti adulti siete: ");
		int adulti = Integer.parseInt(inp.nextLine());

		System.out.println("Quanti bambini ci sono: ");
		int bambini = Integer.parseInt(inp.nextLine());

		inp.close();

		if(bambini > 50) {
			System.out.println("Errore: Acquisto non possibile!");
		}else {
			System.out.println("\tRECAP\nAdulti: " + adulti + "\nBambini: "+ bambini);
			adultiGratis = bambini/10;
			System.out.println("Entrano gratis: " + adultiGratis + " adulti");
			adulti -= adultiGratis;
			costoTotale = (adulti *10) + (bambini*5);
			System.out.println("\n\tCosto Totale \n"+ "\t"+costoTotale +" euro");
		}
	}

	public static void esercizioDisco() {

		Scanner inp = new Scanner(System.in);
		String nome, genere;
		int eta;
		double biglietto = 20, sconto = 0;

		System.out.println("Digita il tuo nome: ");
		nome = inp.nextLine();
		System.out.println("Digita la tua eta': ");
		eta = Integer.parseInt(inp.nextLine());
		System.out.println("Genere M/F: ");
		genere = inp.nextLine().toLowerCase();


		if(eta < 20) {
			sconto += 5;
		}
		if(genere.equals("f")) {
			sconto += 10;
		}

		System.out.println("\tRecap:\n"
				+  "Nominativo: "+ nome.toUpperCase() + "\n"
				+  "Anni: " + eta + "\n"
				+  "Sconto di: "+sconto+"$\n"
				+  "Costo biglietto: "+(biglietto -= sconto)+"$");

	}
}
