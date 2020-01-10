package chap07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppCtx.class);
		
		// "calculator ���Ͻ��� ���� Ÿ���� RecCalculator�� ��ӹ޾����Ƿ� RecCalculator�� Ÿ�� ��ȯ ����
		Calculator cal = ctx.getBean("calculator", Calculator.class);
		cal.factorial(700);
		cal.factorial(700);
		cal.factorial(500);
		cal.factorial(500);
		ctx.close();
		
	}
}