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
    public ResponseEntity<?> findAll() {
        List<Post> postList = postService.findAll();
        if (postList == null || postList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı");
        }
        return ResponseEntity.ok(postList);
    }


    // Belirli bir yazının detaylarını getirir.
    @GetMapping("/{postId}")
    public ResponseEntity<?> findById(Long postId){
        Optional<Post> post = postService.findById(postId);
        if (post.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı");
        }
        return ResponseEntity.ok(post);
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
    public ResponseEntity<?> deleteById(Long postId){
        try {
            postService.deleteById(postId);
            return ResponseEntity.status(HttpStatus.OK).body(postId+" id numaralı blog içeriği başarıyla silindi.");
        }catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu: "+e.getMessage());
        }
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
