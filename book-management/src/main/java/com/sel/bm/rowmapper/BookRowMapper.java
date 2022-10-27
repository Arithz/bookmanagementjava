package com.sel.bm.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sel.bm.api.Book;

public class BookRowMapper implements RowMapper<Book> {
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Book book = new Book();
		
		book.setId(rs.getInt("bookid"));
		book.setName(rs.getString("bookname"));
		book.setAuthor(rs.getString("bookauthor"));
		book.setNumber(rs.getInt("booknumber"));
		
		return book;
	}
}
