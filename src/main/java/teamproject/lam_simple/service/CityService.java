package teamproject.lam_simple.service;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamproject.lam_simple.domain.CityInfo;
import teamproject.lam_simple.repository.CityRepository;

import java.util.Collections;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class CityService {
    private final CityRepository cityRepository;

    public List<CityInfo> getRandomCityInfo(String category) {
        List<CityInfo> cityInfos = cityRepository.findCityInfoByCategory(category);
        Collections.shuffle(cityInfos);
        return cityInfos;
    }

}
