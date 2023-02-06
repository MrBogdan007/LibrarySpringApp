package library.author;

public class Author {
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
