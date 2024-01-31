package entities;

import java.time.LocalDate;

// Persona e figlia di Entity ed eredita le sue proprieta e i suoi metodi visibili.
// Cio che non eredita e l' ABSTRACT, tanto e vero che Persona ora e concreta, cioe posso fare new Persona()
public abstract class Persona extends Entity {
	
	// Proprieta
	private String nome;
	private String cognome;
	private String dob;
	private String residenza;
	
	// Costruttore
	public Persona(int id, String nome, String cognome, String dob, String residenza) {
		super(id);
		setNome(nome);
		setCognome(cognome);
		setDob(dob);
		setResidenza(residenza);
	}

	//Getter & Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getResidenza() {
		return residenza;
	}
	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	
	//Metodi
	@Override
	public String toString() {
		return 	super.toString()			+
				"\nnome: " 		+ nome.toUpperCase() 		+ 
				"\ncognome: " 	+ cognome.toUpperCase() 	+ 
				"\ndob: " 		+ dob 		+ 
				"\nresidenza: " + residenza.toUpperCase()	;
	}
	
	public int eta() {
		
		return LocalDate.now().getYear() - Integer.parseInt(dob.split("-")[2]);
	}
	
	// METODO ASTRATTO: Posseggono solo le firme dei metodi e possono esistere solo nelle classi astratte.
	public abstract double bonus();
	
	
	
	
	
	
	
}
