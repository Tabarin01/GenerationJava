package dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import entities.Entity;
import entities.Libro;
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
	
	public List<Libro> findByTitolo(String titolo) 
	{
		List<Libro> ris = new ArrayList<>();
		String query = "SELECT * FROM Libri INNER JOIN Autori ON libri.idAutore = autori.id WHERE libri.titolo LIKE \"%" + titolo +"%\";";
		List<Map<String, String>> righe = super.read(query);
		for(Map<String, String> riga : righe) 
		{
			IFactory a = Factory.createObject("Libro");
			a.create(riga);
			ris.add((Libro)a);
		}
		
		return ris;
		
	}
	
	public List<Libro> findByGenere(String genere) 
	{
		List<Libro> ris = new ArrayList<>();
		String query = "SELECT * FROM Libri INNER JOIN Autori ON libri.idAutore = autori.id WHERE libri.genere = \"" + genere +"\";";
		List<Map<String, String>> righe = super.read(query);
		for(Map<String, String> riga : righe) 
		{
			IFactory a = Factory.createObject("Libro");
			a.create(riga);
			ris.add((Libro)a);
		}
		
		return ris;
		
	}
	
	public List<Libro> libriPerPrezzo()
	{
		List<Libro> ris = new ArrayList<>();
		String query = "SELECT * FROM Libri INNER JOIN Autori ON libri.idAutore = autori.id ORDER BY prezzo DESC";
		List<Map<String, String>> records = super.read(query);
		for(Map<String,String> record : records) 
		{
			IFactory a = Factory.createObject("Libro");
			a.create(record);
			ris.add((Libro)a);
			
		}
		
		return ris;
		
	}
	
	public Map<String, Integer> libriCasaEditrici()
	{
		Map<String, Integer> caseEditrici = new LinkedHashMap<>();
		String query = "SELECT casa_editrice, COUNT(*) AS numero_libri FROM Libri GROUP BY casa_editrice";
		List<Map<String, String>> records = super.read(query);
		
		for(Map<String, String> record : records) 
		{
			String editore = record.get("casa_editrice").toUpperCase();
			int numeroLibri = Integer.parseInt(record.get("numero_libri"));
			caseEditrici.put(editore, numeroLibri);
		}
		
		return caseEditrici;
		
	}
	
	
	
	


}
