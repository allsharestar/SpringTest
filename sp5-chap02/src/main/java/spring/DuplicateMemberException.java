package spring;

public class DuplicateMemberException extends RuntimeException{
	// ������ �̸����� ���� �ִ� ȸ���� �̹� ������ �� �߻���Ŵ
	public DuplicateMemberException(String message) {
		super(message);
	}
}
