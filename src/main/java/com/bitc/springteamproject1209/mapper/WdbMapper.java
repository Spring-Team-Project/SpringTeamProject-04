package com.bitc.springteamproject1209.mapper;

import com.bitc.springteamproject1209.dto.RegistDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WdbMapper {


    void insertUser(RegistDto regist) throws Exception;

    int idCheck(RegistDto registDto) throws Exception;
}
