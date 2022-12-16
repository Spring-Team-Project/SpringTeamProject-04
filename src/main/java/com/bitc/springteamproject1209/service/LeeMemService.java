package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.MemberDto;

import java.util.List;

public interface LeeMemService {
    public List<MemberDto> selectMemInfo();
    public void updateInfo(MemberDto memberDto);
}
