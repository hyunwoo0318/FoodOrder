package hyunwoo.FoodService.login;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.domain.MemberRepository;

public class LoginService {

    MemberRepository memberRepository = new MemberRepository();

    //로그인 서비스
    //return null이면 로그인실패
    public Member login(String inputLoginId, String inputPassword) {
        return memberRepository.findByLoginId(inputLoginId)
                .filter(m->m.getPassword().equals(inputPassword))
                .orElse(null);
    }
}
