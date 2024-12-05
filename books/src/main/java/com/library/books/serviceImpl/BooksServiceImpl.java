package com.library.books.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.books.dao.BooksDAO;
import com.library.books.models.Book;
import com.library.books.service.BooksService;

@Repository
public class BooksServiceImpl implements BooksService{
	
	@Autowired
	private BooksDAO booksDAO;

	public BooksServiceImpl() {
		super();
	}

	@Override
	public void addBook(Book book) {
		
		booksDAO.createBook(book);
	}

	@Override
	public void updateBook(Book book) {
		booksDAO.updateBook(book);
		
	}

	@Override
	public List<Book> getBooks() {
		
		return booksDAO.getBooks();
	}

	@Override
	public boolean deleteBook(int id) {
		return booksDAO.deleteBook(id);
	}

}
