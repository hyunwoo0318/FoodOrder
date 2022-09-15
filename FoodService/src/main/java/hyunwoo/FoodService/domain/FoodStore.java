package hyunwoo.FoodService.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//음식점 클래스
//음식점 이름, 메뉴-가격, 위치
@Data

public class FoodStore {

    private Long id;
    private String storeName;
    private String pos;
    private Map<String, Integer> menuList = new LinkedHashMap<>();
    private List<Review> reviewList = new ArrayList<>();

    public Map<String, Integer> getMenuList() {
        return menuList;
    }



    public void setMenuList(Map<String, Integer> menuList) {
        this.menuList = menuList;
    }

    public void setMenuList(String foodName, Integer price) {
        menuList.put(foodName, price);
    }



    public FoodStore(String storeName, String pos) {
        this.storeName = storeName;
        this.pos = pos;

    }

    public FoodStore() {
    }

    public FoodStore(String storeName, String pos, Map<String, Integer> menuList, List<Review> reviewList) {
        this.storeName = storeName;
        this.pos = pos;
        this.menuList = menuList;
        this.reviewList = reviewList;
    }



}
