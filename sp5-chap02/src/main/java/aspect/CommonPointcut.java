package aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {
	/*
	 * chap07 패키지나 그 하위 패키지에 속한 빈 객체의 public 메서드를 설정한다.
	 * execute명시자는 Advice를 적용할 메서드를 지정할 때 사용한다.
	 * execute(수식어패턴? 리턴타입패턴 클래스이름패턴?메서드이름패턴(파라미터패턴))
	 * 각 패턴은 '*'를 이용하여 모든 값을 표현, '..'을 사용하여 0개 이상이라는 의미를 표현할 수 있다.
	 */
	@Pointcut("execution(public * chap07..*(..))")
	public void publicTarget() {}
}
