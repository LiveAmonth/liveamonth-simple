package teamproject.lam_simple.dto;

import lombok.Getter;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.CategoryConstants.EmailDomains;
import teamproject.lam_simple.constants.CategoryConstants.GenderTypes;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Getter
public class UserForm {


    @NotEmpty(message = "이메일은 필수 입니다.")
    @Size(max = 100, message = "이메일은 50자리를 초과할 수 없습니다.")
    private String email_id;

    @NotEmpty(message = "이메일은 필수 입니다.")
    private String email_domain;

    @NotEmpty(message = "이름은 필수 입니다.")
    @Size(max = 20, message = "이름은 20자리를 초과할 수 없습니다.")
    private String name;

    @NotEmpty(message = "닉네임은 필수 입니다.")
    @Size(max = 50, message = "닉네임은 50자리를 초과할 수 없습니다.")
    private String nickname;

    @NotEmpty(message = "아이디는 필수 입니다.")
    @Size(max = 50, message = "아이디는 50자리를 초과할 수 없습니다.")
    private String login_id;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    @Size(max = 100, message = "비밀번호는 100자리를 초과할 수 없습니다.")
    private String password;

    @NotNull(message = "생년월일은 필수 입니다.")
    private Date birth;

    @NotEmpty(message = "성별은 필수 입니다.")
    private GenderTypes genderTypes;
}
