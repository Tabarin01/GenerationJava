package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
	
	public static void main(String[] args) {
		
		 try {
	            // Apri il file
	            Scanner file = new Scanner(new File("src/res/elenco.txt"));

	            String nome, cognome;
	            int eta;
	            
	            // Leggi la riga dal file
	            while (file.hasNextLine()) {
	                String riga = file.nextLine();
	                String[] infoRiga = riga.split(",");

	                // Stampa le informazioni in modo ordinato
	               nome = infoRiga[0];
	               cognome = infoRiga[1];
	               eta = Integer.parseInt(infoRiga[2]);
	               
	               System.out.println("Nome: " + nome + "\nCognome: " + cognome + "\nEtà: " + eta);
	            } 
	            file.close();
	            
	           
	        } catch (FileNotFoundException e) {
	            System.out.println("Errore: File non trovato.");
	            e.printStackTrace();
	        }
	}

}
