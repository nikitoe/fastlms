package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.course.model.ServiceResult;

public interface BannerService {

    /**
     * 배너 정보 등록
     */
    ServiceResult add(BannerInput parameter);
}
