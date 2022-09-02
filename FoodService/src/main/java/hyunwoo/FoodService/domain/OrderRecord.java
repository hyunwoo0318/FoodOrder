package hyunwoo.FoodService.domain;

import lombok.Data;

import java.util.List;

@Data
public class OrderRecord {

    //이름, 가게이름, 주문날짜, 주문한 메뉴들
    private final String name;
    private final String storeName;
    private final String date;
    private final List<String> orderedMenu;
}
