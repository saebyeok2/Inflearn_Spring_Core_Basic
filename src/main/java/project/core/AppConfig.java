package project.core;

import project.core.discount.DiscountPolicy;
import project.core.discount.FixDiscountPolicy;
import project.core.member.MemberService;
import project.core.member.MemberServiceImpl;
import project.core.member.MemoryMemberRepository;
import project.core.order.OrderService;
import project.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
