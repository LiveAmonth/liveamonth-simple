package teamproject.lam_simple.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CustomerCenterRepository {
    private final EntityManager em;
}
