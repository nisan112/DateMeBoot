package DTO;

public class UserDTO {
	private String firstname;	
	private String lastname;	
	private int age;	
	private String address;	
	private String phone;	
	private String email;	
	private String password;
	
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(String firstname, String lastname, int age, String address, String phone, String email,
			String password) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	@Override
	public String toString() {
		return "UserDTO [firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", password=" + password + "]";
	}
	
	


}
