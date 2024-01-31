package main;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		// 3) Riempire un AL con numeri generati casualmente tra 1 e 10 compresi
		//    fin quando la loro somma non superi 40. Poi stampare:
		//    elenco dei numeri, il numero dei pari, il numero dei dispari, cancellare i numeri
		//    multipli di 3, modificare tutti i numeri 9 con il numero 0
		
		
		ArrayList<Integer> numeri = new ArrayList<Integer>();
		int somma = 0;
		
		do
		{
		int numeroRandom = (int) (Math.random() * 10) + 1;
		numeri.add(numeroRandom);
		somma += numeroRandom;
		
		}while(somma <=40);
		
		System.out.println(numeri);
		System.out.println("\nLa somma dei numeri randomici: " + somma);
		System.out.println("\nTotale Pari: " + pariElenco(numeri));
		System.out.println("\nTotale Dispari: " + dispariElenco(numeri));
		System.out.println("\nSenza multipli di 3: " + senzaMultipli3(numeri));
		System.out.println("\nModifica dei 9 in 0: " + modificaDei9in0(numeri));
	}
	
	public static int pariElenco(ArrayList<Integer> numeri)
	{
		int ris = 0;
		
		for(Integer n : numeri )
			if(n%2==0)
				ris++;
		
		return ris;
		
	}
	public static int dispariElenco(ArrayList<Integer> numeri) 
	{
		int ris = 0;
		for(Integer n : numeri )
			if(n%2!=0)
				ris++;
		return ris;
	}
	
	public static String senzaMultipli3(ArrayList<Integer> numeri) 
	{
		String ris="";
		
		for(int i = 0; i < numeri.size(); i++)
		{
			boolean cancellato = false;
			if(numeri.get(i)%3==0) {
				cancellato = true;
			}
			if(!cancellato)
				ris += numeri.get(i) + ", ";
		}
		
		
		return ris.isEmpty() ? "\nNessun multiplo di 3" : ris.substring(0,ris.length()-2); 
	}
	
	public static ArrayList<Integer> modificaDei9in0(ArrayList<Integer> numeri) 
	{
		ArrayList<Integer> numeriModificati = new ArrayList<>(numeri);

        for (int i = 0; i < numeriModificati.size(); i++) {
            if (numeriModificati.get(i) == 9) {
                numeriModificati.set(i, 0);
            }
        }

        return numeriModificati;
	}

}
