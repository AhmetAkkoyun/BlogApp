package com.ahmetakkoyun.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSaveRequestDto {

    private String name;
    private String surName;
    private String password;
    private String email;

}
