package member;

public class MemberDTO {
	String id, name, phone, email, regdate;
	int password;
	// <bean id="m" class="member.MemberDTO" scope="" />
	public MemberDTO() {
		System.out.println("MemberDTO 생성자 호출");
	}
	
	public MemberDTO(String id, int password) {
		this.id = id;
		this.password = password;
		System.out.println("MemberDTO 생성자 호출 - " + id + ":" + password);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	
}
