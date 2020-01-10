package chap07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppCtx.class);
		
		// "calculator 프록시의 실제 타입을 RecCalculator를 상속받았으므로 RecCalculator로 타입 변환 가능
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		cal.factorial(700);
		cal.factorial(700);
		cal.factorial(500);
		cal.factorial(500);
		ctx.close();
		
	}
}