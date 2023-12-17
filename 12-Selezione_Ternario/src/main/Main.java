package main;

import java.util.Scanner;

/* Scrivere un programma che permetta di calcolare se
uno studente può andare in erasmus
uno studente inserisce direttamente le medie di 4 materie
italiano, matematica, inglese e francese
-se la media globale è superiore a 7
può andare in erasmus a Londra e avere una borsa di studio di 300 euro
-se la media globale è superiore a 7
e la media di francese è maggiore di 8
può andare in erasmus a Parigi o a Londra e può avere una borsa di 400 euro
-se la media globale è superiore a 8
e la media di francese o la media di inglese
è maggiore di 8
può andare in erasmus a Vancouver e può avere una borsa di studio di 1000 euro
 */


public class Main {

	public static void main(String[] args) {

		Scanner inp = new Scanner (System.in);
		boolean erasmus;
		double mediaItaliano;
		double mediaMatematica;
		double mediaInglese;
		double mediaFrancese;
		double mediaGlobale;
		String localitaErasmusPapabili = "";
		double borsaStudio;

		erasmus = false;
		mediaGlobale = 0;
		borsaStudio = 0;

		System.out.println("Media Italiano: ");
		mediaItaliano = Double.parseDouble(inp.nextLine());
		System.out.println("Media Matematica: ");
		mediaMatematica = Double.parseDouble(inp.nextLine());
		System.out.println("Media Inglese: ");
		mediaInglese = Double.parseDouble(inp.nextLine());
		System.out.println("Media Francese: ");
		mediaFrancese = Double.parseDouble(inp.nextLine());

		inp.close();

		mediaGlobale = (int) (mediaItaliano + mediaMatematica 
				+ mediaInglese + mediaFrancese)/4.0;



		//Metodo 2 con ternary operator

		erasmus = mediaGlobale > 7 ? true : false;
		localitaErasmusPapabili = mediaGlobale > 7 ? "Londra o Parigi" : "Nope";
		borsaStudio = mediaGlobale > 7 ? 400 : 0;

		erasmus = mediaGlobale >= 8 ? true : false;
		localitaErasmusPapabili = mediaGlobale >= 8 ? "Vancouver" : "Nope";
		borsaStudio = mediaGlobale >= 8 ? 1000 : 0;



		String risposta = (erasmus == true) ? "Località: " 
				+ localitaErasmusPapabili + ", Borsa di Studio: " 
				+ borsaStudio : "niente";

		risposta = mediaGlobale > 8 ? 
				(erasmus = true) + 
				(localitaErasmusPapabili = "Londra o Parigi") + 
				(borsaStudio = 400) : "Nope";

		System.out.println(risposta);

//		struct A { int x; int y; } a = { 1, 2 };
//
//		a = a.x < a.y ? ( struct A ){ a.y, a.x } : ( struct A ){ ++a.x, --a.y }; 


		//Metodo 1 con if else
		//		if(mediaGlobale > 7) 
		//		{
		//			erasmus = true;
		//			localitaErasmusPapabili = "Londra o Parigi";
		//			borsaStudio = 400;
		//		}
		//
		//		if(mediaGlobale > 8 && (mediaFrancese >= 8 || mediaInglese >= 8)) 
		//		{
		//			erasmus = true;
		//			localitaErasmusPapabili = "Vancouver";
		//			borsaStudio = 1000;
		//		}
		//		if(erasmus == true) 
		//		{
		//			System.out.println(
		//					"Puoi andare in Erasmus a: "+ localitaErasmusPapabili +
		//					", con" + borsaStudio + " euro di borsa di studio");
		//		}else 
		//		{
		//			System.out.println("Non puoi andare in Erasmus!");
		//		}


	}

}
