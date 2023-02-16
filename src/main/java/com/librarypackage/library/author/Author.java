package com.librarypackage.library.author;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@UuidGenerator
	@Column(name = "auth_id")
	private UUID id;
	private String name;
	private String born;

	//@ManyToOne
	//@JoinColumn(name = "author_id")
	//private BookBean book;
	public Author() {

	}

	public Author(UUID id, String name, String born) {
		super();
		this.id = id;
		this.name = name;
		this.born = born;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name + "";
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
