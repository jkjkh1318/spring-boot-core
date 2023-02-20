package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {


    // DIP(Dependency Inversion Principle, 의존성 역전 원칙) 위반
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // DIP & OCP (Open-Closed Principle, 개발-폐쇄 원칙) 위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    //DIP 준수 (인터페이스에만 의존 중)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
