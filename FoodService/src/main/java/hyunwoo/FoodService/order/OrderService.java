package hyunwoo.FoodService.order;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.domain.MemoryMemberRepository;
import hyunwoo.FoodService.domain.Menu;
import hyunwoo.FoodService.domain.OrderRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    public OrderRecord makeOrder(String storeName, List<String> menuList, String date, Member member){
        OrderRecord orderRecord = new OrderRecord(storeName, date, menuList);
        member.getOrderRecord().add(orderRecord);
        return orderRecord;
    }

}
