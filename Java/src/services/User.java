package CaseStudy;

public class User {
	
	String userId;
	String firstName;
	String lastName;
	String email;
	String password;
	String userStatusId;
	String locationId;
	public User() {
		super();
	}

	public User(String userId, String firstName, String lastName, String email, String password, String userStatusId,
			String locationId) throws IdException{
		super();
        if(userId.length() < 7)
	           throw new IdException("Id can't be less than 7 characters");

		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userStatusId = userStatusId;
		this.locationId = locationId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) throws IdException{
        if(userId.length() < 7)
	           throw new IdException("Id can't be less than 7 characters");
        
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserStatusId() {
		return userStatusId;
	}
	public void setUserStatusId(String userStatusId) throws IdException{
        if(userStatusId.length() < 7)
	           throw new IdException("Id can't be less than 7 characters");
		this.userStatusId = userStatusId;
	}
	public String getLocationId(){
		return locationId;
	}
	public void setLocationId(String locationId) throws IdException{
        if(locationId.length() < 7)
	           throw new IdException("Id can't be less than 7 characters");
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password
				+ ", userStatusId=" + userStatusId + ", locationId=" + locationId + "]";
	}
	
}
