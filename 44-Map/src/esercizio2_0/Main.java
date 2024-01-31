package esercizio2_0;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main{
	
	public static void main(String[] args) throws FileNotFoundException {

		//Leggere da un file dati le informazioni relative a dei film
        // Il file CSV formattato nel seguente modo:
        // id,titolo,genere,durataMinuti
        
        //Usare solo Map, senza classi modello, al massimo una classe aggregatore
        
        //Vedere poi:
        // -Lista delle schede dei film
        // -Lista dei titoli dei film
        // -Film maggior durata
        // -Durata media dei film di un genere passato dall'utente
        // - Numero di film presenti per ogni genere disponibile
		
	ArrayList<Map<String,String>> films = new ArrayList<Map<String,String>>();
	String elencoFilm = "";
	Scanner file = new Scanner(new File("src/res/Dati.txt"));
	
	while(file.hasNextLine())
	{
		Map<String,String> riga = new LinkedHashMap<String, String>();
		
		String[] info = file.nextLine().split(",");
		
		//id,titolo,genere,durataMinuti
		riga.put("id", info[0]);
		riga.put("titolo", info[1]);
		riga.put("genere", info[2]);
		riga.put("durata", info[3]);
		
		films.add(riga);
	}
	
    // -Lista delle schede dei film
	for(Map<String,String> f : films)
	{
		elencoFilm += "\nFILM";
		for(String k : f.keySet())
			elencoFilm += "\n" + k.toUpperCase() + 
						  ": " + f.get(k);
		elencoFilm +="\n_____________________________";
	}
	
	System.out.println(elencoFilm);
	
	
	
    // -Lista dei titoli dei film
	elencoFilm = "";
		
	for(Map<String,String> f : films)
	{
		elencoFilm += "\n- " + f.get("titolo");
	}
	
	System.out.println("\nLISTA DEI TITOLI" + elencoFilm);
	
	
	
	
    // -Film maggior durata
	elencoFilm = "";
	int maxDurata = 0;
	for(Map<String,String> f : films)
	{
		if(Integer.parseInt(f.get("durata")) > maxDurata)
		{
			maxDurata = Integer.parseInt(f.get("durata"));
			elencoFilm = "\n- " + f.get("titolo");
		}
		else if(Integer.parseInt(f.get("durata")) == maxDurata)
			elencoFilm += "\n- " + f.get("titolo");
	}
	
	System.out.println("\nFILM PIU' LUNGO" + elencoFilm);
	
	
	
    // -Durata media dei film di un genere passato dall'utente
	Scanner tastiera = new Scanner(System.in);
	String genereIn;
	double media = 0;
	double somma = 0;
	int conta = 0;
	
	System.out.println("Inserisci un genere");
	genereIn = tastiera.nextLine();
	
	for(Map<String,String> f : films)
	{
		if(f.get("genere").equalsIgnoreCase(genereIn))
		{
			somma += Integer.parseInt(f.get("durata"));
			conta ++;
		}
	}
		
	media = somma/conta;
	
	System.out.println("\nMEDIA DURATA FILM " + genereIn + ": " + media);
	
	
    // - Numero di film presenti per ogni genere disponibile
	ArrayList<String> generi = new ArrayList<String>();
	elencoFilm = "\nNUMERO DI FILM PER GENERE\n";
	
	for(Map<String,String> f : films)
	{
		if(!generi.contains(f.get("genere")))
			generi.add(f.get("genere"));
	}
	
	for(String g : generi)
	{
		conta = 0;
		for(Map<String,String> f : films)
		{
			if(f.get("genere").equalsIgnoreCase(g))
				conta ++;
		}
		
		elencoFilm += "\n" + g + " --> " + conta;
	}
	
	System.out.println(elencoFilm);
	
	}
}
