package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public interface DiscountPolicy {

//    public Long getDC(Long price, Grade grade);

    /**
     * @return 할인 대상 금액
     */
    int discount( Member member, int price);

}


