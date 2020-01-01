package spring;

public class ChangePasswordService {
	// ��й�ȣ�� �����ϴ� Ŭ����
	private MemberDao memberDao;
	
	// MemberDao �������� setter�� ���� ���Թ޴´�.
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}	
	public void ChangePasswordService(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null)
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}
}
