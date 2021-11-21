package teamproject.lam_simple.domain;

import lombok.Getter;
import lombok.Setter;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.CategoryConstants.CityTransportCategory;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "cityTransport")
@Getter @Setter
public class CityTransport {

    @Id @GeneratedValue
    @Column(name = "cityTransportNO")
    private long id;

    @Enumerated(EnumType.STRING)
    private CityTransportCategory cityTransportCategory;
    private int cityStationCount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cityNO")
    private City city;

}
