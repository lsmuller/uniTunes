package br.unisinos.unitunes.DB;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	private static DBManager db;
	private Connection conn;
	private Statement stmt;
		
	public static DBManager getInstance() throws URISyntaxException, SQLException {
		if (db == null) {
			db = new DBManager();
	    }

		return db;
	}
	
	public Connection getConn() {
        return conn;
    }
	
	public DBManager() throws URISyntaxException, SQLException {
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

	    conn = DriverManager.getConnection(dbUrl, username, password);
	}	
}
