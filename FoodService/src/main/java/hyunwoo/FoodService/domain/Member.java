package hyunwoo.FoodService.domain;

import lombok.Data;

//@Data -> 모든 생성자,소멸자 등등을 알아서 생성해줌
@Data
public class Member {

    //각각의 회원의 고유한 id
    private long id;

    //회원의 아이디,비밀번호, 핸드폰번호
    private final String loginId;
    private final String password;
    private final String phoneNumber;

}
