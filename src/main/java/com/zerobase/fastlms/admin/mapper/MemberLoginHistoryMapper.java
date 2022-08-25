package com.zerobase.fastlms.admin.mapper;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.admin.dto.MemberLoginHistoryDto;
import com.zerobase.fastlms.admin.model.MemberLoginHistoryParam;
import com.zerobase.fastlms.admin.model.MemberParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberLoginHistoryMapper {

    long selectListCount(MemberParam parameter);

    List<MemberLoginHistoryDto> selectList(MemberParam parameter);

}
