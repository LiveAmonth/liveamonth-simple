package teamproject.lam_simple.dto;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class LoginForm {

    @NotEmpty(message = "아이디는 필수 입니다.")
    @Size(max = 50, message = "아이디는 50자리를 초과할 수 없습니다.")
    private String loginId;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    @Size(max = 100, message = "비밀번호는 100자리를 초과할 수 없습니다.")
    private String password;

}
