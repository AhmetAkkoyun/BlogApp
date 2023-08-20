package com.ahmetakkoyun.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostUpdateRequestDto {
    private String title;
    private String content;
    @ElementCollection
    private List<Long> categoryId;
}
