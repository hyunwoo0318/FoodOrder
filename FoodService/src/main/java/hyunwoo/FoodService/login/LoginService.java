package hyunwoo.FoodService.login;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.domain.MemoryMemberRepository;

import javax.servlet.http.HttpServletRequest;

public class LoginService {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    //로그인 서비스
    //return null이면 로그인실패
    public Member login(String inputLoginId, String inputPassword) {
        return memoryMemberRepository.findByLoginId(inputLoginId)
                .filter(m->m.getPassword().equals(inputPassword))
                .orElse(null);
    }

    //로그인중인 회원을 찾기.
    public Member findLoginMember(HttpServletRequest request){
        Member loginMember = (Member)request.getSession().getAttribute(LoginConst.LOGIN_MEMBER);
        if (loginMember == null) {
            throw new RuntimeException("로그인이 만료되었습니다.");
        }
        return loginMember;
    }
}
