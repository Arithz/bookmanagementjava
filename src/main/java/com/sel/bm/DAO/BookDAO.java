package com.sel.bm.DAO;

import java.util.List;

import com.sel.bm.api.Book;

public interface BookDAO {
	List<Book> loadBooks();
	public int save(Book b);
	Book getBookById(int id);
	public int update(Book b);
	public int delete(Book b);
}
