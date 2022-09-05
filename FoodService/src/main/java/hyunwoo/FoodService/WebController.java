package hyunwoo.FoodService;

import hyunwoo.FoodService.domain.MemoryMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class WebController {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
    @GetMapping("/mypastorder")
    public String orderList(){
        return "info/orderList";
    }

}
