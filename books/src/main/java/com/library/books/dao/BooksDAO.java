package com.library.books.dao;

import java.util.ArrayList;
import java.util.List;

import com.library.books.models.Book;

public interface BooksDAO {

	void createBook(Book book);

	void updateBook(Book book);

	List<Book> getBooks();

	boolean deleteBook(int id);

}
