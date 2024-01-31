package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> numeri;

		Scanner file = null;
		String path = "src/res/Dati.txt";
		Scanner tastiera = new Scanner(System.in);

		do 
		{
			try 
			{
				file = new Scanner(new File(path));
				numeri = new ArrayList<Integer>();
				break;

			}catch(FileNotFoundException e)
			{
				System.out.println("File non trovato nel percorso " + path + "\nDigita un nuovo percorso:");
				path = tastiera.nextLine();
			}
		}while(true);

		tastiera.close();
		while(file.hasNextLine())
		{
			String[] info = file.nextLine().split(",");
			for(String n: info)
				numeri.add(Integer.parseInt(n));
		}
		numeri.sort(null);
		
		System.out.println("Elenco dei numeri da file: " + numeri +
				"\nIl numero maggiore nella serie: " + numeroMax(numeri) + 
				"\nMedia totale: " + mediaTotale(numeri) +
				"\nMedia dei multipli di 5: " + mediaMultipli5(numeri) +
				"\nNumero minore tra i multipli di 3: " + numeroMinMultipli3(numeri)+
				"\nElenco con 10 al posto di 7: " + modifica7in10(numeri)+
				"\nRimozione numero tra 10 e 25: " + removeNumbers(numeri) +
				"\nElenco dei numeri in ordine crescente: "+ ordineCrescente(numeri)) ;

	}//main

	public static int numeroMax(ArrayList<Integer> numeri) 
	{
		int numeroMax = 0;
//		for(Integer n : numeri) {
//			if(numeroMax < n)
//				numeroMax = n;
//		}	
		
		for (Integer n : numeri) {
            numeroMax = Math.max(numeroMax, n);
        }
		return numeroMax;
	}
	
	public static double mediaTotale(ArrayList<Integer> numeri) 
	{
		int somma = 0;
		
		for(int numero: numeri) 
		{
			somma+=numero;
		}
		
		return (double) somma/numeri.size();
	}
	
	public static double mediaMultipli5(ArrayList<Integer> numeri) 
	{
		int somma = 0, conta = 0;
		
		for(int numero : numeri) 
		{
			if(numero%5==0) 
			{
				somma += numero;
				conta++;
			}
		}
		
		
		return (double) somma/conta;
	}
	
	public static int numeroMinMultipli3(ArrayList<Integer> numeri) 
	{
		int numeroMin = Integer.MAX_VALUE;
		
		for (Integer n : numeri) {
			if(n%3==0)
            numeroMin = Math.min(numeroMin, n);
        }
		
		return numeroMin;
	}
	
	public static ArrayList<Integer> modifica7in10(ArrayList<Integer> numeri) 
	{
		ArrayList<Integer> numeriModificati = new ArrayList<>(numeri);

        for (int i = 0; i < numeriModificati.size(); i++) {
            if (numeriModificati.get(i) == 7) {
                numeriModificati.set(i, 10);
            }
        }

        return numeriModificati;
	}
	
	public static String removeNumbers(ArrayList<Integer> numeri) 
	{
//		ArrayList<Integer> numeriModificati = new ArrayList<>(numeri);
//
//        numeriModificati.removeIf(numero -> numero >= 10 && numero <= 25);
        
//        for (Integer numero : numeri) {
//            if (numero < 10 || numero > 25) {
//                numeriModificati.add(numero);
//            }
//        }
		String ris = "";
		
		for(int i = 0; i < numeri.size(); i++)
		{
			if(!(numeri.get(i)>=10 && numeri.get(i)<=25)) {
				ris += numeri.get(i) + ", ";
			}		
		}
        
        return ris.isEmpty() ? "Nessun numero compreso tra 10 e 25" : ris.substring(0,ris.length()-2);
	}
	
	public static ArrayList<Integer> ordineCrescente(ArrayList<Integer> numeri)
	{
		for(int i = 0; i<numeri.size()-1; i++) 
		{
			int minIndex = i;
			
			for(int j = i + 1; j< numeri.size(); j++) 
			{
				if(numeri.get(j)< numeri.get(minIndex)) 
				{
					minIndex = j;
				}
			}
			int temp = numeri.get(minIndex);
			numeri.set(minIndex, numeri.get(i));
			numeri.set(i, temp);
		}
		
		return numeri;
	}
	

}//class
