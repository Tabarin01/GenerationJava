package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements IDatabase
{
	// Solitamente i dati legati alla connessione sono salvati in un file di configurazione.
	// Per motivi didattici noi invece li scriveremo in scaffolding
	private String user = "root";
	private String password = "root";
	// Il path (sar� il percorso per arrivare al server di turno) lo ricavo facendo:
	//	-> Tasto destro sul quadrotto di local instance di MySQL
	//		-> Copy JDBC connection String to clipboard
	//			-> Incollo negli apici di Java la stringa copiata e cancello l'ultima parte (?user=root)
	private String path = "jdbc:mysql://localhost:3306/";
	// Va in coppia con il DRIVER, quindi cercate il fuso orario accoppiato con la versione del 
	// driver che volete usare
	private final String fusoOrario = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	// Il DRIVER lo trovate cercando su google, ricordate che il drivere cambia in base al DBMS che 
	// usate, cio� per collegare Java a MySQL serve un tipo di driver, mentre per collegare
	// Java a Oracle servir� un tipo diverso di driver.
	// In ogni caso su google li trovate sempre (Maven repository � un ottimo sito su cui cercare)
	
	// Questo � lo strumento che nell'effettivo sosterr� tutto il peso della connessione.
	// Va importato da java.sql.Connection
	private Connection c;
	
	public Database(String nomeDB)
	{
		// Ricordate di importare il JAR scaricato!!
		// Tasto destro sul nome del progetto ->
		//  Build Path -> Configure Build Path -> 
		//   Nella maschera che si apre, click sulla finestra Libraries ->
		//    In base alle versioni della JRE potrete avere tutto insieme o in cartelline sepate:
		//	  se tutto insieme state li, se avete le cartelline cercate Module Path o ClassPath, comunque
		//	  la cartella senza JRE
		//		Click su ADD EXTERNAL JAR -> Nella maschera che si apre cercare il JAR, e copiatelo 
		//		nel progetto attuale, allo stesso livello della cartella src
		//			Click su apri, tornate sulla maschera di Eclips, ciclk su APPLY AND CLOSE ->
		//				La maschera si chiude e nel Project explorer dovrebbe comparire una voce nel 
		//				progetto chaiamata Referenced Libraries con dentro il JAR
		
		setC(nomeDB);
	}
	
	public Connection getC()
	{
		return c;
	}
	public void setC(String nomeDB)
	{
		this.path = path + nomeDB + "?" + fusoOrario;
	}
	
	// Lo scopo di questo metodo � aprire un ponte che colleghi Java al DBMS di tutrno(MySQL)
	// Finch� il ponte � accessibile possiamo dialogare con il DBMS ma cos� facendo ricordiamoci
	// che stiamo occupando un posto e i posti nei server sono limitati, quindi non lasciate 
	// aperta la connessione pi� del dovuto
	public void open()
	{
		try
		{
			// Rappresenta il DRIVER, cio� il connettore che sto usando
			// ATTENZIONE! Il driver cambia in base alle versioni del JAR che usate
			// Se avete dubbi, il driver lo trovate su MAVEN REPOSITORY o tramite Amico Google
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// In questa riga si apre nell'effettivo la connessione.
			// Possibili errori segnalati qui: Manca il JAR, Credenziali errate, Driver errato (riga 69)
			c = DriverManager.getConnection(path,user,password);
		}
		catch(Exception e)
		{
			System.out.println("Controlla: Driver, Crenziali, Connettore");
			// Stampa in console le scritte rosse dell'errore accaduto coi dettagli
			e.printStackTrace();
		}
	}
	
	// Lo scopo di questo metodo � chiudere il ponte aperto precedentemente
	public void close()
	{
		try
		{
			c.close();
		} 
		catch (SQLException e)
		{
			System.out.println("Controlla che apriConnessione() funzioni");
			e.printStackTrace();
		}
	}
	
}//Fine classe Database
