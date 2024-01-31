package entities;

import java.util.ArrayList;

// Per convenzione alcune aziende usano la lettera I maiuscola prima del nome delle
// classi che sfruttano questa interfaccia


// INTERFACCIA: è un contratto.
// In particolare, le interfaccie stipulano dei contratti tra loro stesse e le classi
// L'accordo tra le due parti si regge su questi presupposti: L'interfaccia fornisce alla classe protezione
// la classe fornisce all'interfaccia l'implementazione dei suoi metodi

public interface IScuola 
{
	// Le interfaccie nel corso delle diverse versioni sono cambaite molto.
	// Uno scaglione grosso c'è stato tra le versioni precedenti alla 1.8 e le versioni 1.8 e le successive
	// Nelle versioni più recenti c'è stato un altro grosso passo in avanti, che ha cambiato nuovamente
	// le possibilità di questo strumento.

	// Le versioni precedenti alla 1.8 permettevano alle interfaccie di possedere
	// unicamnete le firme dei metodi.
	
	public String elenco();
	public String elencoPendolari();
	public ArrayList<Entity> getPersone();
	
	// Dalla versione 1.8 in poi è stata implementata la possibilità di dare un corpo ai metodi
	
	default String anziano() 
	{
		int max = 0;
		String ris ="";
		
		for(Entity e : getPersone()) 
		{
			if(((Persona)e).eta() > max)
			{
				max = ((Persona)e).eta();
				ris = e.toString();
			}
			else if(((Persona)e).eta() == max)
			{
				ris += e.toString();
			}
		}
		return ris;
	}
	
	// Nelle versioni recenti e' stata introdotta la possibilita' di avere delle proprieta' STATICHE
	// DIFFERENZA TRA INTERFACCE e CLASSI ASTRATTE
	// La differenza e' che le interfaccie non possono avere lo stato dell'oggetto, la classe astratta si
	
	
	
}
