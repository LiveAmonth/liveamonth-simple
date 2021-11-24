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

    public Map<String, Object> findCityInfoByName(CityNames menu) {
        City city = cityRepository.findAllCityInfoWithGraphByName(menu);
        List<CityInfo> cityInfos = city.getCityInfos();
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
        cityInfoMap.put("cityTransports", city.getCityTransports());
        cityInfoMap.put("cityWeathers", city.getCityWeathers());
        return cityInfoMap;
    }
}
