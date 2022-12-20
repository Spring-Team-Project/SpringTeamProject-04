package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SinWdbMapper {


    void insertUser(SinRegistDto regist) throws Exception;

    int idCheck(String userId) throws Exception;

    int emailCheck(String userEmail) throws Exception;

    void PharmacyToDB(LeePharmacyFullDataItemDto PharmarcyDto) throws Exception;

    void HealthCenterToDB(SinJsonDto sinJsonDto) throws Exception;

    List<SinHCDto> receiveHCDBList() throws Exception;

    List<SinHCDto> receiveHCDBUserSearchList(String userSearchWord) throws Exception;

    List<SinHCDto> receiveHCDBTelCodeList(String telCode) throws Exception;

    List<SinHCDto> receiveHCDBDoubleList(String userSearchWord, String telCode) throws Exception;

    SinHCDto getHCDetailDto(int idx) throws Exception;

    void insertUserReview(ReviewDto reviewDto) throws Exception;

    List<ReviewDto> getHCReview(int idx) throws Exception;
}
