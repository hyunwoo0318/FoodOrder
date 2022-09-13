package hyunwoo.FoodService.members;

import hyunwoo.FoodService.domain.Member;
import hyunwoo.FoodService.login.LoginConst;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    public Member findLoginMember(HttpServletRequest request){
        return (Member) request.getSession().getAttribute(LoginConst.LOGIN_MEMBER);
    }



    //회원가입시 검증 메서드

    public List<String> validateMemberAdd(Member member){

        List<String> errors= new ArrayList<>();

        String loginIdError = findLoginIdError(member);
        String passwordError = findPasswordError(member);
        String phoneNumberError = findPhoneNumberError(member);
        String nameError = findNameError(member);

        if(!loginIdError.isEmpty())
            errors.add(loginIdError);

        if (!passwordError.isEmpty()) {
            errors.add(passwordError);
        }
        if (!phoneNumberError.isEmpty()) {
            errors.add(phoneNumberError);
        }
        if (!nameError.isEmpty()) {
            errors.add(nameError);
        }

        return errors;
    }

    //1. 아이디 -> 첫글자가 숫자인지 아닌지 파악
    public static String findLoginIdError(Member member) {
        String inputLoginID = member.getLoginId();
        if(inputLoginID.charAt(0) >=0 || inputLoginID.charAt(0) <= 9)
           return "invalidType.loginId";
        return null;

    }

    //2.비밀번호 -> 숫자와 영문이 1개 이상 존재
    public static String findPasswordError(Member member) {
        String inputPassword = member.getPassword();
        boolean number = false;
        boolean letter= false;
        for(int i=0;i<inputPassword.length();i++)
        {
            char c = inputPassword.charAt(i);
            if(c >=0 || c <=9)
                number = true;
            else
                letter = true;

            if(number && letter)
                break;
        }
        if(!number || !letter)
            return "invalidType.password";

        return null;
    }

    //3.전화번호 -> 010으로 시작해야함
    public static String findPhoneNumberError(Member member){

        String inputPhoneNumber = member.getPhoneNumber().toString();
        String substring = inputPhoneNumber.substring(0, 2);
        if (substring != "010") {
            return "invalidType.phoneNumber";
        }
        return null;
    }

    //4.이름 -> 문자 외 다른 입력 금지
    public static String findNameError(Member member) {
        String inputName = member.getName();
        for(int i=0;i<inputName.length();i++)
        {
            char c = inputName.charAt(i);
            if(c >=0 && c <=9)
                return "invalidType.name";
        }
        return null;
    }
}
