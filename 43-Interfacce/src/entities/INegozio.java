package entities;

import java.util.ArrayList;

public interface INegozio {
	
	public ArrayList<Entity> getArticoli();
	
	String elencoLaptop();
    ArrayList<Entity> maxPrezzo();
    double prezzoMedio(String tipo);
    
	
	default String elenco() 
	{
		String ris = "";

		for(Entity e : getArticoli())
			ris += e.toString();

		return ris;
	}
	
	

}
