package chap02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		// AnnotationConfigApplicationContext Ŭ������ �ڹ� �������� ������ �о�� �� ��ü�� �����ϰ� �����Ѵ�.
		// AppContext Ŭ������ ������ �Ķ���ͷ� �����Ѵ�. AppContext�� ������ @Bean ���� ������ �о�� Greeter ��ü�� �����ϰ� �����Ѵ�.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		// getBean�� ctx�� �ڹ� ������ �о�� ������ ��(bean) ��ü�� �˻��� �� ���ȴ�.
		// ù ��° �Ķ���ʹ� @Bean �ֳ����̼��� �޼��� �̸��� �� ��ü�� �̸��̸�, �� ��° �Ķ���ʹ� �˻��� ��ü�� Ÿ���̴�.
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("������");
		System.out.println(msg);
		ctx.close();
		
		
	}
}
