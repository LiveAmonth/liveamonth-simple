package teamproject.lam_simple.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class CityWeather {

    @Id @GeneratedValue
    @Column(name = "cityWeatherNO")
    private long id;

    private int cityWeatherMonth;
    private float cityWeatherMaxTemp;
    private float cityWeatherMinTemp;
    private float cityWeatherAVGTemp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityNO")
    private City city;

}
