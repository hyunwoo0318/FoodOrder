package hyunwoo.FoodService.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//음식점 클래스
//음식점 이름, 메뉴-가격, 위치
@Data
public class FoodStore {

    private Long id;

    public void setMenuList(Map<String, Integer> menuList) {
        this.menuList = menuList;
    }

    public FoodStore(String storeName, String pos, Map<String, Integer> menuList) {
        this.storeName = storeName;
        this.pos = pos;
        this.menuList =menuList;
        this.reviewList = new ArrayList<Review>();
    }

    public FoodStore(String storeName, String pos) {
        this.storeName = storeName;
        this.pos = pos;
        this.menuList = new LinkedHashMap<>();
        this.reviewList = new ArrayList<Review>();
    }

    public FoodStore() {
        this.menuList = new LinkedHashMap<String, Integer>();
        this.reviewList = new ArrayList<Review>();
    }

    public FoodStore(String storeName, String pos,  Map<String, Integer> menuList, List<Review> reviewList) {
        this.storeName = storeName;
        this.pos = pos;
        this.menuList = menuList;
        this.reviewList = reviewList;
    }

    private String storeName;
    private String pos;
    private Map<String, Integer> menuList;
    private List<Review> reviewList;

}
