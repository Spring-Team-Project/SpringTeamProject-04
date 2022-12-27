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


  //  List<ReviewDto> selectMyReviewList(String reId) throws Exception;
//  List<ReviewDto> selectMyReviewList(String reId);

  List<LeePharmacyFullDataItemDto> getDataList(String dong);

  Page<ReviewDto> selectReviewListPage2(ReviewDto reviewDto) throws Exception;

  Page<ReviewDto> selectReviewListPage3(ReviewDto reviewDto) throws Exception;

  Page<ReviewDto> selectReviewListPage4(ReviewDto reviewDto) throws Exception;
}