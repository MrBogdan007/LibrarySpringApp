package com.librarypackage.library.book;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Random;

import com.librarypackage.library.genre.Genre;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "book")
public class BookBean implements Serializable {
	@Id
	@Column(nullable = false, length = 50, name = "ISBN")
	private String ISBN = generateISBN();

	@Column(nullable = false, unique = true)
	private String name;
//	private String ISBN;
//	@OneToOne(cascade = CascadeType.ALL)
//	private Author author;
	// not mandatory properties
//	private int noOfCopies;
	@ManyToOne(optional = false)
	@JoinColumn(name = "genre_id", nullable = false)
	private Genre genre;

	public BookBean() {

	}

	public BookBean(String id, String name, Genre genre) {
		super();
		this.ISBN = id;
		this.genre = genre;
		this.name = name;

//		this.author = author;
//		this.ISBN = ISBN;

	}

	public void setIsbn(String id) {
		this.ISBN = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsbn() {
		return ISBN;
	}

	public String getName() {
		return name;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	private static String generateISBN() {
		BigInteger b = new BigInteger(34, new Random());
		String s = toString(b);
		String[] arrOfStr = s.split("");
		arrOfStr[2] += "-";
		arrOfStr[4] += "-";
		arrOfStr[7] += "-";
		String ISBN = String.join("", arrOfStr);
		return "978-" + ISBN;
	}

	@Override
	public String toString() {
		return name + "";

	}

	private static String toString(BigInteger b) {
		return b.toString();
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

}