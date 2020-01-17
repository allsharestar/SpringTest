package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

public class ChangePasswordService {
	// ��й�ȣ�� �����ϴ� Ŭ����
	
	// �ڵ� ���������� �̿���
	@Autowired
	private MemberDao memberDao;
	
	@Transactional
	public void ChangePasswordService(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		
		if(member == null)
			throw new MemberNotFoundException();
		
		member.changePassword(oldPwd, newPwd);
		
		memberDao.update(member);
	}
}
