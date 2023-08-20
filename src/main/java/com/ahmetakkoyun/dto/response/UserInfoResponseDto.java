package com.ahmetakkoyun.dto.response;

import com.ahmetakkoyun.repository.enums.EUserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfoResponseDto {

    private Long id;
    private String firstName;
    private String LastName;
    private String email;
    private String phone;
    private EUserType userType;

}
