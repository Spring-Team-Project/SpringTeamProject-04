package com.bitc.springteamproject1209.service;

import com.bitc.springteamproject1209.dto.MemberDto;
import com.bitc.springteamproject1209.mapper.GwakMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GwakMemberServiceImpl implements GwakMemberService{

  @Autowired
  private GwakMemberMapper gwakMemberMapper;

  //로그인 mapper 접근
  @Override
  public MemberDto Login(MemberDto memberDto) {
    MemberDto DTO = gwakMemberMapper.MemberLogin(memberDto);

//    mapper 에서 조회를 하고 값이 존재하면 VO에 담아서 반환을 한다.
    return DTO;
  }
}
