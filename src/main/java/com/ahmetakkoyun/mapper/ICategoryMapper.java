package com.ahmetakkoyun.mapper;


import com.ahmetakkoyun.dto.request.CategorySaveRequestDto;
import com.ahmetakkoyun.dto.request.UserSaveRequestDto;
import com.ahmetakkoyun.repository.entity.Category;
import com.ahmetakkoyun.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryMapper {

    ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);

    Category toCategory(CategorySaveRequestDto dto);




}
