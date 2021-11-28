package teamproject.lam_simple.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;
import teamproject.lam_simple.constants.CategoryConstants.GenderTypes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User{

    @Id @GeneratedValue
    @Column(name = "user_id")
    private long id;

    private String login_id;
    private String password;
    private String name;
    private String nickname;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private GenderTypes genderTypes;
    private Date birth;

    private String image;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Schedule> schedules = new ArrayList<>();

    @Builder
    public User(String login_id, String password, String name, String nickname, String email, GenderTypes genderTypes, Date birth) {
        Assert.notNull(login_id, "login_id must not be empty");
        Assert.notNull(password, "password must not be empty");
        Assert.notNull(name, "name must not be empty");
        Assert.notNull(nickname, "nickname must not be empty");
        Assert.notNull(email, "email must not be empty");
        Assert.notNull(genderTypes, "gender must not be null");
        Assert.notNull(birth, "birth must not be empty");
        this.login_id = login_id;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.genderTypes = genderTypes;
        this.birth = birth;
    }

}
