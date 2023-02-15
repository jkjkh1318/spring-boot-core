package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        //순수 자바 형태로 설정정보 가져오기
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //스프링 활용해 설정정보 가져오기
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //getBean(메서드명, 반환타입)
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member= " + memberA.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
