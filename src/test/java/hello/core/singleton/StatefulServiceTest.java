package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //Thread A: A사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //Thread B: B사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //Thread A: 사용자A 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price= " + userAPrice);
        System.out.println("price= " + userBPrice);

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }

}