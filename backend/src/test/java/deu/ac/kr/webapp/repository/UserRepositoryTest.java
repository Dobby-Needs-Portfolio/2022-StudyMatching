package deu.ac.kr.webapp.repository;

import static org.assertj.core.api.Assertions.assertThat;

import deu.ac.kr.webapp.configuration.annotate.RepositoryJpaTestEnvironment;
import deu.ac.kr.webapp.entity.User;
import deu.ac.kr.webapp.enums.Gender;
import deu.ac.kr.webapp.enums.UserRole;
import java.util.Optional;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Test for UserRepository and User entity class.
 *
 * @author Mina-1316
 * @see UserRepository
 * @see User
 */
@Log4j2
@RepositoryJpaTestEnvironment
@DisplayName("[REPOSITORY] UserRepository Test")
public class UserRepositoryTest {
  @Autowired
  UserRepository userRepository;

  @PersistenceContext
  private EntityManager entityManager;

  @Test
  @DisplayName("[save] 유저 저장 테스트")
  public void save() {
    // Given
    User testUser = User.builder()
        .username("test_user")
        .email("asdf@asdf.com")
        .gender(Gender.Etc)
        .job("job1")
        .password("password")
        .role(UserRole.USER).build();

    // When
    User savedUser = userRepository.save(testUser);

    // Then
    assertThat(entityManager.contains(savedUser)).isTrue();
    assertThat(savedUser.getId()).isNotNull();
  }

  @Test
  @DisplayName("[find] ID를 통한 유저 조회 테스트(성공)")
  public void findById_success() {
    // Given
    User savedUser = User.builder()
        .username("test_user")
        .email("asdf@asdf.com")
        .gender(Gender.Etc)
        .job("job1")
        .password("password")
        .role(UserRole.USER).build();

    entityManager.persist(savedUser);

    // When
    Optional<User> searchedUser = userRepository.findById(savedUser.getId());

    // Then
    assertThat(searchedUser.isPresent()).isTrue();
    assertThat(searchedUser.get()).usingRecursiveComparison().isEqualTo(savedUser);
  }

  @Test
  @DisplayName("[find] ID를 통한 유저 조회 테스트(실패)")
  public void findById_fail() {
    // Given
    // When
    Optional<User> expectEmpty = userRepository.findById(new Random().nextLong());

    // Then
    assertThat(expectEmpty.isPresent()).isFalse();
  }

  @Test
  @DisplayName("[delete] 유저 삭제 테스트")
  public void userDeletion() {
    // Given
    User savedUser = User.builder()
        .username("test_user")
        .email("asdf@asdf.com")
        .gender(Gender.Etc)
        .job("job1")
        .password("password")
        .role(UserRole.USER).build();

    entityManager.persist(savedUser);
    assertThat(entityManager.contains(savedUser)).isTrue();

    // When
    userRepository.delete(savedUser);

    // Then
    assertThat(entityManager.contains(savedUser)).isFalse();
  }

  @Test
  @DisplayName("[find] Username을 통한 유저 검색 테스트(성공)")
  public void findByUsername_success() {
    // Given
    User savedUser = User.builder()
        .username("test_user")
        .email("asdf@asdf.com")
        .gender(Gender.Etc)
        .job("job1")
        .password("password")
        .role(UserRole.USER).build();

    entityManager.persist(savedUser);

    // When
    Optional<User> searchedUser = userRepository.findByUsername(savedUser.getUsername());

    // Then
    assertThat(searchedUser.isPresent()).isTrue();
    assertThat(searchedUser.get()).usingRecursiveComparison().isEqualTo(savedUser);
  }

  @Test
  @DisplayName("[find] Username을 통한 유저 검색 테스트(실패)")
  public void findByUsername_fail() {
    // Given
    User savedUser = User.builder()
        .username("do_not_search_this")
        .email("asdf@asdf.com")
        .gender(Gender.Etc)
        .job("job1")
        .password("password")
        .role(UserRole.USER).build();

    entityManager.persist(savedUser);
    // When
    Optional<User> expectEmpty = userRepository.findByUsername("test_user");

    // Then
    assertThat(expectEmpty.isPresent()).isFalse();
  }

  @Test
  @DisplayName("[find] Email을 통한 유저 검색 테스트(성공)")
  public void findByEmail_success() {
    // Given
    User savedUser = User.builder()
        .username("test_user")
        .email("asdf@asdf.com")
        .gender(Gender.Etc)
        .job("job1")
        .password("password")
        .role(UserRole.USER).build();

    entityManager.persist(savedUser);

    // When
    Optional<User> searchedUser = userRepository.findByEmail(savedUser.getEmail());

    // Then
    assertThat(searchedUser.isPresent()).isTrue();
  }

  @Test
  @DisplayName("[find] Email을 통한 유저 검색 테스트(실패)")
  public void findByEmail_fail() {
    // Given
    User savedUser = User.builder()
        .username("test_user")
        .email("do.not@find.com")
        .gender(Gender.Etc)
        .job("job1")
        .password("password")
        .role(UserRole.USER).build();

    entityManager.persist(savedUser);

    // When
    Optional<User> expectEmpty = userRepository.findByEmail("test_email@test.com");

    // Then
    assertThat(expectEmpty.isPresent()).isFalse();
  }
}
