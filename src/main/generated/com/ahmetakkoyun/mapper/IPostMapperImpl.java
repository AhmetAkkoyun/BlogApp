package com.ahmetakkoyun.mapper;

import com.ahmetakkoyun.dto.request.PostSaveRequestDto;
import com.ahmetakkoyun.repository.entity.Post;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-20T20:53:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class IPostMapperImpl implements IPostMapper {

    @Override
    public Post toPost(PostSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Post.PostBuilder post = Post.builder();

        post.title( dto.getTitle() );
        post.content( dto.getContent() );

        return post.build();
    }
}
