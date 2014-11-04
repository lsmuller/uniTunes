package br.unisinos.unitunes.DB;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	private static DBManager db;
	private Connection conn;
		
	public static DBManager getInstance() throws URISyntaxException, SQLException {
		if (db == null) {
			db = new DBManager();
	    }

		return db;
	}
	
	public Connection getConn() {
        return this.conn;
    }
	
	public DBManager() throws URISyntaxException, SQLException {
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();

	    this.conn = DriverManager.getConnection(dbUrl, username, password);
	}	
}
