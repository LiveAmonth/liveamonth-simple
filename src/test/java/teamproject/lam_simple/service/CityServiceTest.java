package teamproject.lam_simple.service;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import teamproject.lam_simple.domain.City;
import teamproject.lam_simple.domain.CityInfo;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class CityServiceTest {
    @Autowired
    CityService cityService;

    @Test
    void 도시정보가져오기() throws Exception {
        List<CityInfo> cityList = cityService.getRandomCityInfo("INTRO");
        System.out.println(cityList.get(0).getCity().getCityName());
    }

}