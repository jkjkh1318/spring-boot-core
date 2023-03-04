package hello.core.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    @Test
    void createOrder(){
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        orderService.createOrder(1L, "itemA", 10000);

        //Error
        //@Bean은 singleton이기 때문에 OrderServiceImpl 객체가 이미 생성되어서 생성자 불일치 오류나는 듯!
//        java: constructor OrderServiceImpl in class hello.core.order.OrderServiceImpl cannot be applied to given types;
//        required: no arguments
//        found: hello.core.member.MemberRepository,hello.core.discount.DiscountPolicy
//        reason: actual and formal argument lists differ in length
//        return new OrderServiceImpl(memberRepository(), discountPolicy());

    }

}