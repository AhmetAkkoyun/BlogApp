package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.mapper.ICategoryMapper;
import com.ahmetakkoyun.repository.entity.Category;
import com.ahmetakkoyun.service.CategoryService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    // Belirli bir kategorinin detaylarını getirir.
    @GetMapping("/{categoryId}")
    public ResponseEntity<Optional<Category>> findById(Long categoryId){
        return ResponseEntity.ok(categoryService.findById(categoryId));
    }

    // Yeni bir kategori oluşturur.
    @PostMapping
    public Category save(Category category) {
        return categoryService.save(category);
    }

    // Belirli bir kategorinin bilgilerini günceller.
//    @PutMapping("/{categoryId}")
//    public ResponseEntity<Category> updateById(Long categoryId){
//        return ResponseEntity.ok(categoryService.updateById(categoryId));
//    }

    // Belirli bir kategoriyi siler.
    @DeleteMapping("/{categoryId}")
    public void deleteById(Long categoryId){
        categoryService.deleteById(categoryId);
    }

}
