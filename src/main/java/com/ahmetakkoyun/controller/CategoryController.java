package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.dto.request.CategorySaveRequestDto;
import com.ahmetakkoyun.repository.entity.Category;
import com.ahmetakkoyun.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.ahmetakkoyun.constant.RestApiUrl.*;

@RestController
@RequestMapping(CATEGORY)
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    // Tüm kategorileri listeler.
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Category> categoryList = categoryService.findAll();
        if (categoryList==null || categoryList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı");
        }
        return ResponseEntity.ok(categoryList);
    }

    // Belirli bir kategorinin detaylarını getirir.
    @GetMapping("/{categoryId}")
    public ResponseEntity<?> findById(Long categoryId){
        Optional<Category> category = categoryService.findById(categoryId);
        if (category.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Kullanıcı bulunamadı");
        }
        return ResponseEntity.ok(category);
    }

    // Yeni bir kategori oluşturur.
    @PostMapping
    public ResponseEntity<?> save(@RequestBody CategorySaveRequestDto dto) {
        try{
            categoryService.save(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Kategori başarıyla oluşturuldu.");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu: " + e.getMessage());
        }
    }






    // Belirli bir kategorinin bilgilerini günceller.
//    @PutMapping("/{categoryId}")
//    public ResponseEntity<Category> updateById(Long categoryId){
//        return ResponseEntity.ok(categoryService.updateById(categoryId));
//    }






    // Belirli bir kategoriyi siler.
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<?> deleteById(Long categoryId){
        try{
            categoryService.deleteById(categoryId);
            return ResponseEntity.status(HttpStatus.OK).body(categoryId+" id numaralı kategori başarıyla silindi.");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bir hata oluştu: " + e.getMessage());
        }
    }

}
