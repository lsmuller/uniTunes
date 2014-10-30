package br.unisinos.unitunes.controller;

import java.util.ArrayList;
import java.util.List;

import br.unisinos.unitunes.model.Book;

public class BookController {

	public List<Book> getBookList() {
		ArrayList<Book> books = new ArrayList<Book>();
		
		Book book = new Book();
		book.setTitle("50 tons de cinza");
		
		books.add(book);
		
		return books;
	}
	
}
