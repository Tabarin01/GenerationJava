package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String percorso = "src/res/Bar.txt";
        String[] nomeProdotti = null;
        double[] prezzi = null;

        Scanner file = null;
        try {
            file = new Scanner(new File(percorso));

            int cont = 0;

            while (file.hasNextLine()) {
                file.nextLine();
                cont++;
            }

            nomeProdotti = new String[cont];
            prezzi = new double[cont];

            file.close();
            file = new Scanner(new File(percorso));
            file.useDelimiter(",\\s*|\\n");

            int i = 0;
            while (file.hasNextLine()) {
                nomeProdotti[i] = file.nextLine();
                prezzi[i] = Double.parseDouble(file.nextLine());
                i++;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File non trovato: " + percorso);
            e.printStackTrace();
        } finally {
            if (file != null) {
                file.close();
            }
        }

        String risposta = "";
        String menu = "\n\tSCELTE\n" +
                "1 > Menu del Bar\n" +
                "2 > Prodotti economici\n" +
                "3 > Costo medio prodotti\n" +
                "4 > Costo medio prodotti con parola caffe\n" +
                "0 > Esci";

        String cmd = "";
        do {
            System.out.println(menu + "\n\nScegli: ");
            cmd = tastiera.nextLine();

            switch (cmd) {
                case "1":
                    for (int j = 0; j < nomeProdotti.length; j++) {
                        risposta += nomeProdotti[j] + " " + prezzi[j] + "\n";
                    }
                    break;
                case "2":
                    double prezzoMinimo = Double.MAX_VALUE;
                    String prodottoEconomico = "";

                    for (int j = 0; j < nomeProdotti.length; j++) {
                        if (prezzi[j] < prezzoMinimo) {
                            prezzoMinimo = prezzi[j];
                            prodottoEconomico = nomeProdotti[j];
                        }
                    }
                    risposta = "Il prodotto più economico è: " + prodottoEconomico;
                    break;
                case "3":
                	double somma = 0;
					int i = 0;
					while (i< prezzi.length) {
						somma += prezzi[i];
						i++;
					}
					if(somma >0) 
						risposta = "Il prezzo medio del bar vale: "+ somma/prezzi.length + "$";
					else
						risposta = "Non ho elementi per calcolare il prezzo medio";
					break;
                   
                case "4":
                	int conta = 0;
					somma = 0;

					i = 0;
					
					while(i< prezzi.length) {
						
						if(nomeProdotti[i].toLowerCase().contains("caffe")) {
							somma += prezzi[i];
							conta++;
						}
						i++;
					}

					if(somma>0) 
						risposta = "Il prezzo medio dei prodotti con la parola caffe vale: " + somma/conta + "$";
					else
						risposta = "Non ho elementi per calcolare il prezzo medio dei prodotti con la parola caffe";

					break;
                case "5":
                	System.out.println("Cosa vuoi ordinare?");
					String ordineCliente = tastiera.nextLine();
					
					i = 0;
					
					while(i< nomeProdotti.length) {
						if(nomeProdotti[i].equalsIgnoreCase(ordineCliente)) {
							
							risposta = "Il prodotto " + ordineCliente.toUpperCase()+ "costa " + prezzi[i] + "$";
						}
						i++;
					}
					if(risposta.isEmpty()) 
						risposta = "Non vendiamo " + ordineCliente.toUpperCase();
					
					break;
                case "0":
                    System.out.println("Programma terminato.");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
                    break;
            }
            System.out.println(risposta);
        } while (!cmd.equals("0"));


        tastiera.close();
    }
}
