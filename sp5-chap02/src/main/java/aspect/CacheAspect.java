package aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
//@Order(2) // Aspect순서 숫자가 낮을수록 먼저한다.
public class CacheAspect {
	private Map<Long, Object> cache = new HashMap<Long, Object>();
	
	// Pointcut을 execution()에 직접 지정할수도 있다. @Around("execution(public * chap07..*(..))")
	// 같은 패키지에 있는 ExeTimeAspect클래스의 publicTarget의 Pointcut사용, 다른패키지의 경우 패키지.클래스.메서드()
	@Around("CommonPointcut.publicTarget()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		Long num = (Long)joinPoint.getArgs()[0];
		if(cache.containsKey(num)) {
			long end = System.nanoTime();
			System.out.printf("CacheAspect: Cache에서 구함[%d] 실행 시간 : %dns\n", num, (end-start));
			return cache.get(num);
		}
		
		Object result = joinPoint.proceed();
		cache.put(num, result);
		long end = System.nanoTime();
		System.out.printf("CacheAspect: Cache에 추가[%d] 실행 시간 : %dns\n", num, (end-start));
		return result;
	}
}
