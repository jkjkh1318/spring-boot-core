package hello.core.member;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryMemberRepository implements MemberRepository{ //sql mapper (service-DB 중간)

    //실무에서는 동시성 이슈 때문에 conqurerHashMap? 을 사용해야 한다
    private static Map<Long, Member> store = new HashMap<>(); //DB 역할인듯

    //오류 처리는 생략 ..
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
