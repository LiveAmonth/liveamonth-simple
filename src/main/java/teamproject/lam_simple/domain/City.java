package teamproject.lam_simple.domain;

import lombok.Getter;
import lombok.Setter;
import teamproject.lam_simple.constants.CategoryConstants.CityNames;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cities")
@Getter @Setter
public class City {

    @Id @GeneratedValue
    @Column(name = "city_id")
    private long id;

    @Enumerated(EnumType.STRING)
    private CityNames name;

    @OneToMany
    private List<CityInfo> cityInfos = new ArrayList<>();

    @OneToMany
    private List<CityWeather> cityWeathers = new ArrayList<>();

    @OneToMany
    private List<CityTransport> cityTransports = new ArrayList<>();

}
