package com.librarypackage.library.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "book")
public class BookBean {
	@Id
	@GeneratedValue
	private long id;

	private String name;
//	private String ISBN;
//	@OneToOne(cascade = CascadeType.ALL)
//	private Author author;
	// not mandatory properties
//	private int noOfCopies;
	private String genre;

	public BookBean() {

	}

	public BookBean(long id, String name, String genre) {
		super();
		this.id = id;
		this.genre = genre;
		this.name = name;

//		this.author = author;
//		this.ISBN = ISBN;

	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

//	public String getISBN() {
//		return ISBN;
//	}
//
//	public int getNoOfCopies() {
//		return noOfCopies;
//	}
//
//	public void setNoOfCopies(int noOfCopies) {
//		this.noOfCopies = noOfCopies;
//	}
//
//	public void setISBN(String iSBN) {
//		ISBN = iSBN;
//	}

	@Override
	public String toString() {
		return String.format("ISBN - %s, name - %s, author - %s, genre - %s, number of copies - %d", name);
	}

}
