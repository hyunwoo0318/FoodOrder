package hyunwoo.FoodService.order;

import hyunwoo.FoodService.domain.*;
import hyunwoo.FoodService.login.LoginConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static java.util.Arrays.asList;

@Controller
@Slf4j
public class OrderController {

    MemoryFoodStoreRepository foodStoreRepository = new MemoryFoodStoreRepository();
    OrderService orderService = new OrderService();

    @GetMapping("/makeorder")
    public String storeList(Model model){
        Collection<FoodStore> allFoodStore = foodStoreRepository.findAllFoodStore();
        model.addAttribute("foodStores", allFoodStore);
        return "order/storeList";
    }

    //TODO: List<Menu>로 했을때 타입변환 에러가 나서 일단 String으로 해놓음 전체적인 흐름을 완성하고 변경하기.
    @GetMapping("/makeorder/{storeName}")
    public String menuList(@PathVariable("storeName") String storeName, Model model){
        model.addAttribute("orderRecord", new OrderRecord());
        log.info("get 요청이 왔음");
        List<String> menus = foodStoreRepository.findMenuNameByStoreName(storeName);
        model.addAttribute("menuList", menus);
        return "order/menuList";
    }

    @PostMapping("/makeorder/{storeName}")
    public String makeOrder(@PathVariable("storeName") String storeName,@ModelAttribute("orderRecord") OrderRecord orderRecord,
                            HttpServletRequest request){
        log.info("post 요청이 왔음");
        Member loginMember = (Member)request.getSession().getAttribute(LoginConst.LOGIN_MEMBER);
        if(loginMember == null)
        {
            throw new RuntimeException("로그인 세션 만료");
        }
        Date date = new Date();
        String dateToString = date.toString();
        orderService.makeOrder(storeName, orderRecord.getOrderedMenu(), dateToString, loginMember);
        return "order/orderCheck";
    }







}
