package spring;

public class RegisterRequest {
	// ȸ�������� ó���� �� �ʿ��� �̸��� ��ȣ �̸������͸� ����ִ� ������ Ŭ������ ����� �ô�.
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
