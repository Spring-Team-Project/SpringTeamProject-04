package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.mapper.LeeMemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeeMemServiceImpl implements LeeMemService{
    @Autowired
    private LeeMemMapper leeMemMapper;

    @Override
    public List<MemberDto> selectMemInfo() {
        List<MemberDto> memberDto = leeMemMapper.selectMemInfo();
        System.out.println(memberDto);

        return memberDto;
    }

    @Override
    public void updateInfo(MemberDto memberDto) {
        leeMemMapper.updateInfo(memberDto);
    }
}
