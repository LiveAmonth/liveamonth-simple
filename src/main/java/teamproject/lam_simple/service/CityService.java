package teamproject.lam_simple.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teamproject.lam_simple.repository.CityRepository;
import teamproject.lam_simple.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
}
