package com.ahmetakkoyun.mapper;

import com.ahmetakkoyun.dto.request.PostSaveRequestDto;
import com.ahmetakkoyun.dto.request.PostUpdateRequestDto;
import com.ahmetakkoyun.repository.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPostMapper {

    IPostMapper INSTANCE = Mappers.getMapper(IPostMapper.class);

    Post toPost(PostSaveRequestDto dto);

    @Mapping(target = "id", ignore = true)
    void updatePostFromDto(PostUpdateRequestDto dto, @MappingTarget Post post);

}
