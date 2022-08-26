package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.course.model.ServiceResult;

import java.util.List;

public interface BannerService {

    /**
     * 배너 목록(관리자)
     */
    List<BannerDto> list(BannerParam parameter);

    /**
     * 배너 정보 등록(관리자)
     */
    ServiceResult add(BannerInput parameter);

    /**
     * 배너 정보 삭제(관리자)
     */
    boolean del(String idList);
}
