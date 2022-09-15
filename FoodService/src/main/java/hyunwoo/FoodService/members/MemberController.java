package hyunwoo.FoodService.members;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.domain.MemberClass;
import hyunwoo.FoodService.domain.MemoryMemberRepository;
import hyunwoo.FoodService.domain.OrderRecord;
import hyunwoo.FoodService.login.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
//회원가입을 위한 컨트롤러
public class MemberController {

    //TODO:회원가입시 입력 조건을 보여주게 html파일 수정

    @ModelAttribute("memberClasses")
    public MemberClass[] setMemberClasses(){
        return MemberClass.values();
    }


    private final MemberValidator memberValidator = new MemberValidator();
    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(memberValidator);

    }

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

        //회원가입에 오류가 발생한경우
        if (bindingResult.hasErrors()) {
            log.info("bindingErrors={}", bindingResult.getAllErrors());
            return "members/add";
        }

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
