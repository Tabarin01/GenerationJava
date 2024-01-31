package db;

import java.sql.Connection;

public interface IDatabase 
{
	
	public Connection getC();
	public void apriConnessione();
	public void chiudiConnessione();

}
