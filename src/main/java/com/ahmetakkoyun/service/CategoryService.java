package com.ahmetakkoyun.service;

import com.ahmetakkoyun.dto.request.CategorySaveRequestDto;
import com.ahmetakkoyun.dto.request.CategoryUpdateRequestDto;
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

    public Category save (CategorySaveRequestDto category) {
        Category newCategory = ICategoryMapper.INSTANCE.toCategory(category);
        return categoryRepository.save(newCategory);
    }

    public Category updateById(Long id, CategoryUpdateRequestDto updatedCategory) {
        Category existingCategory = (categoryRepository.findById(id)).get();
        ICategoryMapper.INSTANCE.updateCategoryFromDto(updatedCategory, existingCategory);
        return categoryRepository.save(existingCategory);
    }

    public void deleteById(Long categoryId){
        categoryRepository.deleteById(categoryId);
    }

}
