package br.unisinos.unitunes.controller;

import java.sql.SQLException;
import java.util.List;

public interface IController<T> {

	void insert(T entity) throws SQLException;
	
	long update(T entity) throws SQLException;
	
	int delete(long id) throws SQLException;
	
	List<T> getAll ();
	
	T getById(long id) throws SQLException;
	
}
