package main;


/* Biglietteria a Vezio
 * Intero 10 euro
 * Sconti non cumulabili
 * I residenti a Vezio e Como entrano gratis
 * Studenti 30% di sconto
 * Under 12 e over 65 50% di sconto
 * Militari e medici 65% di sconto
 * 
 * Scrivere programma che chieda i dati 
 * all'utente e calcoli il prezzo del suo biglietto
 * */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String residenza, professione;
        int eta;
        boolean studente;
        double totale;

        System.out.println("Benvenuto alla Biglietteria a Vezio!");
        double biglietto = 10;

        System.out.println("Residenza: ");
        residenza = tastiera.nextLine().toLowerCase();

        System.out.println("Professione: ");
        professione = tastiera.nextLine().toLowerCase();

        System.out.println("Età: ");
        eta = Integer.parseInt(tastiera.nextLine());

        System.out.println("Sei studente? si/no: ");
        studente = tastiera.nextLine().equalsIgnoreCase("si");

        if (residenza.equals("vezio") || residenza.equals("como")) {
            System.out.println("Lei entra gratis!");
        } else if (professione.equals("medico") || professione.equals("militare")) {
            totale = (biglietto * 65) / 100;
            System.out.println("Paga: " + totale);
        } else if (eta <= 12 || eta >= 65) {
            totale = (biglietto * 50) / 100;
            System.out.println("Paga: " + totale);
        } else if (studente) {
            totale = (biglietto * 30) / 100;
            System.out.println("Paga: " + totale);
        } else {
            totale = biglietto;
            System.out.println("Paga: " + totale);
        }

        tastiera.close();
    }
}




        

       

       

      

