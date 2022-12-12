package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.mapper.PageMapper;
import com.bitc.springteamproject1209.mapper.TestMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewBoardServiceImpl implements ReviewBoardService{

  @Autowired
  private PageMapper pageMapper;
  private TestMapper testMapper;

  @Override
  public List<ReviewDto> selectReviewList() throws Exception {
    return pageMapper.selectReviewList();
  }

  @Override
  public Page<ReviewDto> selectReviewList(int pageNo) throws Exception {
    PageHelper.startPage(pageNo, 5);
    return pageMapper.selectReviewListPage();
  }

}
