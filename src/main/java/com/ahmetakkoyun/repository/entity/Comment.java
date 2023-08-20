package com.ahmetakkoyun.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String content;

    @Builder.Default
    private LocalDate date = LocalDate.now();

    private Long userId;

    private Long postId;

    // yoruma yorum yazmak için.
    private Long commentId;

    @ElementCollection
    private Set<Long> comments;

    @ElementCollection
    private Set<Long> likes;

    @ElementCollection
    private Set<Long> dislikes;
}
