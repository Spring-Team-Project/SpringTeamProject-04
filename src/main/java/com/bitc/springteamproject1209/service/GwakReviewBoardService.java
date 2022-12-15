package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.GwakRegistDto;
import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.dto.SinRegistDto;
import com.github.pagehelper.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface GwakReviewBoardService {


  List<ReviewDto> selectReviewList() throws Exception;

  Page<ReviewDto> selectReviewList(int pageNo) throws Exception;


  MemberDto idCheckSQL(String memId, String memPwd);


}
