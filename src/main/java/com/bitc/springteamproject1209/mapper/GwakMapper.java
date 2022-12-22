package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.LeePharmacyFullDataItemDto;
import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GwakMapper {
  List<ReviewDto> selectReviewList() throws Exception;

  Page<ReviewDto> selectReviewListPage() throws Exception;

  MemberDto idCheckSQL(String memId, String memPwd) throws Exception;

  int rvQtySQL(String memId) throws Exception;

  void deleteBoard(int reIdx) throws Exception;



}
