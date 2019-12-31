package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration 애노테이션은 해당 클래스를 스프링 설정 클래스로 지정한다.
@Configuration
public class AppContext {
	// 스프링은 객체를 생성하고 초기화하는 기능을 제공하는데,
	// 스프링이 생성하는 객체를 빈(Bean) 객체라고 부른다.
	// 밑의 메서드는 한 개의 객체를 생성하고 초기화하는 설정을 담고있다.
	// 빈(Bean) 애노테이션을 붙이면 해당 메서드가 생성한 객체를 스프링이 관리하는 빈 객체로 등록한다.
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!");
		return g;
	}
}
