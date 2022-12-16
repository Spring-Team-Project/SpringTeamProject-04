package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LeeMemMapper {
    public List<MemberDto> selectMemInfo();
    public void updateInfo(MemberDto memberDto);

}
