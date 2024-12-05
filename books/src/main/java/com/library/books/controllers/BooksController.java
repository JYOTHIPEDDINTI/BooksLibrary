package com.library.books.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.books.models.Book;
import com.library.books.service.BooksService;

@RestController
public class BooksController {

	@Autowired
	private BooksService bookservice;
	
	// Get all books
    @GetMapping(value = "/getbooks")
    public ArrayList<Book> getBooks() {
        System.out.println("get Books");
        ArrayList<Book> li = (ArrayList<Book>) bookservice.getBooks();
        return li;
    }

    // Delete a book by its ID
    @RequestMapping(value = "/deletebook/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
    	System.out.println("Delete Book");
        if (bookservice.deleteBook(id))
            return new ResponseEntity<>("Book is deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>("Book is not deleted", HttpStatus.OK);
    }

    // Update a book by its ID
    @RequestMapping(value = "/updatebook/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateBook(@PathVariable("id") int id, @RequestBody Book book) {
        System.out.println("Update Book");
        bookservice.updateBook(book);
        return new ResponseEntity<>("Book is updated successfully", HttpStatus.OK);
    }

    // Create a new book
    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public ResponseEntity<Object> createBook(@RequestBody Book book) {
    	System.out.println("Add Book");
    	bookservice.addBook(book);
        return new ResponseEntity<>("Book is created successfully", HttpStatus.CREATED);
    }
	
}
