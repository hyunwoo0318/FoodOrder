package hyunwoo.FoodService;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.domain.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class WebController {

    MemberRepository memberRepository = new MemberRepository();

    @GetMapping("/loginHome")
    public String loginHome(){
        return "loginHome";
    }

    @GetMapping("/makeOrder")
    public String storeList(){
        return "order/storeList";
    }

    @GetMapping("/myPastOrder")
    public String orderList(){
        return "info/orderList";
    }

}
