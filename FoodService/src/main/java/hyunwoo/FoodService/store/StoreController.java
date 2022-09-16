package hyunwoo.FoodService.store;

import hyunwoo.FoodService.domain.FoodStore;
import hyunwoo.FoodService.domain.MemoryFoodStoreRepository;
import hyunwoo.FoodService.domain.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 점주만 접근 가능함
 */
@Controller
@RequestMapping("/owner")
public class StoreController {

    MemoryFoodStoreRepository foodStoreRepository = new MemoryFoodStoreRepository();

    @GetMapping("loginHome")
    public String ownerHome() {
        return "owner/loginHome";
    }

    //TODO: Map을 form에서 binding하는것을 해결해야함.
    @GetMapping("add")
    public String getStore(Model model){
        FoodStore foodStore = new FoodStore();
        model.addAttribute("foodStore",foodStore);
        return "owner/addStore";
    }

    @PostMapping("add")
    public String addStore(@ModelAttribute FoodStore foodStore){
        FoodStore addedFoodStore = foodStoreRepository.newFoodStore(foodStore);
        if (addedFoodStore == null) {
            throw new RuntimeException("음식점 추가 오류 발생");
        }
        return "owner/addStoreCheck";
    }
}
