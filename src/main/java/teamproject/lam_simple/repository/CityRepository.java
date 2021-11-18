package teamproject.lam_simple.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamproject.lam_simple.domain.City;
import teamproject.lam_simple.domain.CityInfo;
import teamproject.lam_simple.domain.User;

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
}
