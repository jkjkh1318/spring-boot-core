package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.*;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member member = new Member(1L, "jinkyoung", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "ra-myeon", 20000);

        System.out.println(order.getDiscountPrice());

    }

}
