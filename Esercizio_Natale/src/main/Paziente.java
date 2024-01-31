package main;

public class Paziente {

	String nome,cognome,dob,residenza,patologia,reparto;
	boolean contagioso;
	int probMorte;
	public Paziente(String nome, String cognome, String dob, String residenza, String patologia, String reparto,
			boolean contagioso, int probMorte) 
	{
		this.nome = nome;
		this.cognome = cognome;
		this.dob = dob;
		this.residenza = residenza;
		this.patologia = patologia;
		this.reparto = reparto;
		this.contagioso = contagioso;
		this.probMorte = probMorte;
	}

	String scheda() 
	{
		String scheda = String.format("| %-12s | %-12s | %-15s | %-12s | %-12s | %-18s | %-11s | %-21s |\n",
				nome, cognome, dob, residenza, patologia, reparto, contagioso ? "Si" : "No", probMorte + " %");
		return scheda;
	}

	boolean rischioZombie() 
	{
		boolean ris = false;
		if(contagioso == true && probMorte > 80)
			ris = true;

		return ris;
	}

	boolean maCheCiFaiQui() 
	{
		boolean ris = false;
		switch(patologia.toLowerCase()) 
		{
		case "raffreddore":
		case "mal di gola":
		case "mal di testa":
		case "tosse":
			ris = true;
			break;
		default:
			ris = false;

		}
		return ris;
	}

	boolean casoRaro() 
	{
		boolean	ris = false;

		switch(reparto.toLowerCase()) 
		{
		case "psichiatria":
		case "neurologia":
		case "nefrologia":
			ris = true;
			break;
		default:
			ris = false;

		}
		return ris;
	}




}