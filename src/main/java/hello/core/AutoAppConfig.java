package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // @Componenet가 붙어있는 것들을 Bean으로 등록해준다
        basePackages = "hello.core.member", // 탐색할 패키지의 위치를 지정해준다 이 패키지를 포함한 하위 패키지를 탐색한다
        basePackageClasses = AutoAppConfig.class, // 해당 클래스가 속한 패키지를 탐색 시작 위치로 설정한다
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // @Configuration은 Bean 등록 제외 (@Configuration 소스코드에 @Componenet 붙어있음)

//basePackage 지정하지 않으면 ComponentScan 설정 파일이 속한 패키지를 탐색 시작 위치로 설정한다
//프로젝트 시작 루트에 ComponentScan 파일을 두고 basePackage를 따로 설정하지 않는 방법을 권장
//+) SpringBootApplication에 ComponentScan 붙어있기 때문에 어차피 프로젝트 루트에 있으면 bean으로 등록된다
public class AutoAppConfig {

}
