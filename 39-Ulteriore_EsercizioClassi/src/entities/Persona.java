package entities;

import java.time.LocalDate;

public abstract class Persona {
	
	protected String nome, dob;

	public Persona(String nome, String dob) {
		
		setNome(nome);
		setDob(dob);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "\n\tPERSONA\n"       +
			   "\nNome: " + nome     + 
			   "\nData di nascita: " + dob;
	}
	
	//Metodi
	
	public int eta()
	{
		return LocalDate.now().getYear() - Integer.parseInt(dob.split("-")[0]);
	}
	

}
