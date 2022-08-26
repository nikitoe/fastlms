package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import com.zerobase.fastlms.course.model.ServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;


    @Override
    public ServiceResult add(BannerInput parameter) {



        Optional<Banner> optionalBanner
                = bannerRepository.findById(parameter.getId());
        if(optionalBanner.isPresent()){
            return new ServiceResult(false, "해당 배너 정보가 중복으로 존재합니다.");
        }

        bannerRepository.save(Banner.builder()
                        .altText(parameter.getAltText())
                        .filename(parameter.getFilename())
                        .linkUrl(parameter.getLinkUrl())
                        .sortValue(parameter.getSortValue())
                        .target(parameter.getTarget())
                        .urlFilename(parameter.getUrlFilename())
                        .openYn(parameter.isOpenYn())
                        .regDt(LocalDateTime.now())
                        .build());

        return new ServiceResult();
    }
}
