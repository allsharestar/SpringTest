package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		
		// g1, g2는 같은 객체다.
		// g1, g2객체 만들 때 ctx.getBean 메서드는 같은 객체를 리턴했기 때문이다.
		// 별도 설정을 하지 않을 경우 스프링은 한 개의 빈 객체만을 생성하며, 이때 빈 객체는 '승글통 범위를 갖는다'라고 표현한다.
		System.out.println("(g1==g2) = " + (g1 == g2));
		ctx.close();
	}
}
