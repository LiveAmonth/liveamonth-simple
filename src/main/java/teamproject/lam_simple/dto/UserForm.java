package teamproject.lam_simple.dto;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import teamproject.lam_simple.constants.CategoryConstants.GenderTypes;
import teamproject.lam_simple.domain.User;

import javax.validation.constraints.*;
import java.sql.Date;

@Data
public class UserForm {

    @NotEmpty(message = "아이디는 필수 입니다.")
    @Size(max = 50, message = "아이디는 50자리를 초과할 수 없습니다.")
    private String loginId;

    @NotEmpty(message = "이름은 필수 입니다.")
    @Size(max = 20, message = "이름은 20자리를 초과할 수 없습니다.")
    private String name;

    @Pattern(regexp = "(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,20}", message = "영문,숫자,특수문자를 포함해 8자 이상 20자 이내의 비밀번호만 가능합니다.")
    @NotEmpty
    private String password;

    @NotEmpty(message = "비밀번호는 필수입니다.")
    private String passwordCheck;

    @NotEmpty(message = "닉네임은 필수 입니다.")
    @Size(max = 50, message = "닉네임은 50자리를 초과할 수 없습니다.")
    private String nickname;

    @NotEmpty(message = "이메일은 필수 입니다.")
    @Size(max = 100, message = "이메일은 50자리를 초과할 수 없습니다.")
    private String email_id;

    @Pattern(regexp = "[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}",message = "올바르지 않은 도메인 이름입니다.")
    @NotEmpty(message = "이메일은 필수 입니다.")
    private String email_domain;

    public String unifyEmail(){
        return this.email_id+"@"+this.email_domain;
    }

//    @Past(message = "잘못된 생년월일 입니다.")
    @NotNull(message = "생년월일은 필수입니다.")
    private Date birth;

    @NotNull(message = "성별은 필수입니다.")
    private GenderTypes genderTypes;

    public User toEntity(PasswordEncoder passwordEncoder) {
        return User.builder()
                .loginId(this.loginId)
//                .password(this.password)
                .password(passwordEncoder.encode(this.password))
                .name(this.name)
                .nickname(this.nickname)
                .birth(this.birth)
                .email(this.unifyEmail())
                .genderTypes(this.genderTypes)
                .build();
    }

}
