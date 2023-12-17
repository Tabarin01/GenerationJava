package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		String nome, residenza;
		int eta, mesi;
		double stipendioMedio, tasse = 0;

		System.out.println("Digita il nome: ");
		nome = inp.nextLine();
		System.out.println("Digita la residenza: ");
		residenza = inp.nextLine();
		System.out.println("Digita la tua eta': ");
		eta = Integer.parseInt(inp.nextLine());
		System.out.println("Digita il tuo stipendio mensile: ");
		stipendioMedio = Integer.parseInt(inp.nextLine());
		System.out.println("Quanti mesi prevede il tuo contratto: ");
		mesi = Integer.parseInt(inp.nextLine());


		if(mesi >=12) {
			switch(residenza.toLowerCase()) {
			case "milano":
				tasse = stipendioMedio*2/100;
				if(eta<21 || eta >= 65) {
					System.out.println("Solo tassa base");
				}else if(eta >=21 && eta <35) {
					tasse += (stipendioMedio*1/100);
				}else if(eta>=35 && eta<65) {
					tasse += (stipendioMedio*2/100);
				}
				break;
			case "roma":
				tasse = stipendioMedio*1.5/100;
				if(eta<25 || eta >= 65) {
					System.out.println("Solo tassa base");
				}else if(eta >=25 && eta <65) {
					tasse += stipendioMedio*2/100;
				}
				break;
			case "bergamo":
				tasse = stipendioMedio*1/100;
				if(eta<25) {
					tasse += stipendioMedio*0.5/100;
				}else {
					tasse += stipendioMedio*1.5/100;
				}
				break;
			default:
				tasse += stipendioMedio*2.5/100;
			}
			 System.out.println("Nome: " + nome.toUpperCase());
	         System.out.println("Importo tasse mensili: " + tasse +"$");
	         System.out.println("Importo tasse annuali: " + tasse * mesi +"$");
		}else {
			System.out.println("Si tassano solo gli stipendi annuali");
		}
		

	}

}
