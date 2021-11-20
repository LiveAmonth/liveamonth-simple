package teamproject.lam_simple.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class CityTransport {

    @Id @GeneratedValue
    @Column(name = "cityTransportNO")
    private long id;
    private String cityTransportCategory;
    private int cityStationCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityNO")
    private City city;

}
