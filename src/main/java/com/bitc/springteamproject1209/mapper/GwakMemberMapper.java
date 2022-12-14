package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GwakMemberMapper {
  //@Select("Select * from T_MEMBER where email=#{email} and pw=#{pw}")
  MemberDto MemberLogin(MemberDto memberDto);
}
