package teamproject.lam_simple.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CityTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cityTransportNO")
    private long id;

    @Column(nullable = false)
    private String cityTransportCategory;
    @Column(nullable = false)
    private int cityStationCount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityNO")
    private City city;

}
