package hyunwoo.FoodService.login;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.domain.MemoryMemberRepository;

public class LoginService {

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    //로그인 서비스
    //return null이면 로그인실패
    public Member login(String inputLoginId, String inputPassword) {
        return memoryMemberRepository.findByLoginId(inputLoginId)
                .filter(m->m.getPassword().equals(inputPassword))
                .orElse(null);
    }
}
