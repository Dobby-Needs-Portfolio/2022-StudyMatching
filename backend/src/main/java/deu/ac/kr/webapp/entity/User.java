package deu.ac.kr.webapp.entity;

import deu.ac.kr.webapp.enums.Gender;
import deu.ac.kr.webapp.enums.UserRole;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * 사용자 정보를 저장하는 User Entity입니다.
 *
 * @author Mina-1316
 */
@Entity
@Table(name = "user")
@Getter
@Builder
@AllArgsConstructor
@Setter
@RequiredArgsConstructor
public class User {
  /**
   * User 엔티티의 Primary Key입니다. 자동으로 생성되며, 대부분의 API에서 이 ID를 통해 접근합니다.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(nullable = false, updatable = false)
  private Long id;

  /**
   * User 엔티티의 사용자명 필드입니다.
   */
  @Column(nullable = false)
  private String username;

  /**
   * User 엔티티의 이메일 필드입니다. 로그인 시 해당 필드를 통해 사용자를 검색합니다.
   */
  @Setter(AccessLevel.NONE)
  @Column(nullable = false, updatable = false)
  private String email;

  /**
   * User 엔티티의 비밀번호 필드입니다. 로그인 시 해당 필드를 검사합니다.
   */
  @Column(nullable = false)
  private String password;

  /**
   * User 엔티티의 사용자 권한 필드입니다.
   *
   * @see UserRole
   */
  @Column(nullable = false)
  private UserRole role;

  /**
   * 최근 로그인 시간을 저장하는 필드입니다.
   */
  @Column
  private LocalDateTime lastLogin;

  /**
   * 사용자의 생성 일자를 저장하는 필드입니다.
   */
  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt;

  /**
   * 사용자의 직업을 저장하는 필드입니다. Null을 입력받을 수도 있습니다.
   */
  private String job;

  /**
   * 사용자의 성별을 저장하는 필드입니다.
   *
   * @see deu.ac.kr.webapp.enums.Gender
   */
  @Column(nullable = false)
  private Gender gender;

  /**
   * 퍼시스트 직전(DB 물리 계증에 입력되기 전)에 실행됩니다.
   * <p>createdAt 필드를 자동으로 생성합니다.</p>
   */
  @PrePersist
  public void createdAt() {
    this.createdAt = LocalDateTime.now();
  }

}