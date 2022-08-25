package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.member.entity.MemberLoginHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginHistoryDto {

    Long id;

    LocalDateTime loginDt;
    String ipAddr;
    String userAgent;
    String userId;


    long totalCount;
    long seq;


    public static MemberLoginHistoryDto of(MemberLoginHistory memberLogHis) {
        return MemberLoginHistoryDto.builder()
                .id(memberLogHis.getId())
                .loginDt(memberLogHis.getLoginDt())
                .ipAddr(memberLogHis.getIpAddr())
                .userAgent(memberLogHis.getUserAgent())
                .userId(memberLogHis.getUserId())
                .build();
    }

    public String getLoginDtText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return loginDt != null ? loginDt.format(formatter) : "";
    }
}
