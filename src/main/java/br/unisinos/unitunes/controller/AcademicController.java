package br.unisinos.unitunes.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unisinos.unitunes.DB.DBManager;
import br.unisinos.unitunes.model.Academic;

public class AcademicController implements IController<Academic> {
	
	DBManager db;
	Connection conn;
	private static AcademicController ac;
	
	
	public static AcademicController getInstance() {
		if (ac == null)
			ac = new AcademicController();
		
		return ac;
	}
	
	public AcademicController() {
		try {
			db = DBManager.getInstance();
			conn = db.getConn();
		}
		catch (Exception e) {
//			TODO: fix
		}
	}

	public void insert(Academic entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(Academic entitiy) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Academic entity) {
		// TODO Auto-generated method stub
		
	}

	public List<Academic> getAll() {
		ArrayList<Academic> academics = new ArrayList<Academic>();
		
		try {
			Connection conn = db.getConn();
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM ACADEMIC;");
			
			while(rs.next()) {
				Academic a = getFromResultSet(rs); 
				academics.add(a);
			}
		}
		catch (Exception e) {
//			TODO: fix
		}
		
		Academic a = new Academic(1, "me@paulograbin.com", "Paulo", "Grabin", "teste", 99.9, true, false);
		academics.add(a);
		
		return academics;
	}

	public Academic getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

    public Academic getFromResultSet(ResultSet rs) {
		Academic a = null;

        try {
        	long id = rs.getLong(1);
        	String firstName = rs.getString(2);
        	String lastName = rs.getString(3);;
        	String email = rs.getString(4);
        	String password = rs.getString(5);
        	double balance = rs.getDouble(6);
        	boolean admin = rs.getBoolean(7);
        	boolean excluded = rs.getBoolean(8);
        	
            a = new Academic(id, email, firstName, lastName, password, balance, admin, excluded);
//            System.out.println("usuarioGetFromResultSet retornando " + u.toString());
        } catch (SQLException e) {
//            TODO: fix
        }

        return a;
    }
	
}
