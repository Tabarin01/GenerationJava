package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Questa classe modello ci servira per creare gli stumenti di connessione con MySQL
// (o qualunque sistema DBMS che stiate usando in questo momento)
public class Database implements IDatabase{
	
	// Solitamente i dati legati alla connessione sono salvati in un file di configurazione.
	// Per motivi didattici, noi invece li scriveremo in scaffolding
	private String user = "root";
	private String password = "root";
	// Il path (il percorso per arrivare al server di turno) lo ricavo facendo:
	//  Tasto destro sul quadrotto di local instance di MySQL
	//	Copy JDBC connection String to clipboard
	//	Incollo negli apici di java la stringa copiata e cancello l'ultima parte (?user=root)
	private String path = "jdbc:mysql://localhost:3306/";
	// Va in coppia con il DRIVER, quindi cercate il fuso orario accoppiato con la versione del driver che volete
	private final String fusoOrario = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	// il DRIVER lo trovate su google, ricordate che il diver cambia in base al dbms che 
	// usate, cioe per collegare Java a MySQL serve un tipo di driver, mentre per collegare
	// Java a Oracle servira un tipo diverso di driver.
	// in ogni caso su google li trovate sempre (Maven repository e un ottimo sito su cui cercare)
	
	// Questo e lo strumento che nell'effettivo sosterra tutto il peso della connesione
	// Va importato da java.sql.Connection
	private Connection c;
	
	public Database(String nomeDB) {
		
		// Ricordate di importare il JAR scaricato!!
		// Tasto destro sul nome del progetto ->
		//  Build Path -> Configure Build Path ->
		//   Nella maschera che si apre, click sulla finestra Libraries ->
		//    In base alle versioni della JRE protreste avere tutto insieme o in cartelline separate:
		//    se tutto insieme state li, se avete le cartelline cercarte Classpath (vuota)
		//     Click su ADD EXTRERNAL JAR -> nella maschera che si apre cercate il JAR, 
		//     e copiatelo nel progetto attuale, allo stesso livello delle cartelle BIN e SRC
		//	    Click su apri, tornate sulla maschera di Eclipse, click su APPLY AND CLOSE ->
		//		 La maschera si chiude e nel Project explorer e dovrebbe comparire una voce nel progetto 
		//		 chiamata Referenced Libraries con dentro la nuova JAR
		
		setC(nomeDB);
	}
	
	public Connection getC() {
		return c;
	}
	public void setC(String nomeDB) {
		this.path = path + nomeDB + "?" + fusoOrario;
	}
	
	// Lo scopo di questo metodo è aprire un ponte che colleghi Java al DBMS di turno(MySql in questo caso)
	// Finché il ponte è accessibile possiamo dialogare con il DBMS ma così facendo ricordia
	// che stiamo occupando un posto e i posti nei server sono limitati, quindi non lasciare 
	// aperta la connessione più del dovuto è molto importante
	
	public void apriConnessione() 
	{
		try 
		{
			// Rappresenta il DRIVER, cioè il connettore che sto usando
			// ATTENZIONE! Il driver cambia in base alle versioni del JAR che si usa
			// In caso di dubbi, il driver si trova su MAVEN REPOSITORY o tramite Amico Google
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// In questa riga si apre nell'effettivo la connessione.
			// Possibili errori segnalati qui: Manca il JAR, Credenziali errate, Driver errato
			
			c = DriverManager.getConnection(path, user, password);
			
		}
		catch(Exception e) 
		{
			System.out.println("Controlla: Driver, credenziali, connettore");
			// STAMPA in console le scritte rosse dell'errore accaduto coi dettagli
			e.printStackTrace();
		}
	}
	
	// Lo scopo di questo metodo è chiudere il ponte aperto precedentemente
	public void chiudiConnessione() 
	{
		try 
		{
			c.close();
		}
		catch(SQLException e) 
		{
			System.out.println("Controla che apriConnessione() funzioni");
			
			e.printStackTrace();
		}
		
	}
	
	
}// FINE CLASSE DATABASE
