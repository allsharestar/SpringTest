package aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
//@Order(2) // Aspect���� ���ڰ� �������� �����Ѵ�.
public class CacheAspect {
	private Map<Long, Object> cache = new HashMap<Long, Object>();
	
	// Pointcut�� execution()�� ���� �����Ҽ��� �ִ�. @Around("execution(public * chap07..*(..))")
	// ���� ��Ű���� �ִ� ExeTimeAspectŬ������ publicTarget�� Pointcut���, �ٸ���Ű���� ��� ��Ű��.Ŭ����.�޼���()
	@Around("CommonPointcut.publicTarget()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		Long num = (Long)joinPoint.getArgs()[0];
		if(cache.containsKey(num)) {
			long end = System.nanoTime();
			System.out.printf("CacheAspect: Cache���� ����[%d] ���� �ð� : %dns\n", num, (end-start));
			return cache.get(num);
		}
		
		Object result = joinPoint.proceed();
		cache.put(num, result);
		long end = System.nanoTime();
		System.out.printf("CacheAspect: Cache�� �߰�[%d] ���� �ð� : %dns\n", num, (end-start));
		return result;
	}
}
