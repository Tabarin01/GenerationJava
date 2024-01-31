package dao;

import entities.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entities.Autore;
import entities.Libro;
import entities.Entity;
import factory.Factory;
import factory.IFactory;

public class DAOLibro extends DAO
{
	public DAOLibro(String nomeDB) 
	{
		super(nomeDB);
	}

	public boolean delete(int id) 
	{
		return super.update("DELETE FROM Libri WHERE id = " + id);
	}

	public boolean insert(Entity e) 
	{
		return super.update("INSERT INTO Libri(titolo,genere,numero_pagine,casa_editrice, prezzo, idAutore) VALUES"+
				"(\"" + ((Libro)e).getTitolo()  		+ "\"," + 
				"\""  + ((Libro)e).getGenere()  		+ "\"," +
				" "   + ((Libro)e).getNumero_pagine() 	+ " ," +
				"\""  + ((Libro)e).getCasa_editrice() 	+ "\"," +
				" "   + ((Libro)e).getPrezzo() 			+ " ," +
				" "   + ((Libro)e).getAutore().getId()  + " )"        
				);

	}

	public boolean update(Entity e) 
	{
		return super.update("UPDATE Libri SET " 	+
				"titolo = \""			    + ((Libro)e).getTitolo() 					+ "\"," +
				"genere = \""			    + ((Libro)e).getGenere() 					+ "\"," +
				"numero_pagine = "  				+ ((Libro)e).getNumero_pagine() 	+ ","   +
				"casa_editrice = \"" 			+ ((Libro)e).getCasa_editrice() 				+ "\"," + 
				"prezzo = "  				+ ((Libro)e).getPrezzo() 					+ " "   +
				"WHERE id = "  			+ e.getId()
				);
	}

	public List<Map<String,String>> read()
	{
		return super.read("SELECT * FROM Libri");
	}
	
	
	public List<Libro> list()
	{
		List<Libro> ris = new ArrayList<Libro>();
		
		List<Map<String,String>> righe = super.read("SELECT * FROM Libri INNER JOIN Autori ON libri.idAutore = autori.id ");
		
		for(Map<String,String> riga : righe) 
		{
			IFactory a = Factory.createObject("Libro");
			a.create(riga);
			
			ris.add((Libro)a);
		}
		
		return ris;
		
	}
	
	public Entity find(int id ) 
	{
		Map<String, String> riga = super.read("SELECT * FROM Libri WHERE idLibro = " + id).get(0);
		IFactory a = Factory.createObject("Libro");
		a.create(riga);
		
		return (Libro)a;
	}
	
	public Entity findByTitolo(String titolo) 
	{
		
		String query = "SELECT * FROM Libri WHERE libri.titolo LIKE \"%" + titolo + "%\";";
		Map<String, String> riga = super.read(query).get(0);
		IFactory a = Factory.createObject("Libro");
		a.create(riga);
		
		return (Libro)a;
		
	}
	
	public List<Libro> findByGenere(String genere) {
	    List<Libro> libri = new ArrayList<>();
	    String query = "SELECT * FROM Libri WHERE genere LIKE \"%" + genere + "%\"";
	    
	    List<Map<String, String>> righe = super.read(query);
	    for (Map<String, String> riga : righe) {
	        IFactory factory = Factory.createObject("Libro");
	        Libro libro = new Libro();
	        factory.create(riga);
	        if (factory instanceof Libro) {
	            libro = (Libro) factory;
	            libri.add(libro);
	        } else {
	            throw new IllegalArgumentException("AAAAAAAAAAAAAAAAAAAA");
	        }
	    }
	    return libri;
	}
	
	public List<Libro> libriPerPrezzo() {
	    List<Libro> libri = new ArrayList<>();
	    String query = "SELECT * FROM Libri ORDER BY prezzo DESC";
	    
	    List<Map<String, String>> righe = super.read(query);
	    for (Map<String, String> riga : righe) {
	        IFactory factory = Factory.createObject("Libro");
	        Libro libro = new Libro();
	        factory.create(riga);
	        if (factory instanceof Libro) {
	            libro = (Libro) factory;
	            libri.add(libro);
	        } else {
	   
	            throw new IllegalArgumentException("L'oggetto restituito non è un'istanza di Libro.");
	        }
	    }
	    return libri;
	}
	
	public Map<String, Integer> libriCaseEditrici() {
	    Map<String, Integer> casaEditriciConNumeroLibri = new LinkedHashMap<>();
	    String query = "SELECT casa_editrice, COUNT(*) AS numero_libri FROM Libri GROUP BY casa_editrice";
	    
	    List<Map<String, String>> righe = super.read(query);
	    for (Map<String, String> riga : righe) {
	        String casaEditrice = riga.get("casa_editrice");
	        int numeroLibri = Integer.parseInt(riga.get("numero_libri"));
	        casaEditriciConNumeroLibri.put(casaEditrice, numeroLibri);
	    }
	    return casaEditriciConNumeroLibri;
	}

}
