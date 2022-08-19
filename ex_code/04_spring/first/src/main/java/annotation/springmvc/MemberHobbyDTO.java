package annotation.springmvc;

public class MemberHobbyDTO {
String id;
int password, age;
String[] hobby;
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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String[] getHobby() {
	return hobby;
}
public void setHobby(String[] hobby) {
	this.hobby = hobby;
}

}
