package teamproject.lam_simple.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import teamproject.lam_simple.domain.User;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LoginRepositoryTest {
    @Autowired
    private LoginRepository loginRepository;

    @Test
    void 비밀번호_변경_테스트(){
        // given
        String testPW = "test!";
        final User user = loginRepository.findUserByLoginId("leeky").orElse(null);

        // when
        final int changedValueCount = loginRepository.editPassword(user, testPW);

        // that
        assertEquals(changedValueCount,1);
    }



}