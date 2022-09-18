package hyunwoo.FoodService.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

//음식점 클래스
//음식점 이름, 메뉴-가격, 위치
@Data

public class FoodStore {

    private Long id;
    private String storeName;
    private String pos;
    private List<Menu> menuList = new ArrayList<>();
    private List<Review> reviewList = new ArrayList<>(3);
    public FoodStore() {}


    public FoodStore(String storeName, String pos, List<Menu> menuList) {
        this.storeName = storeName;
        this.pos = pos;
        this.menuList = menuList;
    }
}
