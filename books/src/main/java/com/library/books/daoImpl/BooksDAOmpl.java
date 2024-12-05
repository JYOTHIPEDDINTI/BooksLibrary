package com.library.books.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.library.books.dao.BooksDAO;
import com.library.books.models.Book;
import com.library.books.rowmappers.BookRowMapper;

@Component
public class BooksDAOmpl implements BooksDAO{

	public BooksDAOmpl() {
		super();
	}
	
	private JdbcTemplate jdbcTemplate;
	
	private String SQL_ADD_BOOK = "insert into books(bookid,bookname,bookauthor,description) values(?,?,?,?)";
	private String GET_BOOKS = "select * from books";
	private String UPDATE_BOOK = "update books set bookname = ?, bookauthor = ? , description = ? where bookid= ?";
	private String DELETE_BOOK = " Delete from Books where bookid = ?";
	
	@Autowired
	public void setJDBCTemplates(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void createBook(Book book) {
		jdbcTemplate.update(SQL_ADD_BOOK,book.getBookid(),book.getBookname(),book.getBookauthor(),book.getDescription());
	}

	@Override
	public void updateBook(Book book) {
		jdbcTemplate.update(SQL_ADD_BOOK,book.getBookname(),book.getBookauthor(),book.getDescription(),book.getBookid());
	}

	@Override
	public List<Book> getBooks() {
		return jdbcTemplate.query(GET_BOOKS, new BookRowMapper());
	}

	@Override
	public boolean deleteBook(int id) {
		return jdbcTemplate.update(DELETE_BOOK, id)>0;
	}

	
}
