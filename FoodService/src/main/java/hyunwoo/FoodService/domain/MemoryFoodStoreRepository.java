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
    public List<Menu> findMenuByStoreName(String storeName)
    {
        return findByStoreName(storeName).get().getMenuList();
    }

    public List<String> findMenuNameByStoreName(String storeName){
        List<String> menuNameList = new ArrayList<>();
        List<Menu> menuList = findByStoreName(storeName).get().getMenuList();
        for (Menu menu : menuList) {
            menuNameList.add(menu.getMenuName());
        }
        return menuNameList;
    }

    public void makeStoreList() {
        List<FoodStore> storeList = new ArrayList<>();
        List<Menu> menuList = new ArrayList<>();

        Menu friedChicken = new Menu("friedChicken", 13000);
        Menu hotChicken = new Menu("hotChicken", 18000);
        Menu coke = new Menu("coke", 3000);

        List<Menu> menuChickenList = asList(friedChicken, hotChicken, coke);

        Menu meatPizza = new Menu("meatPizza", 16000);
        Menu vegPizza = new Menu("vegPizza", 19000);
        Menu pasta = new Menu("pasta", 60000);

        List<Menu> menuPizzaList = asList(meatPizza, vegPizza, pasta);

        storeList.add(new FoodStore("chicken", "seoul", menuChickenList));
        storeList.add(new FoodStore("pizza", "yongin", menuPizzaList));

        newFoodStore(new FoodStore("chicken", "seoul", menuChickenList));
        newFoodStore(new FoodStore("pizza", "yongin", menuPizzaList));
    }

}
