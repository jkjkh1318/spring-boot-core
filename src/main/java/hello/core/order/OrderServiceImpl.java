package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor // final이 붙은 필수 값 들의(RequiredArgs) 생성자(Constructor)를 자동으로 만들어준다
public class OrderServiceImpl implements OrderService {

    // DIP(Dependency Inversion Principle, 의존성 역전 원칙) 위반
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // DIP & OCP (Open-Closed Principle, 개발-폐쇄 원칙) 위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

//    private MemberRepository memberRepository;
//    private DiscountPolicy discountPolicy;
//
//    //setter는 권장되지 않는 방식
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

    //DIP 준수 (인터페이스에만 의존)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자 주입 (생성자 호출시점에 딱 1번만 호출되며 불변, 필수-final-객체에 사용)
    //생성자가 딱 한 개만 있다면 @Autowired 생략 가능
    //의존성 주입에서 권장되는 방식
    //DIP, OCP 준수-생성자를 호출 시 원하는 구현체 선택해서 넣어줄 수 있음 :)
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy rateDiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy;
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
