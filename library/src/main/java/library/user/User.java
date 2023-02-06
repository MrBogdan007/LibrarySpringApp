package library.user;

public class User {
	enum Role {
		librarian, visitor,
	}

	public static Role librarian = Role.librarian;
	public Role customer = Role.visitor;

	public Role getLibrarian() {
		return librarian;
	}

	public void setLibrarian(Role librarian) {
		this.librarian = librarian;
	}

	public Role getCustomer() {
		return customer;
	}

	public void setCustomer(Role customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return librarian + "" + customer;
	}
}
