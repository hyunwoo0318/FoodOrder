package hyunwoo.FoodService.review;

import hyunwoo.FoodService.domain.*;
import hyunwoo.FoodService.login.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class ReviewService {

    LoginService loginService = new LoginService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    MemoryFoodStoreRepository foodStoreRepository = new MemoryFoodStoreRepository();

    public Review storeReview(HttpServletRequest request, String comment, String storeName){
        Member loginMember = loginService.findLoginMember(request);
        Review newReview = new Review(loginMember.getLoginId(), comment);
        FoodStore foodStore = foodStoreRepository.findByStoreName(storeName).get();

        foodStore.getReviewList().add(newReview);
        return newReview;
    }
}
