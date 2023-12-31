package project.core.discount;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import project.core.member.Grade;
import project.core.member.Member;

@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        else {
            return 0;
        }
    }
}
