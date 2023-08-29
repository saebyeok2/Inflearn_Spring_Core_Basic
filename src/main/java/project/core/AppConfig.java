package project.core;

import project.core.discount.FixDiscountPolicy;
import project.core.member.MemberService;
import project.core.member.MemberServiceImpl;
import project.core.member.MemoryMemberRepository;
import project.core.order.OrderService;
import project.core.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
