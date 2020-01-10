package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;

import aspect.CacheAspect;
import aspect.ExeTimeAspect;
import chap07.Calculator;
import chap07.RecCalculator;
import spring.MemberDao;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberSummaryPrinter;
import spring.VersionPrinter;

@Configuration
@ComponentScan(basePackages = {"spring"},
excludeFilters = @Filter(type = FilterType.REGEX, pattern = "spring\\..*Dao"))
@EnableAspectJAutoProxy // Aspect�ֳ����̼��� ���� Ŭ������ ���� ������� �����Ϸ��� �ٿ����ϴ� �ֳ����̼�
// @EnableAspectJAutoProxy�ֳ����̼��� ���̸� @Aspect�ֳ����̼��� ���� �� ��ü�� ã�Ƽ� �� ��ü��
// Pointcut ������ @Around ������ ����Ѵ�.
public class AppCtx {
	// Component�ֳ����̼��� �̿��ؼ� MemberDaoŬ���� ���� ������ ����ߴ�.
	// �׷��� ��ĵ��󿡼� @Filter �ֳ����̼ǿ��� type �Ӽ������� REGEX�� �־���.
	// �̴� ����ǥ������ ����ؼ� ���� �Ӵ���� �����Ѵٴ� ���� �ǹ��Ѵ�.
	// pattern �Ӽ��� FilterType�� ������ ���� �����Ѵ�. �� ������ "spring."���� �����ϰ� Dao�� ������ ����ǥ������ ����
	// spring.MemberDao Ŭ������ ������Ʈ ��ĵ ��󿡼� �����Ѵ�.
	
	// MemberDao�� @Component �ֳ����̼��� �ٿ��������� Filter�� ���ܽ��Ѽ� �ٽõ�Ͻ�Ŵ
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1() {
		return new MemberPrinter();
	}
	@Bean
	@Qualifier("summaryPrinter")
	public MemberSummaryPrinter memberPrinter2() {
		return new MemberSummaryPrinter();
	}
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
	@Bean
	public CacheAspect CacheAspect() {
		return new CacheAspect();
	}
	@Bean
	public ExeTimeAspect exeTimeAspect() {
		return new ExeTimeAspect();
	}
	
	/*
	 * �������� AOP�� ���� ���Ͻ� ��ü�� ������ �� ���� ������ �� ��ü�� �������̽��� ��ӹ޾�����
	 * �������̽��� �̿��ؼ� ���Ͻø� �����Ѵ�. ���� Ÿ���� RecCalculator��� �ص�
	 * calculator �̸��� �ش��ϴ� �� ��ü�� Ÿ���� Calculator �������̽��� ��ӹ��� ���Ͻ� Ÿ���� �ȴ�.
	 * @EnableAspectJAutoProy�� proxyTargetClass�Ӽ����� true�� �ϸ�
	 * �������̽����ƴ� �ڹ� Ŭ����(RecCalculator)�� ��ӹ޾� ���Ͻø� �����Ѵ�.
	 */
	@Bean Calculator calculator() {
		return new RecCalculator();
	}
}
