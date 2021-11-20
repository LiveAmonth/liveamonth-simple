package teamproject.lam_simple.service;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.CategoryConstants.CityTransportCategory;
import teamproject.lam_simple.constants.CategoryConstants.CityTransportGrade;
import teamproject.lam_simple.domain.City;
import teamproject.lam_simple.domain.CityInfo;
import teamproject.lam_simple.domain.CityTransport;
import teamproject.lam_simple.domain.CityWeather;
import teamproject.lam_simple.repository.CityRepository;

import java.util.*;

import static teamproject.lam_simple.constants.CategoryConstants.*;
import static teamproject.lam_simple.constants.CategoryConstants.CityTransportGrade.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<CityInfo> findCityInfoByCategory(String category) {
        return cityRepository.findCityInfoByCategory(category);
    }

    public List<CityWeather> getAVGTempList(){
        Calendar calendar = Calendar.getInstance();
        return cityRepository.getAVGTempList(CityWeatherMonth.values()[calendar.get(Calendar.MONTH)]);
    }
    public HashMap<Long, CityTransportGrade> getCityTransportGradeList(){
        HashMap<Long, CityTransportGrade> cityTransportGradeList = new HashMap<>();
        for(City city: cityRepository.findAll()){
            int score = 0;
            CityTransportGrade grade;
            List<CityTransport> transportVOS = cityRepository.findCityTransportById(city.getId());
            for(CityTransportCategory transportCategory: CityTransportCategory.values()){
                score += transportVOS.get(transportCategory.ordinal()).getCityStationCount() * transportCategory.getScore();
            }
            if(score > 61) grade = T_GOOD;
            else if(score>21 && score<=61) grade = T_FAIR;
            else grade = T_POOR;
            cityTransportGradeList.put(city.getId(), grade);
        }
        return cityTransportGradeList;
    }
}
