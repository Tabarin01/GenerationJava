package entities;

import java.util.Map;

import factory.IFactory;

public class Animale extends Entity implements IFactory
{
	private String specie, nome, dob, genere;
	private double peso;
	private boolean vaccinato;
	// private Allevatore allevatore; Colleghiamo lato allevatore, aggiungendogli un List<Animale> come pr
	
	public Animale() 
	{
		
	}
	
	public Animale(int id, String specie, String nome, String dob, String genere, double peso, boolean vaccinato) 
	{
		super(id);
		setSpecie(specie);
		setNome(nome);
		setDob(dob);
		setGenere(genere);
		setPeso(peso);
		setVaccinato(vaccinato);
	}
	public String getSpecie() {
		return specie;
	}
	public void setSpecie(String specie) {
		this.specie = specie;
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
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public boolean isVaccinato() {
		return vaccinato;
	}
	public void setVaccinato(boolean vaccinato) {
		this.vaccinato = vaccinato;
	}
	@Override
	public String toString() {
		return super.toString() +
				"\nSpecie: " + specie + 
				"\nNome: " + nome + 
				"\nNato il: " + dob + 
				"\nGenere: " + genere + 
				"\nPeso: " + peso   + 
				"\nVaccinato: " + (vaccinato ? "Si" : "No") + 
				"\n_________________________________________\n";
	}
	
	
	// Questo metodo avra' il compito di bypassare il costruttore per popolare un'oggetto creato inizialmente vuoto
	public void create(Map<String, String> map) 
	{
		// La mappa che ci arriva e' il risultato dei record letti da DB
		// Sara' quindi una mappa che avra' come KEY il nome della colonna della tabella SQL
		// come valore invece sara' il contenuto della cella SQL
		
		
		// Tramite i metodi SET vado ad associare i VALUE SQL alle proprieta' JAVA
		setId(Integer.parseInt(map.get("id")));
		setNome(map.get("nome"));  // ATTENZIONE, bisogna mettere il nome delle colonne del db, quindi occhio al case
		setSpecie(map.get("specie"));
		setDob(map.get("dob"));
		setGenere(map.get("genere"));
		setPeso(Double.parseDouble(map.get("peso")));
		setVaccinato(map.get("vaccinato").equalsIgnoreCase("1"));
	}
	
	
	
	

}
