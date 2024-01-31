package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entities.Autore;
import entities.Entity;
import factory.Factory;
import factory.IFactory;

public class DAOAutore extends DAO
{
	public DAOAutore(String nomeDB) 
	{
		super(nomeDB);
	}

	public boolean delete(int id) 
	{
		return super.update("DELETE FROM Autori WHERE id =" + id);
	}

	public boolean insert(Entity e) 
	{
		return super.update("INSERT INTO Autori(nome, cognome, dob, nazionalita, biografia) VALUES"+
				"(\"" + ((Autore)e).getNome() 		+ "\"," +
				 "\"" + ((Autore)e).getCognome() 	+ "\"," +
				 "\"" + ((Autore)e).getDob() 		+ "\"," +
				 "\"" + ((Autore)e).getNazionalita() + "\"," +	
				 "\"" + ((Autore)e).getBiografia()   + "\")");
	}
	
	public boolean update(Entity e) 
	{
		return super.update("UPDATE Autori SET " +
							"nome = \"" 		+ ((Autore)e).getNome() 			+ "\", " +
							"cognome = \"" 		+ ((Autore)e).getCognome() 			+ "\", " +
							"dob = \"" 			+ ((Autore)e).getDob() 				+ "\", "+
							"nazionalita = \""  + ((Autore)e).getNazionalita() 		+ "\", " +
							"biografia = \"" 	+ ((Autore)e).getBiografia() 		+ "\" " +
							"WHERE id = " 		+ e.getId() 
				);
	}
	
	
	public List<Map<String, String>> read()
	{
		return super.read("SELECT * FROM Autori");
		
	}
	
	public List<Autore> list()
	{
		List<Autore> ris = new ArrayList<Autore>();
		
		List<Map<String, String>> righe = super.read("SELECT * FROM Autori");
		
		for(Map<String,String> riga : righe) 
		{
			IFactory a = Factory.createObject("Autore");
			
			a.create(riga);
			
			ris.add((Autore)a);
		}
		
		return ris;
	}
	
	public Entity find(int id) 
	{
		Map<String, String> riga = super.read("SELECT * FROM Autori WHERE id = " + id).get(0);
		IFactory a = Factory.createObject("Autore");
		a.create(riga);
		
		return (Autore)a;
	}
	
	
	
//	public List<Autore> cercaAutore(String nome, String cognome) {
//	    List<Autore> autori = new ArrayList<>();
//	    String query = "SELECT * FROM Autori WHERE ";
//	    if (nome != null && !nome.isEmpty()) {
//	        query += "nome LIKE \"%" + nome + "%\"";
//	        if (cognome != null && !cognome.isEmpty()) {
//	            query += " AND ";
//	        }
//	    }
//	    if (cognome != null && !cognome.isEmpty()) {
//	        query += "cognome LIKE \"%" + cognome + "%\"";
//	    }
//	    
//	    List<Map<String, String>> righe = super.read(query);
//	    for (Map<String, String> riga : righe) {
//	        IFactory factory = Factory.createObject("Autore");
//	        Autore autore = new Autore();
//	        factory.create(riga);
//	        if (factory instanceof Autore) {
//	            autore = (Autore) factory;
//	            autori.add(autore);
//	        }
//	    }
//	    return autori;
//	}
	
	public Map<String, Integer> libriAutore() {
	    Map<String, Integer> autoriConNumeroLibri = new LinkedHashMap<>();
	    String query = "SELECT autori.nome, autori.cognome, COUNT(*) AS numero_libri " +
	                   "FROM Libri " +
	                   "INNER JOIN Autori ON Libri.idAutore = Autori.id " +
	                   "GROUP BY Autori.id";
	    
	    List<Map<String, String>> righe = super.read(query);
	    for (Map<String, String> riga : righe) {
	        String nomeAutore = riga.get("nome") + " " + riga.get("cognome");
	        int numeroLibri = Integer.parseInt(riga.get("numero_libri"));
	        autoriConNumeroLibri.put(nomeAutore, numeroLibri);
	    }
	    return autoriConNumeroLibri;
	}

}
