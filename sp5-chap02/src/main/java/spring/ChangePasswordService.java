package spring;

public class ChangePasswordService {
	// 비밀번호를 변경하는 클래스
	private MemberDao memberDao;
	
	// MemberDao 의존주입 setter를 통해 주입받는다.
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
