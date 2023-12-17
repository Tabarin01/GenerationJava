package main;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		//D
		String [] nomi = {"Alice", "Davide","Lorenzo","Claudia","Stefano", "Anna", "Manuel", "Diana","Diego","Marco"};;

		//I
		nomi = new String [10];


		//Riempire un vettore
		nomi[0] = "Alice";
		nomi[1] = "Davide";
		nomi[2] = "Lorenzo";
		nomi[3] = "Claudia";
		nomi[4] = "Stefano";
		nomi[5] = "Anna";
		nomi[6] = "Manuel";
		nomi[7] = "Diana";
		nomi[8] = "Diego";
		nomi[9] = "Marco";


		System.out.println(Arrays.toString(nomi) + "\n");

		int i = 0 , j =0;



		//Nomi con A
		while(i < nomi.length) {
			// Con charAt()----if(nomi[i].toLowerCase().charAt(0) == 'a')
			if(nomi[i].toLowerCase().startsWith("a") && nomi[i] != null) {

				System.out.println(nomi[i]) ;

			}

			i++;

		}
		System.out.println("");
		
		//Stampa con un ciclo
		while(j < nomi.length) {
			
			System.out.println(nomi[j]);
			j++;
		}

	}
}


