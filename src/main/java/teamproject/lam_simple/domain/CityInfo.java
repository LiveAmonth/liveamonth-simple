package teamproject.lam_simple.domain;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class CityInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cityInfoNO")
    private long id;

    @Column(nullable = false)
    private String cityInfoCategory;
    @Column(nullable = false)
    private String cityInfoDesc;
    @Column(nullable = false)
    private String cityInfoImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cityNO")
    private City city;

}
