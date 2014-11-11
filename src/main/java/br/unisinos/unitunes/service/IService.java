package br.unisinos.unitunes.service;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {

	void insert(T entity) throws SQLException;
	
	long update(T entity) throws SQLException;
	
	int delete(long id) throws SQLException;
	
	List<T> getAll ();
	
	T getById(long id) throws SQLException;
	
}
