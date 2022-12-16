package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.github.pagehelper.Page;

import java.util.List;

public interface GwakReviewBoardService {


  List<ReviewDto> selectReviewList() throws Exception;

  Page<ReviewDto> selectReviewList(int pageNo) throws Exception;


  MemberDto idCheckSQL(String memId, String memPwd) throws Exception ;


  int rvQtySQL(String memId) throws Exception;
}
