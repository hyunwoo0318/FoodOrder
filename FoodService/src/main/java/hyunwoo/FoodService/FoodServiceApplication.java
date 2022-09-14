package hyunwoo.FoodService;

import hyunwoo.FoodService.domain.MemoryFoodStoreRepository;
import hyunwoo.FoodService.domain.MemoryMemberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodServiceApplication {

	public static void main(String[] args) {
		MemoryFoodStoreRepository foodStoreRepository = new MemoryFoodStoreRepository();
		MemoryMemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.newMember(memberRepository.testMemberDataAdd());
		foodStoreRepository.makeStoreList();
		SpringApplication.run(FoodServiceApplication.class, args);
	}

}
