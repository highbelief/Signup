package com.example.signup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.signup.model.UserDTO;
import com.example.signup.service.UserService;

/**
 * UserController는 사용자와 관련된 REST API를 제공하는 컨트롤러입니다.
 * 사용자 생성, 조회, 업데이트, 삭제 기능을 담당합니다.
 */
@CrossOrigin(origins = "http://localhost:63342") // 클라이언트 도메인 허용
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 새로운 사용자를 생성하는 API 엔드포인트입니다.
     *
     * @param userDTO 사용자 정보를 담고 있는 DTO 객체
     * @return 생성된 사용자 정보가 담긴 DTO 객체 또는 회원가입 실패 메시지
     */
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);

        if (createdUser == null) {
            // 아이디 중복으로 인해 회원가입 실패
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("이미 존재하는 아이디입니다.");
        }

        // 회원가입 성공
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("회원가입이 성공적으로 완료되었습니다.");
    }

    /**
     * 사용자 아이디를 통해 사용자를 조회하는 API 엔드포인트입니다.
     *
     * @param username 조회할 사용자의 아이디
     * @return 조회된 사용자 객체 또는 404 Not Found 메시지
     */
    @GetMapping("/{username}")
    public ResponseEntity<Object> getUser(@PathVariable String username) {
        return userService.getUserByUsername(username)
                .map(user -> ResponseEntity.ok().body((Object) user))  // 성공 시 User 객체를 Object로 변환
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다."));  // 실패 시 String 메시지 반환
    }


    /**
     * 사용자 정보를 업데이트하는 API 엔드포인트입니다.
     *
     * @param userDTO 업데이트할 사용자 정보가 담긴 DTO 객체
     * @return 업데이트된 사용자 정보를 담은 DTO 객체 또는 404 Not Found
     */
    @PutMapping("/update")
    public ResponseEntity<Object> updateUser(@RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(userDTO);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);  // 성공 시 업데이트된 User 정보 반환
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다.");
    }

    /**
     * 사용자 아이디를 통해 사용자를 삭제하는 API 엔드포인트입니다.
     *
     * @param username 삭제할 사용자의 아이디
     * @return 성공 시 200 OK, 실패 시 404 Not Found
     */
    @DeleteMapping("/{username}")
    public ResponseEntity<Object> deleteUser(@PathVariable String username) {
        if (userService.deleteUser(username)) {
            return ResponseEntity.ok("사용자 삭제가 완료되었습니다.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("사용자를 찾을 수 없습니다.");
    }

    /**
     * 사용자 아이디 중복을 확인하는 API 엔드포인트입니다.
     *
     * @param username 중복 확인할 사용자 아이디
     * @return 중복이 존재하면 true, 존재하지 않으면 false 반환
     */
    @GetMapping("/check-duplicate")
    public ResponseEntity<Boolean> checkDuplicate(@RequestParam String username) {
        boolean exists = userService.getUserByUsername(username).isPresent();
        return ResponseEntity.ok(exists);
    }

}
