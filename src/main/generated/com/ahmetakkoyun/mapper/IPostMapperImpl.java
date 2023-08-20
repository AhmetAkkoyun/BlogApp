package com.ahmetakkoyun.mapper;

import com.ahmetakkoyun.dto.request.PostSaveRequestDto;
import com.ahmetakkoyun.dto.request.PostUpdateRequestDto;
import com.ahmetakkoyun.repository.entity.Post;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-20T21:52:41+0300",
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

    @Override
    public void updatePostFromDto(PostUpdateRequestDto dto, Post post) {
        if ( dto == null ) {
            return;
        }

        post.setTitle( dto.getTitle() );
        post.setContent( dto.getContent() );
        if ( post.getCategoryId() != null ) {
            List<Long> list = dto.getCategoryId();
            if ( list != null ) {
                post.getCategoryId().clear();
                post.getCategoryId().addAll( list );
            }
            else {
                post.setCategoryId( null );
            }
        }
        else {
            List<Long> list = dto.getCategoryId();
            if ( list != null ) {
                post.setCategoryId( new ArrayList<Long>( list ) );
            }
        }
    }
}
