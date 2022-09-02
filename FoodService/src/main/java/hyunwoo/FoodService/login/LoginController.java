package hyunwoo.FoodService.login;

import hyunwoo.FoodService.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
public class LoginController {

    LoginService loginService = new LoginService();

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("member", new Member());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute Member member)
    {
        Member findMember = loginService.login(member.getLoginId(), member.getPassword());
        //로그인에 실패한경우
        if(findMember == null)
            return "login";

        //로그인에 성공한경우
        return "loginHome";
    }
}