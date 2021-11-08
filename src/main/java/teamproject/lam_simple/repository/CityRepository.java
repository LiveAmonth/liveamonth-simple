package teamproject.lam_simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teamproject.lam_simple.domain.City;
import teamproject.lam_simple.domain.User;

public interface CityRepository extends JpaRepository<City,Long> {
}
