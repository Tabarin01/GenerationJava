package esercizio2;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Leggere da un file dati le informazioni relative a dei film
		// Il file CSV formattato nel seguente modo:
		// id,titolo,genere,durataMinuti

		//Usare solo Map, senza classi modello, al massimo una classe aggregatore



		ArrayList <Map<String, String>> listaFilm = new ArrayList<>();
		Scanner file;

		try 
		{
			file = new Scanner(new File("src/res/Dati.txt"));



			while(file.hasNextLine()) 
			{
				String[] info = file.nextLine().split(",");

				Map<String, String> film = new LinkedHashMap<>();

				film.put("id", info[0]);
				film.put("titolo", info[1]);
				film.put("genere", separaGenere(info[2]));
				film.put("durata", info[3]);


				listaFilm.add(film);

			}

			file.close();
		}
		catch(FileNotFoundException e) 
		{
			System.err.println("Errore nel percorso del file");
		}

		System.out.println(filmPiuPresente(listaFilm));


	}

	public static String separaGenere(String genere) 
	{
		String[] generiSplittati = genere.split("-");
		return String.join(", ", generiSplittati);

	}

	//Vedere poi:
	// -Lista delle schede dei film
	// -Lista dei titoli dei film
	// -Film maggior durata
	// - Durata media dei film di un genere passato dall'utente
	// - Numero di film presenti per ogni genere disponibile

	public static String filmPiuPresente(List<Map<String, String>> mappaFilm) {
        Map<String, Integer> conteggioTitoliPerGenere = new LinkedHashMap<>();

        // Conta il numero di titoli per ogni genere
        for (Map<String, String> film : mappaFilm) {
            String generi = film.get("genere");
            String[] generiSplittati = generi.split(", ");
            
            for (String genere : generiSplittati) {
                conteggioTitoliPerGenere.put(genere, conteggioTitoliPerGenere.getOrDefault(genere, 0) + 1);
            }
        }

        // Costruisci la stringa di output
        String risultato = "";
        for (Map.Entry<String, Integer> entry : conteggioTitoliPerGenere.entrySet()) {
            risultato += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        return risultato.isEmpty() ? "Nessun film presente" : "\nNumero di titoli per genere \n\n" + risultato ;
    }
	
	

	public static String filmPresente(List<Map<String, String>> mappaFilm) 
	{
		String ris = "";
		int conta = 0;
		List<String> generi = new ArrayList();

		for(Map<String, String> film : mappaFilm) 
		{
			if(!generi.contains(film.get("generi")))
			{
				generi.add(film.get("genere"));
			}
		}
		
		for(String g : generi)
		{
			
			for(Map<String,String> f : mappaFilm)
			{
				if(f.get("genere").equalsIgnoreCase(g))
					conta ++;
			}
			
			ris += "\n" + g + " contiene " + conta + " film";
		}



		return ris;
	}

	public static String mediaFilmGenere(List<Map<String, String>> mappaFilm) 
	{
		Scanner tastiera = new Scanner(System.in);
		String ris = "";
		double media = 0;
		int conta = 0;

		System.out.println("Digita un genere: ");
		String genere = tastiera.nextLine();

		for(Map<String,String> film : mappaFilm) 
		{
			if(film.get("genere").equalsIgnoreCase(genere) || film.get("genere").contains(genere))
			{
				media += Integer.parseInt(film.get("durata"));
				conta ++;
			}
		}


		media = conta > 0 ? media/conta : 0;


		tastiera.close();
		return ris += media > 0 ? "La durata media dei film di genere " + genere + ": " + media : "Nessun film del genere presente";
	}

	public static String maggioreDurata(List<Map<String, String>> mappaFilm) 
	{
		String ris = "";
		int max = 0;
		for(Map<String,String> film : mappaFilm) 
		{
			int durata = Integer.parseInt(film.get("durata"));
			if(durata > max) 
			{
				max = durata;
				ris = "\n" + film.get("titolo").toUpperCase() + " con " + film.get("durata") + " minuti";

			}
			else if(durata == max) 
			{
				ris += ", \n" + film.get("titolo").toUpperCase() + " con " + film.get("durata") + " minuti";
			}
		}


		return ris.isEmpty() ? "Nessun film presente" : "\nFilm di maggior Durata: " + ris;
	}

	public static String titoliFilm(List<Map<String, String>> mappaFilm) 
	{
		String ris = "";

		for(Map<String,String> film : mappaFilm)
		{
			ris += "\n- " + film.get("titolo").toUpperCase();
		}

		return ris.isEmpty() ? "Nessun titolo trovato" : "\n\tTitoli dei film:" + ris;

	}

	public static String listaSchede(List<Map<String, String>> mappaFilm) {
		String ris = "";

		for (Map<String, String> film : mappaFilm) {
			for (Entry<String, String> entry : film.entrySet()) {
				ris += "\n" + entry.getKey().toUpperCase() + ": " + entry.getValue().toUpperCase() + "\n";
			}
			ris += "\n-----------------------------"; // Add an empty line between film entries
		}
		return ris;
	}

	public static String listaSchede2(List<Map<String, String>> mappaFilm) 
	{
		String elencoFilm = "";
		for(Map<String,String> f : mappaFilm)
		{
			elencoFilm += "\nFILM";
			for(String e : f.keySet())
				elencoFilm += "\n" + e.toUpperCase() + 
				": " + f.get(e).toUpperCase();
			elencoFilm +="\n_____________________________";
		}

		return elencoFilm.isEmpty() ? "Elenco film vuoti" : elencoFilm;
	}





}
