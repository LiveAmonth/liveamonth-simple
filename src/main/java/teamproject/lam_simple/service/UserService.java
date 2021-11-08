package teamproject.lam_simple.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import teamproject.lam_simple.domain.User;
import teamproject.lam_simple.dto.UserForm;
import teamproject.lam_simple.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
