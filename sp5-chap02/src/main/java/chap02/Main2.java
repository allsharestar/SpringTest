package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		
		// g1, g2�� ���� ��ü��.
		// g1, g2��ü ���� �� ctx.getBean �޼���� ���� ��ü�� �����߱� �����̴�.
		// ���� ������ ���� ���� ��� �������� �� ���� �� ��ü���� �����ϸ�, �̶� �� ��ü�� '�±��� ������ ���´�'��� ǥ���Ѵ�.
		System.out.println("(g1==g2) = " + (g1 == g2));
		ctx.close();
	}
}
