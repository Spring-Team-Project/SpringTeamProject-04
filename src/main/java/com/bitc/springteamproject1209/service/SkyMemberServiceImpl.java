package com.bitc.springteamproject1209.service;


import com.bitc.springteamproject1209.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service("SkyMemberServiceImpl")
public class SkyMemberServiceImpl implements SkyMemberService {

    @Override
    public boolean loginCheck(MemberDto md, HttpSession session) {
        return false;
    }

    @Override
    public void logout(HttpSession session) {

    }
}
