package hyunwoo.FoodService.domain;


import org.springframework.stereotype.Repository;

import java.util.*;

import static java.util.Arrays.asList;

//음식점 리스트 리포지토리
//TODO : 하나의 인터페이스를 만들고 DB를 이용한 레포지토리 클래스를 하나더 만든다. -> 원하는 레포지토리 종류를 골라서 사용할수 있게 할예정
@Repository
public class MemoryFoodStoreRepository {

    private static Map<Long, FoodStore> store = new HashMap();
    private static long sequence = 0L;

    public MemoryFoodStoreRepository() {
    }

    public FoodStore newFoodStore(FoodStore foodStore)
    {
        foodStore.setId(++sequence);
        store.put(foodStore.getId(), foodStore);
        return foodStore;
    }

    public FoodStore findById(Long id){
        return store.get(id);
    }

    public Collection<FoodStore> findAllFoodStore(){
        return store.values();
    }

    //음식점 이름으로 음식점 정보 알기
    public Optional<FoodStore> findByStoreName(String storeName) {
        return store.values().stream().filter(m->m.getStoreName().equals(storeName))
                .findFirst();
    }

    //음식점 이름으로 메뉴 정보 알기
    public Map<String, Integer> findMenuByStoreName(String storeName)
    {
        return findByStoreName(storeName).get().getMenuList();
    }

    //
    public List<String> findMenuNameById(Long id){
        List<String> menuNameList = new ArrayList<>();
        FoodStore foo = findById(id);
        Map<String, Integer> menuList = foo.getMenuList();
        for (String s : menuList.keySet()) {
            menuNameList.add(s);
        }
        return menuNameList;
    }

    public void makeStoreList() {
        List<FoodStore> storeList = new ArrayList<>();
        List<Menu> menuList = new ArrayList<>();

        Map<String, Integer> chickenMap = new LinkedHashMap<>();
        Map<String, Integer> pizzaMap = new LinkedHashMap<>();


        chickenMap.put("friedChicken", 13000);
        chickenMap.put("hotChicken", 18000);
        chickenMap.put("coke", 3000);

        pizzaMap.put("meatPizza", 16000);
        pizzaMap.put("vegPizza", 19000);
        pizzaMap.put("pasta", 60000);

        storeList.add(new FoodStore("chicken", "seoul", chickenMap));
        storeList.add(new FoodStore("pizza", "yongin", pizzaMap));

        newFoodStore(new FoodStore("chicken", "seoul", chickenMap));
        newFoodStore(new FoodStore("pizza", "yongin", pizzaMap));
    }

}
