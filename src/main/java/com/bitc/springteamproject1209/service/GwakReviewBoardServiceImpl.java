package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.mapper.GwakPageMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class GwakReviewBoardServiceImpl implements GwakReviewBoardService {

  @Autowired
  private GwakPageMapper gwakPageMapper;


  @Override
  public List<ReviewDto> selectReviewList() throws Exception {
    return gwakPageMapper.selectReviewList();
  }

  @Override
  public Page<ReviewDto> selectReviewList(int pageNo) throws Exception {
    PageHelper.startPage(pageNo, 5);
    return gwakPageMapper.selectReviewListPage();
  }


  @Override
  public MemberDto idCheckSQL(String memId, String memPwd){
    MemberDto memberDto = gwakPageMapper.idCheckSQL(memId, memPwd);
    return memberDto;
  }
}
