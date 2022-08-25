package com.zerobase.fastlms.course.controller;

import com.zerobase.fastlms.util.PageUtil;

public class BaseController {

    public String getPageHtml(
            long totalCount,
            long pageSize,
            long pageIndex,
            String queryString
    ) {
        PageUtil pageUtil = new PageUtil(totalCount, pageSize, pageIndex, queryString);

        return pageUtil.pager();
    }

    public String getPageHtmlHistory(
            long totalCount,
            long pageSize,
            long pageIndex,
            String queryString,
            String userId
    ) {
        PageUtil pageUtil = new PageUtil(totalCount, pageSize, pageIndex, queryString,userId);

        return pageUtil.pager();
    }
}
