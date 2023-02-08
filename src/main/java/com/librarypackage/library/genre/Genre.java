package com.librarypackage.library.genre;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "genre")
@Table(name = "genre")
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@UuidGenerator
	private UUID id;
	@Column(nullable = false, unique = true, name = "genre_name")
	private String name;

	public Genre() {

	}

	public Genre(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
