package dto;
//JDBC -- MYBATIS
public class MemberDTO {
	String id; // varchar(30) 
	int password;// int 
	String name;// varchar(30) 
	String phone; //char(13) 
	String email; // varchar(30) 
	String regdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return id + " 회원님의 이름은 " + name + " , 폰번호는 " + phone + " , 이메일은 " + email
			+ " , 가입일은 " + regdate + " 입니다.";	
	}

	
	
}
