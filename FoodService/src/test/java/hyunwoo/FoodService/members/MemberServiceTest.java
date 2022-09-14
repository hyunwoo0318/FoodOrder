package hyunwoo.FoodService.members;

import hyunwoo.FoodService.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService =new MemberService();

    static class testMember{
        public static final String loginId="whskwock";
        public static final String password="gusdn123123";
        public static final String name="임현우";
        public static final String phoneNumber="01085865098";
    }

    @Test
    public void testNormal(){
        Member member = new Member();
        member.setPassword(testMember.password);
        member.setPhoneNumber(testMember.phoneNumber);
        member.setName(testMember.name);
        member.setLoginId(testMember.loginId);

        List<String> errors = memberService.validateMemberAdd(member);
        assertThat(errors).isEmpty();
    }

}