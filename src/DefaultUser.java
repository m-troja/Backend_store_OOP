

public class DefaultUser implements User {



	String firstname;
	String lastname;
	String password;
	String email;
	private int id = 0;
	public DefaultUser() {
	}
	
		
	public DefaultUser(String firstname, String lastname, String password, String email, int id) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.email = email;
		this.id = setID(id);



	}

	private int setID(int id) {
			return id ;
	}





	@Override
	public String getFirstName() {
		this.firstname = firstname;
		return this.firstname;

	}

	@Override
	public String getLastName() {
		this.lastname = lastname;
		return this.lastname;
	}

	@Override
	public String getPassword() {
		this.password = password;
		return this.password;
	}

	@Override
	public String getEmail() {
		this.email = email;
		return this.email;
	}
	@Override
	public String toString() {
		return "First Name: " + this.getFirstName() + "\t\t" +
				"Last Name: " + this.getLastName() + "\t\t" +
				"Email: " + this.getEmail();
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		this.email = email;
	}

	@Override
	public int getId() {
		this.id = id;
		return this.id;
	}
	
	void clearState() {
		// <write your code here>
	}
}
