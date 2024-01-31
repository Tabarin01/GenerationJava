package entities;

// Le classi modello devono cercare di essere il piu aderenti possibile 
// alle tabelle che vogliono rappresentare
public class Persona extends Entity {
	
	// Esistono molti sistemi automatici che sono in grado di assegnare da soli
	// i valori letti nelle colonne SQL alle proprieta degli oggetti JAVA.
	// Per far funzionare bene questi sistemi pero dovete fare in modo che la colonna SQL
	// e la proprieta Java si chiamino nello stesso modo.
	
	// PROPRIETA 				// COLONNE TABELLA SQL
	// id appartiene a Entity	//id INT PRIMARY KEY AUTO_INCREMENT,
    private String nome;		//nome VARCHAR(150),
    private String cognome;		//cognome VARCHAR(200),
    private String dob;			//dob DATE,
    private String residenza;	//residenza VARCHAR(200),
    private String genere;		//genere CHAR,
    private String professione;	//professione VARCHAR(250)
	
    // COSTRUTTORE
    public Persona(int id, String nome, String cognome, String dob, String residenza, String genere,
			String professione) {
		super(id);
		setNome(nome);
		setCognome(cognome);
		setDob(dob);
		setResidenza(residenza);
		setGenere(genere);
		setProfessione(professione);
	}

    // GETTER & SETTERS
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		// Controllo lunghezza stringa
		if(nome.length() <= 150)
			this.nome = nome;
		else
			this.nome = nome.substring(0,150);
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		// Controllo lunghezza stringa
		if(cognome.length() <= 200)
			this.cognome = cognome;
		else
			this.cognome.substring(0, 200);
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		// Controllo dob
		if(dob.length() == 10)
			this.dob = dob;
		else
			this.dob = null;
	}
	public String getResidenza() {
		return residenza;
	}
	public void setResidenza(String residenza) {
		// Controllo lunghezza stringa
		if(residenza.length() <= 200)
			this.residenza = residenza;
		else
			this.residenza.substring(0, 200);
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		// Controllo char
		if(genere.length() == 1)
			this.genere = genere;
		else if (genere.toLowerCase().startsWith("m") || genere.toLowerCase().startsWith("f"))
			this.genere = genere.substring(0,0);
		else
			this.genere = null;
	}
	public String getProfessione() {
		return professione;
	}
	public void setProfessione(String professione) {
		// Controllo lunghezza stringa
		if(professione.length() <= 250)
			this.professione = professione;
		else
			this.professione = professione.substring(0,250);
	}

	
	// METODI
	@Override
	public String toString() {
		return 	super.toString() 	+
				"\nNominativo: " 	+ nome + " " + cognome 	+  
				"\nDob: " 			+ dob 					+ 
				"\nResidenza: " 	+ residenza 			+ 
				"\nGenere: " 		+ genere.toUpperCase()	+ 
				"\nProfessione: " 	+ professione 			+
				"\n----------------------------------------";
	}
	
    
}
