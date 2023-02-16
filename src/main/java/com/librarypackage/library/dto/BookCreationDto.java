package com.librarypackage.library.dto;

import java.util.UUID;

import com.librarypackage.library.book.BookBean;

public class BookCreationDto extends BookBean {

	private UUID genre_id;
	private UUID author_id;

	public BookCreationDto() {

	}

	public UUID getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(UUID author_id) {
		this.author_id = author_id;
	}

	public UUID getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(UUID genre_id) {
		this.genre_id = genre_id;
	}

}
