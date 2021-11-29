package teamproject.lam_simple.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import teamproject.lam_simple.domain.User;
import teamproject.lam_simple.repository.LoginRepository;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;

    private final PasswordEncoder passwordEncoder;

    /**
     * @return null 로그인 실패
     */
    public User login(String loginId, String password) {
        return loginRepository.findUserByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
//        return loginRepository.findUserByLoginId(loginId)
//                .filter(m -> passwordEncoder.matches(password, m.getPassword()))
//                .orElse(null);
    }
}
