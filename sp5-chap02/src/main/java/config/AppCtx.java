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
//@EnableAspectJAutoProxy // Aspect애노테이션을 붙이 클래스를 공통 기능으로 적용하려면 붙여야하는 애노테이션
// @EnableAspectJAutoProxy애노테이션을 붙이면 @Aspect애노테이션이 붙은 빈 객체를 찾아서 빈 객체의
// Pointcut 설정과 @Around 설정을 사용한다.
public class AppCtx {
	// Component애노테이션을 이용해서 MemberDao클래스 등을 빈으로 등록했다.
	// 그런데 스캔대상에서 @Filter 애노테이션에서 type 속성값으로 REGEX를 주었다.
	// 이는 정규표현식을 사용해서 제오 ㅣ대상을 지정한다는 것을 의미한다.
	// pattern 속성은 FilterType에 적용할 값을 설정한다. 위 설정은 "spring."으로 시작하고 Dao로 끝나는 정규표현식을 지정
	// spring.MemberDao 클래스를 컴포넌트 스캔 대상에서 제외한다.
	
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
		// 스프링이 제공하는 트랜잭션 매니저 인터페이스
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	// MemberDao는 @Component 애노테이션이 붙여져있지만 Filter로 제외시켜서 다시등록시킴
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
	 * 스프링은 AOP를 위한 프록시 객체를 생서할 때 실제 생성할 빈 객체가 인터페이스를 상속받았으면
	 * 인터페이스를 이용해서 프록시를 생성한다. 실제 타입이 RecCalculator라고 해도
	 * calculator 이름에 해당하는 빈 객체의 타입은 Calculator 인터페이스를 상속받은 프록시 타입이 된다.
	 * @EnableAspectJAutoProy의 proxyTargetClass속성값을 true로 하면
	 * 인터페이스가아닌 자바 클래스(RecCalculator)를 상속받아 프록시를 생성한다.
	 */
	@Bean Calculator calculator() {
		return new RecCalculator();
	}
}
