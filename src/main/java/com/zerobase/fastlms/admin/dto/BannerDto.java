package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BannerDto {

    Long id;

    String altText;
    String filename;
    String linkUrl;
    String target;
    int sortValue;
    boolean openYn;
    String urlFilename;

    LocalDateTime regDt;
    LocalDateTime udDt;

    long totalCount;
    long seq;

    public static BannerDto of(Banner banner){

        return BannerDto.builder()
                .altText(banner.getAltText())
                .filename(banner.getFilename())
                .linkUrl(banner.getLinkUrl())
                .sortValue(banner.getSortValue())
                .target(banner.getTarget())
                .urlFilename(banner.getUrlFilename())
                .openYn(banner.isOpenYn())
                .regDt(banner.getRegDt())
                .udDt(banner.getUdDt())
                .build();
    }

    public String getRegDtText(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return regDt != null ? regDt.format(formatter) : "";
    }
}
