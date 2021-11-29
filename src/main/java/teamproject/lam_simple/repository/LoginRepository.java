package teamproject.lam_simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teamproject.lam_simple.domain.User;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByLoginId(String loginId);

}
