package com.librarypackage.library.dto;

import java.util.List;
import java.util.UUID;

import com.librarypackage.library.book.BookBean;

public class BookCreationDto extends BookBean {

	private UUID genre_id;
	private List<UUID> auth_id;

	public BookCreationDto() {

	}


	public List<UUID> getAuth_id() {
		return auth_id;
	}


	public void setAuth_id(List<UUID> auth_id) {
		this.auth_id = auth_id;
	}


	public UUID getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(UUID genre_id) {
		this.genre_id = genre_id;
	}

}
