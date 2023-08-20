package com.ahmetakkoyun.service;

import com.ahmetakkoyun.dto.request.PostSaveRequestDto;
import com.ahmetakkoyun.mapper.IPostMapper;
import com.ahmetakkoyun.repository.IPostRepository;
import com.ahmetakkoyun.repository.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final IPostRepository postRepository;

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

//    public Post updateById(Long postId){
//        return postRepository.updateById(postId);
//    }

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
}
