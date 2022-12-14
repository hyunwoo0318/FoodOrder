package hyunwoo.FoodService.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository {

    //저장할 맵을 선언 -> <id, Member>
    private static Map<Long, Member> store = new HashMap<>();
    //회원마다 고유한 아이디를 배정하기 위한 static 변수
    private static long sequence = 0L;

    //회원을 새로 추가함.
    public Member newMember(Member member){
        //멤버마다 고유한 아이디를 배정 ++연산자를 이용
        member.setId(++sequence);

        //회원가입시 새로운 주문기록 리스트를 만들어줘야함
        member.setOrderRecord(new ArrayList<>());
        store.put(member.getId(), member);
        return member;
    }

    //아이디로 회원정보 알아내기
    public Member findById(Long id){
        return store.get(id);
    }

    //모든 회원정보 알아내기
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    //로그인아이디로 회원정보 알아내기
    //TODO : 찾을 수 없을때 예외처리하기.
    public Optional<Member> findByLoginId(String loginId){
        return findAll().stream().filter(m -> m.getLoginId().equals(loginId))
                .findFirst();
    }

    public Member testMemberDataAdd(){
        Member member = new Member();
        member.setLoginId("whskwock");
        member.setPhoneNumber("01085865098");
        member.setPassword("gusdn123123");
        member.setName("임현우");
        member.setMemberClass(MemberClass.OWNER);
        return member;
    }
}
