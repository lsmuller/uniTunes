package br.unisinos.unitunes.controller;

import java.sql.SQLException;
import java.util.List;

public interface IController<T> {

	void insert(T entity);
	
	void update(T entitiy);
	
	void delete(T entity);
	
	List<T> getAll ();
	
	T getById(long id) throws SQLException;
	
}
