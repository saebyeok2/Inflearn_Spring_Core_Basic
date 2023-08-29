package project.core;

import project.core.member.Grade;
import project.core.member.Member;
import project.core.member.MemberService;
import project.core.member.MemberServiceImpl;
import project.core.order.Order;
import project.core.order.OrderService;
import project.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
