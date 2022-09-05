package hyunwoo.FoodService.order;

import hyunwoo.FoodService.domain.FoodStore;
import hyunwoo.FoodService.domain.MemoryFoodStoreRepository;
import hyunwoo.FoodService.domain.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

@Controller
public class OrderController {

    MemoryFoodStoreRepository foodStoreRepository = new MemoryFoodStoreRepository();

    @GetMapping("/makeorder")
    public String storeList(Model model){
        //임시로 음식점 리스트를 넣어둠
        makeStoreList(model);

        return "order/storeList";
    }

    @GetMapping("/makeorder/{storeName}")
    public String menuList(@PathVariable("storeName") String storeName, Model model){
        List<Menu> menus = foodStoreRepository.findMenuByStoreName(storeName);
        model.addAttribute("menuList", menus);
        return "order/menuList";
    }

    private void makeStoreList(Model model) {
        List<FoodStore> storeList = new ArrayList<>();
        List<Menu> menuList = new ArrayList<>();

        Menu friedChicken = new Menu("friedChicken", 13000);
        Menu hotChicken = new Menu("hotChicken", 18000);
        Menu coke = new Menu("coke", 3000);

        List<Menu> menuChickenList = asList(friedChicken, hotChicken, coke);

        Menu meatPizza = new Menu("meatPizza", 16000);
        Menu vegPizza = new Menu("vegPizza", 19000);
        Menu pasta = new Menu("pasta", 60000);

        List<Menu> menuPizzaList = asList(meatPizza, vegPizza, pasta);

        storeList.add(new FoodStore("chicken", "seoul", menuChickenList));
        storeList.add(new FoodStore("pizza", "yongin", menuPizzaList));

        foodStoreRepository.newFoodStore(new FoodStore("chicken", "seoul", menuChickenList));
        foodStoreRepository.newFoodStore(new FoodStore("pizza", "yongin", menuPizzaList));

        model.addAttribute("foodStores",storeList);
    }





}
