package com.ahmetakkoyun.repository;

import com.ahmetakkoyun.repository.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {

    List<Post> findPostsByUserId(Long userId);

    List<Post> findPostsByCategoryId(Long categoryId);

    List<Post> findPostsByContentContainingIgnoreCase(String value);

    @Query(
            value = "SELECT * FROM posts AS p " +
            "JOIN categories AS c ON p.categoryId = c.id " +
            "WHERE c.name=:x"
    ,nativeQuery = true)
    List<Post> getPostsByCategoryName(@Param("x") String categoryName);

    List<Post> getPostsByOrderByPublishedAt();

    List<Post> getPostsByOrderByPublishedAtDesc();

    @Query(
            value = "SELECT * FROM posts p " +
                    "JOIN categories c ON c.id = p.categoryId " +
                    "WHERE c.id IN :x"
            ,nativeQuery = true)
    List<Post> findByCategoryIdListContaining(@Param("x") List<Long> idList);

    List<Post> getPostsByUserId(Long userId);

}
