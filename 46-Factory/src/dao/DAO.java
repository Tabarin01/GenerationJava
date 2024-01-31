package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import db.*;

public class DAO implements IDAO
{
	private static IDatabase instance = null;
	private IDatabase db;


	private static IDatabase getInstance(String nomeDB) 
	{
		if(instance == null) 
		{
			instance = new Database("fattoria");
		}

		return instance;
	}
	public DAO(String nomeDB) 
	{
		db = getInstance(nomeDB);
	}

	// Questo metodo lancia una query di : insert, update e delete
	public boolean update(String query) 
	{
		try 
		{
			db.open();
			PreparedStatement ps = db.getC().prepareStatement(query);
			int righe = ps.executeUpdate();
			return righe > 0;
		}
		catch(Exception e) 
		{
			System.out.println("Errore nell'esecuzione della query: n " + query);
			e.printStackTrace();
			return false;
		}
		finally
		{
			db.close();
		}
	}


	public List<Map<String, String>> read(String query)
	{
		List<Map<String, String>> ris = new ArrayList<Map<String, String>>();

		try 
		{
			db.open();
			PreparedStatement ps = db.getC().prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while(rs.next())  // Cicla per i vari record
			{
				Map<String, String> riga = new LinkedHashMap<String, String>();

				// getMetaData() -> Mi fa accedere ai metadati del record che sto ciclando
				//					(nomi, colonne, quante colonne sono, tipo della colonna, ecc)
				// .getColumnCount() -> Mi permette di sapere quante colonne ci sono nel record che sto ciclando
				
				
				
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) // Cicla le singole colonne del record
				{
					// getColumnLabel() -> trasforma il metadato "nomeColonna" in testo
					riga.put(rs.getMetaData().getColumnLabel(i).toLowerCase(), rs.getString(i));
					// Con i = 1 -> KEY id VALUE = "1"
					// 	   i = 2 -> KEY specie VALUE "Mucca"
					//	   i = 3 -> KEY nome VALUES "Guendalina"
				}

				ris.add(riga);
				
				// Il ciclo WHILE mi serve per estrarre dal ResultSEt l'intero record
				// (esempio al giro 1 ottengo tutto il record 1 e cosi via)
				// Il ciclo FOR mi serve per estrarre dal record del WHILE le singole combo colonna-valora
				// (esempio al giro 1 vedo colonna-valore 1, al giro 2 vedo colonna-valore 2, e cosi via)

			}


		}
		catch(Exception e) 
		{
			System.err.println("Errore nella query: " + query);
			e.printStackTrace();

		}
		finally 
		{
			db.close();
		}

		return ris;

	}
}
