package teamproject.lam_simple.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.domain.CityInfo;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static teamproject.lam_simple.constants.CategoryConstants.CityInfoCategory.INTRO;

@SpringBootTest
@Transactional
class CityServiceTest {
    @Autowired
    CityService cityService;

    @Test
    void 도시정보가져오기() throws Exception {
        List<CityInfo> cityList = cityService.findCityInfoByCategory(INTRO);
        System.out.println(cityList.get(0).getCity().getCityName());
    }

}