package springbootsamples.ExceptionHandling;

public class UserExistsException extends Exception{

	
	private static final long serialVersionUID = -6319400394725794839L;

	public UserExistsException(String message) {
		super(message);
		
	}
	
	

}
