package chap02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration �ֳ����̼��� �ش� Ŭ������ ������ ���� Ŭ������ �����Ѵ�.
@Configuration
public class AppContext {
	// �������� ��ü�� �����ϰ� �ʱ�ȭ�ϴ� ����� �����ϴµ�,
	// �������� �����ϴ� ��ü�� ��(Bean) ��ü��� �θ���.
	// ���� �޼���� �� ���� ��ü�� �����ϰ� �ʱ�ȭ�ϴ� ������ ����ִ�.
	// ��(Bean) �ֳ����̼��� ���̸� �ش� �޼��尡 ������ ��ü�� �������� �����ϴ� �� ��ü�� ����Ѵ�.
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, �ȳ��ϼ���!");
		return g;
	}
}
