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

    public List<FoodStore> findAllFoodStore(){
        return new ArrayList<FoodStore>(store.values());
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

    //
    public List<String> findMenuNameById(Long id){
        List<String> menuNameList = new ArrayList<>();
        FoodStore foo = findById(id);
        List<Menu> menuList = foo.getMenuList();
        for (Menu menu : menuList) {
            menuNameList.add(menu.getMenuName());
        }
        return menuNameList;
    }

    public void makeStoreList() {
        List<Menu> chickenList = new ArrayList<>();
        List<Menu> pizzaList = new ArrayList<>();


       chickenList.add(new Menu("friedChicken", 13000));
        chickenList.add(new Menu("hotChicken", 18000));
        chickenList.add(new Menu("coke", 3000));

        pizzaList.add(new Menu("meatPizza", 16000));
        pizzaList.add(new Menu("vegPizza", 19000));
        pizzaList.add(new Menu("pasta", 60000));

        newFoodStore(new FoodStore("chicken", "seoul", chickenList));
        newFoodStore(new FoodStore("pizza", "yongin", pizzaList));
    }

}
