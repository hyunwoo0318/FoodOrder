package hyunwoo.FoodService.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

//@Data -> 모든 생성자,소멸자 등등을 알아서 생성해줌
@Data
public class Member {

    //각각의 회원의 고유한 id
    private long id;

    //회원의 아이디 조건
    //1.첫글자는 숫자 X
    //2. 아이디 10자 이내
    @NotBlank
    @Size(max = 10)
    private String loginId;

    //회원의 비밀번호 조건
    //1.숫자와 영문이 1개 이상 존재
    //2.8자 이상 16자 이하
    @NotBlank
    @Size(min=8, max=16)
    private  String password;

    //회원의 핸드폰번호 조건
    //1. 010으로 시작해야함
    //2. 10자 아니면 11자여야함.
    //3. 숫자 외 다른 자료형 금지

    @NotNull
    @Size(min = 10, max = 11)
    private String phoneNumber;

    //회원의 이름 조건
    //1. 문자 외 다른 입력 금지
    @NotBlank
    private  String name;

    //회원별 주문내역을 저장
    private  List<OrderRecord> orderRecord;



}
