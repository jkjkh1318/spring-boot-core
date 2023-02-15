package hello.core.member;

import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // DIP(Dependency Inversion Principle, 의존성 역전 원칙) 위반
    // OCP (Open-Closed Principle, 개발-폐쇄 원칙) 위반 가능
//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // DIP 준수
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
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
