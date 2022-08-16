package com.zerobase.fastlms.admin.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDto {

    String userId;

    String userName;
    String password;
    String phone;
    LocalDateTime regDt;

    boolean emailAuthYn;
    LocalDateTime emailAuthDt;
    String emailAuthKey;

    String resetPasswordKey;
    LocalDateTime resetPasswordLimitDt;

    boolean adminYn;

    long totalCount;
    long seq;
}
