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
    private List<Review> reviewList = new ArrayList<>();







    public FoodStore(String storeName, String pos) {
        this.storeName = storeName;
        this.pos = pos;

    }

    public FoodStore() {

    }

    public FoodStore(String storeName, String pos, List<Menu> menuList, List<Review> reviewList) {
        this.storeName = storeName;
        this.pos = pos;
        this.menuList = menuList;
        this.reviewList = reviewList;
    }

    public FoodStore(String storeName, String pos, List<Menu> menuList) {
        this.storeName = storeName;
        this.pos = pos;
        this.menuList = menuList;
    }
}
