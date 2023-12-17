package main;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

	// Scrivere in un file i nomi e i voti complessivi di una serie di studenti.
	// Il file scrivetelo come CSV(nome,voto)
	// Leggere il file e salvare i dati nei vettori giusti.
	// Voglio poi vedere:
	// - La lista di tutti gli studenti coi loro voti
	// - Il nome dello studenti( o degli studenti) con il voto maggiore
	// - I nomi degli studenti con un voto superiore alla media complessiva dei voti nel file

	public static void main(String[] args) throws FileNotFoundException {

		Scanner file;
		String[] nomi;
		double[] voti;
		int elementi;
		int indice;

		indice = 0;
		file = new Scanner(new File("src/res/Dati.txt"));

		elementi = Integer.parseInt(file.nextLine());

		nomi = new String[elementi];
		voti = new double[elementi];

		while(file.hasNextLine()) {

			String[] infoRiga = file.nextLine().split(";");

			nomi[indice] = infoRiga[0];
			voti[indice] = Double.parseDouble(infoRiga[1]);

			indice++;
		}

		file.close();
		//Lista di tutti gli studenti con voti
		String risposta;

		risposta = "";

		for(int i=0; i<nomi.length;i++) {

			risposta += "\n-" + nomi[i] + ": " + voti[i];

		}

		risposta += risposta.isEmpty() ? "\n\t Nessuno studente in lista" : "\n\tLISTA STUDENTI" + risposta;

		//-
		double max = 0;
		String nomiMax = "";

		for(int i = 0; i< nomi.length; i++)
			if(voti[i] > max)
			{
				max = voti[i];
				nomiMax = nomi[i];
			}
			else if(voti[i] == max)
				nomiMax += ", " + nomi[i];

		risposta += max > 0 ? "\nStudenti bravi: " + nomiMax : "";

		double media = 0;
		nomiMax = "";

		for(int i = 0; i< voti.length; i++)
			media += voti[i];

		media /= voti.length;

		for(int i = 0; i< voti.length; i++)
			if(voti[i] > media)
				nomiMax += nomi[i] + ", ";

		risposta += nomiMax.isEmpty() ? "" : "\nStudenti decenti: " + nomiMax.substring(0, nomiMax.length()-2);

		System.out.println(risposta);
	}

}
