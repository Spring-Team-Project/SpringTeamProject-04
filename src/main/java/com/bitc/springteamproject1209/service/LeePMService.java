package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.LeePMDto;
import com.bitc.springteamproject1209.dto.ReviewDto;

import java.util.List;

public interface LeePMService {
//    리스트 기본 출력
    List<LeePMDto> PMDBList() throws Exception;

//    필터링 관련
    List<LeePMDto> PMFilterList(String userSearchWord, String telCode) throws Exception;

    List<LeePMDto> PMTelFilter(String telCode) throws Exception;

    LeePMDto selectPMDetail(int idx) throws Exception;

    void insertUserReview(ReviewDto reviewDto) throws Exception;
    List<ReviewDto> selectPMReview(int idx) throws Exception;

}

































