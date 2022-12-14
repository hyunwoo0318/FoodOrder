package hyunwoo.FoodService.login;

import hyunwoo.FoodService.domain.LoginForm;
import hyunwoo.FoodService.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class LoginController {

    LoginService loginService = new LoginService();

    @GetMapping("/login")
    public String getLogin(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Validated @ModelAttribute LoginForm loginForm, BindingResult bindingResult,
                            @RequestParam(defaultValue = "/loginHome") String redirectURL, HttpServletRequest request) {
        Member findMember = loginService.login(loginForm.getLoginId(), loginForm.getPassword());

        if (findMember == null) {
            return "login";
        }

        //오류가 있는 경우
        if (bindingResult.hasErrors()) {
            log.info("bindingError={}", bindingResult.getAllErrors());
            return "login";
        }

        //로그인에 성공한경우
        HttpSession session = request.getSession();
        session.setAttribute(LoginConst.LOGIN_MEMBER, findMember);

        return "redirect:" + redirectURL;
    }

    @GetMapping("/loginHome")
    public String loginHome() {
        return "loginHome";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session!= null)
            session.invalidate();

        return "redirect:/";
    }
}
