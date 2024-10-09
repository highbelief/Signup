package com.example.signup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * User 엔티티는 데이터베이스의 사용자 테이블과 매핑됩니다.
 * 각 사용자의 아이디, 이름, 이메일, 비밀번호 정보를 포함합니다.
 */
@Entity
public class User {
    @Id
    private String username; // 사용자 아이디 (기본 키)
    private String name;     // 사용자 이름
    private String email;    // 사용자 이메일
    private String password; // 사용자 비밀번호

    // Getter와 Setter 메소드
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
