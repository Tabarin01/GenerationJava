package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num1, num2, num3;


		System.out.println("Inserisci il primo numero: ");
		num1 = Integer.parseInt(input.nextLine());
		System.out.println("Inserisci il secondo numero: ");
		num2 = Integer.parseInt(input.nextLine());
		System.out.println("Inserisci il terzo numero: ");
		num3 = Integer.parseInt(input.nextLine());

		input.close();

		System.out.println("\t Scheda numeri selezionati \n"                +
				           " Il numero "+ num1 + " è: "+ analisiNumero(num1) + 
				    "\n" + " Il numero "+ num2 + " è: "+ analisiNumero(num2) + 
				    "\n" + " Il numero "+ num3 + " è: "+ analisiNumero(num3));

	}

	public static String analisiNumero(int numero) {
		String risultato = "";

		if(numero %2 == 0) {
			risultato += "pari;"; 
		}else {
			risultato += "dispari;";
		}
		if (numero>5) {
			risultato += " maggiore di 5;";
		}
		if(numero>25) {
			risultato += " numero grande;";
		}
		if(numero<0) {
			risultato += " numero negativo;";
		}

		return risultato;
	}

}
