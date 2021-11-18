package teamproject.lam_simple.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cityNO")
    private long id;

    @Column(nullable = false)
    private String cityName;

    @OneToMany
    private List<CityInfo> cityInfos = new ArrayList<CityInfo>();
    @OneToMany
    private List<CityWeather> cityWeathers = new ArrayList<CityWeather>();
    @OneToMany
    private List<CityTransport> cityTransports = new ArrayList<CityTransport>();

//    public City(long id, String cityName) {
//        this.id = id;
//        this.cityName = cityName;
//    }
}
