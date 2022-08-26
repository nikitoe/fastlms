package com.zerobase.fastlms.admin.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BannerInput {

    long id;
    String altText;
    String filename;
    String linkUrl;
    String target;
    int sortValue;
    boolean openYn;
    String urlFilename;
    LocalDateTime regDt;
    LocalDateTime udDt;
}
