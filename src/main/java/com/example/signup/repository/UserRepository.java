package com.example.signup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.signup.model.User;

/**
 * UserRepository는 JPA를 사용하여 데이터베이스에 접근하는 DAO(Data Access Object)입니다.
 * 기본적인 CRUD 기능을 제공합니다.
 */
public interface UserRepository extends JpaRepository<User, String> {
    // 사용자 정의 쿼리 메소드를 추가할 수 있습니다.
}
