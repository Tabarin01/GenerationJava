package main;

import java.util.Scanner;

public class NumberExercise {

	public static void main(String[] args) {

		Scanner inp = new Scanner(System.in);

		System.out.println("Inserisci il primo numero: ");
		int num1 = Integer.parseInt(inp.nextLine());
		System.out.println("Inserisci il secondo numero: ");
		int num2 = Integer.parseInt(inp.nextLine());
		System.out.println("Inserisci il terzo numero: ");
		int num3 = Integer.parseInt(inp.nextLine());

		inp.close();
		
 
		    //Primo numero
		    System.out.print("\t Scheda numeri selezionati \n" +
	                " Il numero " + num1 + " è: ");
	        if (num1 % 2 == 0) {
	            System.out.print("pari;");
	        } else {
	            System.out.print("dispari;");
	        }
	        if (num1 > 5) {
	            System.out.print(" maggiore di 5;");
	        }
	        if (num1 > 25) {
	            System.out.print(" numero grande;");
	        }
	        if (num1 < 0) {
	            System.out.print(" numero negativo;");
	        }  
	        
	        // Secondo numero
	        System.out.print("\n" +
	                " Il numero " + num2 + " è: ");
	        if (num2 % 2 == 0) {
	            System.out.print("pari;");
	        } else {
	            System.out.print("dispari;");
	        }
	        if (num2 > 5) {
	            System.out.print(" maggiore di 5;");
	        }
	        if (num2 > 25) {
	            System.out.print(" numero grande;");
	        }
	        if (num2 < 0) {
	            System.out.print(" numero negativo;");
	        }
	        
	        //Terzo numero
	        System.out.print("\n" +
	                " Il numero " + num3 + " è: ");
	        if (num3 % 2 == 0) {
	            System.out.print("pari;");
	        } else {
	            System.out.print("dispari;");
	        }
	        if (num3 > 5) {
	            System.out.print(" maggiore di 5;");
	        }
	        if (num3 > 25) {
	            System.out.print(" numero grande;");
	        }
	        if (num3 < 0) {
	            System.out.print(" numero negativo;");
	        }
	        
	}

}
