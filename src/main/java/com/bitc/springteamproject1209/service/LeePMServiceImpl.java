package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.LeePMDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.mapper.LeePharmacyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeePMServiceImpl implements LeePMService {
    @Autowired
    private LeePharmacyMapper leePharmacyMapper;

//    DB에서 가져오는 약국 리스트 (기본)
    @Override
    public List<LeePMDto> PMDBList() throws Exception {

        return leePharmacyMapper.receivePMDBList();
    }

//    검색 및 필터링
    @Override
    public List<LeePMDto> PMFilterList(String userSearchWord, String telCode) throws Exception {
        return leePharmacyMapper.receivePMDBDoubleList(userSearchWord, telCode);
    }
//    지역번호로 필터링
    @Override
    public List<LeePMDto> PMTelFilter(String telCode) throws Exception {
        return leePharmacyMapper.receivePMDBTelCodeList(telCode);
    }

//    약국 상세 페이지
    @Override
    public LeePMDto selectPMDetail(int idx) throws Exception {

        return leePharmacyMapper.getPMDetailDto(idx);
    }

//    상세페이지 안에 들어갈 리뷰 메서드임. 작성
    @Override
    public void insertUserReview(ReviewDto reviewDto) throws Exception {
        leePharmacyMapper.insertUserReview(reviewDto);
    }

//    불러오기
    @Override
    public List<ReviewDto> selectPMReview(int idx) throws Exception {
        return leePharmacyMapper.getPMReview(idx);
    }

}












