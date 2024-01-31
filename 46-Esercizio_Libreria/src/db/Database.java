package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database implements IDatabase{

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

	@Override
	public void open() {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(path, user, password);
			
		}
		catch(Exception e) 
		{
			System.err.println("Controlla: Driver, Crenziali, Connettore");
			e.printStackTrace();
		}
		
	}

	@Override
	public void close() {
		try
		{
			c.close();
		} 
		catch (SQLException e)
		{
			System.err.println("Controlla che apriConnessione() funzioni");
			e.printStackTrace();
		}
		
	}
	
	

}
