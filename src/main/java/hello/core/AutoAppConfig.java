package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // @Configuration 은 빈으로 등록하지 않는다
// @Configuration 소스코드에 @Componenet 등록되어 있음
public class AutoAppConfig {

}
