package br.unisinos.unitunes.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.unisinos.unitunes.DB.DBManager;
import br.unisinos.unitunes.model.Midia;

public class MidiaService implements IService<Midia> {

	DBManager db;
	Connection conn;
	private static MidiaService ms;
	
	
	public static MidiaService getInstance() {
		if (ms == null)
			ms = new MidiaService();
		
		return ms;
	}
	
	public MidiaService() {
		try {
			db = DBManager.getInstance();
			conn = db.getConn();
		}
		catch (Exception e) {
//			TODO: fix
		}
	}
	
	public long insert(Midia entity) throws SQLException {
		ResultSet generatedKeys = null;
        long idRetornado = -1;

        PreparedStatement ps = conn.prepareStatement("INSERT INTO midia "
        		+ "(name, description, price, author, category, duration, pages, creation, excluded) "
        		+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", 
        		Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, entity.getName());
        ps.setString(2, entity.getDescription());
        ps.setDouble(3, entity.getPrice());
        ps.setLong(4, entity.getAuthor());
        ps.setLong(5, entity.getCategory());
        ps.setInt(6, entity.getDuration());
        ps.setInt(7, entity.getPages());
        ps.setDate(8, (java.sql.Date) entity.getCreation());
        ps.setBoolean(9, entity.isExcluded());
        
        int affectedRows = ps.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Creating user failed, no rows affected.");
        }
        generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            idRetornado = generatedKeys.getLong(1);
        } else {
            throw new SQLException("Creating user failed, no generated key obtained.");
        }

        return idRetornado;
	}

	public long update(Midia entity) throws SQLException {
		ResultSet generatedKeys = null;
		long affectedRows;
		
		PreparedStatement ps = conn.prepareStatement("UPDATE MIDIA "
				+ " SET name = ?, " 
				+ " description = ?, "
				+ " price = ?, "
				+ " author = ?, "
				+ " category = ?, "
				+ " duration = ?, "
				+ " pages = ?, "
				+ " creation = ?, "
				+ " excluded = ?"
				+ " WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1, entity.getName());
		ps.setString(2, entity.getDescription());
		ps.setDouble(3, entity.getPrice());
		ps.setLong(4, entity.getAuthor());
		ps.setLong(5, entity.getCategory());
		ps.setInt(6, entity.getDuration());
		ps.setInt(7, entity.getPages());
		ps.setDate(8, (java.sql.Date) entity.getCreation());
		ps.setBoolean(9, entity.isExcluded());
		ps.setLong(10, entity.getId());			// WHERE CLAUSE
		
        affectedRows = ps.executeUpdate();
        if (affectedRows == 0) {
            throw new SQLException("Update midia failed, no rows affected.");
        } else if (affectedRows > 1) {
            throw new SQLException("More than one row updated");
        }

        return affectedRows;
	}

	public int delete(long id) throws SQLException {
		int resultDelete;
		
		PreparedStatement ps = conn.prepareStatement("UPDATE MIDIA"
				+ " SET excluded = true"
				+ " WHERE ID = ?");
		ps.setLong(1, id);
		
		resultDelete = ps.executeUpdate();
		
		 if (resultDelete == 0) {
	            throw new SQLException("No record found for deletion!");
	        } else if (resultDelete > 1) {
	            throw new SQLException("More than one row deleted!");
	        } else {
	            System.out.println("Midia código " + id + " deletado!");
	        }

	        return resultDelete;
	}

	public List<Midia> getAll() {
		ArrayList<Midia> midias = new ArrayList<Midia>();
		
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM MIDIA;");
			
			while(rs.next()) {
				Midia m = getFromResultSet(rs); 
				midias.add(m);
			}
		}
		catch (Exception e) {
			midias.add(new Midia(5, e.getMessage(), "", 0, 0, 0, 0, 0, Calendar.getInstance().getTime(), false));
		}
		
		return midias;
	}

	public Midia getById(long id) throws SQLException {
		ResultSet rs ;
		Midia m = null;
		
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM MIDIA WHERE ID = ?");
		ps.setLong(1, id);

		rs = ps.executeQuery();
		
		if(rs.next()) {
			m = getFromResultSet(rs);
		}
		else {
			throw new SQLException("Midia not found!");
		}

		return m;
	}
	
	public Midia getFromResultSet(ResultSet rs) {
		Midia m = null;

        try {
        	long id = rs.getLong(1);
        	String name = rs.getString(2);
        	String description = rs.getString(3);
        	double price = rs.getDouble(4);
        	long author = rs.getLong(5);
        	long category = rs.getLong(6);
        	int duration = rs.getInt(7);
        	int pages = rs.getInt(8);
        	Date creation = rs.getDate(9);
        	boolean excluded = rs.getBoolean(10);
        	
            m = new Midia(id, name, description, price, author, category, duration, pages, creation, excluded);
        } catch (SQLException e) {
//            TODO: fix
        }

        return m;
    }
}
