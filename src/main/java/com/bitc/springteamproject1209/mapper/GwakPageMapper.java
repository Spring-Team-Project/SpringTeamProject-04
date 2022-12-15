package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.ReviewDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GwakPageMapper {

  Page<ReviewDto> selectReviewListPage() throws Exception;

//  로그인


}
