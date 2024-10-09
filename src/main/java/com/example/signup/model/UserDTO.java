package com.example.signup.model;

/**
 * UserDTO는 사용자 데이터를 전달하기 위한 클래스입니다.
 * 클라이언트와 서버 간에 데이터를 주고받을 때 사용됩니다.
 */
public class UserDTO {
    private String username; // 사용자 아이디
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
