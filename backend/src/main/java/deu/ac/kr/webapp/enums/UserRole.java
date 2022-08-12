package deu.ac.kr.webapp.enums;

import deu.ac.kr.webapp.entity.User;
import lombok.AllArgsConstructor;

/**
 * 유저 권한을 관리하는 Enum 클래스입니다.
 *
 * @author Mina-1316
 * @see User
 */
@AllArgsConstructor
public enum UserRole {
  /**
   * 일반 사용자 권한입니다.
   */
  USER,
  /**
   * 멘토 사용자 권한입니다.
   */
  MENTOR,
  /**
   * 관리자 권한입니다.
   */
  ADMIN
}
