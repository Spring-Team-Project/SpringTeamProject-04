package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.*;
import com.github.pagehelper.Page;

import java.util.List;

public interface SinWdbService {


    int overlappedID(String userId) throws Exception;

    void insertUser(SinRegistDto sinRegistDto) throws Exception;

    int overlappedEmail(String userEmail) throws Exception;

//    폐기 시작//////////////////////////////////////////////////////

    List<SinJsonDto> HCList(String userSearchWord, String telCode) throws Exception;

    List<SinJsonDto> HCMainList() throws Exception;

//    폐기 끝 ///////////////////////////////////////////////////////

    List<SinHCDto> HCDBList() throws Exception;
    List<SinHCDto> HCDBList(int HCpageNum) throws Exception;


    List<SinHCDto> HCFilterList(String userSearchWord, String telCode) throws Exception;

    List<SinHCDto> HCTelFilter(String telCode) throws Exception;

    SinHCDto selectHCDetail(int idx) throws Exception;

    void insertUserReview(ReviewDto reviewDto) throws Exception;

    List<ReviewDto> selectHCReview(int idx) throws Exception;


    List<LeePharmacyFullDataItemDto> findNearPharmacy(String addr) throws Exception;

    void insertStarAvg(int idx) throws Exception;
}
