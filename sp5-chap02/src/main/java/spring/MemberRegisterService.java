package spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class MemberRegisterService {
	// 회원등록하는 클래스를 만들어봄
	
	@Autowired
	private MemberDao memberDao;
	
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		
		if(member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), LocalDateTime.now());
		
		memberDao.insert(newMember);
		return newMember.getId();
	}
}
