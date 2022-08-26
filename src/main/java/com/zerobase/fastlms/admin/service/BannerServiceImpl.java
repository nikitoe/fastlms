package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.mapper.BannerMapper;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import com.zerobase.fastlms.course.model.ServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerRepository bannerRepository;
    private final BannerMapper bannerMapper;


    @Override
    public List<BannerDto> list(BannerParam parameter) {

        long totalCount = bannerMapper.selectListCount(parameter);

        List<BannerDto> list = bannerMapper.selectList(parameter);
        if (!CollectionUtils.isEmpty(list)) {
            int i = 0;
            for (BannerDto x : list) {
                x.setTotalCount(totalCount);
                x.setSeq(totalCount - parameter.getPageStart() - i);
                i++;
            }
        }
        return list;

    }

    @Override
    public ServiceResult add(BannerInput parameter) {


        Optional<Banner> optionalBanner
                = bannerRepository.findById(parameter.getId());
        if (optionalBanner.isPresent()) {
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

    @Override
    public boolean del(String idList) {

        if (idList != null && idList.length() > 0) {

            String[] ids = idList.split(",");
            for (String x : ids) {
                long id = 0L;
                try {
                    id = Long.parseLong(x);
                } catch (Exception e) {
                }
                if (id > 0) {
                    bannerRepository.deleteById(id);
                }
            }
        }
        return true;
    }


}
