package com.bitc.springteamproject1209.service;


import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.mapper.SkyWdbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service("SkyMemberServiceImpl")
public class SkyMemberServiceImpl implements SkyMemberService {

    @Autowired
    private SkyWdbMapper skyWdbMapper;

    @Override
    public boolean loginCheck(MemberDto md, HttpSession session) {
        return false;
    }

    @Override
    public void logout(HttpSession session) {

    }
    @Override
    public List<ReviewDto> selectMyReviewList(String reId){
        List<ReviewDto> reviewList = skyWdbMapper.selectMyReviewList(reId);
        return reviewList;
    }

    @Override
    public void updateBored(int reIdx) throws Exception {
        skyWdbMapper.updateBored(reIdx);
    }

    @Override
    public void updateR(ReviewDto rvdto) throws Exception {
        skyWdbMapper.updateR(rvdto);
    }

    @Override
    public void deleteR(ReviewDto rvdto1) throws Exception {
        skyWdbMapper. deleteR(rvdto1);
    }

}
