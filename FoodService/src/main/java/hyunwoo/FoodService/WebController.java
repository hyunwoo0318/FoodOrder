package hyunwoo.FoodService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/members/add")
    public String createMember() {
        return "members/add";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
