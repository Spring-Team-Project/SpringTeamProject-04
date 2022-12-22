package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.LeePharmacyFullDataItemDto;
import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.mapper.GwakMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GwakServiceImpl implements GwakService {

  @Autowired
  private GwakMapper gwakMapper;


  @Override
  public void deleteBoard(int reIdx) throws Exception {
    gwakMapper.deleteBoard(reIdx);
  }

  @Override
  public List<ReviewDto> selectReviewList() throws Exception {
    return gwakMapper.selectReviewList();
  }

  @Override
  public Page<ReviewDto> selectReviewList(int pageNo) throws Exception {
    PageHelper.startPage(pageNo, 5);
    return gwakMapper.selectReviewListPage();
  }


  @Override
  public MemberDto idCheckSQL(String memId, String memPwd) throws Exception {
    MemberDto memberDto = gwakMapper.idCheckSQL(memId, memPwd);
    return memberDto;
  }

  @Override
  public int rvQtySQL(String memId) throws Exception {
    int rvQty = gwakMapper.rvQtySQL(memId);
    return rvQty;
  }

  @Override
  public List<ReviewDto> selectMyReviewList(String reId){
    List<ReviewDto> reviewList = gwakMapper.selectMyReviewList(reId);
    return reviewList;
  }

  @Override
  public List<LeePharmacyFullDataItemDto> getMapData(String dong) {

    return gwakMapper.getDataList(dong);
  }

//  @Override
//  public List<ReviewDto> selectMyReviewList(String reId) throws Exception {
//    return gwakMapper.selectMyReviewList(reId);
//  }


}