package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.MemberDto;

import javax.servlet.http.HttpSession;


public interface SkyMemberService {
    //로그인 체크
    public boolean loginCheck(MemberDto md, HttpSession session);

    //로그 아웃
    public void logout(HttpSession session);


}
