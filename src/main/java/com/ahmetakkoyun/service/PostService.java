package com.ahmetakkoyun.service;

import com.ahmetakkoyun.dto.request.PostSaveRequestDto;
import com.ahmetakkoyun.dto.request.PostUpdateRequestDto;
import com.ahmetakkoyun.mapper.IPostMapper;
import com.ahmetakkoyun.repository.IPostRepository;
import com.ahmetakkoyun.repository.entity.Category;
import com.ahmetakkoyun.repository.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final IPostRepository postRepository;
    private final CategoryService categoryService;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(Long postId){
        return postRepository.findById(postId);
    }

    public Post save(PostSaveRequestDto dto) {
        Post newPost = IPostMapper.INSTANCE.toPost(dto);
        return postRepository.save(newPost);
    }

    public Post updateById(Long id, PostUpdateRequestDto updatedPost) {
        Post existingPost = (postRepository.findById(id)).get();
        IPostMapper.INSTANCE.updatePostFromDto(updatedPost, existingPost);
        return postRepository.save(existingPost);
    }

    public void deleteById(Long postId){
        postRepository.deleteById(postId);
    }

    public List<Post> findPostsByUserId(Long userId){
        return postRepository.findPostsByUserId(userId);
    }

    public List<Post> findPostsByCategoryId(Long categoryId){
        return postRepository.findPostsByCategoryId(categoryId);
    }

    public List<Post> findPostsByContentContainingIgnoreCase(String value){
        return postRepository.findPostsByContentContainingIgnoreCase(value);
    }

    public List<Post> getPostsByCategoryName(String categoryName){
        return postRepository.getPostsByCategoryName(categoryName);
    }

    public List<Post> getPostsByOrderByPublishedAt(){
        return postRepository.getPostsByOrderByPublishedAt();
    }

    public List<Post> getPostsByOrderByPublishedAtDesc(){
        return postRepository.getPostsByOrderByPublishedAtDesc();
    }

    public List<Post> getPostsByCategoryNames(String categoryNames) {
        List<Category> categories = parseCategoryNames(categoryNames);
        List<Long> categoryIdList = categories.stream().map(Category::getId).collect(Collectors.toList());
        return postRepository.findByCategoryIdListContaining(categoryIdList);
    }

    private List<Category> parseCategoryNames(String categoryNames) {
        List<Category> categories = new ArrayList<>();

        // Virgülle ayrılmış kategori isimlerini ayrıştırarak Category nesnelerini bulma
        String[] categoryNameArray = categoryNames.split(",");
        for (String categoryName : categoryNameArray) {
            String trimmedCategoryName = categoryName.trim(); // Boşlukları kaldır
            Category category = categoryService.findByName(trimmedCategoryName);
            if (category != null) {
                categories.add(category);
            }
        }
        return categories;
    }
    public List<Post> getPostsByUserId(Long userId){
        return postRepository.getPostsByUserId(userId);
    }
}
