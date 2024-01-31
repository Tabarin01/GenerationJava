package entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Ristorante 
{
	private ArrayList<Piatto> piatti;

	public Ristorante(String path)throws FileNotFoundException
	{
		piatti = new ArrayList<>();

		Scanner file = new Scanner(new File(path));

		while(file.hasNextLine()) 
		{
			String[] info = file.nextLine().split(",");
			String[] ingredienti = info[3].split("-");

			piatti.add(new Piatto(
					info[0],
					info[1],
					Double.parseDouble(info[2]),
					ingredienti
					));
		}
		file.close();
	}


	//Metodi


	//Ritornare tutta la lista dei piatti
	public ArrayList<Piatto> getPiatti() {
		return piatti;
	}

	//Ritornare tutti i piatti del tipo indicato
	public ArrayList<Piatto> listaPiatti(String tipo) 
	{
		ArrayList<Piatto> piattiTipo = new ArrayList<>();

		for(Piatto p : piatti) 
		{
			if(p.getTipo().equalsIgnoreCase(tipo)) 
			{
				piattiTipo.add(p);
			}
		}

		return piattiTipo;
	}
	//Ritornare tutti i piatti che hanno l'ingrediente specificato
	public ArrayList<Piatto> piattiConIngrediente(String ingrediente)
	{
		ArrayList<Piatto> piattiConIngrediente = new ArrayList<>();

		for(Piatto p: piatti) 
		{
			if(p.ingredientiValidi()) {
				String[] ingredienti = p.getIngredienti();
				for(String ingr : ingredienti)
				{
					if(ingr.equalsIgnoreCase(ingrediente) ) 
					{
						piattiConIngrediente.add(p);
					}
				}
			}
		}

		if(piattiConIngrediente.isEmpty()) {
			System.err.println("Ingrediente non valido");
		}
		return piattiConIngrediente;
	}

	//Ritornare tutti i piatti che hanno gli ingredienti specificati
	public ArrayList<Piatto> piattiConIngredienti(String[] ingredientiUtente) {
		ArrayList<Piatto> piattiConIngredienti = new ArrayList<>();

		for (Piatto p : piatti) {
			if (p.ingredientiValidi()) {
				String[] ingredientiPiatto = p.getIngredienti();
				boolean contieneTutti = true;

				for (String ingrCercato : ingredientiUtente) {
					boolean ingredienteTrovato = false;

					for (String ingrPiatto : ingredientiPiatto) {
						if (ingrPiatto.equalsIgnoreCase(ingrCercato)) {
							ingredienteTrovato = true;
							break;
						}
					}

					if (!ingredienteTrovato) {
						contieneTutti = false;
						break;
					}
				}

				if (contieneTutti) {
					piattiConIngredienti.add(p);
				}
			}
		}

		if (piattiConIngredienti.isEmpty()) {
			System.err.println("Nessun piatto trovato con gli ingredienti specificati");
		}

		return piattiConIngredienti;
	}

	public Piatto piuCostoso() {
		if (piatti.isEmpty()) {
			System.err.println("Nessun piatto disponibile");
			return null;
		}

		Piatto piattoPiuCostoso = piatti.get(0);

		for (Piatto p : piatti) {
			if (p.getPrezzo() > piattoPiuCostoso.getPrezzo()) {
				piattoPiuCostoso = p;
			}
		}

		return piattoPiuCostoso;
	}


	//Restituire un AL ordinato in modo crescente per prezzo
	public ArrayList<Piatto> menuOrdinatoPerPrezzo()
	{
		ArrayList<Piatto> copia = new ArrayList<>();

		for(Piatto p : piatti) 
		{
			if(p.getPrezzo() >= 0) 
			{
				copia.add(p);
			}
		}

		//copia.removeIf(p -> p.getPrezzo() < 0);

		copia.sort(Comparator.comparingDouble(Piatto::getPrezzo));

		return copia;	
	}

	//Restituire il costo medio di tutti i piatti
	public double costoMedioMenu() 
	{
		if(piatti.isEmpty()) 
		{
			System.err.println("Nessun piatto disponibile");
			return 0;
		}

		double somma = 0;

		for(Piatto p : piatti) 
		{
			if(p.getPrezzo() > 0)
				somma+= p.getPrezzo();
		}

		return somma / piatti.size();
	}

	//Ritorna un AL contenente tutti i piatti con valido() == false
	public ArrayList<Piatto> piattiNonValidi() 
	{
		ArrayList<Piatto> piattiNonValidi = new ArrayList<>();

		for(Piatto p : piatti) 
		{
			if(!p.valido()) 
			{
				piattiNonValidi.add(p);
			}
		}

		if(piattiNonValidi.isEmpty()) 
		{
			System.out.println("Tutti i piatti sono validi");
		}

		return piattiNonValidi;

	}

	//Trovare la moda del TIPO
	public String tipoRicorrente() {
		if (piatti.isEmpty()) {
			return null;
		}

		String moda = null;
		int maxCount = 0;

		for (int i = 0; i < piatti.size(); i++) {
			String tipoCorrente = piatti.get(i).getTipo();
			int count = 1;

			for (int j = i + 1; j < piatti.size(); j++) {
				if (tipoCorrente.equals(piatti.get(j).getTipo())) {
					count++;
				}
			}

			if (count > maxCount) {
				maxCount = count;
				moda = tipoCorrente;
			}
		}

		return moda.toUpperCase();
	}

	public String ingredienteRicorrente() 
	{
		if (piatti.isEmpty()) {
			return null; 
		}

		String ingredienteRicorrente = null;
		int maxCount = 0;

		for (Piatto piatto : piatti) {
			if(piatto.ingredientiValidi()) {
				String[] ingredienti = piatto.getIngredienti();

				for (int i = 0; i < ingredienti.length; i++) {
					String ingredienteCorrente = ingredienti[i];
					int count = 1;

					for (int j = i + 1; j < ingredienti.length; j++) {
						if (ingredienteCorrente.equals(ingredienti[j])) {
							count++;
						}
					}

					if (count > maxCount) {
						maxCount = count;
						ingredienteRicorrente = ingredienteCorrente;
					}
				}
			}
		}

		return ingredienteRicorrente.toUpperCase();
	}

	public ArrayList<String> tipiRicorrenti() {
		ArrayList<String> listaTipologie = new ArrayList<>();
	    ArrayList<String> tipologieRicorrenti = new ArrayList<>();
	    
	    for (Piatto p : piatti) {
	        if (p.tipoValido()) {
	            listaTipologie.add(p.getTipo());
	        }
	    }

	    int maxConteggio = 0;

	    for (int i = 0; i < listaTipologie.size(); i++) {
	        int conteggioAttuale = 0;

	        for (int j = 0; j < listaTipologie.size(); j++) {
	            if (i != j && listaTipologie.get(i).equals(listaTipologie.get(j))) {
	                conteggioAttuale++;

	                if (conteggioAttuale > maxConteggio) {
	                    maxConteggio = conteggioAttuale;
	                }
	            }
	        }
	    }

	    for (int i = 0; i < listaTipologie.size(); i++) {
	        int conteggioAttuale = 0;

	        for (int j = 0; j < listaTipologie.size(); j++) {
	            if (i != j && listaTipologie.get(i).equals(listaTipologie.get(j))) {
	                conteggioAttuale++;
	            }
	        }

	        if (conteggioAttuale == maxConteggio && !tipologieRicorrenti.contains(listaTipologie.get(i))) {
	            tipologieRicorrenti.add(listaTipologie.get(i));
	        }
	    }

	    return tipologieRicorrenti;
	}

	//Se la moda è più di una, restituirle tutte sottoforma di arraylist
	public ArrayList<String> ingredientiRicorrenti() {
		ArrayList<String> listaIngredienti = new ArrayList<>();
		ArrayList<String> ingredientiRicorrenti = new ArrayList<>();

		for (Piatto p : piatti) {
			if (p.ingredientiValidi()) {
				listaIngredienti.addAll(Arrays.asList(p.getIngredienti()));
			}
		}

		int[] conteggioIngredienti = new int[listaIngredienti.size()];
		int maxConteggio = 0;


		for (int i = 0; i < listaIngredienti.size(); i++) {
			for (int j = 0; j < listaIngredienti.size(); j++) {
				if (i != j && listaIngredienti.get(i).equals(listaIngredienti.get(j))) {
					conteggioIngredienti[i]++;
					if (conteggioIngredienti[i] > maxConteggio) {
						maxConteggio = conteggioIngredienti[i];
					}
				}
			}
		}


		for (int i = 0; i < listaIngredienti.size(); i++) {
			if (conteggioIngredienti[i] == maxConteggio && !ingredientiRicorrenti.contains(listaIngredienti.get(i))) {
				ingredientiRicorrenti.add(listaIngredienti.get(i));
			}
		}
		return ingredientiRicorrenti;
	}


	//Ordinare i piatti secondo l'ordine alfabetico per nome
	public ArrayList<Piatto> menuOrdinatoPerNome() {
		piatti.sort(Comparator.comparing(Piatto::getNome));
		return piatti;
	}


}
