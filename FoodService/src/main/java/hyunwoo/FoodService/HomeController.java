package hyunwoo.FoodService;

import hyunwoo.FoodService.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@SessionAttribute(name="loginMember", required = false) Member loginMember, HttpServletRequest request,
                       Model model){

        //로그인 상태가 아닌경우
        if(loginMember ==null)
        {
            return "home";
        }
        //로그인 상태인경우
        else {
            model.addAttribute("member", loginMember);
            return "loginHome";
        }
    }
}
