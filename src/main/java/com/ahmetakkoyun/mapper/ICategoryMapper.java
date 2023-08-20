package com.ahmetakkoyun.mapper;

import com.ahmetakkoyun.dto.request.CategorySaveRequestDto;
import com.ahmetakkoyun.dto.request.CategoryUpdateRequestDto;
import com.ahmetakkoyun.repository.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryMapper {

    ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);

    Category toCategory(CategorySaveRequestDto dto);

    @Mapping(target = "id", ignore = true)
    void updateCategoryFromDto(CategoryUpdateRequestDto dto, @MappingTarget Category category);

}
