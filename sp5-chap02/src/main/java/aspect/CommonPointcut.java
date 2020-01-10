package aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {
	/*
	 * chap07 ��Ű���� �� ���� ��Ű���� ���� �� ��ü�� public �޼��带 �����Ѵ�.
	 * execute����ڴ� Advice�� ������ �޼��带 ������ �� ����Ѵ�.
	 * execute(���ľ�����? ����Ÿ������ Ŭ�����̸�����?�޼����̸�����(�Ķ��������))
	 * �� ������ '*'�� �̿��Ͽ� ��� ���� ǥ��, '..'�� ����Ͽ� 0�� �̻��̶�� �ǹ̸� ǥ���� �� �ִ�.
	 */
	@Pointcut("execution(public * chap07..*(..))")
	public void publicTarget() {}
}
