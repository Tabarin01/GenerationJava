package main;

import java.time.LocalDate;

public class Persona {

	String nome, cognome, dob, residenza, professione;
	int figliACarico;
	double stipendio;


	Persona(String nome, String cognome, String dob, String residenza, String professione, int figliACarico,
			double stipendio) 
	{	
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.residenza = residenza;
		this.professione = professione;
		this.figliACarico = figliACarico;
		this.stipendio = stipendio;
	}


	//METODI
	String scheda() 
	{
		String scheda = String.format("| %-12s | %-12s | %-15s | %-12s | %-12s | %-18s | %-11s |\n",
				nome.toUpperCase(), cognome.toUpperCase(), dob, residenza.toUpperCase(), professione.toUpperCase(), figliACarico > 0 ? "Ha " + figliACarico + " figli" : "Nessun figlio", stipendio + "$");
		return scheda;
	}

	//Il metodo restituisce l'età della persona basandosi sul suo anno di nascita
	int eta()
	{
		String[] arrayData = dob.split("-");
		int annoNascita = Integer.parseInt(arrayData[2]);

		int annoCorrente = LocalDate.now().getYear();
		int eta = annoCorrente - annoNascita;

		return eta;
	}

	//Il metodo torna true se lo stipendio rimanente è superiore al 30% dello stipendio mensile
	boolean sbarcare() 
	{
		
		double stipendioTrenta = stipendio*30/100;

		for(int i = 0; i < figliACarico; i++) 
		{
			stipendio -= 100;
		}
		switch(residenza.toUpperCase()) 
		{
		case "MILANO":
			stipendio -= 900;
			break;
		case "ROMA":
			stipendio -= 850;
			break;
		default:
			stipendio-= 500;
		}

		return stipendio > stipendioTrenta;
	}
	
	


}
