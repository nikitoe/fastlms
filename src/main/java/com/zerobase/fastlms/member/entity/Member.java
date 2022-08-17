package com.zerobase.fastlms.member.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member implements MemberCode{

    @Id
    private String userId;

    private String userName;
    private String password;
    private String phone;
    private LocalDateTime regDt;

    private boolean emailAuthYn;
    private LocalDateTime emailAuthDt;
    private String emailAuthKey;

    private String resetPasswordKey;
    private LocalDateTime resetPasswordLimitDt;

    // 관리자여부를 지정할 것인지
    // 회원에 따른 ROLE을 지정할 것인지
    // 준회원/정회원/특별회원/관리자
    // ROLE_SEMI_USER/ROLE_USER/ROLE_SPECIAL_USER/ROLE_ADMIN

    private boolean adminYn;

    private String userStatus;  // 이용 가능 상태, 불가 상태


}
