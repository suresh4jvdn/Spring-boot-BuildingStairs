package springbootsamples.entitie;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="username",length=50,nullable = false,unique = true)
	private String username;
	

	@Column(name="firstname",length=50,nullable = false)
	private String firstname;
	
	@Column(name="lasttname",length=50,nullable = false)
	private String lasttname;
	
	@Column(name="email",length=50,nullable = false)
	private String email;
	
	@Column(name="role",length=50,nullable = false)
	private String role;
	
	@Column(name="ssn",length=50,nullable = false,unique = true)
	private String ssn;

	// setters & getters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "User [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lasttname=" + lasttname
				+ ", email=" + email + ", role=" + role + ", ssn=" + ssn + "]";
	}
   
	
	// No field constructor
		public User() {

		} 
		
	// Fields constructor
	public User(long id, String username, String firstname, String lasttname, String email, String role, String ssn) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lasttname = lasttname;
		this.email = email;
		this.role = role;
		this.ssn = ssn;
	}

	
	
	

}
