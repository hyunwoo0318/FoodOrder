package hyunwoo.FoodService.review;

import hyunwoo.FoodService.domain.FoodStore;
import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.domain.MemoryFoodStoreRepository;
import hyunwoo.FoodService.domain.Review;
import hyunwoo.FoodService.login.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/reviews")
public class ReviewController {

    MemoryFoodStoreRepository foodStoreRepository = new MemoryFoodStoreRepository();
    ReviewService reviewService = new ReviewService();

    @GetMapping("write/{storeName}")
    public String storeReviewList(@PathVariable("storeName") String storeName, Model model){
        Optional<FoodStore> findStore = foodStoreRepository.findByStoreName(storeName);
       if(findStore.isEmpty())
            throw new RuntimeException("존재하지 않는 음식점입니다.");
        FoodStore foodStore = findStore.get();
        model.addAttribute("review", new Review());
        return "/info/writeReview";
    }

    @PostMapping("write/{storeName}")
    public String submitReivew(@PathVariable("storeName") String storeName, @ModelAttribute("review") Review review,
                               HttpServletRequest request){
        log.info("submit review POST요청이 옴");
        reviewService.storeReview(request, review.getComment(), storeName);
        return "redirect:../../mypastorder";
    }

    @GetMapping("view/{storeName}")
    public String viewReview(@PathVariable String storeName, Model model)  {
        FoodStore foodStore = foodStoreRepository.findByStoreName(storeName).get();
        model.addAttribute("reviews", foodStore.getReviewList());
        log.info("viewReview GET 요청이 옴");
        return "/info/showReview";
    }


}
