package project.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import project.core.discount.DiscountPolicy;
import project.core.discount.FixDiscountPolicy;
import project.core.discount.RateDiscountPolicy;
import project.core.member.Member;
import project.core.member.MemberRepository;
import project.core.member.MemoryMemberRepository;

@Component
// final 인스턴스 변수를 받는 생성자를 자동으로 생성
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
