package hyunwoo.FoodService.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
public class OrderRecord {
    public OrderRecord() {
        this.orderedMenu = new ArrayList<>();
    }

    public OrderRecord(String storeName, String date, List<String> orderedMenu) {
        this.storeName = storeName;
        this.date = date;
        this.orderedMenu = orderedMenu;
    }

    // 가게이름, 주문날짜, 주문한 메뉴들

    private  String storeName;
    private  String date;
    private List<String> orderedMenu;

}
