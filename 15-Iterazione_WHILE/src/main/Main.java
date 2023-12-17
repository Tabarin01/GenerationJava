package main;

import java.util.Scanner;

public class Main {

	//Introduzione del while
	
	public static void main(String[] args) {

		Scanner inp = new Scanner(System.in);
		int numero, somma = 0;

		try {
			System.out.println("Digita un numero: ");
			numero = Integer.parseInt(inp.nextLine());

			while(numero >= 0) {

				somma += numero;
				System.out.println("Ancora: ");
				numero = Integer.parseInt(inp.nextLine());
			}
		} catch (NumberFormatException e) {
			System.out.println("Errore di formato: Inserisci un numero valido.");
			System.exit(0);
		} catch (Exception e) {
			System.out.println("Si è verificato un errore: " + e.getMessage());
			System.exit(0);
		} finally {
			inp.close();
		}
		
		System.out.println("La somma dei tuoi numeri e': " + somma);
	
	}

}
