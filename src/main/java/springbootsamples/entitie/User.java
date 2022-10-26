package springbootsamples.entitie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	private String firstname;
	@Column
	private String lasttname;
	@Column
	private String email;
	@Column
	private String role;
	@Column
	private String ssn;

	// setters & getters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLasttname() {
		return lasttname;
	}

	public void setLasttname(String lasttname) {
		this.lasttname = lasttname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	// ToString
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lasttname=" + lasttname + ", email=" + email
				+ ", role=" + role + ", ssn=" + ssn + "]";
	}

	// No field constructor
	public User() {

	}

	// Fields constructor
	public User(long id, String firstname, String lasttname, String email, String role, String ssn) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lasttname = lasttname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

}
