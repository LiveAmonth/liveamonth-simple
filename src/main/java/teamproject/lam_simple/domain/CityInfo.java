package teamproject.lam_simple.domain;

import lombok.Getter;
import lombok.Setter;
import teamproject.lam_simple.constants.EntityConstants;
import teamproject.lam_simple.constants.EntityConstants.CityInfoCategory;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "cityInfo")
@Getter @Setter
public class CityInfo {

    @Id @GeneratedValue
    @Column(name = "cityInfoNO")
    private long id;

    private String cityInfoCategory;
    private String cityInfoDesc;
    private String cityInfoImage;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "cityNO")
    private City city;

}
