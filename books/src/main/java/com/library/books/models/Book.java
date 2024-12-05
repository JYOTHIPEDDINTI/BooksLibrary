package com.library.books.models;

public class Book {

		private long bookid;
		private String bookname;
		private String bookauthor;
		private String description;
		
		public Book() {
		}

		public long getBookid() {
			return bookid;
		}

		public void setBookid(long bookid) {
			this.bookid = bookid;
		}

		public String getBookname() {
			return bookname;
		}

		public void setBookname(String bookname) {
			this.bookname = bookname;
		}

		public String getBookauthor() {
			return bookauthor;
		}

		public void setBookauthor(String bookauthor) {
			this.bookauthor = bookauthor;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		
		
}
