package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LeePharmacyMapper {

    void receivePMDBList(LeePMDto leePMDto) throws Exception;

    List<LeePMDto> receivePMDBList() throws Exception;

    List<LeePMDto> receivePMDBUserSearchList(String userSearchWord) throws Exception;

    List<LeePMDto> receivePMDBTelCodeList(String telCode) throws Exception;

    List<LeePMDto> receivePMDBDoubleList(String userSearchWord, String telCode) throws Exception;

    LeePMDto getPMDetailDto(int idx) throws Exception;

    void insertUserReview(ReviewDto reviewDto) throws Exception;

    List<ReviewDto> getPMReview(int idx) throws Exception;


    String getStarAvg(int idx) throws Exception;

    void insertPMStarAvg(LeePMDto pmStarAvg) throws Exception;

    void updateNotice(SinNoticeDto sinNoticeDto) throws Exception;
}
