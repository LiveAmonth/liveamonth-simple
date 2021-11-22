package teamproject.lam_simple.domain;

import groovy.util.ObservableList;
import lombok.Getter;
import lombok.Setter;
import teamproject.lam_simple.dto.UserForm;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter @Setter
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private long id;

    @NotEmpty
    private String login_id;
    @NotEmpty
    private String password;
    @NotEmpty
    private String name;
    @NotEmpty
    private String nickname;
    @NotEmpty
    private String email;
    @NotEmpty
    private boolean gender;
    @NotEmpty
    private int birth;
    private String image;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Schedule> schedules = new ArrayList<>();


}
