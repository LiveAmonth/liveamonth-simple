package teamproject.lam_simple.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import teamproject.lam_simple.constants.CategoryConstants;
import teamproject.lam_simple.domain.User;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("회원이 DB에 저장이 잘되는지 확인")
    void saveUser(){
        // given
        String loginId = "testAdmin";
        User user = User.builder()
                .loginId(loginId)
                .name("text")
                .nickname("test")
                .birth(java.sql.Date .valueOf("2020-06-22"))
                .genderTypes(CategoryConstants.GenderTypes.FEMALE)
                .email("test@test.com")
                .password("testData!!").build();

        // when
        User savedUser = userRepository.save(user);

        // then
        assertEquals(loginId, savedUser.getLoginId());
    }

    @Test
    @DisplayName("저장된 회원이 제대로 조회되는지 확인")
    void findUser() {
        // given
        String loginId = "testAdmin";
        User user = User.builder()
                .loginId(loginId)
                .name("text")
                .nickname("test")
                .birth(java.sql.Date.valueOf("2020-06-22"))
                .genderTypes(CategoryConstants.GenderTypes.FEMALE)
                .email("test@test.com")
                .password("testData!!").build();
        User savedUser = userRepository.save(user);

        // when
        User findUser = userRepository.findById(savedUser.getId())
                .orElseThrow(() -> new IllegalArgumentException("Wrong MemberId:<" + savedUser.getId() + ">"));

        // then
        Assertions.assertThat(findUser.getName()).isEqualTo("text");
        Assertions.assertThat(findUser.getEmail()).isEqualTo("test@test.com");
    }
}