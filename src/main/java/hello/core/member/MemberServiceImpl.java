package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // DIP(Dependency Inversion Principle, 의존성 역전 원칙) 위반
    // OCP (Open-Closed Principle, 개발-폐쇄 원칙) 위반 가능
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // DIP 준수
    private final MemberRepository memberRepository;

    @Autowired //@Component 사용할 경우 거의 필수로 사용
    //MemberRepository 유형을 자동으로 주입해준다
    //ac.getBean(MemberRepository.class)와 같은 역할을 해 준다
    public MemberServiceImpl(MemberRepository memberRepository)  {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        //다형성에 의해서 MemoryMemberRepository 호출
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long MemberId) {
        return memberRepository.findById(MemberId);
    }

    //테스트
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
