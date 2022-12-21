package com.bitc.springteamproject1209.service;


import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.dto.ReviewDto;
import com.bitc.springteamproject1209.mapper.SkyWdbMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
