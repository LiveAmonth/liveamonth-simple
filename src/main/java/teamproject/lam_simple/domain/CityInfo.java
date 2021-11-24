package teamproject.lam_simple.domain;

import lombok.Getter;
import lombok.Setter;
import teamproject.lam_simple.constants.CategoryConstants.CityInfoCategory;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@NamedEntityGraph(
        name = "cityInfo-with-city",
        attributeNodes = {
                @NamedAttributeNode("city")
        }
)
@Entity
@Table(name = "city_infos")
@Getter
@Setter
public class CityInfo {

    @Id
    @GeneratedValue
    @Column(name = "city_info_id")
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "city_info_category")
    private CityInfoCategory cityInfoCategory;

    @Lob
    private String content;
    private String image;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "city_id")
    private City city;

}
