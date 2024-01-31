package entities;

import java.util.List;
import java.util.Map;

import factory.IFactory;

public class Autore extends Entity implements IFactory
{
	private String nome, cognome, dob, nazionalita, biografia;
	
	public Autore() 
	{
		
	}

	public Autore(int id, String nome, String cognome, String dob, String nazionalita, String biografia) {
		super(id);
		setNome(nome);
		setCognome(cognome);
		setDob(dob);
		setNazionalita(nazionalita);
		setBiografia(biografia);
		
	}

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
 
	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	

	@Override
	public String toString() {
		return 	super.toString() +
 				"\nNome autore: " + nome +" " + cognome + 
 				"\nNato il: " + dob + 
 				"\nNazionalita': " + nazionalita + 
 				"\nBiografia: " + biografia +
				"\n_________________________________________\n";
	}

	@Override
	public void create(Map<String, String> map) {
		setId(Integer.parseInt(map.get("id")));
		setNome(map.get("nome"));
		setCognome(map.get("cognome"));
		setDob(map.get("dob"));
		setNazionalita(map.get("nazionalita"));
		setBiografia(map.get("biografia"));
	}
	
	
	
	
	

}
