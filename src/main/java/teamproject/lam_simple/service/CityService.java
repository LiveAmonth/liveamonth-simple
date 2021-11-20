package teamproject.lam_simple.service;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.CategoryConstants.CityTransportCategory;
import teamproject.lam_simple.domain.City;
import teamproject.lam_simple.domain.CityInfo;
import teamproject.lam_simple.domain.CityTransport;
import teamproject.lam_simple.domain.CityWeather;
import teamproject.lam_simple.repository.CityRepository;

import java.util.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class CityService {
    private final CityRepository cityRepository;

    public List<CityInfo> findCityInfoByCategory(String category) {
        return cityRepository.findCityInfoByCategory(category);
    }

    public List<CityWeather> getAVGTempList(){
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        return cityRepository.getAVGTempList(month);
    }
    public HashMap<String, String> getCityTransportGradeList(){
        HashMap<String, String> cityTransportGradeList = new HashMap<>();
        for(City city: cityRepository.findAll()){
            int score = 0;
            String grade;
            List<CityTransport> transportVOS = cityRepository.findCityTransportByName(city.getCityName());
            for(CityTransportCategory transportCategory: CityTransportCategory.values()){
                score += transportVOS.get(transportCategory.ordinal()).getCityStationCount() * transportCategory.getScore();
            }
            if(score > 61) grade = "상";
            else if(score>21 && score<=61) grade = "중";
            else grade = "하";
            cityTransportGradeList.put(city.getCityName(), grade);
        }
        return cityTransportGradeList;
    }
}
