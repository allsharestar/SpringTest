package spring;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

public class MemberPrinter {
	private DateTimeFormatter dateTimeFormatter;
	
	public MemberPrinter() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	}
	
	public void print(Member member) {
		if(dateTimeFormatter == null) {
			System.out.printf("아이디 : %d, 이메일 : %s, 이름 : %s, 등록일 : %tF\n",
					member.getId(), member.getEmail(), member.getName(), member.getRegisterDateTime());
		} else {
			System.out.printf("아이디 : %d, 이메일 : %s, 이름 : %s, 등록일 : %s\n",
					member.getId(), member.getEmail(), member.getName(), dateTimeFormatter.format(member.getRegisterDateTime()));
		}
	}
	// Nullable애노테이션을 사용해도 된다. 자동 주입할 빈이 존재하면 인자로 전달
	@Autowired
	public void setDateFormatter(@Nullable DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
	}
//	@Autowired // 스프링5부터는 required대신에 자바8 Optional을 사용해도 된다.
//	public void setDateFormatter(Optional<DateTimeFormatter> formatterOpt) {
//		if(formatterOpt.isPresent()) {
//			this.dateTimeFormatter = formatterOpt.get();
//		} else {
//			this.dateTimeFormatter = null;
//		}
//	}
}
