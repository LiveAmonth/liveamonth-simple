package teamproject.lam_simple.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.constants.CategoryConstants.CityWeatherMonth;
import teamproject.lam_simple.domain.*;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class CityRepository{

    private final EntityManager em;

    public List<CityInfo> findCityInfoByCategory(String category){
        return em.createQuery("select c from CityInfo c where c.cityInfoCategory = :category", CityInfo.class)
                .setParameter("category", category)
                .getResultList();
    }

    public List<CityWeather> getAVGTempList(CityWeatherMonth month) {
        return em.createQuery("select c from CityWeather c where c.cityWeatherMonth = :month", CityWeather.class)
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
