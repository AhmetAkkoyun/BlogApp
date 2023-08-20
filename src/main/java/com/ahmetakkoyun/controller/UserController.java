package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.dto.request.UserSaveRequestDto;
import com.ahmetakkoyun.repository.entity.User;
import com.ahmetakkoyun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.ahmetakkoyun.constant.RestApiUrl.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Tüm kullanıcıları listeler.
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    // Belirli bir kullanıcının detaylarını getirir.
    @GetMapping("/{userId}")
    public ResponseEntity<Optional<User>> findById(Long userId){
        return ResponseEntity.ok(userService.findById(userId));
    }

    // Yeni bir kullanıcı oluşturur.
    @PostMapping
    public ResponseEntity<User> save (@RequestBody UserSaveRequestDto dto){
        return ResponseEntity.ok(userService.save(dto));
    }

    // Belirli bir kullanıcının bilgilerini günceller.
//    @PutMapping("/{userId}")
//    public ResponseEntity<Users> updateById(Long userId){
//        return ResponseEntity.ok(usersService.updateById(userId));
//    }

    // Belirli bir kullanıcıyı siler.
    @DeleteMapping("/{userId}")
    public void deleteById(Long userId){
        userService.deleteById(userId);
    }

}