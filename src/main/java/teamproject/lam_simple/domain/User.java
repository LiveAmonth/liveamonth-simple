package teamproject.lam_simple.domain;

import lombok.Getter;
import lombok.Setter;
import teamproject.lam_simple.dto.UserForm;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "userNO")
    private long id;

    @Column(nullable = false)
    private String userID;
    @Column(nullable = false)
    private String userPassword;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private String userNickname;
    @Column(nullable = false)
    private String userEmail;
    @Column(nullable = false)
    private boolean userSex;
    @Column(nullable = false)
    private int userAge;
    @Column
    private String userImage;

}
