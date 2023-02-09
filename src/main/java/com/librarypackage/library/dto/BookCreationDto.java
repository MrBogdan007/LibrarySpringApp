package com.librarypackage.library.dto;

import java.util.UUID;

import com.librarypackage.library.book.BookBean;

public class BookCreationDto extends BookBean {

	private UUID genre_id;
	private String some;

	public BookCreationDto() {

	}

	public UUID getGenre_id() {
		return genre_id;
	}

	public String getSome() {
		return some;
	}

	public void setSome(String some) {
		this.some = some;
	}

	public void setGenre_id(UUID genre_id) {
		this.genre_id = genre_id;
	}

}
