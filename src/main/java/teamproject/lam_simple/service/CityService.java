package teamproject.lam_simple.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    public List<CityInfo> findCityInfoByCategory(CityInfoCategory category) {
        return cityRepository.findCityInfoByCategory(category);
    }

    public List<CityWeather> getAVGTempList(){
        Calendar calendar = Calendar.getInstance();
        return cityRepository.getAVGTempList(Month.values()[calendar.get(Calendar.MONTH)]);
    }
    public HashMap<Long, CityTransportGrade> getCityTransportGradeList(){
        HashMap<Long, CityTransportGrade> cityTransportGradeList = new HashMap<>();
        for(City city: cityRepository.findAll()){
            int score = 0;
            CityTransportGrade grade;
            List<CityTransport> transportVOS = cityRepository.findCityTransportById(city.getId());
            for(TransportCategory transportCategory: TransportCategory.values()){
                score += transportVOS.get(transportCategory.ordinal()).getStation_count() * transportCategory.getScore();
            }
            if(score > 61) grade = T_GOOD;
            else if(score>21 && score<=61) grade = T_FAIR;
            else grade = T_POOR;
            cityTransportGradeList.put(city.getId(), grade);
        }
        return cityTransportGradeList;
    }

    public Map<String, Object> findCityInfoByName(CityNames menu) {
        List<CityInfo> cityInfos = cityRepository.findCityInfoByName(menu);
        Map<String, Object> cityInfoMap = new HashMap<>();
        List<CityInfo> views = new ArrayList<>();
        List<CityInfo> foods = new ArrayList<>();
        for (CityInfo cityInfo : cityInfos) {
            if(cityInfo.getCityInfoCategory() == CityInfoCategory.INTRO){
                cityInfoMap.put(CityInfoCategory.INTRO.name(), cityInfo);
            }else if(cityInfo.getCityInfoCategory() == CityInfoCategory.VIEW){
                views.add(cityInfo);
            }else{
                foods.add(cityInfo);
            }
        }
        cityInfoMap.put(CityInfoCategory.VIEW.name(), views);
        cityInfoMap.put(CityInfoCategory.FOOD.name(), foods);
        return cityInfoMap;
    }
    public List<CityTransport> findCityTransportByName(CityNames menu) {
        return cityRepository.findCityTransportByName(menu);
    }
    public List<CityWeather> findCityWeatherByName(CityNames menu) {
        return cityRepository.findCityWeatherByName(menu);
    }
}
