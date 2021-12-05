package teamproject.lam_simple.repository;

import org.springframework.stereotype.Repository;
import teamproject.lam_simple.constants.CategoryConstants.CityNames;
import teamproject.lam_simple.domain.City;
import teamproject.lam_simple.domain.CityInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static teamproject.lam_simple.constants.AttrConstants.*;
import static teamproject.lam_simple.constants.CategoryConstants.CityInfoCategory;

@Repository
public class CityRepository {

    @PersistenceContext
    private EntityManager em;

    public List<CityInfo> findCityInfoByCategory(CityInfoCategory category) {
        return em.createQuery("select c from CityInfo c where c.cityInfoCategory = :category", CityInfo.class)
                .setParameter(CATEGORY, category)
                .setHint(JAVAX_PER_FG, em.getEntityGraph(CITYINFO_WITH_CITY))
                .getResultList();
    }

    public City findWithGraphByName(CityNames name, String graphName) {
        return em.createQuery("select c from City c where c.name =: name", City.class)
                .setParameter(NAME, name)
                .setHint(JAVAX_PER_FG, em.getEntityGraph(graphName))
                .getSingleResult();
    }

    public City findAllCityInfoWithGraphByName(CityNames name) {
        return em.createQuery("select c from City c where c.name =: name", City.class)
                .setParameter(NAME, name)
                .setHint(JAVAX_PER_FG, CITY_WITH_CITYINFOS)
                .setHint(JAVAX_PER_FG, CITY_WITH_CITYWEATHERS)
                .setHint(JAVAX_PER_FG, CITY_WITH_CITYTRANSPORTS)
                .getSingleResult();
    }

    public List<City> findAll() {
        return em.createQuery("select c from City c", City.class)
                .getResultList();
    }
}
