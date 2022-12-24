package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;

import javax.servlet.http.HttpSession;
import java.util.List;


public interface SkyMemberService {
    //로그인 체크
    public boolean loginCheck(MemberDto md, HttpSession session);

    //로그 아웃
    public void logout(HttpSession session);

    List<ReviewDto> selectMyReviewList(String reId);

    void updateBored(int reIdx) throws Exception;

    void updateR(ReviewDto rvdto) throws Exception;
}
