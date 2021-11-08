package teamproject.lam_simple.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CityWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cityWeatherNO")
    private long id;

    @Column(nullable = false)
    private int cityWeatherMonth;
    @Column(nullable = false)
    private float cityWeatherMaxTemp;
    @Column(nullable = false)
    private float cityWeatherMinTemp;
    @Column(nullable = false)
    private float cityWeatherAVGTemp;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityNO")
    private City city;

}
