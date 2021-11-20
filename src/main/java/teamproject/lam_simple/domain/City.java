package teamproject.lam_simple.domain;

import lombok.Getter;
import lombok.Setter;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.CategoryConstants.CityCategory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
@Getter @Setter
public class City {

    @Id @GeneratedValue
    @Column(name = "cityNO")
    private long id;

    @Enumerated(EnumType.STRING)
    private CityCategory cityName;

    @OneToMany
    private List<CityInfo> cityInfos = new ArrayList<>();

    @OneToMany
    private List<CityWeather> cityWeathers = new ArrayList<>();

    @OneToMany
    private List<CityTransport> cityTransports = new ArrayList<>();

}
