package hyunwoo.FoodService.domain;

import lombok.Data;

import java.util.List;

@Data
public class OrderRecord {

    public OrderRecord(String name, String storeName, String date, List<Menu> orderedMenu) {
        this.name = name;
        this.storeName = storeName;
        this.date = date;
        this.orderedMenu = orderedMenu;
    }

    //이름, 가게이름, 주문날짜, 주문한 메뉴들
    private  String name;
    private  String storeName;
    private  String date;
    private  List<Menu> orderedMenu;
}
