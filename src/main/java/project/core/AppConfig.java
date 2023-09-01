package project.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.core.discount.DiscountPolicy;
import project.core.discount.FixDiscountPolicy;
import project.core.discount.RateDiscountPolicy;
import project.core.member.MemberService;
import project.core.member.MemberServiceImpl;
import project.core.member.MemoryMemberRepository;
import project.core.order.OrderService;
import project.core.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
