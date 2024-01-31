package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Blockbuster {

	private ArrayList<Film> film;
	private ArrayList<SerieTv> serieTv;

	public Blockbuster(String path) throws FileNotFoundException 
	{
		film = new ArrayList<Film>();
		serieTv = new ArrayList<SerieTv>();

		Scanner file = new Scanner(new File(path));

		while(file.hasNextLine()) 
		{
			String[] info = file.nextLine().split(",");

			switch(info[0].toLowerCase()) 
			{
			case "film":
				film.add(
						new Film(
								info[1],
								Integer.parseInt(info[2]),
								info[3],
								info[4].equalsIgnoreCase("s")
								)
						);
				break;
			case "serietv":
				serieTv.add(
						new SerieTv(
								info[1],
								Integer.parseInt(info[2]),
								Integer.parseInt(info[3]),
								Integer.parseInt(info[4]),
								info[5].equalsIgnoreCase("s")
								)
						);
				break;
			default:
				System.out.println("Riga Errata nel file dati");
			}
		}
		file.close();

	}//costruttore

	//	String listaFilm()---------> solo le schede dei film
	public String listaFilm() 
	{
		String ris = "";

		for(Film f : film)
			ris += f.toString();
		return ris;
	}
	//	String listaSerie() -------> solo le schede delle serietv
	public String listaSerieTv() 
	{
		String ris = "";

		for(SerieTv s : serieTv)
			ris += s.toString();
		return ris;
	}
	//	String listaCompleta ------> le schede sia di film che di serie
	public String listaCompleta() 
	{
		return listaFilm() + listaSerieTv();
	}
	//	double durataMediaFilm() --> durata media dei film
	public String durataMediaFilm() 
	{

		String ris = "";
		double sommaDurate = 0, cont = 0;

		for(Film f : film) 
		{
			sommaDurate += f.getDurataMin();
			cont++;
		}

		return ris += "Durata media dei film: " + sommaDurate / cont + " minuti";

	}
	//	String filmCaro() ---------> la scheda del film più caro
	public String filmCaro() 
	{
		String ris = "";
		double max = 0;

		for(Film f : film) 
		{
			if(f.prezzo() > max) 
			{
				ris = f.toString();
				max = f.prezzo();
			}else if( f.prezzo() == max) 
			{
				ris += f.toString();
			}
		}

		return ris.isEmpty() ? "Nessun film trovato" : "\nFILM CARI\n" + ris;
	}
	//	String invalidi() ---------> le schede dei film o delle serie che non sono valide
	public String invalidi() 
	{
		String ris = "";
		for(Film f : film) 
		{
			if(!f.filmValido()) 
			{
				ris += f.toString();
			}
		}

		for(SerieTv s : serieTv) 
		{
			if(!s.serieValida()) 
			{
				ris += s.toString();
			}
		}
		return ris.isEmpty() ? "\nNessun cortometraggio presente" : "\nCortometraggi: " + ris;
	}
	
	//	String registaFrequente() -> il nome del regista che ha fatto più film del file e il numero di film in cui è presente
	public String registaFrequenteS() {
		String risposta = "\nREGISTA + FREQUENTE E LISTA FILM \n";
	    String regista = "";
	    String listaFilm = "";
	    int max = 0;

	    for (Film currentFilm : film) {
	        String currentRegista = currentFilm.getRegista();
	        int contaRegista = 0;

	        for (Film film : film) {
	            if (film.getRegista().equals(currentRegista)) {
	                contaRegista++;
	            }
	        }

	        if (contaRegista > max) {
	            max = contaRegista;
	            regista = currentRegista;
	        }
	    }

	    for (Film currentFilm : film) {
	        if (currentFilm.getRegista().equals(regista)) {
	            listaFilm += currentFilm.toString() + "\n";
	        }
	    }

	    risposta += "Regista: " + regista + " | " + "Numero Films: " + max + "\n" + listaFilm;
	    return risposta;
	}

	public String registaFrequente() 
	{
		String ris = "";
		String registaFrequente = "";
		int contaFrequenza = 0;

		for (Film filmCorrente : film) 
		{
			String registaCorrente = filmCorrente.getRegista();
			int contaRegista = 0;

			for (Film altroFilm : film) 
			{
				if (registaCorrente.equals(altroFilm.getRegista())) 
				{
					contaRegista++;
				}
			}

			if (contaRegista > contaFrequenza) 
			{
				contaFrequenza = contaRegista;
				registaFrequente = registaCorrente;
			}
		}

		if (!registaFrequente.isEmpty()) 
		{
			ris = "\nRegista più frequente: " + registaFrequente + "\nNumero di film: " + contaFrequenza;
		} 
		else 
		{
			ris = "Nessun regista trovato";
		}

		return ris;
	}
}
