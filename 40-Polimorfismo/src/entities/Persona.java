package entities;

import java.time.LocalDate;

public class Persona 
{
	
	private String nome, cognome, residenza, dob;

	public Persona(String nome, String cognome, String residenza, String dob) 
	{
		//Si usano i set per usare i controlli quando si assegna il dato al costruttore
		//Per esempio nel DOB verifico che sia giorno, mese ,anno attraverso if
		
		setNome(nome);
		setCognome(cognome);
		setResidenza(residenza);
		setDob(dob);
		
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public String getCognome() 
	{
		return cognome;
	}

	public void setCognome(String cognome) 
	{
		this.cognome = cognome;
	}

	public String getResidenza() 
	{
		return residenza;
	}

	public void setResidenza(String residenza) 
	{
		this.residenza = residenza;
	}

	public String getDob() 
	{
		return dob;
	}

	public void setDob(String dob) 
	{
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "\n\tPERSONA\n" +
				"\nNominativo: "      + nome + " " + cognome    + 
			   "\nResidenza: "       + residenza 			   + 
			   "\nData di nascita: " + dob 			           +
			   "\nEta': " + eta() + " anni";
	}
	
	public int eta() 
	{
		return LocalDate.now().getYear()-Integer.parseInt(dob.split("-")[2]);
	}
	
	
	

}
