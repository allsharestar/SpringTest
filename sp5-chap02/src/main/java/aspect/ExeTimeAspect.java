package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
//@Order(1)
public class ExeTimeAspect {
	
	// Pointcut���� publicTarget()�޼��带 �����ߴ�
	@Around("CommonPointcut.publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.nanoTime();
			org.aspectj.lang.Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) ���� �ð� : %d ns\n",
					joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(),
					Arrays.toString(joinPoint.getArgs()),
					(finish - start));
		}
	}
}
