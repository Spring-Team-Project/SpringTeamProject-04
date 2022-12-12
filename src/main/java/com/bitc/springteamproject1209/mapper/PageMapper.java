package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.ReviewDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PageMapper {
  List<ReviewDto> selectReviewList() throws Exception;

  Page<ReviewDto> selectReviewListPage() throws Exception;
}
