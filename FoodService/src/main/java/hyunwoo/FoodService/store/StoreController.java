package hyunwoo.FoodService.store;

import hyunwoo.FoodService.domain.FoodStore;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 점주만 접근 가능함
 */
@Controller
@RequestMapping("/owner")
public class StoreController {

    @GetMapping("loginHome")
    public String ownerHome() {
        return "owner/loginHome";
    }

    //TODO: Map을 form에서 binding하는것을 해결해야함.
    @GetMapping("add")
    public String addStore(Model model){
        model.addAttribute("foodStore", new FoodStore());
        return "owner/addStore";
    }
}
