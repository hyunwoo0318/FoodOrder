package hyunwoo.FoodService.members;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.domain.MemberClass;
import hyunwoo.FoodService.login.LoginConst;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MemberClassInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession(false);
        Member loginMember = (Member) session.getAttribute(LoginConst.LOGIN_MEMBER);
        if(loginMember.getMemberClass() == MemberClass.OWNER){
            response.sendRedirect(requestURI);
            return false;
        }
        return true;
    }


}
