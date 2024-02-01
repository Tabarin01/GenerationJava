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
		return super.update("DELETE FROM Autori WHERE id = " + id);
	}

	public List<Map<String,String>> read()
	{
		return super.read("SELECT * FROM Autori");
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

	public List<Autore> list()
	{
		List<Autore> ris = new ArrayList<Autore>();

		List<Map<String, String>> righe = super.read("SELECT * FROM Autori");

		for(Map<String, String> riga : righe) 
		{
			IFactory a = Factory.createObject("Autore");

			a.create(riga);

			ris.add((Autore)a);

		}

		return ris;
	}

	public Entity find(int id) 
	{
		List<Map<String, String>> riga = super.read("SELECT * FROM Autori WHERE id = " + id);
		IFactory a = Factory.createObject("Autore");
		a.create(riga.get(0));
		return (Autore)a;
	}

	public String libriAutore()
	{
		Map<String, Integer> autori = new LinkedHashMap<>();
		String query = "SELECT CONCAT(autori.nome,' ',autori.cognome) AS nominativo, COUNT(*) AS numero_libri " +
					   "FROM Libri " +
					   "INNER JOIN Autori ON libri.idAutore = autori.id " +
					   "GROUP BY autori.id ";
		List<Map<String, String>> records = super.read(query);
		for(Map<String, String> record : records) 
		{
			String nomeAutore = record.get("nominativo");
			int numeroLibri = Integer.parseInt(record.get("numero_libri"));
			autori.put(nomeAutore, numeroLibri);
		}
		
		String risultato = "";
        for (Map.Entry<String, Integer> entry : autori.entrySet()) {
            risultato += entry.getKey() + ": " + entry.getValue() + "\n";
        }
        
		return risultato;
	}
}
