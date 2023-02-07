package library.author;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Author {
	@Id
	@GeneratedValue
	@Column(name = "auth_id")
	private Integer id;
	private String name;
	private String born;

	public Author(String name) {
		this.name = name;
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
