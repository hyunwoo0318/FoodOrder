package hyunwoo.FoodService.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginForm {
    public LoginForm(String loginId, String password) {
        this.loginId = loginId;
        this.password = password;
    }

    @NotNull
    private String loginId;

    public LoginForm() {
    }

    @NotNull
    private String password;
}
