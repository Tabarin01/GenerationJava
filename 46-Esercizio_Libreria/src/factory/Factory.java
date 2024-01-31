package factory;

import java.util.Map;

import entities.Autore;
import entities.Libro;

public class Factory {

	public static IFactory createObject(String classe) 
	{
		switch(classe) 
		{
		case "Libro":
			return new Libro();
			
		case "Autore":
			return new Autore();
			
		default:
			throw new IllegalArgumentException(classe + " sconosciuta");
		}
	}

}
