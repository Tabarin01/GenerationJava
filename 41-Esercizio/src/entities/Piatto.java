package entities;

import java.util.Arrays;

public class Piatto 
{
	private final static String[] TIPI_VALIDI = {"Antipasto", "Primo", "Secondo", "Dolce"};
	private final static String[] INGREDIENTI_VALIDI = {"farina", "glutine", "zucchero", "sale", "glutammato", "olio"};
	private String nome;
	private String tipo;
	private double prezzo;
	private String[] ingredienti;

	public Piatto(String nome, String tipo, double prezzo, String[] ingredienti) 
	{
		setNome(nome);
		setTipo(tipo);
		setPrezzo(prezzo);
		setIngredienti(ingredienti);
	}

	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public String getTipo() 
	{
		return tipo;
	}
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}
	public double getPrezzo() 
	{
		return prezzo;
	}
	public void setPrezzo(double prezzo) 
	{
			this.prezzo = prezzo;
	}
	public String[] getIngredienti() 
	{
		return ingredienti;
	}
	public void setIngredienti(String[] ingredienti) 
	{
        this.ingredienti = ingredienti;
	}
	public static String[] getTipivalidi() 
	{
		return TIPI_VALIDI;
	}
	

	@Override
	public String toString() {
		return "\n"+ nome.toUpperCase() + 
			   "\nTipo: " + tipo.toUpperCase() + 
			   "\nPrezzo: " + prezzo + 
			   "$\nIngredienti: " + Arrays.toString(ingredienti).toUpperCase() + 
			   "\n--------------------------------------------------\n";
	}

	//Metodi
	//	Restituire true se il tipo
	//	del piatto rientra nella lista dei tipi validi
	public boolean tipoValido() 
	{
		for(String s : TIPI_VALIDI) 
		{
			if(s.equalsIgnoreCase(tipo))
				return true;
		}
		return false;
	}

	//	restituire true se TUTTI gli ingredienti
	//	rientrano nella lista di quelli validi
	public boolean ingredientiValidi() 
	{
		for(String in : ingredienti) 
		{
			boolean ingredienteValido = false;

			for(String i : INGREDIENTI_VALIDI) 
			{
				if(i.equalsIgnoreCase(in)) 
				{
					ingredienteValido = true;
					break;
				}
			}

			if(!ingredienteValido) 
			{
				return false;
			}
		}

		return true;
	}


	//	se il piatto ha sia il tipo valido
	//	che gli ingredienti validi
	public boolean valido() 
	{
		if(!tipoValido()) 
		{
			return false;
		}

		if(!ingredientiValidi()) 
		{
			return false;
		}

		return true;

	}

	public boolean contieneIngrediente(String ingrediente) 
	{
		for(String element : ingredienti) 
		{
			if(element.equalsIgnoreCase(ingrediente)) 
			{
				return true;
			}
		}
		return false;
	}

	//	restituire true se il vettore contiene
	//	TUTTI gli ingredienti del parametro
	public boolean contieneIngredienti(String[] ingredientiDaControllare) 
	{
		for (String element : ingredientiDaControllare) 
		{
			boolean contieneIngrediente = false;

			for (String ingr : ingredienti) 
			{
				if (ingr.equalsIgnoreCase(element)) 
				{
					contieneIngrediente = true;
					break;
				}
			}

			if (!contieneIngrediente) 
			{
				return false; 
			}
		}

		return true;
	}

}
