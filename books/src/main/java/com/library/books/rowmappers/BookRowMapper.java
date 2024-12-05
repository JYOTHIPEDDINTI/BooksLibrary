package com.library.books.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.library.books.models.Book;

public class BookRowMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Book book = new Book();
		
		book.setBookid(rs.getLong("bookid"));
		book.setBookname(rs.getString("bookname"));
		book.setBookauthor(rs.getString("bookauthor"));
		book.setDescription(rs.getString("description"));
		
		return book;
	}
	
}
