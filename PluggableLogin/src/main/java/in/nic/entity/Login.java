package in.nic.entity;

public class Login {
	
	private String Name;
	private String Password;
	private String userId;
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserID(String userID) {
		this.userId = userID;
	}

	public Login() {}
	
	public Login(String Name, String Password) {
		super();

		this.Name = Name;
		this.Password = Password; 
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}


	
	
}
