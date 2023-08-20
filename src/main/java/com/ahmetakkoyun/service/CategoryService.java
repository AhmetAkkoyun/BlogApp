package com.ahmetakkoyun.service;

import com.ahmetakkoyun.mapper.ICategoryMapper;
import com.ahmetakkoyun.repository.ICategoryRepository;
import com.ahmetakkoyun.repository.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ICategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> findById(Long categoryId){
        return categoryRepository.findById(categoryId);
    }

    public Category save (Category category) {
        Category newCategory = ICategoryMapper.INSTANCE.toCategory(category);
        return categoryRepository.save(newCategory);
    }


//    public Categories updateById(Long categoryId){
//        return categoryRepository.updateById(categoryId);
//    }

    public void deleteById(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }

}
