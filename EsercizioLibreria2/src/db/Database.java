package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements IDatabase {
	
	private String user = "root";
	private String password = "root";
	private String path = "jdbc:mysql://localhost:3306/";
	private final String fusoOrario = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private Connection c;
	
	public Database(String nomeDB) 
	{
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

	public void open() {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(path, user, password);
			System.out.println("Connected to SQL");
		}
		catch(Exception e) 
		{
			System.err.println("Controlla: Driver, Crenziali, Connettore");
			e.printStackTrace();
		}
		
	}

	public void close() {
		try
		{
			c.close();
			System.out.println("Closed connection");
		} 
		catch (SQLException e)
		{
			System.err.println("Controlla che apriConnessione() funzioni");
			e.printStackTrace();
		}
		
	}

}
