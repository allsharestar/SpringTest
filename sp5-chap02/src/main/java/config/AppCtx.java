package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import aspect.CacheAspect;
import aspect.ExeTimeAspect;
import chap07.Calculator;
import chap07.RecCalculator;
import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration
@EnableTransactionManagement
//@ComponentScan(basePackages = {"spring"},
//excludeFilters = @Filter(type = FilterType.REGEX, pattern = "spring\\..*Dao"))
//@EnableAspectJAutoProxy // Aspect�ֳ����̼��� ���� Ŭ������ ���� ������� �����Ϸ��� �ٿ����ϴ� �ֳ����̼�
// @EnableAspectJAutoProxy�ֳ����̼��� ���̸� @Aspect�ֳ����̼��� ���� �� ��ü�� ã�Ƽ� �� ��ü��
// Pointcut ������ @Around ������ ����Ѵ�.
public class AppCtx {
	// Component�ֳ����̼��� �̿��ؼ� MemberDaoŬ���� ���� ������ ����ߴ�.
	// �׷��� ��ĵ��󿡼� @Filter �ֳ����̼ǿ��� type �Ӽ������� REGEX�� �־���.
	// �̴� ����ǥ������ ����ؼ� ���� �Ӵ���� �����Ѵٴ� ���� �ǹ��Ѵ�.
	// pattern �Ӽ��� FilterType�� ������ ���� �����Ѵ�. �� ������ "spring."���� �����ϰ� Dao�� ������ ����ǥ������ ����
	// spring.MemberDao Ŭ������ ������Ʈ ��ĵ ��󿡼� �����Ѵ�.
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
	@Bean
	public PlatformTransactionManager transactionManager() {
		// �������� �����ϴ� Ʈ����� �Ŵ��� �������̽�
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	// MemberDao�� @Component �ֳ����̼��� �ٿ��������� Filter�� ���ܽ��Ѽ� �ٽõ�Ͻ�Ŵ
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		return pwdSvc;
	}
	@Bean
	public MemberPrinter memberPrinter() {
		return new MemberPrinter();
	}
	@Bean
	public MemberListPrinter listPrinter() {
		return new MemberListPrinter();
	}
	@Bean
	public MemberInfoPrinter infoPrinter() {
		return new MemberInfoPrinter();
	}
	@Bean
	public VersionPrinter versionPrinter() {
		VersionPrinter versionPrinter = new VersionPrinter();
		versionPrinter.setMajorVersion(5);
		versionPrinter.setMinorVersion(0);
		return versionPrinter;
	}
	@Bean
	public MemberRegisterService MemberRegisterService() {
		return new MemberRegisterService();
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
