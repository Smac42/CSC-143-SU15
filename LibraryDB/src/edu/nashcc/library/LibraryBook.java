package edu.nashcc.library;

public class LibraryBook {
	// needs to accept book title, author, year, genre, record number/ISBN
	private String bookTitle, author, genre, ISBN;
	private int year;
	
	public LibraryBook(String bookTitle, String author, String genre,
			String iSBN, int year) {
		this.bookTitle = bookTitle;
		this.author = author;
		this.genre = genre;
		this.ISBN = iSBN;
		this.year = year;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
