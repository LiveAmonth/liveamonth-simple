package teamproject.lam_simple.domain;

import lombok.Getter;
import lombok.Setter;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.CategoryConstants.CityWeatherMonth;

import javax.persistence.*;

@Entity
@Table(name = "cityWeather")
@Getter @Setter
public class CityWeather {

    @Id @GeneratedValue
    @Column(name = "cityWeatherNO")
    private long id;

    @Enumerated(EnumType.STRING)
    private CityWeatherMonth cityWeatherMonth;

    private float cityWeatherMaxTemp;
    private float cityWeatherMinTemp;
    private float cityWeatherAVGTemp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityNO")
    private City city;

}
