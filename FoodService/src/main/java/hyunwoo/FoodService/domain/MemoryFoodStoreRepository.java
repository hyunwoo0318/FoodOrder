package hyunwoo.FoodService.domain;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//음식점 리스트 리포지토리
//TODO : 하나의 인터페이스를 만들고 DB를 이용한 레포지토리 클래스를 하나더 만든다. -> 원하는 레포지토리 종류를 골라서 사용할수 있게 할예정
@Repository
public class MemoryFoodStoreRepository {

    private Map<Long, FoodStore> store = new HashMap();
    private static long sequence = 0L;

    public FoodStore newFoodStore(FoodStore foodStore)
    {
        foodStore.setId(++sequence);
        store.put(foodStore.getId(), foodStore);
        return foodStore;
    }

    public FoodStore findById(Long id){
        return store.get(id);
    }

    //음식점 이름으로 음식점 정보 알기
    public Optional<FoodStore> findByStoreName(String storeName) {
        return store.values().stream().filter(m->m.getStoreName().equals(storeName))
                .findFirst();
    }

    //음식점 이름으로 메뉴 정보 알기
    public List<Menu> findMenuByStoreName(String storeName)
    {
        return findByStoreName(storeName).get().getMenuList();
    }


}
