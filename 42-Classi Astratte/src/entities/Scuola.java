package entities;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Scuola {

	private ArrayList<Entity> persone;

	public Scuola(String path) throws FileNotFoundException {

		persone = new ArrayList<Entity>();

		Scanner file = new Scanner(new File(path));

		Entity e;

		while(file.hasNextLine()) {

			String[] info = file.nextLine().split(";");

			e = null;

			if(info[0].equalsIgnoreCase("s")) {

				e = new Studente(Integer.parseInt(info[1]), 
						info[2], 
						info[3], 
						info[4], 
						info[5], 
						info[6], 
						info[7], 
						trasforma(info[8]));
			}
			else if (info[0].equalsIgnoreCase("d")) {

				e = new Dipendente(Integer.parseInt(info[1]), 
						info[2], 
						info[3], 
						info[4], 
						info[5], 
						info[6], 
						Double.parseDouble(info[7]), 
						info[8],
						Integer.parseInt(info[9]));
			}

			if(e != null)
				persone.add(e);
		}
		file.close();

	}

	// Metodi
	private double[] trasforma(String info) {
		String[] vettore = info.split("-");
		double[] ris = new double[vettore.length];

		for(int i = 0; i < vettore.length; i++)
			ris[i] = Double.parseDouble(vettore[i]);

		return ris;
	}

	public String elenco() {

		String ris = "";

		for(Entity e : persone)
			ris += e.toString();

		return ris;
	}

	// Voglio vedere l'elenco dai dipendenti pendolari
	public String pendolari() 
	{
		String ris = "";
		for (Entity e : persone) 
		{
			if (e instanceof Dipendente) 
			{
				Dipendente dipendente = (Dipendente) e;
				if (dipendente.pendolare()) 
				{
					ris += dipendente.toString() + "\n";
				}
			}
		}
		return ris.isEmpty() ? "Nessun pendolare" : "\nPENDOLARI\n" + ris;
	}
	// Voglio vedere la persona piu vecchia tra tutti
	public String personaVecchia() 
	{
		int max = 0;
		String ris = "";
		if(persone.isEmpty()) 
		{
			return null;
		}

		for(Entity e: persone) 
		{
			if(e instanceof Persona) 
			{
				Persona p = (Persona)e;

				if(p.eta() > max) 
				{
					max = p.eta();
					ris = p.getNome().toUpperCase() + " " + p.getCognome().toUpperCase() + " con " + p.eta() + " anni\n";
				}
				else if(p.eta() == max)
				{
					ris += ", " + p.getNome().toUpperCase() + " " + p.getCognome().toUpperCase() + " con " + p.eta() + " anni\n";
				}
			}
		}

		return ris.isEmpty() ? "Nessuna persona trovata" : "\nVECCHIO\n" + ris;

	}
	
	// Voglio vedere il voto medio complessivo della scuola
	public String votoMedio() 
	{
		String ris = "";
		double somma = 0;
		int count = 0;
		for(Entity e : persone) 
		{
			if(e instanceof Studente)
			{
				Studente s = (Studente)e;
				somma += s.media();
				count++;
			}
		}
		if(somma > 0) 
		{
			somma /= count;
		}
		ris += somma;

		return somma > 0 ? "Voto medio complessivo: " + ris : "Nessun voto presente";
	}
	
	// Voglio vedere per ogni persona il valore del bonus che prende
	
	public String bonusView() 
	{
		String ris = "";
		
		for(Entity e : persone) 
		{
			if(e instanceof Persona) 
			{
				Persona p = (Persona)e;
				ris += p.getNome() + " " + p.getCognome() + " prende " + p.bonus() + "\n";
			}
		}
		return ris.isEmpty() ? "Nessun Bonus presente" : "\nBONUS ASSEGNATI: \n" + ris;
	}









}
