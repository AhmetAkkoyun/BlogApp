package com.ahmetakkoyun.controller;


import java.util.List;
import java.util.Optional;

import com.ahmetakkoyun.dto.request.PostSaveRequestDto;
import com.ahmetakkoyun.repository.entity.Post;
import com.ahmetakkoyun.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.ahmetakkoyun.constant.RestApiUrl.*;

@RestController
@RequestMapping(POST)
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // Tüm yazıları listeler.
    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok(postService.findAll());
    }

    // Belirli bir yazının detaylarını getirir.
    @GetMapping("/{postId}")
    public ResponseEntity<Optional<Post>> findById(Long postId){
        return ResponseEntity.ok(postService.findById(postId));
    }

    // Yeni bir yazı oluşturur.
    @PostMapping
    public ResponseEntity<?> save (@RequestBody PostSaveRequestDto dto){
        try {
            return ResponseEntity.ok(postService.save(dto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu: " + e.getMessage());
        }
    }

    // Belirli bir yazının bilgilerini günceller.
//    @PutMapping("/{postId}")
//    public Post updateById(Long postId){
//        return postService.updateById(postId);
//    }

    // Belirli bir yazıyı siler.
    @DeleteMapping("/{postId}")
    public void deleteById(Long postId){
        postService.deleteById(postId);
    }

    // Belirli bir kullanıcının yazılarını listeler.
    @GetMapping("/user/{userId}")
    public List<Post> findPostByUserId(Long userId){
        return postService.findPostsByUserId(userId);
    }

    // Belirli bir kategoriye ait yazıları listeler.
    @GetMapping("/category/{categoryId}")
    public List<Post> findPostByCategoryId(Long categoryId){
        return postService.findPostsByCategoryId(categoryId);
    }


    // BU AŞAĞIDAKİ İKİSİNE TEKRAR BAK!!!!

    //  Belirli bir kelimeye göre yazıları arar.
    @GetMapping("/search")
    public List<Post> findPostsByContentContainingIgnoreCase(String value){
        return postService.findPostsByContentContainingIgnoreCase(value);
    }

    // Belirli bir kategoriye ait yazıları getirir.
    @GetMapping("/category")
    public List<Post> getPostsByCategoryName(String categoryName){
        return postService.getPostsByCategoryName(categoryName);
    }
}
