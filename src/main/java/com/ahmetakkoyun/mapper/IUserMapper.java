package com.ahmetakkoyun.mapper;

import com.ahmetakkoyun.dto.request.UserSaveRequestDto;
import com.ahmetakkoyun.dto.request.UserUpdateRequestDto;
import com.ahmetakkoyun.dto.response.UserInfoResponseDto;
import com.ahmetakkoyun.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toUser(UserSaveRequestDto dto);

    @Mapping(target = "id", ignore = true)
    void updateUserFromDto(UserUpdateRequestDto dto, @MappingTarget User user);

    UserInfoResponseDto toUserResponseDto(User user);

    List<UserInfoResponseDto> toUserResponseDtos(List<User> userList);

}
