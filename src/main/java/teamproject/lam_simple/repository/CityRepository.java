package teamproject.lam_simple.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import teamproject.lam_simple.constants.CategoryConstants.CityNames;
import teamproject.lam_simple.constants.CategoryConstants.Month;
import teamproject.lam_simple.domain.City;
import teamproject.lam_simple.domain.CityInfo;
import teamproject.lam_simple.domain.CityTransport;
import teamproject.lam_simple.domain.CityWeather;

import javax.persistence.EntityManager;
import java.util.List;

import static teamproject.lam_simple.constants.CategoryConstants.*;

@Repository
@RequiredArgsConstructor
public class CityRepository{

    private final EntityManager em;

    public List<CityInfo> findCityInfoByCategory(CityInfoCategory category){
        return em.createQuery("select c from CityInfo c where c.cityInfoCategory = :category", CityInfo.class)
                .setParameter("category", category)
                .getResultList();
    }
    public List<CityInfo> findCityInfoByName(CityNames name){
        return em.createQuery("select c from CityInfo c where c.city.name = :name", CityInfo.class)
                .setParameter("name", name)
                .getResultList();
    }
    public List<CityTransport> findCityTransportByName(CityNames name){
        return em.createQuery("select c from CityTransport c where c.city.name = :name", CityTransport.class)
                .setParameter("name", name)
                .getResultList();
    }
    public List<CityWeather> findCityWeatherByName(CityNames name){
        return em.createQuery("select c from CityWeather c where c.city.name = :name", CityWeather.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<CityWeather> getAVGTempList(Month month) {
        return em.createQuery("select c from CityWeather c where c.month = :month", CityWeather.class)
                .setParameter("month", month)
                .getResultList();
    }

    public List<CityTransport> findCityTransportById(Long id) {
        return em.createQuery("select c from CityTransport c where c.city.id = :id", CityTransport.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<City> findAll() {
        return em.createQuery("select c from City c", City.class)
                .getResultList();
    }
}
