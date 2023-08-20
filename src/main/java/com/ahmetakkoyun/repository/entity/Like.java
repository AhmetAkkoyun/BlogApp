package com.ahmetakkoyun.repository.entity;

import com.ahmetakkoyun.repository.enums.ELikeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Builder.Default
    @Enumerated
    private ELikeStatus status = ELikeStatus.NO_STATUS;

    @Builder.Default
    private LocalDate date = LocalDate.now();

    private Long userId;

    private Long postId;

    // yorumu beğenmek için
    private Long commentId;
}
