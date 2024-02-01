package entities;

import java.util.Map;

import factory.IFactory;

public class Libro extends Entity implements IFactory
{
	private String titolo, genere, editore;
	private int numeroPagine;
	private double prezzo;
	private Autore autore;
	
	public Libro() 
	{
		
	}
	
	public Libro(int id,String titolo, String genere, String editore, int numeroPagine, double prezzo, Autore autore) {
		super(id);
		setTitolo(titolo);
		setGenere(genere);
		setEditore(editore);
		setNumeroPagine(numeroPagine);
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


	public String getEditore() {
		return editore;
	}


	public void setEditore(String editore) {
		this.editore = editore;
	}


	public int getNumeroPagine() {
		return numeroPagine;
	}


	public void setNumeroPagine(int numeroPagine) {
		this.numeroPagine = numeroPagine;
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
	
	
	public String toString() {
		return 	super.toString() +
				"\nTitolo: " + titolo + 
				"\nGenere: " + genere + 
				"\nEditore: " + editore + 
				"\nNumero di pagine: " + numeroPagine + 
				"\nPrezzo: " + prezzo + 
				"\nAutore: " + autore.getNome() + " " + autore.getCognome() + " " + autore.getId() +
				"\n______________________________________\n";
	}


	@Override
	public void create(Map<String, String> map) {
		setId(Integer.parseInt(map.get("idLibro")));
		setTitolo(map.get("titolo"));
		setGenere(map.get("genere"));
		setEditore(map.get("casa_editrice"));
		setNumeroPagine(Integer.parseInt(map.get("numero_pagine")));
		setPrezzo(Double.parseDouble(map.get("prezzo")));
		
		Autore a = new Autore();
		a.setNome(map.get("nome"));
		a.setCognome(map.get("cognome"));
		a.setId(Integer.parseInt(map.get("idAutore")));
		setAutore(a);
		
	}
	

}
