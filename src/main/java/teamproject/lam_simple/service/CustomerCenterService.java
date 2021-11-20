package teamproject.lam_simple.service;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamproject.lam_simple.repository.CustomerCenterRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerCenterService {
    private final CustomerCenterRepository customerCenterRepository;


}
