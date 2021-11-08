package teamproject.lam_simple.domain;

import lombok.Getter;
import teamproject.lam_simple.dto.UserForm;

import javax.persistence.*;

@Entity
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public User(UserForm userForm) {
        this.userID = userForm.getUserID();
        this.userName = userForm.getUserName();
        this.userPassword = userForm.getUserPassword();
        this.userAge = userForm.getUserAge();
        this.userNickname = userForm.getUserNickname();
        this.userSex = userForm.isUserSex();
        this.userEmail = userForm.getUserEmail();
    }

    public static User createUser(UserForm userForm){
        return new User(userForm);
    }
}
