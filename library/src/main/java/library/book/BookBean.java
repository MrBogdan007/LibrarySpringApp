package library.book;

import library.author.Author;

public class BookBean {

	private String name;
	private String ISBN;
	private Author author;
	// not mandatory properties
	private int noOfCopies = 1;
	private String genre;

	public BookBean(String name, String ISBN, Author author) {
		this.name = name;
		this.author = author;
		this.ISBN = ISBN;

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

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	@Override
	public String toString() {
		return String.format("ISBN - %s, name - %s, author - %s, genre - %s, number of copies - %d", ISBN, name, author,
				genre, noOfCopies);
	}

}
