package entities;

import java.util.Map;

import factory.IFactory;

public class Libro extends Entity implements IFactory{
	
	private String titolo, genere, casa_editrice;
	private int numero_pagine;
	private double prezzo;
	private Autore autore;
	
	
	public Libro() 
	{
		
	}
	
	public Libro(int id,String titolo, String genere, String casa_editrice, int numero_pagine, double prezzo, Autore autore) {
		super(id);
		setTitolo(titolo);
		setGenere(genere);
		setCasa_editrice(casa_editrice);
		setNumero_pagine(numero_pagine);
		setPrezzo(prezzo);
		setAutore(autore);
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public String getCasa_editrice() {
		return casa_editrice;
	}

	public void setCasa_editrice(String casa_editrice) {
		this.casa_editrice = casa_editrice;
	}

	public int getNumero_pagine() {
		return numero_pagine;
	}

	public void setNumero_pagine(int numero_pagine) {
		this.numero_pagine = numero_pagine;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	

	@Override
	public String toString() {
		return 	super.toString() +
				"\nTitolo: " + titolo + 
				"\nGenere: " + genere + 
				"\nEditore: " + casa_editrice + 
				"\nNumero di pagine: " + numero_pagine + 
				"\nPrezzo: " + prezzo + 
				"\nAutore: " + autore.getNome() + " " + autore.getCognome() + " " + autore.getId() +
				"\n______________________________________\n";
	}

	@Override
	public void create(Map<String, String> map) {
		setId(Integer.parseInt(map.get("idLibro")));
		setTitolo(map.get("titolo"));
		setGenere(map.get("genere"));
		setCasa_editrice(map.get("casa_editrice"));
		setNumero_pagine(Integer.parseInt(map.get("numero_pagine")));
		setPrezzo(Double.parseDouble(map.get("prezzo")));
		
		// Un plauso a 
		Autore a = new Autore();
		a.setNome(map.get("nome"));
		a.setCognome(map.get("cognome"));
		a.setId(Integer.parseInt(map.get("idAutore")));
		setAutore(a);
		//Simone Michelon
	}
	
	
	
	
	

}
