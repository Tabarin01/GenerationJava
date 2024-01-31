package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import db.IDatabase;
import entities.Entity;
import entities.Persona;

// DAO è un acronimo che sta per Data Access Object
// Essendo un acronimo per conenzione viene sempre scritto in CAPS

// Tutte le classi che iniziano per DAO sono classi
// il cui compito è quelli di interrogare il DBMS, scambiando dati
// facendo domande, cercando di fare inserimenti sul db, facendo modifiche
// eliminazioni


// Solitamente abbiamo minimo un DAO per ogni tabella SQL e/o per ogni classe JAVA 
public class DAOPersona implements IDAO
{
	// PATTERN: trovare una soluzione a un problema ricorrente nel tempo.
	// I pattern si dividono in famiglie e ce ne sono tantissimi.
	// Sono suddivisi in base al tipo di problema che vanno a risolvere

	// Pattern SINGLETON -> impedisce la creazione di oggetti copia (duplicati) della classe 
	// in cui si usa :

	// STEP 1: Creo una variabile static che tenga in memoria se ho gia' creato un oggetto di tipo
	//         DAOPersona oppure no
	private static DAOPersona instance = null;

	//STEP 2: Costruttore privato per impedire la creazione diretta di istanze, ovvero oggetti non desiderati
	private DAOPersona(String nomeDb) 
	{
		db = new Database(nomeDb);
	}

	// STEP 3: Creo un metodo pubblico che gestira' la creazione di un nuovo oggetti
	// di tipo DAOPersona:
	//					  valuta se instance ha un valore o meno, se e' null crea un oggeto di tipo DAOPersona
	//					  altrimenti restituisce l'oggetto gia' in memoria nella variabile instance.

	public static DAOPersona getInstance() 
	{
		if (instance == null) 
		{
			instance = new DAOPersona("anagrafe");
		}

		return instance;
	}
	// ------------------------------------------------
	private IDatabase db;

	// Le classi DAO si occupano degli scambi con il DBMS
	// Quindi nelle classi DAO si trovano i cosi' detti metodi CRUD -> Create, Read, Update, Delete
	// I metodi CRUD sono il minimo indispensabile per una classe DAO

	// DELETE: elimina un record alla volta dalla tabella
	public boolean delete(int id) 
	{
		db.apriConnessione();

		String query  = "DELETE FROM persone WHERE id = " + id + ";";

		try 
		{
			//STEP 3: Creo un messaggero che sia capace di portare la query da JAVA al DBMS interessato
			PreparedStatement st = db.getC().prepareStatement(query);
			// PreparedStatement e' un'interfaccia che da origine a un oggetto in grado do
			// leggere la query e trovare errori di sintassi.

			//Inoltre possiede i metodi EXECUTE che sono capaci di lanciare la query sul DBMS

			//STEP 4: Ordino di eseguire la query sul DBMS

			int righe = st.executeUpdate();

			return righe > 0;

		}
		catch(Exception e)
		{
			System.err.println("Errore nel metodo DELETE di DAOPersona");
			return false;
		}
		finally
		{
			//STEP 5 Chiudo la connessione con il DBMS
			db.chiudiConnessione();
		}

	}

	//UPDATE: modifica un record alla volta gia' esistente nella tabella
	public boolean update(Entity e) 
	{
		db.apriConnessione();
		Persona p = (Persona)e;
		String query = "UPDATE Persone SET " +
				"nome = \"" 			 + p.getNome()				+ "\"," +
				"cognome = \"" 		 + p.getCognome() 			+ "\"," +
				"dob = \"" 			 + p.getDob() 				+ "\"," +
				"residenza = \"" 	 + p.getResidenza() 		+ "\"," +
				"genere = \"" 		 + p.getGenere() 			+ "\"," +
				"professione = \"" 	 + p.getProfessione() 		+ "\" " +
				"WHERE id = " 	     + p.getId();

		try 
		{
			PreparedStatement ps = db.getC().prepareStatement(query);
			int righe = ps.executeUpdate();

			return righe > 0;
		}
		catch(Exception ex) 
		{
			System.out.println("Errore nel metodo UPDATE di DAOPersona\nQUERY: " + query);
			return false;
		}
		finally 
		{
			db.chiudiConnessione();
		}

	}

	// CREATE o INSERT: salva un nuovo record nella tabella
	public boolean create(Entity e) 
	{
		db.apriConnessione();
		Persona p = (Persona)e;
		String query = "INSERT INTO Persone " +
				"(nome, cognome, dob, residenza, genere, professione) VALUES (" +
				"\"" + p.getNome() 			+ "\", " +
				"\"" + p.getCognome() 		+ "\", " +
				"\"" + p.getDob() 			+ "\", " +
				"\"" + p.getResidenza() 	+ "\", " +
				"\"" + p.getGenere() 		+ "\", " +
				"\"" + p.getProfessione() 	+ "\")";

		try 
		{
			PreparedStatement ps = db.getC().prepareStatement(query);
			int righe = ps.executeUpdate();

			return righe > 0;
		}
		catch(Exception ex) 
		{
			System.err.println("Errore nel metodo INSERT di DAOPersona\nQUERY: " + query);
			return false;
		}
		finally 
		{
			db.chiudiConnessione();
		}
	}

	//READ 
	public List<Entity> read()
	{
		List<Entity> ris = new ArrayList<Entity>();

		db.apriConnessione();

		String query = "SELECT * FROM Persone";



		try 
		{
			PreparedStatement st = db.getC().prepareStatement(query);
			//ResultSet e' un'interfaccia in grado di gestire la struttura di una tabella SQL
			ResultSet tabella = st.executeQuery();

			// Bisogna per forza ciclare, anche se sappiamo che la tabella avra' un solo record
			while(tabella.next()) 
			{
				Entity e = new Persona(tabella.getInt("id"), 
						tabella.getString("nome"), 
						tabella.getString("cognome"), 
						tabella.getString("dob"), 
						tabella.getString("residenza"), 
						tabella.getString("genere"),
						tabella.getString("professione"));

				ris.add(e);
			}



		}
		catch(Exception e) 
		{
			System.err.println("Errore nel metodo READ di DAOPersona\nQUERY: " + query);
			e.printStackTrace();
		}
		finally 
		{
			db.chiudiConnessione();
		}

		return ris;
	}

	public Entity find(int id) 
	{
		Entity ris = null;

		db.apriConnessione();

		String query = "SELECT * FROM Persone WHERE id = " + id;



		try 
		{
			PreparedStatement st = db.getC().prepareStatement(query);
			//ResultSet e' un'interfaccia in grado di gestire la struttura di una tabella SQL
			ResultSet tabella = st.executeQuery();

			// Bisogna per forza ciclare, anche se sappiamo che la tabella avra' un solo record
			while(tabella.next()) 
			{
				ris = new Persona(
						tabella.getInt("id"), 
						tabella.getString("nome"), 
						tabella.getString("cognome"), 
						tabella.getString("dob"), 
						tabella.getString("residenza"), 
						tabella.getString("genere"),
						tabella.getString("professione"));

			}

		}
		catch(Exception e) 
		{
			System.err.println("Errore nel metodo FIND di DAOPersona\nQUERY: " + query);
			e.printStackTrace();
		}
		finally 
		{
			db.chiudiConnessione();
		}

		return ris;
	}

}
