package teamproject.lam_simple.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class FindIdForm {

    @NotEmpty(message = "이름은 필수 입니다.")
    @Size(max = 20, message = "이름은 20자리를 초과할 수 없습니다.")
    private String name;

    @NotEmpty(message = "이메일은 필수 입니다.")
    @Size(max = 100, message = "이메일은 50자리를 초과할 수 없습니다.")
    private String email_id;

    @Pattern(regexp = "[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}",message = "올바르지 않은 도메인 이름입니다.")
    @NotEmpty(message = "이메일은 필수 입니다.")
    private String email_domain;

    public String unifyEmail(){
        return this.email_id+"@"+this.email_domain;
    }
}
