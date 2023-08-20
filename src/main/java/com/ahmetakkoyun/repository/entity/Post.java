package com.ahmetakkoyun.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    @Builder.Default
    private LocalDate publishedAt =LocalDate.now();

    private String userId;

    @ElementCollection
    private List<Long> categoryId;

    @ElementCollection
    private Set<Long> comments;

    @ElementCollection
    private Set<Long> likes;

    @ElementCollection
    private Set<Long> dislikes;

}



