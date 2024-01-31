package entities;


public class Studente extends Persona{
	
	//Proprieta
	private String scuola;
	private String classe;
	private double[] votiFinali;
	
	//Costruttore
	public Studente(int id, String nome, String cognome, String dob, String residenza, 
			String scuola, String classe, double[] votiFinali) {
		super(id, nome, cognome, dob, residenza);
		setScuola(scuola);
		setClasse(classe);
		setVotiFinali(votiFinali);
	}

	//Getter & Setters
	public String getScuola() {
		return scuola;
	}
	public void setScuola(String scuola) {
		this.scuola = scuola;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public double[] getVotiFinali() {
		return votiFinali;
	}
	public void setVotiFinali(double[] votiFinali) {
		this.votiFinali = votiFinali;
	}

	
	//Metodi
	@Override
	public String toString() {
		return 	super.toString()	+	
				"\nScuola: " 		+ scuola.toUpperCase() 		+ 
				"\nClasse: " 		+ classe 		+ 
				"\nVotiFinali: " 	+ stampaVoti()	+
				"\nMedia: "			+ media()		+
				"\nEsito: "			+ esito()		+
				"\n--------------------------------";
	}
	
	public double media() {
		
		double ris = 0;
		
		for(double v : votiFinali)
			ris += v;
		
		ris = ris > 0 ? ris/votiFinali.length : 0;
		return ris;
	}
	
	public String esito() {
		
		return media() >= 6 ? "PROMOSSO" : "BOCCIATO";
	}
	
	public String stampaVoti() {
		
		String ris = "";
		
		for (double v : votiFinali)
			ris += v + ", ";
		
		ris = ris.length() > 2 ? ris.substring(0, ris.length()-2) : ris;
		
		return ris;
	}

	@Override
	public double bonus() {
		
		double ris = 0;
		
		if(media() > 9)
			ris += 800;
		else if(media() >= 8)
			ris += 600;
		else if(media() >= 7)
			ris+= 400;
		
		return ris;
	}
	
	
	
}// Fine classe
