package hyunwoo.FoodService.order;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.domain.MemoryMemberRepository;
import hyunwoo.FoodService.domain.Menu;
import hyunwoo.FoodService.domain.OrderRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();
    public OrderRecord makeOrder(String storeName, List<Menu> menuList, String date, Member member){
        OrderRecord orderRecord = new OrderRecord(member.getName(), storeName, date, menuList);
        Member findMember = memberRepository.findById(member.getId());
        findMember.getOrderRecord().add(orderRecord);
        return orderRecord;
    }

}
