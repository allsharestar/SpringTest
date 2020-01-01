package spring;

public class RegisterRequest {
	// 회원가입을 처리할 때 필요한 이메일 암호 이름데이터를 담고있는 간단한 클래스로 만들어 봤다.
	private String email;
	private String password;
	private String confirmPassword;
	private String name;
	
	public String getEmail() {
		return email;
	}
	public RegisterRequest setEmail(String email) {
		this.email = email;
		return this;
	}
	public String getPassword() {
		return password;
	}
	public RegisterRequest setPassword(String password) {
		this.password = password;
		return this;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public RegisterRequest setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
		return this;
	}
	public String getName() {
		return name;
	}
	public RegisterRequest setName(String name) {
		this.name = name;
		return this;
	}
	public boolean isPasswordEqualToConfirmPassword() {
		return password.equals(confirmPassword);
	}
}
