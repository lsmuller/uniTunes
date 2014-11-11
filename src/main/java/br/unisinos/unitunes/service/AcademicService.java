package br.unisinos.unitunes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unisinos.unitunes.DB.DBManager;
import br.unisinos.unitunes.model.Academic;

public class AcademicService implements IService<Academic> {
	
	DBManager db;
	Connection conn;
	private static AcademicService ac;
	
	
	public static AcademicService getInstance() {
		if (ac == null)
			ac = new AcademicService();
		
		return ac;
	}
	
	public AcademicService() {
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

	public long update(Academic entity) throws SQLException {
		ResultSet generatedKeys = null;
		long affectedRows;
		
		PreparedStatement ps = conn.prepareStatement("UPDATE ACADEMIC "
				+ " SET firstname = ?, " 
				+ " SET lastname = ?, "
				+ " SET email = ?, "
				+ " SET password = ?, "
				+ " SET balance = ?, "
				+ " SET admin = ?, "
				+ " SET excluded = ?"
				+ " WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1, entity.getFirstName());
		ps.setString(2, entity.getLastName());
		ps.setString(3, entity.getEmail());
		ps.setString(4, entity.getPassword());
		ps.setDouble(5, entity.getBalance());
		ps.setBoolean(6, entity.isAdmin());
		ps.setBoolean(7, entity.isExcluded());
		

        affectedRows = ps.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Update user failed, no rows affected.");
        } else if (affectedRows > 1) {
            throw new SQLException("More than one row updated");
        }

        return affectedRows;
	}

	public int delete(long l) throws SQLException {
		int resultDelete;
		
		PreparedStatement ps = conn.prepareStatement("UPDATE ACADEMIC"
				+ " SET excluded = true"
				+ " WHERE ID = ?");
		ps.setLong(1, l);
		
		resultDelete = ps.executeUpdate();
		
		 if (resultDelete == 0) {
	            throw new SQLException("No record found for deletion!");
	        } else if (resultDelete > 1) {
	            throw new SQLException("More than one row deleted!");
	        } else {
	            System.out.println("Usuario código " + l + " deletado!");
	        }

	        return resultDelete;
	}
	
	public Academic login(String email, String password) throws SQLException {
		ResultSet rs ;
		Academic a = null;
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACADEMIC WHERE EMAIL = ? "
				+ "AND PASSWORD = ?");
		
		ps.setString(1, email);
		ps.setString(2, password);

		rs = ps.executeQuery();
		
		if(rs.next()) {
			a = getFromResultSet(rs);
		}
		else {
			throw new SQLException("Academic not found!");
		}

		return a;
	}

	public List<Academic> getAll() {
		ArrayList<Academic> academics = new ArrayList<Academic>();
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM ACADEMIC;");
			
			while(rs.next()) {
				Academic a = getFromResultSet(rs); 
				academics.add(a);
			}
		}
		catch (Exception e) {
			academics.add(new Academic(5, e.getMessage(), "teste", "teste", "teste", 3, false, false));
		}
		
		return academics;
	}

	public Academic getById(long id) throws SQLException {
		ResultSet rs ;
		Academic a = null;
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM ACADEMIC WHERE ID = ?");
		ps.setLong(1, id);

		rs = ps.executeQuery();
		
		if(rs.next()) {
			a = getFromResultSet(rs);
		}
		else {
			throw new SQLException("Academic not found!");
		}

		return a;
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
        } catch (SQLException e) {
//            TODO: fix
        }

        return a;
    }
}
