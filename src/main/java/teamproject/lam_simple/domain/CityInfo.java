package teamproject.lam_simple.domain;

import lombok.Getter;
import lombok.Setter;
import teamproject.lam_simple.constants.CategoryConstants.CityInfoCategory;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Table(name = "cityInfo")
@Getter @Setter
public class CityInfo {

    @Id @GeneratedValue
    @Column(name = "cityInfoNO")
    private long id;

    @Enumerated(EnumType.STRING)
    private CityInfoCategory cityInfoCategory;

    private String cityInfoDesc;
    private String cityInfoImage;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cityNO")
    private City city;
}
