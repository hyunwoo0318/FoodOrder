package hyunwoo.FoodService.members;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.login.LoginConst;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class MemberService {

    public Member findLoginMember(HttpServletRequest request){
        return (Member) request.getSession().getAttribute(LoginConst.LOGIN_MEMBER);
    }
}
