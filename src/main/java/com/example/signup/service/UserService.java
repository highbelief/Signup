package com.example.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.example.signup.model.User;
import com.example.signup.model.UserDTO;
import com.example.signup.repository.UserRepository;

/**
 * UserService는 사용자 관리에 대한 비즈니스 로직을 처리하는 서비스 클래스입니다.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 사용자 정보를 데이터베이스에 저장하는 메소드입니다.
     * 동일한 아이디가 이미 존재하면 회원가입 실패.
     *
     * @param userDTO 사용자 정보를 담고 있는 DTO 객체
     * @return 성공 시 저장된 사용자 정보가 담긴 DTO 객체, 실패 시 null
     */
    public UserDTO createUser(UserDTO userDTO) {
        // 이미 동일한 아이디가 존재하는지 확인
        if (userRepository.existsById(userDTO.getUsername())) {
            return null; // 이미 존재하는 아이디이므로 실패 반환
        }

        // 새로운 사용자 생성 및 저장
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return userDTO;
    }

    /**
     * 사용자 아이디를 통해 사용자를 조회하는 메소드입니다.
     *
     * @param username 조회할 사용자의 아이디
     * @return 해당 사용자 객체를 Optional로 반환
     */
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findById(username);
    }

    /**
     * 사용자 정보를 업데이트하는 메소드입니다.
     *
     * @param userDTO 업데이트할 사용자 정보가 담긴 DTO 객체
     * @return 업데이트된 사용자 정보가 담긴 DTO 객체
     */
    public UserDTO updateUser(UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(userDTO.getUsername());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            userRepository.save(user);
            return userDTO;
        }
        return null;
    }

    /**
     * 사용자 아이디를 통해 사용자를 삭제하는 메소드입니다.
     *
     * @param username 삭제할 사용자의 아이디
     * @return 성공 시 true, 실패 시 false 반환
     */
    public boolean deleteUser(String username) {
        if (userRepository.existsById(username)) {
            userRepository.deleteById(username);
            return true;
        }
        return false;
    }
}
