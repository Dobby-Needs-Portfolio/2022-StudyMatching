package deu.ac.kr.webapp.repository;

import deu.ac.kr.webapp.entity.User;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository for {@link User} entity. This repository is used to manage users.
 *
 * @version 1.0
 *
 * @author Mina-1316
 */
public interface UserRepository extends JpaRepository<User, Long> {
  /**
   * Finds user by email.
   *
   * @param email user's email
   * @return user entity or empty optional if not found
   */
  Optional<User> findByEmail(String email);

  /**
   * Finds user by username.
   *
   * @param username user's username
   * @return user entity or empty optional if not found
   */
  Optional<User> findByUsername(String username);

  /**
   * Finds user by id.
   *
   * @param id user's id
   * @return user entity or empty optional if not found
   */
  Optional<User> findById(Long id);

  /**
   * Finds all users.
   *
   * @param pageable pageable object for pagination
   * @return page of users
   */
  @Override
  Page<User> findAll(Pageable pageable);


}
