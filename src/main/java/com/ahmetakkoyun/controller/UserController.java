package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.dto.request.UserSaveRequestDto;
import com.ahmetakkoyun.dto.request.UserUpdateRequestDto;
import com.ahmetakkoyun.repository.entity.User;
import com.ahmetakkoyun.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
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
    public ResponseEntity<?> findAll() {
        List<User> userList = userService.findAll();
        if (userList == null || userList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı");
        }
        return ResponseEntity.ok(userList);
    }

    // Belirli bir kullanıcının detaylarını getirir.
    @GetMapping("/{userId}")
    public ResponseEntity<?> findById(Long userId) {
        Optional<User> user = userService.findById(userId);
        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı");
        }
        return ResponseEntity.ok(user);
    }

    // Yeni bir kullanıcı oluşturur.
    @PostMapping
    public ResponseEntity<?> save (@RequestBody UserSaveRequestDto dto){
        try{
            userService.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Kullanıcı başarıyla oluşturuldu.");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu: "+e.getMessage());
        }
    }

    // Belirli bir kullanıcının bilgilerini günceller.
    @PutMapping("/{userId}")
    public ResponseEntity<?> updateById(Long id, @RequestBody UserUpdateRequestDto updatedUser) {
        try {
            User savedUser = userService.updateById(id, updatedUser);
            return new ResponseEntity(savedUser, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity("Kullanıcı bulunamadı", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity("Kullanıcı güncellenemedi", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Belirli bir kullanıcıyı siler.
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteById(Long userId){
        try{
            userService.deleteById(userId);
            return ResponseEntity.status(HttpStatus.OK).body(userId+" id numaralı kullanıcı başarıyla silindi.");
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu: "+e.getMessage());
        }
    }
}
