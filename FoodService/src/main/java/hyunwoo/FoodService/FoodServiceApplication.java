package hyunwoo.FoodService;

import hyunwoo.FoodService.domain.MemoryFoodStoreRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodServiceApplication {

	public static void main(String[] args) {
		MemoryFoodStoreRepository foodStoreRepository = new MemoryFoodStoreRepository();
		foodStoreRepository.makeStoreList();
		SpringApplication.run(FoodServiceApplication.class, args);
	}

}
