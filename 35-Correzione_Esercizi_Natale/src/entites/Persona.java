package entites;

import java.time.LocalDate;

// Classe Modello
public class Persona
{
	// Proprietà
	String nome;
	String cognome;
	String dob;
	String residenza;
	String professione;
	int figliACarico;
	double stipendio;
	
	// Costruttore
	public Persona(String nome, String cognome, String dob, String residenza, 
				   String professione, int figliACarico, double stipendio)
	{
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.residenza = residenza;
		this.professione = professione;
		this.figliACarico = figliACarico;
		this.stipendio = stipendio;
	}
	
	// Metodi
//	scheda()
	public String scheda()
	{
		return  "\n\t" 					+ nome 	+ " " 			+ cognome 	+
				"\nNato il " 			+ dob 	+ " di anni " 	+ eta() 	+
				"\nResidente a " 		+ residenza 			+ 
				"\nProfessione: " 		+ professione 			+
				"\nFigli a Carico: " 	+ figliACarico 			+
				"\nStipendio Medio: " 	+ stipendio 			+
				"\nSbarca il lunario? " + (sbarcare() 	? "Sì" 	: "No") 	+
				"\n----------------------------------------\n"	;
	}
	
//	int eta()
	public int eta()
	{
		return LocalDate.now().getYear() - Integer.parseInt(dob.split("-")[2]);
	}
	
//	boolean sbarcare() -> sottrae 100 euro per ogni figlio a carico dallo stipendio.
//		Per vivere a Milano si pagano al mese 900 euro,
//		per vivere a Roma se ne pagano 850,
//		per vivere in altre città se ne pagano 550.
//		Il metodo torna true se lo stipendio rimanente è superiore al 30% dello stipendio mensile
	public boolean sbarcare()
	{
		boolean ris = false;
		double totale = stipendio;
		
		totale -= 100*figliACarico;
		
		switch(residenza.toLowerCase())
		{
			case "milano" :
				totale -= 900;
				break;
			case "roma" :
				totale -= 850;
				break;
			default :
				totale -= 550;
		}
		
		double trentaPercento = stipendio/100*30;
		
		ris = totale > trentaPercento;
		
		return ris;
	}
	
}// Fine classe