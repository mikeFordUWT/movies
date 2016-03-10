package data;

public class User {
	private String userID;
	private String firstName;
	private String lastName;
	private String eMail;

	public User(String id, String first, String last, String mail) {
		userID = id;
		firstName = first;
		lastName = last;
		eMail = mail;
	}

	public String getID(){
		return userID;
	}

	public String getFirstName(){
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEMail(){
		return eMail;
	}
}
