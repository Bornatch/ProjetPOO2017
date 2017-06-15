package fonctionsSmartphone;

import java.io.Serializable;
import java.util.UUID;

public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private UUID contactID;
	private String lastname;
	private String firstname;
	private String phonenumber;
	
	public Contact(String lastname, String firstname) {
		this.contactID = UUID.randomUUID();
		this.lastname = lastname;
		this.firstname = firstname;
	}
	
	public Contact() {
		
	}
	
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public UUID getContactID() {
		return contactID;
	}

	public void setContactID(UUID contactID) {
		this.contactID = contactID;
	}

	public String toString()
	{
		String toList = this.getLastname() + " " + this.getFirstname();
		return toList;
	}
	
}
