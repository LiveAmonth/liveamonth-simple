package teamproject.lam_simple.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserForm {

    @NotEmpty(message = "이메일은 필수 입니다.")
    @Size(max = 100, message = "이메일은 100자리를 초과할 수 없습니다.")
    private String userEmail;

    @NotEmpty(message = "이름은 필수 입니다.")
    @Size(max = 20, message = "이름은 20자리를 초과할 수 없습니다.")
    private String userName;

    @NotEmpty(message = "닉네임은 필수 입니다.")
    @Size(max = 50, message = "닉네임은 50자리를 초과할 수 없습니다.")
    private String userNickname;

    @NotEmpty(message = "아이디는 필수 입니다.")
    @Size(max = 50, message = "아이디는 50자리를 초과할 수 없습니다.")
    private String userID;

    @NotEmpty(message = "비밀번호는 필수 입니다.")
    @Size(max = 100, message = "비밀번호는 100자리를 초과할 수 없습니다.")
    private String userPassword;

    @NotEmpty(message = "나이는 필수 입니다.")
    @Size(min = 0, message = "나이는 1세 이상 이어야 합니다.")
    private int userAge;

    @NotEmpty(message = "성별은 필수 입니다.")
    private boolean userSex;
}
