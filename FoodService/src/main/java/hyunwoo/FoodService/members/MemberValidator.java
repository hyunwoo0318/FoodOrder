package hyunwoo.FoodService.members;

import hyunwoo.FoodService.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MemberValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Member member = (Member) target;

        String loginIdError = findLoginIdError(member);
        String nameError = findNameError(member);
        String passwordError = findPasswordError(member);
        List<String> phoneNumberError = findPhoneNumberError(member);


        if (!loginIdError.isEmpty()) {
            errors.rejectValue("loginId", loginIdError);
        }
        if (!nameError.isEmpty()) {
            errors.rejectValue("name", nameError);
        }
        if (!passwordError.isEmpty()) {
            errors.rejectValue("password", passwordError);
        }
        for (String s : phoneNumberError) {
            errors.rejectValue("phoneNumber", s);
        }
    }


    //1. 아이디 -> 첫글자가 숫자인지 아닌지 파악
    public static String findLoginIdError(Member member) {
        String inputLoginID = member.getLoginId();
        if(inputLoginID.isEmpty())
            return "";
        if(inputLoginID.charAt(0)-'0' >=0 && inputLoginID.charAt(0)-'0' <= 9)
            return "invalidType";
        return "";
    }

    //2.비밀번호 -> 숫자와 영문이 1개 이상 존재
    public static String findPasswordError(Member member) {

        String inputPassword = member.getPassword();
        boolean number = false;
        boolean letter= false;
        for(int i=0;i<inputPassword.length();i++)
        {
            char c = inputPassword.charAt(i);
            if(c-'0' >=0 && c-'0' <=9)
                number = true;
            else
                letter = true;

            if(number && letter)
                break;
        }
        if(!number || !letter)
            return  "invalidType";

        return "";
    }

    //3.전화번호 -> 010으로 시작해야함
    public static List<String> findPhoneNumberError(Member member){
        List<String> errors = new ArrayList<>();
        String inputPhoneNumber = member.getPhoneNumber();
        if(inputPhoneNumber.isEmpty())
            return errors;
        String substring = inputPhoneNumber.substring(0, 3);
        if (!substring.equals("010")) {
            errors.add("invalidType");
        }
        for (int i=0;i<inputPhoneNumber.length();i++) {
            char c = inputPhoneNumber.charAt(i);
            if(c-'0' <0  || c-'0'>9){
                errors.add("typeMismatch");
                break;
            }
        }

        return errors;
    }

    //4.이름 -> 문자 외 다른 입력 금지
    public static String findNameError(Member member) {

        String inputName = member.getName();
        for(int i=0;i<inputName.length();i++)
        {
            char c = inputName.charAt(i);
            if(c >=0 && c <=9)
               return "invalidType";
        }
        return "";
    }
}
