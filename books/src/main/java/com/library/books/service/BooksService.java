package com.library.books.service;

import java.util.ArrayList;
import java.util.List;

import com.library.books.models.Book;

public interface BooksService {

	void addBook(Book book);

	void updateBook(Book book);

	List<Book> getBooks();

	boolean deleteBook(int id);

}
