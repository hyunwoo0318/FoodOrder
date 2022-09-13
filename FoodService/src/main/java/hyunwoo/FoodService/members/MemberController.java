package hyunwoo.FoodService.members;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.domain.MemoryMemberRepository;
import hyunwoo.FoodService.domain.OrderRecord;
import hyunwoo.FoodService.login.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
//회원가입을 위한 컨트롤러
public class MemberController {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberService();

    //회원가입화면
    @GetMapping("/members/add")
    public String getAdd(Model model) {
        model.addAttribute("member", new Member());
        return "members/add";
    }

    @PostMapping("/members/add")
    public String postAdd(@Validated @ModelAttribute Member member, BindingResult bindingResult){

        if(!bindingResult.hasErrors())
        {
            List<String> errors = memberService.validateMemberAdd(member);

            for (String error : errors) {
                bindingResult.reject(error);
            }
        }


        //회원가입에 오류가 발생한경우
        if (bindingResult.hasErrors()) {
            log.info("bindingErrors={}", bindingResult.getAllErrors());
            return "members/add";
        }

        //TODO :오류 메세지를 보여주는 타임리프 수정

        memoryMemberRepository.newMember(member);
        return "redirect:/";
    }

    //자신의 주문목록 확인하는 화면
    @GetMapping("/mypastorder")
    public String orderList(Model model,HttpServletRequest request){
        Member loginMember = memberService.findLoginMember(request);
        List<OrderRecord> loginMemberOrderRecord = loginMember.getOrderRecord();
        model.addAttribute("orderList", loginMemberOrderRecord);

        log.info("orderRecord={}" , loginMemberOrderRecord);

        return "info/orderList";
    }
}
