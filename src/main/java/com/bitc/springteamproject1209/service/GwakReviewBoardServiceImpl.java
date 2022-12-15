package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.mapper.GwakPageMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GwakReviewBoardServiceImpl implements GwakReviewBoardService {

  @Autowired
  private GwakPageMapper gwakPageMapper;

  @Override
  public Page<ReviewDto> selectReviewList(int pageNo) throws Exception {
    PageHelper.startPage(pageNo, 10);
    return gwakPageMapper.selectReviewListPage();
  }

}
