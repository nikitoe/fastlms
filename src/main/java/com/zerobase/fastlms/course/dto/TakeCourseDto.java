package com.zerobase.fastlms.course.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TakeCourseDto {

    Long id;
    long courseId;
    String userId;

    long payPrice; //결제금액
    String status; //상태(수강신청, 결재완료, 수강취소)

    LocalDateTime regDt;    // 신청일

    // Join
    String userName;
    String phone;
    String subject;

    long totalCount;
    long seq;

    public String getRegDtText(){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return regDt != null ? regDt.format(formatter) : "";
    }

}
