package teamproject.lam_simple.domain;

import lombok.Getter;
import teamproject.lam_simple.constants.EntityConstants;
import teamproject.lam_simple.constants.EntityConstants.CityInfoCategory;

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



    @ManyToOne
    @JoinColumn(name = "cityNO")
    private City city;

//    public CityInfo(long id, String cityInfoCategory, String cityInfoDesc, String cityInfoImage, City city) {
//        this.id = id;
//        this.cityInfoCategory = cityInfoCategory;
//        this.cityInfoDesc = cityInfoDesc;
//        this.cityInfoImage = cityInfoImage;
//        this.city = city;
//    }
//    public String getCityInfoImage() {
//        String imageURL = "";
//        for (CityInfoCategory category : CityInfoCategory.values()) {
//            if (category.name().equals(this.cityInfoImage)) {
//                imageURL = "/img/" + category.getImgUrlPath() + this.cityInfoImage;
//            }
//        }
//        return imageURL;
//    }
}
