package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.dto.SinRegistDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SkyWdbMapper {
    List<ReviewDto> selectMyReviewList(String reId);


    void updateBored(int reIdx) throws Exception;

    void updateR(ReviewDto rvdto) throws Exception;
    void deleteR(ReviewDto rvdto1) throws Exception;
    
}
