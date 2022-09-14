package hyunwoo.FoodService.members;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.login.LoginConst;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    public Member findLoginMember(HttpServletRequest request){
        return (Member) request.getSession().getAttribute(LoginConst.LOGIN_MEMBER);
    }
}
