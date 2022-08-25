package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.admin.dto.MemberLoginHistoryDto;
import com.zerobase.fastlms.admin.model.MemberParam;

import java.util.List;

public interface MemberLoginHistoryService {

    /**
     * 회원 로그인 히스토리 정보 목록
     */

    List<MemberLoginHistoryDto> selectList(MemberParam parameter);
}
