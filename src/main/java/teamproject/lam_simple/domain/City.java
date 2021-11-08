package teamproject.lam_simple.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cityNO")
    private long id;

    @Column(nullable = false)
    private String cityName;
}
