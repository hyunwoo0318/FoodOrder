package hyunwoo.FoodService.members;

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
//회원가입을 위한 컨트롤러
public class MemberController {

    MemberRepository memberRepository = new MemberRepository();

    //회원가입화면
    @GetMapping("/members/add")
    public String getAdd(Model model) {
        model.addAttribute("member", new Member());
        return "members/add";
    }

    @PostMapping("/members/add")
    public String postAdd(@ModelAttribute Member member){
        memberRepository.newMember(member);
        return "redirect:/";
    }
}
