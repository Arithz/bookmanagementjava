package com.sel.bm.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sel.bm.api.Book;
import com.sel.bm.rowmapper.BookRowMapper;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Book> loadBooks() {
		
		String sql = "SELECT * from book";
		List <Book> theListofBooks = jdbcTemplate.query(sql, new BookRowMapper());
		
		return theListofBooks;
	}

	@Override
	public int save(Book b) {
		String sql = "INSERT INTO book (bookname, bookauthor, booknumber) values ('"+b.getName()+"','"+b.getAuthor()+"','"+b.getNumber()+"')";
		return jdbcTemplate.update(sql);
	}

	@Override
	public Book getBookById(int id) {
		Book book = (Book) jdbcTemplate.queryForObject("select * from book where bookid = ?",
				new Object[] { id }, new BookRowMapper());
		return book;
	}

	@Override
	public int update(Book b) {
		String sql = "UPDATE book SET bookname =?, bookauthor=?, booknumber=? WHERE bookid =?";
		return jdbcTemplate.update(sql, b.getName(), b.getAuthor(), b.getNumber(), b.getId());
	}

	@Override
	public int delete(Book b) {
		String sql = "DELETE from book where bookid =" + b.getId();
		return jdbcTemplate.update(sql);
	}

}
