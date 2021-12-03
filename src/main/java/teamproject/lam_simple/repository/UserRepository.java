package teamproject.lam_simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teamproject.lam_simple.domain.User;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    Optional<User> findById(Long Id);

    Boolean existsByEmail(String email);

    Boolean existsByLoginId(String loginId);

    Boolean existsByNickname(String nickname);
}
