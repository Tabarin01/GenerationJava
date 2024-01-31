package main;

import entities.Persona;

public class Main {

	public static void main(String[] args) 
	{
		int min = Persona.etaMin; // cosi' se in Persona la variabile e' static la trova

		int eta = 25;
		String provincia = "MI";
		
		if(Persona.valida(eta) && Persona.valida(provincia)) 
		{
			Persona p = new Persona("Sandro","Di Silvestro",provincia, "Zelo", eta);
			System.out.println(p.toString());
		}
		else
			System.out.println("Oggetto non creato");
		
	}

}
