package CaseStudy;

public class UserStatus {
	int userStatusId;
	String userStatus;
	
	public UserStatus() {
		super();
	}
	
	public UserStatus(int userStatusId, String userStatus) {
		super();
		this.userStatusId = userStatusId;
		this.userStatus = userStatus;
	}
	
	public int getUserStatusId() {
		return userStatusId;
	}
	public void setUserStatusId(int userStatusId) {
		this.userStatusId = userStatusId;
	}
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	@Override
	public String toString() {
		return "UserStatus [userStatusId=" + userStatusId + ", userStatus=" + userStatus + "]";
	}
}
