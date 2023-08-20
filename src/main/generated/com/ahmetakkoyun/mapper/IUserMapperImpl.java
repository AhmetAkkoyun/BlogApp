package com.ahmetakkoyun.mapper;

import com.ahmetakkoyun.dto.request.UserSaveRequestDto;
import com.ahmetakkoyun.dto.request.UserUpdateRequestDto;
import com.ahmetakkoyun.dto.response.UserInfoResponseDto;
import com.ahmetakkoyun.repository.entity.User;
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
public class IUserMapperImpl implements IUserMapper {

    @Override
    public User toUser(UserSaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( dto.getFirstName() );
        user.lastName( dto.getLastName() );
        user.email( dto.getEmail() );
        user.password( dto.getPassword() );

        return user.build();
    }

    @Override
    public void updateUserFromDto(UserUpdateRequestDto dto, User user) {
        if ( dto == null ) {
            return;
        }

        user.setFirstName( dto.getFirstName() );
        user.setLastName( dto.getLastName() );
        user.setEmail( dto.getEmail() );
        user.setPassword( dto.getPassword() );
    }

    @Override
    public UserInfoResponseDto toUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserInfoResponseDto.UserInfoResponseDtoBuilder userInfoResponseDto = UserInfoResponseDto.builder();

        userInfoResponseDto.id( user.getId() );
        userInfoResponseDto.firstName( user.getFirstName() );
        userInfoResponseDto.email( user.getEmail() );
        userInfoResponseDto.userType( user.getUserType() );

        return userInfoResponseDto.build();
    }

    @Override
    public List<UserInfoResponseDto> toUserResponseDtos(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserInfoResponseDto> list = new ArrayList<UserInfoResponseDto>( userList.size() );
        for ( User user : userList ) {
            list.add( toUserResponseDto( user ) );
        }

        return list;
    }
}
